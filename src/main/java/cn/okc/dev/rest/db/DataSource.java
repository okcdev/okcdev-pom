/*
 * File: DataSource.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-03-29
 */

package cn.okc.dev.rest.db;

import cn.okc.dev.rest.entity.Articles;
import cn.okc.dev.rest.entity.Projects;
import cn.okc.dev.rest.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * @author fengtao.xue
 */
@Component
public class DataSource<T>{
    static Logger logger = LoggerFactory.getLogger(DataSource.class);

    private static ConcurrentMap<String, List> data = new ConcurrentHashMap<>();

    /**
     * 初次加载所有数据，放入缓存
     */
    static {
        logger.info("******** first load data from native file......");
        data.put(User.class.getName(), LoadData.getUser());
        data.put(Articles.class.getName(), LoadData.getArticles());
        data.put(Projects.class.getName(), LoadData.getProjects());
        logger.info("******** load data from native file successfully");
    }

    /**
     * listBy,列表数据
     * @param entity
     * @return
     */
    public List<T> listBy(T entity){
        logger.info("listBy:{} \n entity:{}", entity.getClass().getName(), entity);
        List<T> result = new ArrayList<>();
        try {
            List<T> tList = data.get(entity.getClass().getName());
            for (T t : tList){
                int i = 0;
                Field[] fields = entity.getClass().getDeclaredFields();
                for (Field field : fields){
                    field.setAccessible(true);
                    Object srcField = field.get(entity);
                    Object dstField = field.get(t);
                    if (srcField != null && dstField != null && srcField != dstField){
                        i = 0;
                        break;
                    }
                    else {
                        i++;
                    }
                }
                if (i != 0){
                    result.add(t);
                }
            }
        }catch (Exception e){
            logger.error("Error: {}\n{}", e.getMessage(), e.getStackTrace());
        }
        return result;
    }

    /**
     * get,跟进id获取详情
     * @param entity
     * @param id
     * @return
     */
    public T get(T entity,String id) {
        logger.info("get:{},{}", entity.getClass().getName(),id);
        try {
            List<T> tList = data.get(entity.getClass().getName());
            for (T t : tList){
                Field field = entity.getClass().getDeclaredField("id");
                field.setAccessible(true);
                if (id.equals(field.get(t))){
                    return t;
                }
            }
        }catch (Exception e){
            logger.error("Error: {}\n{}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    /**
     * 刷新缓存
     */
    public void refresh() {
        logger.info("******** refresh all data");
        data.clear();
        data.put(User.class.getName(), LoadData.getUser());
        data.put(Articles.class.getName(), LoadData.getArticles());
        data.put(Projects.class.getName(), LoadData.getProjects());
    }
}
