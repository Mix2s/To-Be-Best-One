
package Bill_Controller;

import java.util.List;

public class ZhangWuController {
	private static ZhangWuService service = new ZhangWuService();\
	/*
	 * 定义查询所有账务数据的方法由视图层调用
	 * 起调用service的方法
	 */
	public List<ZhangWu> selectAll(){
		return service.selectAll();
	}
	//定义条件查询
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate,endDate);
	}
	//添加账务由视图层调用传递过来不是5个参数而是一个zhangwu对象
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	//添加账务
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	//删除账务
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}
}
