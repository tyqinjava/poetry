package org.curd.datesource;

public class DataSourceTypeHolder {

   private static ThreadLocal<DataSourceType> dataSourceType = new ThreadLocal<DataSourceType>();

    public static DataSourceType getDataSourceType() {
        return dataSourceType.get();
    }

    public static void setDataSourceType(DataSourceType type) {
        DataSourceTypeHolder.dataSourceType.set(type);
    }

    public static void clear(){
        dataSourceType.remove();
    }
}
