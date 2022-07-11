package project.javacore.order.sevice;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.javacore.order.App;
import project.javacore.order.models.OrderDetail;
import project.javacore.order.models.order;
import project.javacore.order.models.product;

public class OderService {
	public void Oder() {
		Scanner input=new Scanner(System.in);
		System.out.println("----------------------mua hàng----------------------");	
		try {
			System.out.println("Mã đặt hàng");
			Integer id=input.nextInt();
			 input.nextLine();
			 System.out.println("nhập tên khách hàng:");
			 String customerName=input.nextLine();
			 
			 System.out.println("nhập số điện thoại:");
			 String phone= input.nextLine();
			 
			 
			 System.out.println("nhập email:");
			 String email=input.nextLine();
					 
			 order orders= new order(id,customerName,phone,email);
			 Integer productId=-1;
			 while(true) {
				 Scanner inputs=new Scanner(System.in);
				 System.out.println("nhập mã sản phẩm(nhập -1 để kết thúc): ");
				 productId=inputs.nextInt();
				 if(productId.equals(-1)) {
					 break;
				 }
				 
				 System.out.println("nhập số lượng:");
				 int quantity=inputs.nextInt();
				 product products =null;
					for(product p :App.Products) {
						if(p.getId().equals(productId)) {
							products=p;
							break;
							}
					}
					if(products ==null) {
						System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại");
					}					
				 
			
			OrderDetail oderdetail= new OrderDetail();
			oderdetail.setId(1);
			oderdetail.setOrderId(orders.getId());
			oderdetail.setPrice(products.getPrice());
			oderdetail.setProductId(productId);
			oderdetail.setQuantity(quantity);
			orders.getOrderdentails().add(oderdetail);
				 
			 }
			 App.orders.add(orders);
			}
			catch(InputMismatchException i) {
		    	   System.out.println("hãy nhập lại");
		       }
		    	   catch(Exception e) {
		    	   System.out.println(e.getMessage());}
			}
		
	
public void show() {
	System.out.println("Danh sách đặt hàng: ");
	String header =String.format("%4s%10s%15s%13s","Mã","Tên khách hàng","số điện thoại","email");
	System.out.println(header);
	for(order oders: App.orders){
		String row =String.format("%4d%10s%15s%13s",oders.getId(),oders.getCustomerName(),oders.getPhone(),oders.getEmail());
		System.out.println(row);
		
		String orderdetailheader =String.format("%4s%10s%15s%13s","STT","Tên sản phẩm","giá","số lượng");
		System.out.println(orderdetailheader);	
		ProductSevice productsevice= new ProductSevice();
		
		int i=1;
		for(OrderDetail od: oders.getOrderdentails()) {
			product p= productsevice.getById(od.getProductId());
			String orderdetailrow =String.format("%4d%10s%15s%13s",i,p.getName(),od.getPrice(),od.getQuantity());
			System.out.println(orderdetailrow);
			i++;
		}
	
}
}}


