class Member{
	private String goods;
	//货品单价
	private long price;
	//个数
	private long num;
	//单价金额
	private long singleprice;
	//总金额
	private long sumprice;
	//实际金额
	private long factprice;
	
	public void setGoods(String goods){
		this.goods = goods;
	}
	public String getGoods(){
		return goods;
	}
	public void setPrice(long price){
		this.price = price;
	}
	public long getPrice(){
		return price;
	}
	public void setNum(long num){
		this.num=num;
	}
	public long getNum(){
		return num;
	}
	public void setSingleprice(long singleprice){
		this.singleprice = singleprice;
	}
	public long getSingleprice(){
		return singleprice;
	}
	public void setSumprice(long sumprice){
		this.sumprice = sumprice;
	}
	public long getSumprice(){
		return sumprice;
	}
	public void setFactprice(long factprice){
		this.factprice = factprice;
	}
	public long getFactprice(){
		return factprice;
	}

	public Member(long num){
		this.numl
	}
}

class utils extends Member{
	/*
		计算单个商品总额
	*/
	public long Caleprice(long price,long num){
		this.setPrice(price);
		this.setNum(num);
		return this.getPrice()*this.getNum();
	}
	/*
		计算总金额
	*/
	public discount(){
		
	}
}

public class Ticket{
	
}
