package cn.bite.travel.dao;

import cn.bite.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 通过分类ID查询总记录数
     * @param cid
     * @return
     */
    public int findTotalPage(int cid);

    /**
     * 查询当前页面数据集合
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize);
}
