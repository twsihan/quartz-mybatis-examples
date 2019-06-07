package com.twsihan.examples.components.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import java.util.Properties;

public class HikariCPDataSourceFactory extends UnpooledDataSourceFactory
{


    @Override
    public void setProperties(final Properties props)
    {
        try {
            dataSource = new HikariDataSource(new HikariConfig(props));
        } catch (final RuntimeException e) {
            throw e;
        } catch (final Exception e) {
            throw new RuntimeException("init datasource error", e);
        }
    }
}
