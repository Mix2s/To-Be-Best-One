package cn.bite.travel.web.servlet;

import cn.bite.travel.domain.PageBean;
import cn.bite.travel.domain.Route;
import cn.bite.travel.service.RouteService;
import cn.bite.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    /**
     * 查询旅游线路分类后台业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    //Service 层 业务对象
    private RouteService routeService = new RouteServiceImpl();
    public void PageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            //1 接收前台页面 传递的参数
        String cidStr = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        //第一次访问 当前页码设置默认值
        int cid = 0;
        if(cidStr!=null&&cidStr.length()>0){
            //cid存在
            cid = Integer.parseInt(cidStr);
        }
        int currentPage;
        if(currentPageStr!=null&&currentPageStr.length()>0){
            //存在 进行转换
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            //第一次访问可以给默认值
            currentPage = 1;
        }
        /**
         * 每页显示条数
         */
        int pageSize;
        if(pageSizeStr!=null&&pageSizeStr.length()>0){
            //存在 进行转换
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            //第一次访问可以给默认值
            pageSize = 1;
        }

        //3 调用Service 完成后台封装
        PageBean<Route> pb = routeService.pageQuery(cid,currentPage,pageSize);

        //将 PageBean对象直接返回前台页面
        writeVlue(pb,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
