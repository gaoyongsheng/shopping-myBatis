package com.shopping.demo.utils;

/**
 * @Author ldc
 * @Date 2021/1/12 15:31
 * @Version 1.0
 */
public class CodeThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void set(String object) {
        threadLocal.set(object);
    }

    public static String get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

}
