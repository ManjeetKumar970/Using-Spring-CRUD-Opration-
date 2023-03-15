package org.jsp.userapp.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.userapp.UserConfig;
import org.jsp.userapp.dto.User;
import org.jsp.userapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SaveUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		UserService service =context.getBean(UserService.class);
		
		boolean b =false;
		System.out.println("Enter Name");
		String name2 = sc.nextLine();
		System.out.println("Enter PassWord");
		String password = sc.nextLine();
		
	   User user1=service.userVerification(name2, password);
	    if(user1!=null) {
		
		do {
		  
		 System.out.println("Enter You chouse ");
		 System.out.println("S : Save Data ");
		 System.out.println("U : Update Data ");
		 System.out.println("D : Delete Data ");
		 System.out.println("F : Find By id Data ");
		 System.out.println("A : Display All Details of  Data ");

		 char chouse = sc.next().charAt(0);
		 char ch = Character.toUpperCase(chouse);
		 switch(ch) {
		 // Save date
		 case 'S':
			 System.out.println("Enter Name :");
			   String name = sc.next();
			 System.out.print("Enter Password :");
			   String pass = sc.next();
			System.out.println("Enter Phone :");
			   double phone = sc.nextDouble();
			    user.setName(name);
				user.setPassword(pass);
				user.setPhone(phone);
				service.saveUser(user);
				 System.out.println("SAVE Succesfully");
			 break;
		
			 //update Data
		 case 'U' :
			 System.out.println("Enter Name :");
			   String name1 = sc.nextLine();
			 System.out.println("Enter Password :");
			   String pass1 = sc.nextLine();
			System.out.println("Enter Phone :");
			   double phone1 = sc.nextDouble();
			    user.setName(name1);
				user.setPassword(pass1);
				user.setPhone(phone1);
				service.updateUser(user);
				 System.out.println("Update Succesfully");
				break;
				// Delete Data
		 case 'D':
			 System.out.println("Enter Id ");
			 int d=sc.nextInt();
			 service.DeleteUser(d);
			 System.out.println("Delete Succesfully");
			 break;
			 
			 // Find data using Id
		 case 'F':
			 System.out.println("Enter Id");
			 int id=sc.nextInt();
			 User ef=service.findUserById(id);
			 if(ef!=null) {
				 System.out.println(ef.getId());
				 System.out.println(ef.getName());
				 System.out.println(ef.getPassword());
				 System.out.println(ef.getPhone());
				
			 }
		     break;
		     
		     // Display All data
		 case 'A':
			 List<User> al=service.ShowAllUser();
			 for(User t:al) {
				 System.out.println(t.getId());
				 System.out.println(t.getName());
				 System.out.println(t.getPassword());
				 System.out.println(t.getPhone());
			 }
				break;
				
				// Exit 
		  case 'E':
			  sc.close();
			  System.exit(0);
			  break;
		  default:
			  System.out.println("Select S,A,D,F,U");
		 
		}
			
		}while(b!=true);
	    }else {
	    	System.out.println("Check User Password");
	    }
	}
}
