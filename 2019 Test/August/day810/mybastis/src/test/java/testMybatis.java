import bz.UserBZ;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import poEx.UserEx;


import java.io.InputStream;
import java.util.List;


public class testMybatis {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit(){
        String file = "sqlMapConfig.xml";
        InputStream in = null;
        try{
            in = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryUserByZH(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserEx userEx = new UserEx();
            //userEx.setSex("2");
            userEx.setUsername("tom");
            UserBZ userBZ = new UserBZ();
            userBZ.setUserEx(userEx);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExes = mapper.queryUserByZH(userBZ);
            System.out.println(userExes.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByZH2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserEx userEx = new UserEx();
            userEx.setSex("2");
            userEx.setUsername("tom");
            UserBZ userBZ = new UserBZ();
            userBZ.setUserEx(userEx);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int userExes = mapper.queryUserByZH2(userBZ);
            System.out.println(userExes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserByotherName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<UserEx> userExes = mapper.queryUserByotherName2();
            System.out.println(userExes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
