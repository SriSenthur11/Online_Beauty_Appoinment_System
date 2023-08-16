package com.beautician.service;

import java.util.List;

import com.beautician.dao.AppmtDAOImpl;
import com.beautician.dao.IAppmtDAO;
import com.beautician.entity.Appmt;

public class AppmtServiceImpl implements AppmtService {

	private IAppmtDAO appmtDAO;
	
	public AppmtServiceImpl() {
		appmtDAO = new AppmtDAOImpl();
	}
	
	@Override
	public int insertAppService(Appmt appmt) {
		return appmtDAO.insertAppService(appmt);
	}

	@Override
	public int deleteAppService(int appId) {
		return appmtDAO.deleteAppService(appId);
	}

	@Override
	public Appmt viewAppService(int appId) {
		return appmtDAO.viewOneAppService(appId);
	}

	@Override
	public List<Appmt> viewAppServices() {
		return appmtDAO.viewAllAppServices();
	}

}

