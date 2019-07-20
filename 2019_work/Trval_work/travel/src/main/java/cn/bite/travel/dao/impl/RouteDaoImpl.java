package cn.bite.travel.dao.impl;

import cn.bite.travel.dao.RouteDao;
import cn.bite.travel.domain.Route;
import cn.bite.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 旅游线路 dao实现
 */
public class RouteDaoImpl implements RouteDao {
    //声明查询模板对象
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalPage(int cid) {
        //准备sql
        String sql =  "select count(*) from tab_route where cid = ?";
        //执行查询
        return jdbcTemplate.queryForObject(sql,Integer.class,cid);
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
        //准备sql
        String sql = "select * from tab_route where cid = ? limit ?,?";
        //查询
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pageSize);
    }
}
