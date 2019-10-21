package com.yang.learn.multisource1.component;

import com.yang.learn.multisource1.anotions.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String key =  DataSourceRouteHolder.getDataSourceKey();
        if(key==null) {
            return DataSource.source1;
        }
        return key;
    }
}
