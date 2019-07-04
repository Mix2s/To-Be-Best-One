package cookie;

import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 记录用户浏览商品id
 */
public class GetProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置编码
        response.setContentType("test/html;charset=uft-8");
        //获取参数
        String id = request.getParameter("id");
        //获取指定名称cookie对象
        Cookie c = CookieUtils.getCookieByName("ids",request.getCookies());
        //初始化ids作为cookie内容
        String ids = "";
        //判断cookie是否为null
        if(c==null){
            ids=id;
        }else{
            //获取cookie内容
            String value = c.getValue();
            String[] strArray = value.split("-");
            //将strArray变为list
            List<String> asList = Arrays.asList(strArray);  //长度固定

            //构架nLinkeedList集合
            LinkedList<String> list = new LinkedList<>(asList);

            //判断集合list是否包含访问id

            if(list.contains(id)){
                list.remove();
                list.addFirst(id);
            }else{
                //不包含id
                //假如长度3
                if(list.size()>=3){
                    list.removeLast();
                    list.addFirst(id);
                }else{
                    list.addFirst(id);
                }
            }

            //将ids清空
            ids="";
            //遍历LinkedList集合
            for(String s:list){
                ids+=(s+"");
            }
            //截取ids
            ids=ids.substring(0,ids.length()-1);
        }

        //将ods内容存储cookie
        c = new Cookie("ids",ids);
        //设置cookie有效时间
        c.setMaxAge(3600);
        //写会dao到浏览器
        response.addCookie(c);

        //重定向到指定商品页面
        response.sendRedirect("/product_info"+id+".html");

    }
}
