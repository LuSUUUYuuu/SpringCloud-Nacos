package com.ice.nacos.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
* @Description:
* @Param:
* @return:
* @Author: LuuuuSuYunnn
* @Date: 2022/2/4
*/

@Slf4j
public class EsBaseService {


    public void esTest() throws IOException {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        CreateIndexRequest request = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse =
                esClient.indices().create(request, RequestOptions.DEFAULT);

        //响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        log.info("索引操作:{}", acknowledged);

        //关闭ES客户端
        esClient.close();

    }

    public void getEsIndex() throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //查询索引
        GetIndexRequest request = new GetIndexRequest("user");
        GetIndexResponse getIndexResponse =
                esClient.indices().get(request, RequestOptions.DEFAULT);

        //响应状态
        log.info(String.valueOf(getIndexResponse.getAliases()));
        log.info(String.valueOf(getIndexResponse.getMappings()));
        log.info(String.valueOf(getIndexResponse.getSettings()));


        //关闭ES客户端
        esClient.close();

    }

}
