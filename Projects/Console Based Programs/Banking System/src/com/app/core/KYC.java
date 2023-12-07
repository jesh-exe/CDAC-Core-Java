package com.app.core;

import java.time.LocalDate;

public class KYC {
	String addr;
	long phone;
	String aadharNo;
	LocalDate dob;

	public KYC(String addr, long phone, String aadharNo, LocalDate dob) {
		this.addr = addr;
		this.phone = phone;
		this.aadharNo = aadharNo;
		this.dob = dob;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Address: " + addr + "\nPhone: " + phone + "\nAadhar Number: " + aadharNo + "\nDate of Birth: " + dob;
	}

}
