package cn.zk.jsj14.wsgwpt.domain;

public class Goods_imformation {
	private String goods_id;
	private String goods_name;
	private String goods_amount;
	private String goods_type;
	private Double good_price;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name	() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name	= goods_name;
	}
	public String getGoods_amount() {
		return goods_amount;
	}
	public void setGoods_amount(String goods_amount) {
		this.goods_amount = goods_amount;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public Double getGood_price() {
		return good_price;
	}
	public void setGood_price(Double good_price) {
		this.good_price = good_price;
	}
}
