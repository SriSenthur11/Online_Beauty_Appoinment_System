package com.beautician.entity;

import java.util.Objects;

public class Services {
	private int SerId;
	private String Sername;
	
	public Services() {
	}

	public Services(int SerId, String Sername) {
		this.SerId = SerId;
		this.Sername = Sername;
	}

	public int getSerId() {
		return SerId;
	}

	public void setSerId(int SerId) {
		this.SerId = SerId;
	}

	public String getSername() {
		return Sername;
	}

	public void setSername(String Sername) {
		this.Sername = Sername;
	}

	@Override
	public int hashCode() {
		return SerId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Services other = (Services) obj;
		return SerId == other.SerId && Objects.equals(Sername, other.Sername);
	}

	@Override
	public String toString() {
		return "Services [SerId=" + SerId + ", Sername=" + Sername +  "]";
	}
}