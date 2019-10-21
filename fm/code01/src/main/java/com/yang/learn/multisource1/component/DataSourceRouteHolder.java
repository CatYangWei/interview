package com.yang.learn.multisource1.component;

public class DataSourceRouteHolder {
    private static final ThreadLocal<String> dataSources = new ThreadLocal<>();

    public static void setDataSourceKey(String customType) {
        dataSources.set(customType);
    }
    public static String getDataSourceKey() {
        return  dataSources.get();
    }
    public static void clearDataSourceKey() {
        dataSources.remove();
    }
}
