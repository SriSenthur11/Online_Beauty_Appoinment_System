package com.beautician.controller;

import java.util.List;

import com.beautician.entity.Appmt;
import com.beautician.service.AppmtService;
import com.beautician.service.AppmtServiceImpl;

public class AppmtController {

	private AppmtService appmtService;

	public AppmtController() {
		appmtService = new AppmtServiceImpl();
	}
	
	public void insertAppService(Appmt appmt) {
		int status = appmtService.insertAppService(appmt);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	
	
	public void deleteAppService(int appId) {
		int status = appmtService.deleteAppService(appId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Appmt viewAppService(int appId) {
		Appmt appmt = appmtService.viewAppService(appId);
		return appmt;
	}
	
	public List<Appmt> viewAllAppServices(){
		return appmtService.viewAppServices();
	}
}
