package com.busms.Busmanagement_system.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Component
public class Agency {
	@Id
	@GeneratedValue(generator = "a_id")
	@SequenceGenerator(initialValue = 121001, allocationSize = 1, name = "a_id")
	private int id;
	@Size(min = 3, max = 30, message = "* Enter between 3 to 30 charecters")
	private String name;
	@NotEmpty(message = "* this is Required field")
	private String address;
	@DecimalMax(value = "9999999999", message = "* Enter Proper Mobile Number")
	@DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
	private long mobile;
	@NotEmpty(message = "* this is Required field")
	@Email(message = "* Enter Proper Email")
	private String email;
	@NotEmpty(message = "* this is Required field")
	private String gst_no;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "* Password should contain minimum 8 chareecter, inlcude one upper case, lowercase , number and special charecter")
	private String password;
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "* Password should contain minimum 8 chareecter, inlcude one upper case, lowercase , number and special charecter")
	private String cpassword;
	@NotEmpty(message = "* this is Required field")
	private String reg_no;
	@NotEmpty(message = "* this is Required field")
	private String pan_no;
	private int otp;
	private boolean status;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Bus> buses = new ArrayList<Bus>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

}
