package com.twsihan.examples.components.mybatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.twsihan.examples.components.base.BaseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum MapperFactory
{
    BASE {
        private SqlSessionFactory sqlSessionFactory;

        @Override
        public <T> T getMapper(Class<? extends BaseMapper> clazz)
        {
            return _getMapper(clazz, this);
        }

        @Override
        protected void createSqlSessionFactory(InputStream inputStream)
        {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, this.name());
        }

        @Override
        public SqlSessionFactory getSqlSessionFactory()
        {
            return sqlSessionFactory;
        }
    };

    protected abstract void createSqlSessionFactory(InputStream inputStream);

    public abstract SqlSessionFactory getSqlSessionFactory();

    public abstract <T> T getMapper(Class<? extends BaseMapper> clazz);

    private static final String CONFIGURATION_PATH = "mybatis.xml";

    static {
        try {
            BASE.createSqlSessionFactory(Resources.getResourceAsStream(CONFIGURATION_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T _getMapper(Class<? extends BaseMapper> clazz, MapperFactory mapperFactory)
    {
        SqlSession sqlSession = mapperFactory.getSqlSessionFactory().openSession();
        BaseMapper mapper = sqlSession.getMapper(clazz);
        return (T) MapperProxy.bind(mapper, sqlSession);
    }

    private static class MapperProxy implements InvocationHandler
    {
        private BaseMapper baseMapper;

        private SqlSession sqlSession;


        private MapperProxy(BaseMapper baseMapper, SqlSession sqlSession)
        {
            this.baseMapper = baseMapper;
            this.sqlSession = sqlSession;
        }

        private static BaseMapper bind(BaseMapper mapper, SqlSession sqlSession)
        {
            return (BaseMapper) Proxy.newProxyInstance(
                    mapper.getClass().getClassLoader(),
                    mapper.getClass().getInterfaces(),
                    new MapperProxy(mapper, sqlSession)
                );
        }

        public Object invoke(Object proxy, Method method, Object[] args)
        {
            Object object = null;
            try {
                object = method.invoke(baseMapper, args);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               sqlSession.close();
            }
            return object;
        }
    }
}
