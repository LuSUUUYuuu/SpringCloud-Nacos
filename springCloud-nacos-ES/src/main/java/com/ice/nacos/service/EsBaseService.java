package com.ice.nacos.service;

public interface EsBaseService {

    /** 
    * @Description: ES测试 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/5 
    */ 
    void esTest() throws Exception;
    
    /** 
    * @Description: 获取ES索引
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/5 
    */ 
    String getEsIndex() throws Exception;


    /** 
    * @Description: ES插入数据 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/5 
    */ 
    void esDocInsert() throws Exception;
    
    
    /** 
    * @Description: ES修改数据 
    * @Param:  
    * @return:  
    * @Author: LuuuuSuYunnn
    * @Date: 2022/2/5 
    */ 
    void esDocUpdate() throws Exception;


    String esDocGet() throws Exception;
}
