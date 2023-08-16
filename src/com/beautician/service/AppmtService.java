package com.beautician.service;

import java.util.List;

import com.beautician.entity.Appmt;
import com.beautician.entity.Services;

public interface AppmtService {
	public int insertAppService(Appmt appmt);
	public int deleteAppService(int AppId);
	public Appmt viewAppService(int AppId);
	public List<Appmt> viewAppServices();
}

