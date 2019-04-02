/*
 * File: ArticlesService.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-04-01
 */

package cn.okc.dev.rest.service;

import cn.okc.dev.rest.entity.Articles;
import cn.okc.dev.rest.utils.BaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @author fengtao.xue
 */
@Service
public class ArticlesService extends BaseUtils<Articles> {
    static Logger logger = LoggerFactory.getLogger(ArticlesService.class);

}
