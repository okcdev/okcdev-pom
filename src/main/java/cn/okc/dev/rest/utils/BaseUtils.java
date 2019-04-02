/*
 * File: CommonUtils.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-04-01
 */

package cn.okc.dev.rest.utils;

import cn.okc.dev.rest.db.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author fengtao.xue
 */
public abstract class BaseUtils<T>{
    static Logger logger = LoggerFactory.getLogger(BaseUtils.class);

    @Autowired
    DataSource<T> dataSource;

    public List<T> listBy(T entity){
        return dataSource.listBy(entity);
    }

    public T get(T entity, String id){
        return dataSource.get(entity, id);
    }
}
