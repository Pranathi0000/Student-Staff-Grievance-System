package com.restapi.services;

import java.util.List;

import com.restapi.model.Complaint;

public interface ComplaintServices {
   
	public Complaint addComplaint(Complaint complaint);
	
	public List<Complaint> findAllComplaints();
	
	public List<Complaint> findDepartmentComplaints(String department);
	
	public Complaint updateComplaintStatus(long complaintId,String status);
}
