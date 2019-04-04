/*
 * File: LoadData.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-04-02
 */

package cn.okc.dev.rest.db;

import cn.okc.dev.rest.entity.Articles;
import cn.okc.dev.rest.entity.Projects;
import cn.okc.dev.rest.entity.User;
import cn.okc.dev.rest.utils.DataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author fengtao.xue
 */
public class LoadData {
    static Logger logger = LoggerFactory.getLogger(LoadData.class);

    //private static final String FILE_ARTICLES = "/home/fengtao.xue/okcdev/data/articles.txt";
    private static final String FILE_ARTICLES = "./data/articles.txt";
    private static final String TAB = "&";

    /**
     * 获取ArticlesList
     * @return
     */
    public static List<Articles> getArticles(){
        logger.info("******** loading articles......");
        List<Articles> articlesList = new ArrayList<>();
        List<String> data = getDate(FILE_ARTICLES);
        for (String line : data){
            String[] strs = line.split(TAB);
            Articles articles = new Articles();
            try {
                articles.setId(UUID.randomUUID().toString().replace("-", ""));
                articles.setTitle(strs[0]);
                articles.setStar(Integer.valueOf(strs[1]));
                articles.setLike(Integer.valueOf(strs[2]));
                articles.setMessage(Integer.valueOf(strs[3]));
                articles.setOwner(strs[4]);
                articles.setHref(strs[5]);
                articles.setUpdateDate(DataUtils.parseDate(strs[6]));
                articles.setContent(strs[7]);
                articlesList.add(articles);
            } catch (Exception e) {
                logger.error("Error: {}\n{}", e.getMessage(), e.getStackTrace());
            }
        }
        return articlesList;
    }

    /**
     * 获取Projects列表
     * @return
     */
    public static List<Projects> getProjects() {
        logger.info("******** loading projects......");
        List<Projects> projectsList = new ArrayList<>();
        return projectsList;
    }

    /**
     * 获取user列表
     * @return
     */
    public static List<User> getUser() {
        logger.info("******** loading user......");
        List<User> userList = new ArrayList<>();
        return userList;
    }

    /**
     * 读取本地文件
     * @param filePath
     * @return
     */
    public static List<String> getDate(String filePath){
        List<String> data = new ArrayList<>();
        //logger.debug("filePath:{}", filePath);
        File file = new File(filePath);
        if (!file.exists()){
            logger.debug("******** {} not exist", filePath);
            System.exit(0);
        }
        try {
            //Reader reader = new FileReader(filePath);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                data.add(line);
            }
        }catch (Exception e){
            logger.error("Error: {}\n{}", e.getMessage(), e.getStackTrace());
            return null;
        }
        return data;
    }
}
