package cn.bite.travel.dao;

import cn.bite.travel.domain.Category;

import java.util.List;

/**
 * 旅游分类 dao接口
 */
public interface CategoryDao {

    List<Category> findAll();
}
