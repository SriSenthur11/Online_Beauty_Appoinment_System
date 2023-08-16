package com.beautician.service;

import java.util.List;

import com.beautician.dao.BeauticianDAOImpl;
import com.beautician.dao.IBeauticianDAO;
import com.beautician.entity.Beautician;

public class BeauticianServiceImp1 implements BeauticianService {

	private IBeauticianDAO beauticianDAO;
	
	public BeauticianServiceImp1() {
		beauticianDAO = new BeauticianDAOImpl();
	}
	
	@Override
	public int insertBeautician(Beautician beautician) {
		return beauticianDAO.insert(beautician);
	}

	@Override
	public int updateBeautician(Beautician beautician) {
		return beauticianDAO.update(beautician);
	}

	@Override
	public int deleteBeautician(int bId) {
		return beauticianDAO.delete(bId);
	}

	@Override
	public Beautician viewBeautician(int bId) {
		return beauticianDAO.viewOne(bId);
	}

	@Override
	public List<Beautician> viewBeauticians() {
		return beauticianDAO.viewAll();
	}

}

