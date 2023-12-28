package com.ilp.services;

import java.security.Provider.Service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class BankServices

{
	public static  ArrayList<Services> createService(ArrayList<Services> serviceList) 
	{
		
		char ans;
		do
		{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the service code");
		String serviceCode=scanner.nextLine();
		System.out.println("Enter the service name");
		String serviceName=scanner.nextLine();
		System.out.println("Enter the service rate");
		double serviceRate=scanner.nextDouble();
		Services service=new Services(serviceCode,serviceName,serviceRate);
		serviceList.add(service);
		System.out.println("Do you wish to add more services(y/n)");
		ans=scanner.next().charAt(0);
		}while(ans=='y');
		return serviceList;
	}
	public static ArrayList<Product> createProduct(ArrayList<Services> serviceList,ArrayList<Product> productList) 
	{
		
	   char ans;
	   char moreProductChoice;
       do
       {
    	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the product code");
		String productCode=scanner.nextLine();
		System.out.println("Enter the product name");
		String productName=scanner.nextLine();
		System.out.println("Service code\tServicename");
		ArrayList<Services> newServiceList=new ArrayList<Services>();
		for(Services service:serviceList)
		{
          System.out.println(service.getServiceCode()+" "+service.getServiceName());
	    }
		do
		{
			Scanner scanner2=new Scanner(System.in);	
		    String code;
			System.out.println("Enter the servicecode you wish to add");
			code=scanner2.nextLine();
			for(Services service:serviceList)
			{
			 if(code.equalsIgnoreCase(service.getServiceCode()))
			 {
				 newServiceList.add(service);
			 }}
			 System.out.println("Do you wish to add more services\n");
			 ans=scanner2.next().charAt(0);
			 scanner.nextLine();
			}while(ans=='y');
	
			if (productName.equalsIgnoreCase("SavingsMaxAccount"))
	        {
				SavingsMaxAccount product = new SavingsMaxAccount(productCode, productName, newServiceList);
	           productList.add(product);
	        }
	        else if (productName.equalsIgnoreCase("CurrentAccount"))
	        {
	       	CurrentAccount product  = new CurrentAccount(productCode, productName, newServiceList);
	           productList.add(product);
	        }
	        else if (productName.equalsIgnoreCase("LoanAccount"))
	        {
	         	LoanAccount product = new LoanAccount(productCode, productName, newServiceList);
	           productList.add(product);
	        }
			
			
			System.out.println("Do you want to add more products into productlist : ");
			moreProductChoice = scanner.next().charAt(0);
		
		
	}while(moreProductChoice == 'y');

	return productList;
		
	
}
     

		public static Customer createCustomer(ArrayList<Product> productList) {
			// TODO Auto-generated method stub
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Customer Code : ");
			String customerCode = scanner.nextLine();
			System.out.println("Enter the Customer Name : ");
			String customerName = scanner.nextLine();
			ArrayList<Account> accountList = new ArrayList<Account>();
			char repeatChoice;
			do {
				Scanner scanner1 = new Scanner(System.in);
				
				accountList.add(createAccount(productList));
				System.out.println("Do you want to create more account : ");
				repeatChoice = scanner1.next().charAt(0);
				
			}while(repeatChoice == 'y');
				
			Customer customer =  new Customer(customerCode, customerName, accountList);
			return customer;
			
		}
	 
	 
		private static Account createAccount(ArrayList<Product> productList) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Account No : ");
			String accountNo = scanner.nextLine();
			System.out.println("Enter theccount Type : ");
			String  accountType = scanner.nextLine();
			System.out.println("Enter the Account Balance : ");
			double accountBalance = scanner.nextDouble();
			
			Product accountProduct = null;
			
			System.out.println("Product Code" + "	"  + "Product Name" );
			for (Product product : productList)
			{
				System.out.println(product.getProductCode() + "	"  + product.getProductName());  
			}
			
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Enter the Product Code of the product you want to add : ");
			String productCode = scanner1.nextLine();
				
			for (Product product : productList)
			{
				if( product.getProductCode().equalsIgnoreCase(productCode))
					accountProduct = product;				
			}
			
			Account account =  new  Account(accountNo, accountType, accountBalance,  accountProduct);
			return account;
			// TODO Auto-generated method stub
			
		}
		public static Customer manageaccount(Customer customer)
		{String accountNum;
		System.out.println("Enter the customer code");
		Scanner scanner=new Scanner(System.in);
		if(customer.getCustomerCode().equalsIgnoreCase(scanner.nextLine()))
				{
			    System.out.println(customer.getCustomerName()+"  has the following accounts");
			    for(Account account:customer.getAccount())
			    {
			    	System.out.println(account.getAccountNo()+account.getAccountType());
			    }
			    System.out.println("Enter your account number choice :");
			    accountNum=scanner.nextLine();
			    for(Account account:customer.getAccount())
			    {   int flag=0;
			    	if(accountNum.equalsIgnoreCase(account.getAccountNo()))
			    	{	
			    	   flag=1;
			    	  char ans;
			    		do
			    		{  
			    			int choice;
			    			System.out.println("*****Manage Account******");
			    			System.out.println("1.Deposit 2.Withdraw 3.Display balance\n");
			    			choice=scanner.nextInt();
			    			switch(choice)
			    			{
			    			case 1:
			    			  account.getProduct().depositMoney(account);
			    			  break;
			    			case 2:
			    			  account.getProduct().withdrawMoney(account);
			    			  break;
			    			case 3:
			    				System.out.println("Account no: "+account.getAccountNo());
			    				System.out.println("Account balance: "+account.getBalance());
			    				break;
			    			default:
			    				System.out.println("invalid choice");
			    				
			    			}
			    			if(flag==0)
			    			{
			    				System.out.println("No such account");
			    			}
			    			System.out.println("do you wish to continue with manage account");
			    			ans=scanner.next().charAt(0);
			    		}while(ans=='y' || ans=='Y');
			    		
			    	}
			    			
			    }
			    }return customer;
			
		}
		public static void displayDetails(Customer customer) 
		{
			System.out.println("******Customer Details*******");
			System.out.println("Customer code: "+customer.getCustomerCode());
			System.out.println("Customer name: "+customer.getCustomerName());
			for(Account account:customer.getAccount())
			{
				displayDetails(account);
			}
			
		}
		public static void displayDetails(Account account)
		{
			System.out.println("Account Name : "+account.getAccountType());
			System.out.println("Account Balance : "+account.getBalance());
			displayDetails(account.getProduct());
		}
	   public static void displayDetails(Product product)
	   {
		 System.out.println("Product code : "+product.getProductCode());
		System.out.println("Product Name : "+product.getProductName());
		for(Services service:product.getServiceList())
		{
			displayDetails(service);
		}
	   }
	   public static void displayDetails(Services service)
	   {
		   System.out.println("Service code :"+service.getServiceCode());
		   System.out.println("Service name : "+service.getServiceName());
	   }
	}