package com.beautician.service;

import java.util.List;

import com.beautician.dao.serviceDAOImpl;
import com.beautician.entity.Services;
import com.beautician.dao.IserviceDAO;
import com.beautician.entity.Customer;

public class ServicesServiceImpl implements ServicesService {

	private serviceDAOImpl serviceDAO;
	
	public ServicesServiceImpl() {
		serviceDAO = new serviceDAOImpl();
	}
	
	@Override
	public int insertService(Services service) {
		return serviceDAO.insertService(service);
	}

	@Override
	public int updateService(Services service) {
		return serviceDAO.updateService(service);
	}

	@Override
	public int deleteService(int SerId) {
		return serviceDAO.deleteService(SerId);
	}

	@Override
	public Services viewService(int custId) {
		return serviceDAO.viewOneService(custId);
	}

	@Override
	public List<Services> viewServices() {
		return serviceDAO.viewAllServices();
	}

}
