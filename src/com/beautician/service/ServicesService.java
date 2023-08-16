package com.beautician.service;

import java.util.List;

import com.beautician.entity.Services;

public interface ServicesService {
	public int insertService(Services service);
	public int updateService(Services service);
	public int deleteService(int SerId);
	public Services viewService(int SerId);
	public List<Services>viewServices();
}
