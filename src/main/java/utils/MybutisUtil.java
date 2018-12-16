package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public  class MybutisUtil {

    private  static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSession(){
        if(sqlSessionFactory == null){
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

            return sqlSessionFactory.openSession(true);
    }
}
