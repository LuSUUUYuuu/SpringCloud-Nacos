package com.ice.nacos.utils;


import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.Current;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
* @Description: 线程池工具类
* @Param:
* @return:
* @Author: LuuuuSuYunnn
* @Date: 2022/3/14
*/
@Slf4j
public class ThreadPoolUtils {


    public static ExecutorService getCachedThreadPool(){
        //newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService executorService = Executors.newCachedThreadPool();
        return executorService;
    }

    private static ExecutorService getFixedThreadPool(){
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        return executorService;
    }


    private static ExecutorService getScheduledThreadPool(){
        //创建一个定长线程池，支持定时及周期性任务执行。
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        return scheduledExecutorService;
    }

    private static ExecutorService getSingleThreadExecutor(){
        //创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        return executorService;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("线程:{}", Thread.currentThread().getName());
        ExecutorService newCachedThreadPool = getCachedThreadPool();
        newCachedThreadPool.execute(() -> {
            log.info("线程:{}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("创建一个可缓存线程池，执行一个Runnable");
            log.info("线程:{}执行完成", Thread.currentThread().getName());
        });

        ExecutorService fixedThreadPool = getFixedThreadPool();
        Future<String> submit = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("线程:{}", Thread.currentThread().getName());
                System.out.println("创建一个定长线程池，执行一个Callable");
                TimeUnit.SECONDS.sleep(5);
                log.info("线程:{}执行完成", Thread.currentThread().getName());
                return "SUCCESS";
            }
        });

        log.info("线程的执行结果:{}", submit.get());


        newCachedThreadPool.shutdown();
        fixedThreadPool.shutdown();

        log.info("线程:{}执行完成", Thread.currentThread().getName());


    }



}
