package project.javacore.order;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import project.javacore.order.models.order;
import project.javacore.order.models.product;
import project.javacore.order.sevice.OderService;
import project.javacore.order.sevice.ProductSevice;

/**
 * Hello world!
 *
 */
public class App 
{
		public static List<product> Products= new ArrayList<product>();
		public static List<order> orders= new ArrayList<order>();
	 public static void menu() {
		 System.out.println("-------------Danh sách chức năng--------");
		 System.out.println("1.Thêm mới sản phẩm");
		 System.out.println("2.Hiển thị sản phẩm");
		 System.out.println("3.Sửa sản phẩm");
		 System.out.println("4. Xóa sản phẩm");
		 System.out.println("5. Mua sản phẩm");
		 System.out.println("6. Hiển thị đơn hàng");
		 System.out.println("7. Thoát");
	 }
    public static void main( String[] args )
    {
    	for(int i=0;i<4;i++) {
    		float price=(float)i+4;
    		product p=new product(i+1,"sản phẩm "+(i+1),i+1,"ghi chú",price);
    		App.Products.add(p);
    		}
       int function=0;
      
      
       do {  
    	   menu(); 
    	   Scanner input =new Scanner(System.in);
    	   try {
    	   System.out.println("Chọn chức năng:");
    	   function= input.nextInt();
    	   ProductSevice prs=new ProductSevice();
    	   OderService odsv=new OderService();
    	   switch (function) {
		case 1:
			prs.insert();
			break;
		case 2:
			prs.show();
			break;
		case 3:
			prs.update();
			break;
		case 4:
			prs.remove();
			break;
		case 5:
			odsv.Oder();
			break;
		case 6:
			odsv.show();
			break;

		default:
			break;
		}
       }catch(InputMismatchException i) {
    	   System.out.println("hãy nhập lại");
       }
    	   catch(Exception e) {
    	   System.out.println(e.getMessage());}
       }
       while(function!=7);
       System.out.println("cám ơn bạn đã sử dụng dịch vụ");
       }
    }
 
