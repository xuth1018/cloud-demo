package com.xx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.Arrays;

@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
public class ZuulApiApp {

    /**
     * zuul网管
     * 访问方式：http:${eureka.instance.hostname}:${server.port}/调用者serviceId/接口rul
     * 例子：
     * 原始访问路径：http://company-8101.com:8101/company/get/hello；
     * Zuul 代理访问：http://gateway-9501.com:9501/microcloud-provider-company/company/get/hello；
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Product.class.getGenericSuperclass());
        //SpringApplication.run(ZuulApiApp.class,args);
    }
}

enum Product{
    Coco("1","可口"),
    Apple("2","苹果");

    private String id;
    private String name;

    private Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(String id){
        Product[] pro = Product.values();
        Product.valueOf("");
        for(Product p:pro){
            if(p.getId().equals(id)) {
                return p.getName();
            }
        }
        return "";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface Pro{
    void name();
    default String getName(){
        return "";
    }
}