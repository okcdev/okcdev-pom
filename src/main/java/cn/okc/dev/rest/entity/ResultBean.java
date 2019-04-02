/*
 * File: ResultBean.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-03-29
 */

package cn.okc.dev.rest.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author fengtao.xue
 */
public class ResultBean<T> {
    static Logger logger = LoggerFactory.getLogger(ResultBean.class);

    public static final Integer STATUS_SUCCESS = 2000;
    public static final Integer STATUS_ERROE = 4001;
    public static final Integer STATUS_EXCEPTION = 4002;
    public static final Integer STATUS_OTHERS = 4003;

    private Integer status;
    private String message;
    private T data;

    public ResultBean(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
