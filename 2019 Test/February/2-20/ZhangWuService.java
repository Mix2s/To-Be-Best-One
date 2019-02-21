
package Bill_Controller;

import java.util.List;

public class ZhangWuService {
	private static ZhangWuDao dao = new ZhangWuDao():
		/*
		 * 定义方法查询所有数据 控制层调用
		 * 去调用dao层方法
		 * 返回存储ZhangWu对象List集合
		 */
	public List<ZhangWu> selectAll(){
		return dao.selectAll();
	}
	//定义条件查询
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate,endDate);
	}
	//添加账务
	public static void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	//编辑账务
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	//删除账务
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
}
