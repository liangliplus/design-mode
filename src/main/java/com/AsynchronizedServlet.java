package com;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="async",urlPatterns = "/hello")
public class AsynchronizedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要异步的支持，需要设置这个作用域
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        AsyncContext asynContext = req.startAsync();//开始异步

        System.out.println("主线程开始处理 ============"+System.currentTimeMillis());
        //一般我们会维护一个异步线程来进入处理，但是还是没有解决当请求数据 或者 返回数据特别大的情况，IO也可以非阻塞处理
        //
        ServletInputStream in = req.getInputStream();
        in.setReadListener(new ReadListener() {
            @Override
            public void onDataAvailable() throws IOException {

            }

            @Override
            public void onAllDataRead() throws IOException {
                System.out.println("异步线程开始处理 ==============="+System.currentTimeMillis());
                try {
                    sayHello();
                    System.out.println("异步线程结束处理 ==============="+System.currentTimeMillis());
                    HttpServletResponse response = (HttpServletResponse) asynContext.getResponse();
                    response.getWriter().println("hello async");
                    asynContext.complete();//通知客户端
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    asynContext.complete();
                }

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);
                asynContext.complete();;
            }
        });


        System.out.println("主线程处理结束 ============"+System.currentTimeMillis());

    }


    private void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "process ..........");
        Thread.sleep(3000);
    }
}
