/*
 * File: User.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-04-04
 */

package cn.okc.dev.rest.entity;

import cn.okc.dev.rest.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author fengtao.xue
 */
public class User {
    static Logger logger = LoggerFactory.getLogger(User.class);

    private String id;
    private String name;
    private String email;
    private String company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString(){
        return JSONUtils.toJson(this);
    }
}
