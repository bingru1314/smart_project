package com.smart.frame.helper;

import com.smart.frame.annotation.Action;
import com.smart.frame.bean.Handler;
import com.smart.frame.bean.Request;
import com.smart.frame.util.ArrayUtil;
import com.smart.frame.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制层助手
 */
public final class ControllerHelper {
    /**
     * 请求和处理器映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request,Handler>();
    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            for(Class<?> controllerClass:controllerClassSet){
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    for(Method method:methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] requestHanderArray = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(requestHanderArray) && requestHanderArray.length == 2){
                                    String requestMethod = requestHanderArray[0].toLowerCase();
                                    String requestPath = requestHanderArray[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
