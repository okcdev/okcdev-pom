/*
 * File: DataSource.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-03-29
 */

package cn.okc.dev.rest.db;

import cn.okc.dev.rest.entity.Articles;
import cn.okc.dev.rest.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * @author fengtao.xue
 */
@Component
public class DataSource<T>{
    static Logger logger = LoggerFactory.getLogger(DataSource.class);

    private static final String TYPE_ARTICLES = "Articles";
    private static final String TYPE_PROJECTS = "projects";
    private static final String TYPE_OTHERS = "others";

    private static ConcurrentMap<String, List> data = new ConcurrentHashMap<>();

    static {
        //ArticlesDS articlesDS = new ArticlesDS();
        data.put(Articles.class.getName(), ArticlesDS.getDate());
    }

    public List<T> list(T entity){
        List<T> result = new ArrayList<>();
        try {
            List<T> tList = data.get(entity.getClass().getName());
            for (T t : tList){
                int i = 0;
                Field[] fields = entity.getClass().getDeclaredFields();
                for (Field field : fields){
                    //logger.info("filed:{}", field.getName());
                    field.setAccessible(true);
                    Object srcProperty = field.get(entity);
                    Object dstProperty = field.get(t);
                    if (srcProperty != null && dstProperty != null && srcProperty != dstProperty){
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

    public T get(T entity,String id) {
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

}
