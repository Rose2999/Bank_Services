package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.services.BankServices;

public class BankUtility {

	public static void main(String[] args)
	{
		int mainmenuchoice;
		char ans ;
		ArrayList<Services> serviceList=new ArrayList<Services>();
		ArrayList<Account> accountList=new ArrayList<Account>();
		 ArrayList<Product> productList=new ArrayList<Product>();
		Customer customer=null;
		
		Scanner scanner=new Scanner(System.in);
		
		do
		{    
			System.out.println("******WELCOME TO BANK******");
			System.out.println("1.Create service\n2.Create Product\n3.Create customer\n4.Manage accounts\n5.Display customer\n6.Exit");
			mainmenuchoice=scanner.nextInt();
			switch(mainmenuchoice)
			{
				 case 1:
					serviceList=BankServices.createService(serviceList);
					System.out.println("SERVICE CODE\t SERVICENAME");
					for(Services service: serviceList)
					{
						System.out.println(service.getServiceCode()+" "+service.getServiceName());
					}
				    break;
				 case 2:
					 productList=BankServices.createProduct(serviceList,productList);
					 for(Product product : productList) {
						   System.out.println("Product code: "+product.getProductCode());
						   System.out.println("Product name: "+product.getProductName());
							ArrayList<Services> serviceList1 = new ArrayList<Services>();
							serviceList1 = product.getServiceList();
							for(Services service : serviceList1) {
								System.out.println(service.getServiceCode()+" "+service.getServiceName());
							}
							
		             }
					 break;
				 case 3:
				     customer=BankServices.createCustomer(productList);
				     break;
				 case 4:
					 customer=BankServices.manageaccount(customer);
					 break;
				 case 5:
					 BankServices.displayDetails(customer);
					 break;
				 case 6:
					 System.exit(0);
				      break;
					 default:
						 System.out.println("invalid choice");
				
		    }
			
			System.out.println("Do you wish to continue (y/n) : ");
			ans=scanner.next().charAt(0);
        
	}while(ans=='y');

}
}
	
	

	

