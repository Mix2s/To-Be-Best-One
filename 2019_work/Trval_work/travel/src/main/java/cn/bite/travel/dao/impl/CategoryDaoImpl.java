package cn.bite.travel.dao.impl;

import cn.bite.travel.dao.CategoryDao;
import cn.bite.travel.domain.Category;
import cn.bite.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 旅游分类 dao 接口实现
 */
public class CategoryDaoImpl implements CategoryDao {
    //声明模板对象 执行查询
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        //准备sql语句
        String sql = "select * from tab_category";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Category>(Category.class));
    }
}
