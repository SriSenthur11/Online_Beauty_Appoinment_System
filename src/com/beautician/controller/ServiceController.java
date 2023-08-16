package com.beautician.controller;

import java.util.List;

import com.beautician.entity.Services;
import com.beautician.service.ServicesService;
import com.beautician.service.ServicesServiceImpl;

public class ServiceController {

	private ServicesService servicesService;

	public ServiceController() {
		servicesService = new ServicesServiceImpl();
	}
	
	public void insertService(Services service) {
		int status = servicesService.insertService(service);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateService(Services service) {
		int status = servicesService.updateService(service);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteService(int SerId) {
		int status = servicesService.deleteService(SerId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Services viewService(int SerId) {
		Services service = servicesService.viewService(SerId);
		return service;
	}
	
	public List<Services> viewAllservices(){
		return servicesService.viewServices();
	}
}
