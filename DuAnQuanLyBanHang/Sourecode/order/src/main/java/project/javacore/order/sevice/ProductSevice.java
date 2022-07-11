package project.javacore.order.sevice;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.javacore.order.App;
import project.javacore.order.models.product;

public class ProductSevice {
	public void insert() {
		Scanner input =new Scanner(System.in);
		System.out.println("nhập thông tin sản phẩm");
		try {
		System.out.println("Mã: ");
		int id= input.nextInt();
		input.nextLine(); 
		System.out.println("Tên sản phẩm: ");
		String name= input.nextLine();
		
		System.out.println("Số lượng: ");
		int quantity= input.nextInt();
		input.nextLine();
		System.out.println("Ghi chú: ");
		String description= input.nextLine();
		 
		
		System.out.println("giá bán:");
		float price=input.nextFloat();
		     
		product p =new product(id,name,quantity,description,price);
		App.Products.add(p);
		}
		catch(InputMismatchException i) {
	    	   System.out.println("hãy nhập lại");
	       }
	    	   catch(Exception e) {
	    	   System.out.println(e.getMessage());}
		}
	
public void show() {
		System.out.println("Danh sách sản phẩm: ");
		String header =String.format("%4s%10s%15s%15s%13s","Mã","Tên","Số lượng","Giá bán","Ghi chú");
		System.out.println(header);
		for(product p : App.Products){
			String row =String.format("%4d%10s%15d%15f%13s",p.getId(),p.getName(),p.getQuantity(),p.getPrice(),p.getDescription());
			System.out.println(row);
}
}
public void update() {
	Scanner inputs = new Scanner(System.in);
	
	try {
		System.out.println("nhập mã sản phẩm cần sửa: ");
		Integer id=inputs.nextInt();
		product product =null;
		for(product p :App.Products) {
			if(p.getId().equals(id)) {
				product=p;
				break;
				}
		}
		if(product == null) {
			System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại");
		}
		System.out.println("thông tin sản phẩm");
		String header =String.format("%4s%10s%15s%15s%13s","Mã","Tên","Số lượng","Giá bán","Ghi chú");
		String row =String.format("%4d%10s%15d%15f%13s",product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription());
		System.out.println(row);
		
		for(int i=0;i<=App.Products.size();i++) {
			if(id.equals(App.Products.get(i).getId())) {
				inputs.nextLine(); 
				System.out.println("Tên sản phẩm: ");
				String name= inputs.nextLine();
				
				System.out.println("Số lượng: ");
				int quantity= inputs.nextInt();
				
				inputs.nextLine();
				
				System.out.println("Ghi chú: ");
				String description= inputs.nextLine();
				 
				
				System.out.println("giá bán:");
				float price=inputs.nextFloat();
				
				App.Products.get(i).setName(name);
				App.Products.get(i).setQuantity(quantity);
				App.Products.get(i).setDescription(description);
				App.Products.get(i).setPrice(price);
			}
		}
		
		}
		catch(InputMismatchException i) {
	    	   System.out.println("hãy nhập lại");
	       }
	    	   catch(Exception e) {
	    	   System.out.println(e.getMessage());}
		}
	public void remove() {
		Scanner inputs = new Scanner(System.in);
		
		try {
			System.out.println("nhập mã sản phẩm cần xóa: ");
			Integer id=inputs.nextInt();
			product product =null;
			for(product p :App.Products) {
				if(p.getId().equals(id)) {
					product=p;
					break;
					}
			}
			if(product == null) {
				System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại");
			}
			System.out.println("thông tin sản phẩm");
			String header =String.format("%4s%10s%15s%15s%13s","Mã","Tên","Số lượng","Giá bán","Ghi chú");
			String row =String.format("%4d%10s%15d%15f%13s",product.getId(),product.getName(),product.getQuantity(),product.getPrice(),product.getDescription());
			System.out.println(row);
			
			
			for(int i=0;i<=App.Products.size();i++) {
				if(id.equals(App.Products.get(i).getId())) {			
					App.Products.remove(product);
				}
			}
			
			}
			catch(InputMismatchException i) {
		    	   System.out.println("hãy nhập lại");
		       }
		    	   catch(Exception e) {
		    	   System.out.println(e.getMessage());}
			}
	
	public product getById(int id) {
		product products= new product();
		for(product p :App.Products) {
			if(p.getId().equals(id)) {
				products=p;
				break;
				}
		}

		return products;
		
	}
}


	

