/*
 * File: Controller.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-03-29
 */

package cn.okc.dev.rest.web;

import cn.okc.dev.rest.entity.Articles;
import cn.okc.dev.rest.entity.ResultBean;
import cn.okc.dev.rest.service.ArticlesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author fengtao.xue
 */
@RestController
public class Controller {
    static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    ArticlesService articlesService;

    @CrossOrigin
    @RequestMapping("/articles/list")
    public ResultBean<List<Articles>> list(){
        Articles articles = new Articles();
        //articles.setTitle("前辈的忠告1");
        return new ResultBean<>(ResultBean.STATUS_SUCCESS, "调用成功", articlesService.listBy(articles));
    }

    @CrossOrigin
    @RequestMapping("/articles/get/{id}")
    public ResultBean<Articles> get(@PathVariable("id") String id){
        return new ResultBean<>(ResultBean.STATUS_SUCCESS, "调用成功", articlesService.get(new Articles(), id));
    }
}
