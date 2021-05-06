package com.db.es;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.script.Script;

import java.io.IOException;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/5/5 22:08
 */
public class UpdateEs {
    public static void main(String[] args) {
        try {
            new UpdateEs().update();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update() throws Exception {
        UpdateRequest updateRequest = new UpdateRequest("posts", "doc", "1")
                .script(new Script("ctx._source.gender = \"male\""));
        ESUtils.getClient().update(updateRequest, RequestOptions.DEFAULT).getGetResult();
    }
    public void delete(String indexName, String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, id);
        ESUtils.getClient().delete(deleteRequest,RequestOptions.DEFAULT);
    }

}
