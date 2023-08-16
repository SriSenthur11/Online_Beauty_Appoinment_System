package com.beautician.client;

import java.util.List;
import java.util.Scanner;

import com.beautician.controller.AppmtController;
import com.beautician.controller.BeauticianController;
import com.beautician.controller.NurseryController;
import com.beautician.controller.ServiceController;
import com.beautician.entity.Appmt;
import com.beautician.entity.Beautician;
import com.beautician.entity.Customer;
import com.beautician.entity.Services;

public class BeauticianDetail {

	public static void main(String[] args) {

		int choice = -1;
		int innerChoice = -1;
		int custId = 0;
		String name = null;
		String address = null;
		String contactNo = null;

		int bId = 0;
		String bname = null;
		String baddress = null;
		String bcontactNo = null;
		
		int SerId = 0;
		String Sername = null;
		
		int appId=0;
		
		ServiceController serviceController= new ServiceController();
		
		NurseryController nurseryController = new NurseryController();
		
		 AppmtController appmtController= new AppmtController();
		 
		 BeauticianController beauticianController = new BeauticianController();
		
		Customer customer = null;
		Services service=null;	
		Appmt appmt=null;
	

		

		Beautician beautician = null;

		Scanner scInput = new Scanner(System.in);
		do {
			System.out.println("Following is the choice:");
			System.out.println("1. Customer");
			System.out.println("2. Appoinment");
			System.out.println("3. Services");
			System.out.println("4. Beautician");
			System.out.println("0. Exit");

			choice = Integer.parseInt(scInput.nextLine());

			switch (choice) {
			case 1:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Customer");
					System.out.println("2. Update Customer");
					System.out.println("3. Delete Customer");
					System.out.println("4. View single customer");
					System.out.println("5. View all customers");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					
					case 1:
						System.out.print("Enter customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter address: ");
						address = scInput.nextLine();
						
						System.out.print("Enter contact no: ");
						contactNo = scInput.nextLine();
						
						customer = new Customer(custId, name, address, contactNo);
	
						nurseryController.insertCustomer(customer);
						break;
					case 2:
						System.out.print("Enter customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						name = scInput.nextLine();
						
						System.out.print("Enter address: ");
						address = scInput.nextLine();
						
						System.out.print("Enter contact no: ");
						contactNo = scInput.nextLine();
						
						customer = new Customer(custId, name, address, contactNo);
	
						nurseryController.updateCustomer(customer);
						break;
					case 3:
						System.out.print("Enter customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						nurseryController.deleteCustomer(custId);
						break;
					case 4:
						System.out.print("Enter customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						customer = nurseryController.viewCustomer(custId);
						System.out.println(customer);
						break;
					case 5:
						List<Customer>customers = nurseryController.viewAllCustomers();
						
						System.out.println("Following is the customer list:");
						
						for(Customer cust : customers) {
							System.out.println(cust);
						}
						break;							
					}
				}while(innerChoice != 0);
				break;
			case 2:
				do {
					System.out.println();
					System.out.println("1. Book an Appointment");
					System.out.println("2. Delete Appointment");
					System.out.println("3. View Appointment");
					System.out.println("4. View all Appointments");
					System.out.println("0. Go Back");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						List<Services>services = serviceController.viewAllservices();
						
						System.out.println("Following is the list of Services:");
						
						for(Services ser : services) {
							System.out.println(ser);
						}
						System.out.print("Enter Appointment ID: ");
						appId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Customer ID: ");
						custId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service ID: ");
						SerId = Integer.parseInt(scInput.nextLine());
						
						appmt = new Appmt(appId,custId,SerId);
						
						appmtController.insertAppService(appmt);

						break;
					
					case 2:
						System.out.print("Enter Appointment ID: ");
						appId = Integer.parseInt(scInput.nextLine());
						
						appmtController.deleteAppService(appId);
						break;
					case 3:
						System.out.print("Enter Appointment ID: ");
						appId = Integer.parseInt(scInput.nextLine());
						
						appmt = appmtController.viewAppService(appId);
						System.out.println(appmt);
						break;
					case 4:
						List<Appmt>appointments = appmtController.viewAllAppServices();
						
						System.out.println("Following is the list of Services:");
						
						for(Appmt app : appointments) {
							System.out.println(app);
						}
						break;							
					}
				}while(innerChoice != 0);
				break;	
			case 3:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Services");
					System.out.println("2. Update Services");
					System.out.println("3. Delete Services");
					System.out.println("4. View single Service");
					System.out.println("5. View all Services");
					System.out.println("0. Exit");
					
					innerChoice = Integer.parseInt(scInput.nextLine());
					
					switch(innerChoice) {
					case 1:
						System.out.print("Enter Service ID: ");
						SerId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter Service: ");
						Sername = scInput.nextLine();
						
						service = new Services(SerId, Sername);
	
						serviceController.insertService(service);
						break;
					case 2:
						System.out.print("Enter Service ID: ");
						SerId = Integer.parseInt(scInput.nextLine());
						
						System.out.print("Enter name: ");
						Sername = scInput.nextLine();
						
						
						service = new Services(SerId, Sername);
	
						serviceController.updateService(service);
						break;
					case 3:
						System.out.print("Enter Service ID: ");
						SerId = Integer.parseInt(scInput.nextLine());
						
						serviceController.deleteService(SerId);
						break;
					case 4:
						System.out.print("Enter Service ID: ");
						SerId = Integer.parseInt(scInput.nextLine());
						
						service = serviceController.viewService(SerId);
						System.out.println(service);
						break;
					case 5:
						List<Services>services = serviceController.viewAllservices();
						
						System.out.println("Following is the list of Services:");
						
						for(Services ser : services) {
							System.out.println(ser);
						}
						break;							
					}
				}while(innerChoice != 0);
				break;				
			case 4:
				do {
					System.out.println("Following is the choice:");
					System.out.println("1. Insert Beautician details");
					System.out.println("2. Update Beautician details");
					System.out.println("3. Delete Beautician details");
					System.out.println("4. View single Beautician");
					System.out.println("5. View all Beautician Available");
					System.out.println("0. Exit");

					innerChoice = Integer.parseInt(scInput.nextLine());

					switch (innerChoice) {
					case 1:
						System.out.print("Enter Beautician ID: ");
						bId = Integer.parseInt(scInput.nextLine());

						System.out.print("Enter name: ");
						bname = scInput.nextLine();

						System.out.print("Enter address: ");
						baddress = scInput.nextLine();

						System.out.print("Enter contact no: ");
						bcontactNo = scInput.nextLine();

						beautician = new Beautician(bId, bname, baddress, bcontactNo);

						beauticianController.insertBeautician(beautician);
						break;
					case 2:
						System.out.print("Enter Beautician ID: ");
						bId = Integer.parseInt(scInput.nextLine());

						System.out.print("Enter name: ");
						bname = scInput.nextLine();

						System.out.print("Enter address: ");
						baddress = scInput.nextLine();

						System.out.print("Enter contact no: ");
						bcontactNo = scInput.nextLine();

						beautician = new Beautician(bId, bname, baddress, bcontactNo);

						beauticianController.updateBeautician(beautician);
						break;
					case 3:
						System.out.print("Enter Beautician ID: ");
						bId = Integer.parseInt(scInput.nextLine());

						beauticianController.deleteBeautician(bId);
						break;
					case 4:
						System.out.print("Enter Beautician ID: ");
						bId = Integer.parseInt(scInput.nextLine());

						beautician = beauticianController.viewBeautician(bId);
						System.out.println(beautician);
						break;
					case 5:
						List<Beautician> beauticians = beauticianController.viewAllBeauticians();

						System.out.println("Following is the Beautician list:");

						for (Beautician b : beauticians) {
							System.out.println(b);
						}
						break;
					}
				} while (innerChoice != 0);
				break;
			}
		} while (choice != 0);
		scInput.close();
	}

}
