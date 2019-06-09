package test.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import test.domain.User;
import test.util.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *  数据库访问层
 */
public class UserDao {
    public User getUserByUserNameAndPassword(String username, String password) {
        //穿件QueryRunner对象
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSorce());
        //准备sql语句
        String sql = "select * from user where username=？and password=?";
        //执行查询
        /**
         * 查询后的结果 list new BeanListHandler(实体类类名.class)
         *              Bean对象  new BeanHandler(类名.class)
         *      查询指定行数据  new columnListHandler()  查询到几行数据
         */
        User user = null;
        try {
             user = qr.query(sql, new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
