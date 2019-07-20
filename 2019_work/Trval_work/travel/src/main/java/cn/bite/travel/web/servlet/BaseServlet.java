package cn.bite.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 抽取的基类
 */
public class BaseServlet extends HttpServlet {
   //重写HttpServlet 中的 service方法


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        //获取子类对象
       Class clazz =  this.getClass();
        //执行调用子类中所有的方法  暴力获取直接拿到私有的
        //强制解决 反射 验证

        try {
            Method method =clazz.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);  //强制解决反射验证 调用子类的方法
            //调用方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将obj写会前台 转换为json格式(json对象)
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeVlue(Object obj,HttpServletResponse response) throws IOException {
        //创建解析器对象
        ObjectMapper mapper = new ObjectMapper();
        //处理服务器响应的:json格式
        response.setContentType("application/json;charset=utf-8");
        //直接将集合对象写会
        mapper.writeValue(response.getOutputStream(),obj);
    }


    /**
     * 将当前对象解析为json串
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public String writerValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        return json;
    }

}
