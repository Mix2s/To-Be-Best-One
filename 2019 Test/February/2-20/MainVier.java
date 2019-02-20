package Bill_Controller;

import java.util.List;
import java.util.Scanner;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	Scanner sc = new Scanner(System.in);
	public void run() {
		boolean flag = true;
		while(true) {
			System.out.println("-----记账软件-----");
			System.out.println("1.添加账务 2.编辑账务 3.删除帐务 4.查询账务 5.推出系统");
			System.out.println("请输入你的操作：");
			int choose = sc.nextInt();
			switch(choose) {
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.out.println("退出");
				flag=false;
				break;
			default:
					System.out.println("输入错误");
			}
		}
	}
	
	private void selectZhangWu() {
		// TODO Auto-generated method stub
		System.out.println("1.查询所有 2.按条件查询");
		Scanner in = new Scanner(System.in);
		int choose=in.nextInt();
		switch(choose) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			System.out.println("输入错误");
		}
	}
	
	//全部查询
	public void selectAll() {
		//调用控制层的方法查询所有账务数据
		List<ZhangWu> list = controller.selectAll();
		print(list);
	}
	/*
	 * 实现条件查询，用户输入开始和结束日期
	 * 两个参数传递到controller 获取结果打印
	 */
	public void select() {
		Scanner sc = new Scanner(System.in);
		System.out.println("选择条件为 请输入日期格式:YYYY-MM-DD");
		System.out.println("输入开始日期");
		String startDate = sc.nextLine();
		System.out.println("书屋结束日期");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate,endDate);
		if(list.size()!=0) {
			print(list);
		}else {
			System.out.println("没有查询到数据");
		}
	}
	
	private void print(List<ZhangWu> list) {
		System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for(ZhangWu zw:list) {
			System.out.println(zw.getZwid());
			System.out.println(zw.getFlname());
			System.out.println(zw.getZhanghu());
			System.out.println(zw.getMoney());
			System.out.println(zw.getCreatetime());
			System.out.println(zw.getDescription());
		}
	}
	

	private void deleteZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		System.out.println("选择删除的功能，请输入需要删除的ID：");
		int zwid=sc.nextInt();
		controller.deletezhanghu(zwid);
		System.out.println("删除成功");
	}
	
	
	
	private void editZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		System.out.println("选择编辑功能，请输入数据");
		System.out.println("输入ID");
		int zwid = sc.nextInt();
		System.out.println("输入分类名称");
		String flname = sc.next();
		System.out.println("输入金额");
		double money = sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu = sc.next();
		System.out.println("输入日期格式YYYY-MM-DD");
		String createtime = sc.next();
		System.out.println("输入描述");
		String description=sc.next();
	}

	//添加账号
	public void addZhangWu() {
		System.out.println("选择添加账号的功能");
		System.out.println("输入分类的名称");
		String flname = sc.next();
		
		System.out.println("输入的金额");
		double money = sc.nextDouble();
		System.out.println("输入账户");
		String zhangwu = sc.next();
		System.out.println("请输入日期的格式：YYYY-MM-DD");
		String createtime=sc.next();
		System.out.println("输入具体描述");
		String description=sc.next();
		//将用户输入的数据封装成对象 id为0
		ZhangWu zw = new ZhangWu(0,flname,money,zhangwu,createtime,description);
		//调用comtroller添加方法
		controller.addZhangWu(zw);
		System.out.println("添加成功");
	}
}
