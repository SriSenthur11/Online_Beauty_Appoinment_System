package com.beautician.entity;

import java.util.Objects;

public class Beautician {
	private int bId;
	private String bname;
	private String baddress;
	private String bcontactNo;
	
	public Beautician(){
		
	}

	public Beautician(int bId, String bname, String baddress, String bcontactNo) {
		this.bId = bId;
		this.bname = bname;
		this.baddress = baddress;
		this.bcontactNo = bcontactNo;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getName() {
		return bname;
	}

	public void setName(String bname) {
		this.bname = bname;
	}

	public String getAddress() {
		return baddress;
	}

	public void setAddress(String baddress) {
		this.baddress = baddress;
	}

	public String getContactNo() {
		return bcontactNo;
	}

	public void setContactNo(String bcontactNo) {
		this.bcontactNo = bcontactNo;
	}

	@Override
	public int hashCode() {
		return bId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beautician other = (Beautician) obj;
		return Objects.equals(baddress, other.baddress) && Objects.equals(bcontactNo, other.bcontactNo)
				&& bId == other.bId && Objects.equals(bname, other.bname);
	}

	@Override
	public String toString() {
		return "Beautician[bId=" + bId + ", name=" + bname + ", address=" + baddress + ", contactNo=" + bcontactNo
				+ "]";
	}
}