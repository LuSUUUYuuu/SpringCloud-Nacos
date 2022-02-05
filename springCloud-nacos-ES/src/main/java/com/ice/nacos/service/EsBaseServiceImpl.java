package com.ice.nacos.service;

import com.google.gson.Gson;
import com.ice.nacos.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;


@Slf4j
public class EsBaseServiceImpl implements EsBaseService {


    @Override
    public void esTest() throws Exception {
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

    @Override
    public String getEsIndex() throws Exception {
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

        return getIndexResponse.toString();
    }


    @Override
    public void esDocInsert() throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = new User();
        user.setName("zhangsan").setAge(18).setGender(1);

        //向ES插入数据，必须将数据转换成JSON格式
        Gson gson = new Gson();
        String json = gson.toJson(user);

        request.source(json, XContentType.JSON);

        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);



        log.info(response.getResult().toString());


        esClient.close();


    }


    @Override
    public void esDocUpdate() throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );


        //修改数据
        UpdateRequest request = new UpdateRequest();

        request.index("user").id("1001");
        request.doc(XContentType.JSON, "gender", 0);

        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);

        log.info(response.getResult().toString());
        esClient.close();
    }

    @Override
    public String esDocGet() throws Exception {
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        GetRequest request = new GetRequest();

        request.index("user").id("1001");

        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        log.info(response.getSourceAsString());

        esClient.close();
        return response.getSourceAsString();
    }
}
