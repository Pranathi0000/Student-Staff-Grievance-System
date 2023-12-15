package com.restapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long complaintId;
	
	private Date complaintRegisteredDate;
	private String role;
	private String department;
	private String category;
	private String details;
	private String desiredOutcome;
	private String status;
	
	

	//getters and setters
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(long complaintId) {
		this.complaintId = complaintId;
	}

	public Date getComplaintRegisteredDate() {
		return complaintRegisteredDate;
	}

	public void setComplaintRegisteredDate(Date complaintRegisteredDate) {
		this.complaintRegisteredDate = complaintRegisteredDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	public String getDesiredOutcome() {
		return desiredOutcome;
	}

	public void setDesiredOutcome(String desiredOutcome) {
		this.desiredOutcome = desiredOutcome;
	}

	//constructors

	public Complaint(long complaintId, Date complaintRegisteredDate, String role, String department, String category,
			String details, String desiredOutcome, String status) {
		super();
		this.complaintId = complaintId;
		this.complaintRegisteredDate = complaintRegisteredDate;
		this.role = role;
		this.department = department;
		this.category = category;
		this.details = details;
		this.desiredOutcome = desiredOutcome;
		this.status = status;
	}
	
	public Complaint() {
		super();
		this.status = "Received";
	}
	
}
