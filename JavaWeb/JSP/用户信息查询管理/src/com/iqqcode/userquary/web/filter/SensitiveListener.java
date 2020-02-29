package com.iqqcode.userquary.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-28 20:16
 * @Description:Filter敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveListener implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强getParameter方法
                //判断是否是getParameter方法
                if(method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req,args);
                    if(value != null) {
                        for (String str : list) {
                            if(value.contains(str)){
                                value = value.replaceAll(str,"***");
                            }
                        }
                    }
                    return  value;
                }


                //判断方法名是否是 getParameterValue
                if (method.getName().equals("getParameterValues")) {
                    //获取参数的值
                    String[] values = (String[]) method.invoke(req, args);
                    //定义一个新数组
                    String[] newValues = new String[values.length];
                    //遍历数组
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            for (String s : list) {
                                if (values[i].contains(s)) {
                                    newValues[i] = values[i].replaceAll(s, "***");
                                    break;
                                } else {
                                    newValues[i] = values[i];
                                }
                            }
                        }
                        return newValues;
                    }
                }

                //判断方法名是否是getParameterMap
                if (method.getName().equals("getParameterMap")) {
                    //增强getParameterMap方法
                    //获取参数
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, args);
                    //定义一个新的map集合
                    Map<String, String[]> newMap = new HashMap<String, String[]>();
                    Set<String> keySet = map.keySet();
                    for (String key : keySet) {
                         String[] values = map.get(key);
                        //定义一个String数组
                        String[] newValues = new String[values.length];
                        if (values != null) {
                            for (int i = 0; i < values.length; i++) {
                                //遍历集合
                                for (String s : list) {
                                    if (values[i].contains(s)) {
                                        newValues[i] = values[i].replaceAll(s, "***");
                                        break;
                                    } else {
                                        newValues[i] = values[i];
                                    }
                                }
                            }
                        }
                        newMap.put(key, newValues);
                    }
                    return newMap;
                }



                return method.invoke(req,args);
            }
        });

        //2.放行
        chain.doFilter(proxy_req, resp);
    }

    //敏感词汇集合
    private List<String> list = new ArrayList<String>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        try{
            //1.获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            //2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            //3.将文件的每一行数据添加到list中
            String line = null;
            while((line = br.readLine())!=null){
                list.add(line);
            }

            br.close();

            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() { }
}
