package com.db.es;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.document.DocumentField;

import java.util.Map;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/5/5 21:53
 */
public class SelectEs {
    public static void main(String[] args) {
        try {
            new SelectEs().getIndex("posts","1");
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getIndex(String indexName, String id) throws Exception {
        GetRequest getRequest = new GetRequest(indexName, id);
        GetResponse getResponse = ESUtils.getClient().get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.toString());
        Map<String, Object> source = getResponse.getSource();
        System.out.println(source.toString());

        return;
    }

}
