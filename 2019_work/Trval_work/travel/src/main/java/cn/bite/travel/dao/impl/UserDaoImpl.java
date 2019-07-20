package cn.bite.travel.dao.impl;

import cn.bite.travel.dao.UserDao;
import cn.bite.travel.domain.User;
import cn.bite.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 用户相关数据库访问层
 */
public class UserDaoImpl implements UserDao {
    //底层使用jdbcTenplate操作数据库
    //创建jdbcTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User finByUsername(String username) {
        User user = null;
       try{
           //准备SQL?
           String sql = "SELECT * FROM java49_travel.tab_user where username=?;";
           //执行查询 BeanPropertyRowMapper
           //queryForObject将查询信息封装所需要的类型中
           //使用JDBCTemplate 末班查询表 会出现异常
           user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
       }catch (Exception e){
           e.printStackTrace();
       }

        return user;
    }

    /**
     * 保存用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        //准备sql
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code)" +
                " values(?,?,?,?,?,?,?,?,?)";

        //执行更新操作
        template.update(sql
                ,user.getUsername()
                ,user.getPassword()
                ,user.getName()
                ,user.getBirthday()
                ,user.getSex()
                ,user.getTelephone()
                ,user.getEmail(),user.getStatus(),user.getCode());
    }

    /**
     * 根据激活码插叙
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        User user = null;
        try{
            //准备sql
            String sql = "select * from tab_user where code = ?;";
            //查询
             user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), code);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 更新用户激活状态 N--Y
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid = ?;";

        template.update(sql,user.getUid());
    }

    /**
     * 根据用户名密码查询是否存在
     * @param username
     * @param password
     * @return
     */
    @Override
    public User finByUsernameAndPassword(String username, String password) {
        User user = null;
        try{
            //准备SQL?
            String sql = "SELECT * FROM java49_travel.tab_user where username=? and password=?;";
            //执行查询 BeanPropertyRowMapper
            //queryForObject将查询信息封装所需要的类型中
            //使用JDBCTemplate 末班查询表 会出现异常
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }
}
