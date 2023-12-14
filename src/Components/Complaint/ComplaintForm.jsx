import React, { useState } from 'react';
import axios from 'axios';
import './Style.css';

const ComplaintForm = () => {
  const [formData, setFormData] = useState({
    complaintRegisteredDate: '',
    role:'',
    category: '',
    details: '',
    desiredOutcome: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/complaint', formData);
      console.log(response.data); // Log response from the backend
      setFormData({
        complaintRegisteredDate: '',
        role:'',
        category: '',
        details: '',
        desiredOutcome: ''
      });
    } catch (error) {
      console.error('Error submitting complaint:', error);
    }
  };

  const categoryOptions = [
    'Course',
    'Teachers',
    'Students',
    'Labs',
    'Library',
    'Fee',
    'Sports',
    'Hostel',
    'Ragging',
    'Infrastructure'
  ];

  return (
    <div className="container">
      <h2>Complaint Form</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="complaintRegisteredDate" className="form-label">Complaint Registered Date:</label>
          <input
            type="date"
            className="form-control"
            id="complaintRegisteredDate"
            name="complaintRegisteredDate"
            value={formData.complaintRegisteredDate}
            onChange={handleChange}
            placeholder="YYYY/MM/DD"
          />
        </div>
        <div className="form-group">
  <label htmlFor="role" className="form-label">Role:</label>
  <select
    className="form-control"
    id="role"
    name="role"
    value={formData.role}
    onChange={handleChange}
  >
    <option value="">Select role</option>
    <option value="STUDENT">Student</option>
    <option value="STAFF">Staff</option>
  </select>
</div>

        
        <div className="form-group">
          <label htmlFor="category" className="form-label">Category:</label>
          <select
            className="form-control"
            id="category"
            name="category"
            value={formData.category}
            onChange={handleChange}
          >
            <option value="">Select category</option>
            {categoryOptions.map((option, index) => (
              <option key={index} value={option}>{option}</option>
            ))}
          </select>
        </div>
        <div className="form-group">
          <label htmlFor="details" className="form-label">Complaint Details:</label>
          <textarea
            className="form-control"
            id="details"
            name="details"
            value={formData.details}
            onChange={handleChange}
            placeholder="Enter complaint details"
          />
        </div>
        <div className="form-group">
          <label htmlFor="desiredOutcome" className="form-label">Desired Outcome:</label>
          <textarea
            className="form-control"
            id="desiredOutcome"
            name="desiredOutcome"
            value={formData.desiredOutcome}
            onChange={handleChange}
            placeholder="Enter desired outcome"
          />
        </div>
        <button type="submit" className="btn">Submit</button>
      </form>
     
    </div>
  );
};

export default ComplaintForm;
