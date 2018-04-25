package com.example.myrxjava.util;

import java.lang.reflect.ParameterizedType;

/**
 * 泛型实例化工具类 (MVP模式) 
 * Created by baixiaokang on 16/4/30. 
 */  
public class TUtil {  
    public static <T> T getT(Object o, int i) {  
        try {  
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])  
                    .newInstance();  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        } catch (ClassCastException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    public static Class<?> forName(String className) {  
        try {  
            return Class.forName(className);  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
}  