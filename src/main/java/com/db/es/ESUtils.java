package com.db.es;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.*;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.mapper.ObjectMapper;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mjwang
 * @version 1.0
 * @date 2021/5/5 21:28
 */

public class ESUtils {
    private static int port = 9200;
    //可以写 ip  但是 logstash 配置要修改
    private static String host = "192.168.56.102";

    private static RestHighLevelClient restHighLevelClient;

    static {
        try {
            restHighLevelClient = getClient();
            System.out.println("初始化es-client"+restHighLevelClient.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static RestHighLevelClient getClient() throws Exception {

        RestClientBuilder restClient = RestClient.builder(new HttpHost(host, port,
                "http"));


        // 定义监听器，节点出现故障会收到通知。
        restClient.setFailureListener(new RestClient.FailureListener() {
            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
            }
        });
        // 定义节点选择器 这个是跳过data=false，ingest为false的节点
        restClient.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);
        // 定义默认请求配置回调
        restClient.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                return requestConfigBuilder.setConnectTimeout(90000) // 连接超时（默认为1秒）
                        .setSocketTimeout(30000); // 套接字超时（默认为30秒）
            }
        });


        RestHighLevelClient client = new RestHighLevelClient(restClient);

        return client;
    }


}
