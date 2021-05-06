package com.db.es;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/5/5 21:23
 */
public class InsertEs {

    public static void main(String[] args) {
        try {
            new InsertEs().index();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void index() throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1").source(jsonMap);
        IndexResponse indexResponse = ESUtils.getClient().index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.status());
        System.out.println(indexResponse.toString());
    }

}
