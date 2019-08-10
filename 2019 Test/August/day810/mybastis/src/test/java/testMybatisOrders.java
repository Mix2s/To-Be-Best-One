
import mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import po.Orders;
import poEx.OrdersEx;

import java.io.InputStream;
import java.util.List;

public class testMybatisOrders {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit() {
        String file = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(file);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByZH() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
            List<OrdersEx> oderlist = mapper.queryOrdersANDUser();
            System.out.println(oderlist.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1:1
    @Test
    public void qyeryOrderToUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> oderlist = mapper.qyeryOrderToUser();
            System.out.println(oderlist.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1:m orders ---Ordertail
    @Test
    public void queryOdersToOrderDetail() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> oderlist = mapper.queryOdersToOrderDetail();
            System.out.println(oderlist.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // m:m
    @Test
    public void queryOdersToitesmMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> oderlist = mapper.queryOrdersToitems();
            System.out.println(oderlist.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
