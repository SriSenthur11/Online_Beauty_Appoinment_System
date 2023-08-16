package com.beautician.service;

import java.util.List;

import com.beautician.entity.Beautician;

public interface BeauticianService {
	public int insertBeautician(Beautician beautician);
	public int updateBeautician(Beautician beautician);
	public int deleteBeautician(int custId);
	public Beautician viewBeautician(int bId);
	public List<Beautician>viewBeauticians();
}
