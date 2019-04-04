/*
 * File: RestTest.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-04-04
 */

package cn.okc.dev.rest;

import cn.okc.dev.rest.db.LoadData;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @author fengtao.xue
 */
public class RestTest {
    static Logger logger = LoggerFactory.getLogger(RestTest.class);

    //@Test
    public void TestLoadData(){
        List<String> data = LoadData.getDate("./data/articles.txt");
    }
}
