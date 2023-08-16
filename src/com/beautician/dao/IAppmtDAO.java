package com.beautician.dao;

import java.util.List;

import com.beautician.entity.Appmt;
import com.beautician.entity.Services;

public interface IAppmtDAO {
	int insertAppService(Appmt appmt);
	int deleteAppService(int AppmtId);
	Appmt viewOneAppService(int AppmtId);
	List<Appmt> viewAllAppServices();
}