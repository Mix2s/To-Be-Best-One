package cn.bite.travel.service.impl;

import cn.bite.travel.dao.RouteDao;
import cn.bite.travel.dao.impl.RouteDaoImpl;
import cn.bite.travel.domain.PageBean;
import cn.bite.travel.domain.Route;
import cn.bite.travel.service.RouteService;

import java.util.List;

/**
 * 旅游线路业务接口层实现层
 *
 */
public class RouteServiceImpl implements RouteService {
    //声明旅游线路dao层对象
    private RouteDao routeDao  = new RouteDaoImpl();
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        //组装pageBean信息
        //创建一个pageBean对象
        PageBean<Route> pb = new PageBean<Route>();
        //设置前台当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);

        //封装总记录数(查数据库)
        int totalCount = routeDao.findTotalPage(cid);
        System.out.println(totalCount);
        pb.setTotalCount(totalCount);

        //封装列表数据集合/（查数据库）
        //起始条数 = （当前页码-1）*每页显示条数
        int start = (currentPage-1)*pageSize;
        List<Route> list = routeDao.findByPage(cid,start,pageSize);
        pb.setList(list);

        //计算总页数
        int totalPage = totalCount%pageSize==0?(totalCount/pageSize):((totalCount)/pageSize+1);
        pb.setCurrentPage(totalPage);

        return pb;
    }
}
