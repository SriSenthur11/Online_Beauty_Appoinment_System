package com.beautician.dao;

import java.util.List;

import com.beautician.entity.Services;

public interface IserviceDAO {
	int insertService(Services service);
	int updateService(Services service);
	int deleteService(int SerId);
	Services viewOneService(int SerId);
	List<Services> viewAllServices();
}