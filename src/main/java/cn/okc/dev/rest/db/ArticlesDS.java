/*
 * File: ArticlesDS.java
 * Created By: fengtao.xue@gausscode.com
 * Date: 2019-03-29
 */

package cn.okc.dev.rest.db;

import cn.okc.dev.rest.entity.Articles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author fengtao.xue
 */
public class ArticlesDS {
    static Logger logger = LoggerFactory.getLogger(ArticlesDS.class);

    private static List<Articles> articlesList = new ArrayList<>();

    static {
        Articles articles1 = new Articles();
        articles1.setId(UUID.randomUUID().toString().replace("-",""));
        articles1.setStar(12);
        articles1.setLike(33);
        articles1.setMessage(6);
        articles1.setOwner("xiaoshuai");
        articles1.setHref("http://www.okcdev.cn");
        articles1.setContent("我常常想，人是一种很悲剧的动物:当你慢慢懂得了一些事情时，你发现时间其实已经过去一大半了!" +
                "我们总是在最美好的年华错过了应该那个年纪懂的一些道理。当我们懂得那个道理的时候，我们已经步入一个新的年龄段。这种滞后与生俱来，" +
                "基因无法将一些经验传递给下一代，但是可以通过书籍来完成。然而更悲剧的是：当前辈用自己的一辈子得到的感悟写成的书告诉我们的道理， " +
                "年少轻狂的我们根本不会领悟里面的生命哲学， 一定要自己趟一遍，才能感悟到，噢 ，原来书上写的是对的，该趟的，还是要趟一遍。这也有好有坏，" +
                "因为时间在演进，世界也在变化。");
        articles1.setTitle("前辈的忠告");
        articles1.setUpdateDate(new Date());

        Articles articles2 = new Articles();
        articles2.setId(UUID.randomUUID().toString().replace("-",""));
        articles2.setStar(12);
        articles2.setLike(33);
        articles2.setMessage(6);
        articles2.setOwner("xiaoshuai");
        articles2.setHref("http://www.okcdev.cn");
        articles2.setContent("我常常想，人是一种很悲剧的动物:当你慢慢懂得了一些事情时，你发现时间其实已经过去一大半了!" +
                "我们总是在最美好的年华错过了应该那个年纪懂的一些道理。当我们懂得那个道理的时候，我们已经步入一个新的年龄段。这种滞后与生俱来，" +
                "基因无法将一些经验传递给下一代，但是可以通过书籍来完成。然而更悲剧的是：当前辈用自己的一辈子得到的感悟写成的书告诉我们的道理， " +
                "年少轻狂的我们根本不会领悟里面的生命哲学， 一定要自己趟一遍，才能感悟到，噢 ，原来书上写的是对的，该趟的，还是要趟一遍。这也有好有坏，" +
                "因为时间在演进，世界也在变化。");
        articles2.setTitle("前辈的忠告1");
        articles2.setUpdateDate(new Date());

        articlesList.add(articles1);
        articlesList.add(articles2);
    }

    public static List<Articles> getDate() {
        return articlesList;
    }
}
