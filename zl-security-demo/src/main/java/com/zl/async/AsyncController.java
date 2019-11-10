package com.zl.async;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 异步处理
 *
 * @author zhagnlei
 * @ProjectName: security-auth
 * @create 2019-11-10 15:28
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@RestController
public class AsyncController {

    /**
     * 使用Runnable来异步处理
     * @return
     */
    @RequestMapping("/order")
    public Callable<String> order() {
        System.out.println("主线程开始");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("子线程开始");
                Thread.sleep(1000L);
                System.out.println("子线程返回");
                return "SUCCESS";
            }
        };
        System.out.println("主线程返回");
        return result;
    }

    @RequestMapping("/deferredOrder")
    public DeferredResult<String> deferredOrder() {
        System.out.println("主线程开始");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        /**
         * deferredResult.setResult("hello");这一步通过异步调用即可
         */
        new Thread(() -> {
            System.out.println("子线程开始");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String orderNo = RandomStringUtils.random(8);
            System.out.println("子线程返回");
            deferredResult.setResult(orderNo);
        }).start();
        System.out.println("主线程返回");
        return deferredResult;
    }


}
