package cn.bite.travel.web.servlet;

import cn.bite.travel.domain.Category;
import cn.bite.travel.service.CategoryService;
import cn.bite.travel.service.impl.CategoryServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    /**
     * 查询分类信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用CateService findAll 方法
        List<Category> list = categoryService.findAll();
        //处理服务器响应格式
        //直接将当前list集合写回到前台
        writeVlue(list,response);
    }


}
