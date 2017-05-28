package cn.zk.jsj14.wsgwpt.domain;

public class Shopping_cart {
	private String thing_id;
	private String thing_name;
	private String thing_amount;
	private String thing_state;
	private Double thing_price;
	public String getThing_id() {
		return thing_id;
	}
	public void setThing_id(String thing_id) {
		this.thing_id =thing_id;
	}
	public String getThing_name	() {
		return thing_name;
	}
	public void setThing_name(String thing_name) {
		this.thing_name	= thing_name;
	}
	public String getThing_amount() {
		return thing_amount;
	}
	public void setThing_amount(String thing_amount) {
		this.thing_amount = thing_amount;
	}
	public String getThing_state() {
		return thing_state;
	}
	public void setThing_state(String thing_state) {
		this.thing_state = thing_state;
	}
	public Double getThing_price() {
		return thing_price;
	}
	public void setThing_price(Double thing_price) {
		this.thing_price = thing_price;
	}
}
