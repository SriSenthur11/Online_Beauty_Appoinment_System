package com.beautician.controller;

import java.util.List;

import com.beautician.entity.Beautician;
import com.beautician.service.BeauticianService;
import com.beautician.service.BeauticianServiceImp1;

public class BeauticianController {

	private BeauticianService beauticianService;

	public BeauticianController() {
		beauticianService = new BeauticianServiceImp1();
	}
	
	public void insertBeautician(Beautician beautician) {
		int status = beauticianService.insertBeautician(beautician);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
		
	}
	
	public void updateBeautician(Beautician beautician) {
		int status = beauticianService.updateBeautician(beautician);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteBeautician(int bId) {
		int status = beauticianService.deleteBeautician(bId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Beautician viewBeautician(int bId) {
		Beautician beautician = beauticianService.viewBeautician(bId);
		return beautician;
	}
	
	public List<Beautician> viewAllBeauticians(){
		return beauticianService.viewBeauticians();
	}


}

