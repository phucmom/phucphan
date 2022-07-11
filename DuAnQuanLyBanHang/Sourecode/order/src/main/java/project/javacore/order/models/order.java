package project.javacore.order.models;

import java.util.ArrayList;
import java.util.List;

public class order {
	private Integer id;
	private String customerName;
	private String phone;
	private String email;
	
	private List<OrderDetail> orderdentails= new ArrayList<OrderDetail>();
	
	public order(Integer id,String customerName,String phone,String email) {
		this.id=id;
		this.customerName=customerName;
		this.phone=phone;
		this.email=email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderDetail> getOrderdentails() {
		return orderdentails;
	}
	public void setOrderdentails(List<OrderDetail> orderdentails) {
		this.orderdentails = orderdentails;
	}
}
