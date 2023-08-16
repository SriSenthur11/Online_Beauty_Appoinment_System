package com.beautician.entity;

import java.util.Objects;

public class Appmt {
	private int AppId;
	private int CustId;
	private int SerId;
	
	
	public Appmt(int appId, int custId , int serId) {
		this.AppId = appId;
		this.CustId = custId;
		this.SerId = serId;
	}
	
	public int getCustId() {
		return CustId;
	}

	public void setCustId(int custId) {
		CustId = custId;
	}
	
	public void setSerId(int serId) {
		SerId = serId;
	}

	public int getSerId() {
		return SerId;
	}

	public Appmt() {
	}

	public Appmt(int AppId) {
		this.AppId = AppId;
	}

	public int getAppId() {
		return AppId;
	}

	public void setappId(int appId) {
		this.AppId = appId;
	}

	@Override
	public int hashCode() {
		return AppId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appmt other = (Appmt) obj;
		return AppId == other.AppId && CustId == other.CustId && SerId == other.SerId;
				
	}

	@Override
	public String toString() {
		return "Appoinment [AppId=" + AppId  +",SerId="+ SerId +", CustId= "+ CustId +"]";
		
	}


}