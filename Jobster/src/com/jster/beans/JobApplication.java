package com.jster.beans;

import java.util.Objects;

public class JobApplication{
	private String userId;
	private String jobId;
	private String dateApplied; 
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String dateOfBirth;
	private String phoneNumber;
	private String email;
	
	private String schoolAttended;
	private String degree;
	private String major;
	private String gradDate;
	private String gpa;
	
	private String companyName;
	private String jobTitle;
	private String dateStart;
	private String dateEnd;
	
	
	private String workEligibility;
	
	public void setUserId(String userID) {
		this.userId=userID;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void seJobId(String jobID) {
		this.jobId=jobID;
	}
	
	public String getJobId() {
		return jobId;
	}
	
	public void setDateApplied(String dateApplied) {
		this.dateApplied=dateApplied;
	}
	
	public String getDateApplied() {
		return dateApplied;
	}
	
	public void setFirstName(String fname) {
		this.firstName=fname;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lname) {
		this.lastName=lname;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}
	
	public void setState(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	}
	
	public void setCountry(String country) {
		this.country=country;
	}
	public String getCountry() {
		return country;
	}
	
	
	public void setZip(String zipCode) {
		this.zip=zipCode;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setDoB(String dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}
	
	public String getDoB() {
		return dateOfBirth;
	}
	
	public void setPhoneNumber(String phone) {
		this.phoneNumber=phone;
	}
	public String PhoneNumber() {
		return phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	public String PhoneEmail() {
		return email;
	}
	
	
	
	public void setSchoolAttended(String schoolAttended) {
		this.schoolAttended=schoolAttended;
	}
	public String getSchoolAttended() {
		return schoolAttended;
	}
	
	public void setDegree(String degree) {
		this.degree=degree;
	}
	public String getDegree() {
		return degree;
	}
	
	public void setMajor(String major) {
		this.major=major;
	}
	public String getMajor() {
		return major;
	}
	
	public void setGradDate(String gradDate) {
		this.gradDate=gradDate;
	}
	public String getGradDate() {
		return gradDate;
	}
	
	public void setGPA(String gpa) {
		this.gpa=gpa;
	}
	public String getGPA() {
		return gpa;
	}
	
	
	public void setCompName(String compName) {
		this.companyName=compName;
	}
	public String getCompName() {
		return companyName;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle=jobTitle;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setDateStarted(String dateStarted) {
		this.dateStart=dateStarted;
	}
	public String getDateStarted() {
		return dateStart;
	}
	
	public void setDateEnd(String dateEnd) {
		this.dateEnd=dateEnd;
	}
	public String getDatEnd() {
		return dateEnd;
	}
	
	
	public void setWorkElig(String ans) {
		this.workEligibility=ans;
	}
	public String getWorkElig() {
		return workEligibility;
	}
	
	@Override
	public String toString() {
		return "JavaBeans [userId=" + userId + ", jobId=" + jobId + ", dateApplied=" + dateApplied + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zip=" + zip + ", dateOfBirth=" + dateOfBirth + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", schoolAttended=" + schoolAttended + ", degree=" + degree
				+ ", major=" + major + ", gradDate=" + gradDate + ", gpa=" + gpa + ", companyName=" + companyName
				+ ", jobTitle=" + jobTitle + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", workEligibility="
				+ workEligibility + "]";
	}
	
	
	
	
}
