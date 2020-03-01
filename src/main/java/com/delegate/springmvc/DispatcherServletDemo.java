package com.delegate.springmvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * httpServlet service方法就是根据请求头的方法类型去分发到具体的方法
 * 如get doGet post doPost doPut等
 * 不要把委托和代理弄混了，比如我们租房子，通过中介看房，最后是否选着入住的选着权在我们手上
 * 委托关注点在于结果，我发起一个请求，拿到响应结果
 */
public class DispatcherServletDemo extends HttpServlet {
    public List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        /**
         * 用到了单例和工厂，servlet 本身是单例，handlerMapping可以理解为简单工厂，反射初始化类
         */
        //以orderController为例
        try {
            Class<OrderController> clazz = OrderController.class;
            handlerMapping.add(new Handler().setController(clazz.newInstance()).setMethod(clazz
            .getMethod("getOrderbyId",Integer.class)).setUrl("/order/getOrder"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected  void doDispatch(HttpServletRequest req, HttpServletResponse resp){
        //获取用户请求的url
        //1.如果按照javaEE规范，每一个url请求都能找到具体的一个servlet去处理
        String uri = req.getRequestURI();

        //2.servlet拿到url以后， 要做权衡（要做判断,要做选择）
        //根据用户请求url,找到url对应的一个java类 controller



        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Handler h = null;//3.通过拿到的url去handlerMapping（我们把它认为策略常量）
            for (Handler handler : handlerMapping){
                if(uri.equals(handler.getUrl())){
                    h = handler;
                    break;
                }
            }
            //将具体的任务分发给Method 通过反射去调用其对应方法
            //controller 就是策略的实现， 一个请求找到一个controller策略
            Object invoke = h.getMethod().invoke(h.getController(), id);
            resp.getWriter().write(invoke.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 链式调用
     */
    private class Handler {
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;

        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }


    /*protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String requestURI = req.getRequestURI();
        int id = Integer.parseInt(req.getParameter("id"));
        if(requestURI.endsWith("order")){
            new OrderController().getOrderbyId(id);
        }else if(requestURI.endsWith("getUser")){
            new UserController().getUserInfo(id);
        }else if(requestURI.endsWith("loginOut")){
            new SystemController().loginOut(id);
        }else{
            resp.getWriter().write("404 NOT FOUND 请求资源为响应");
        }

    }*/
}
