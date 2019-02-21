
package Bill_Controller;

import java.sql.SQLException;
import java.util.List;

/*
 * 用来实现对数据表数据的增删该查操作
 * 使用工具类完成QueryRunnerd对象的创建，指定数据源
 */

public class ZhangWuDao {
    private QueryRunner qr= new QueryRunner(JDBCUtils.getDataSource());
    /*
     * 定义方法查询数据库，获取所有账务的数据
     * 由业务层调用
     * 查询到的是一个结果集将所有的账务数据存储到Bean对象的及集合中。
     */
    public List<ZhangWu> selectAll(){
        try{
            //查询账务数据的SQL语句
            String sql="select * from gjp_zhangwu";
            //调用qr对象的query方法,使用结果集BeanListHandler
            List<ZhangWu> list =qr.query(sql,new BeanListHandler<>(ZhangWu.class));
            return list;
        }catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("查询所有账务失败!");
        }        
    }
    //条件查询
    public List<ZhangWu> select(String startDate,String endDate){
        try{
            //查询账务数据的SQL语句
            String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            //定义数组对象存储问号占位符
            Object[] params ={startDate,endDate};
            //调用qr对象的query方法,使用结果集BeanListHandler
            List<ZhangWu> list =qr.query(sql,new BeanListHandler<>(ZhangWu.class),params);
            return list;
        }catch(SQLException ex){
            System.out.println(ex);
            throw new RuntimeException("条件查询账务失败!");
        }        
    }
    
    //添加账务方法
    public void addZhangWu(ZhangWu zw) {
        try{
             //获取sql语句
            String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
            //保存占位符参数
            Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            //更新数据
            qr.update(sql, params);
        }catch(SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("添加账务失败！");
        }
    }
    //编辑账务
    public void editZhangWu(ZhangWu zw) {
        // TODO Auto-generated method stub
        try {
            // 修改sql语句
            String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
            // 存储占位符
            Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription(),zw.getZwid() };
            qr.update(sql, params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("编辑账务失败");
        }    
    }
    
    public void deletehangWu(int zwid) {
        // TODO Auto-generated method stub
        try {
            //删除语句
            String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
            qr.update(sql, zwid);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("数据删除失败!");
        }
    }
}
