package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements BeanNameAware /*InitializingBean*/, ApplicationContextAware /* DisposableBean*/ {
    Map<Integer,String> mp;

    public CartService(){
        mp = new HashMap<>();
        System.out.println("cart service constructor called");
    }

    @Override
    public void setBeanName(String name){
        System.out.println("Name of bean is : "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("The context of application is : "+applicationContext);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("intializing callback");
//        mp.put(1,"Vineet");
//        mp.put(2,"Aditya");
//    }
    @PostConstruct
    public  void start(){
        System.out.println("bean intialized");
        mp.put(1,"raj");
        mp.put(2,"rohan");
    }
    public String GetVal(int key){
        return mp.get(key);
    }
    public void AddToCart(){
        System.out.println("added to cart");
    }
//    @Override
//    public void destroy() throws  Exception{
//        mp.clear();
//        System.out.println("map getting destroyed");
//    }
    @PreDestroy
    public void close(){
        mp.clear();
        System.out.println("bean destroyed");
    }
}
