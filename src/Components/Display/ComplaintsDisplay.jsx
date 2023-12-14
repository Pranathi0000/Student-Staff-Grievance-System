import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Styles.css';


const ComplaintsDisplay = () => {
  
  const [complaints, setComplaints] = useState([]);

  useEffect(() => {
    // Fetch complaints when the component mounts
    async function fetchComplaints() {
      try {
        
        const response = await axios.get('http://localhost:8080/get');
        setComplaints(response.data); // Assuming response.data is an array of complaints
      } catch (error) {
        console.error('Error fetching complaints:', error);
      }
    }

    fetchComplaints();
  });

  

  const handleStatusChange = async (id, newStatus) => {
    console.log(newStatus);
    try {
      const updatedComplaints = complaints.map((complaint) => {
        if (complaint.complaintId === id) {
          return { ...complaint, status: newStatus };
        }
        return complaint;
      });
  
      setComplaints([...updatedComplaints]); // Update the state with the modified complaints list
  
      // Update the status in the backend for the specific complaint
      await axios.put(`http://localhost:8080/status/${id}`,null, {
        params: {
          newStatus: newStatus
        }
      });
  } catch (error) {
    console.error('Error updating status:', error);
  }
  };  
  

  return (
    <div className="complaints-container">
      <h2>Complaints List</h2>
      <table className="complaints-table">
        <thead>
          <tr>
            <th>Complaint ID</th>
            <th>Date</th>
            <th>Role</th>
            <th>Department</th>
            <th>Category</th>
            <th>Details</th>
            <th>Desired Outcome</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {complaints.map((complaint) => (
            <tr key={complaint.complaintId}>
              <td>{complaint.complaintId}</td>
              <td>{complaint.complaintRegisteredDate}</td>
              <td>{complaint.role}</td>
              <td>{complaint.department}</td>
              <td>{complaint.category}</td>
              <td>{complaint.details}</td>
              <td>{complaint.desiredOutcome}</td>
              <td>
                <select
                  value={complaint.status}
                  onChange={(e) => handleStatusChange(complaint.complaintId, e.target.value)}
                  className="status-dropdown"
                >
                  <option value="received">Received</option>
                  <option value="in_progress">In Progress</option>
                  <option value="completed">Completed</option>
                </select>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      
    </div>
  );
};

export default ComplaintsDisplay;
