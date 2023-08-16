package com.beautician.dao;

import java.util.List;

import com.beautician.entity.Beautician;

public interface IBeauticianDAO {
	int insert(Beautician beautician);
	int update(Beautician beautician);
	int delete(int bId);
	Beautician viewOne(int bId);
	List<Beautician> viewAll();
}