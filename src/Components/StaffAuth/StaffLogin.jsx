// StaffLogin.js

import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify'; // Import ToastContainer and toast
import 'react-toastify/dist/ReactToastify.css';
import './Styles.css';

function StaffLogin() {
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [department, setDepartment] = useState('');
  const navigate = useNavigate();

  const handleStaffLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/auth/staff', {
        name,
        password,
        department,
      });

      if (response.data === 'Staff authentication successful') {
        // Redirect to another page after successful authentication
        toast.success('Login Successful!', {
          position: toast.POSITION.TOP_RIGHT,
          autoClose: 2000, // Close the notification in 2 seconds
          hideProgressBar: false, // Display a progress bar
          closeOnClick: true, 
          style: {
            fontSize: '16px', // Adjust the font size
            padding: '16px',
            whiteSpace: 'nowrap', // Adjust the padding
          },// Close the notification when clicked
        });
        navigate('/complaint-form');
      } else {
        console.log("Error while login");
      }
    } catch (error) {
      console.error('Staff login failed:', error);
      toast.error('Login Failed.check credentials.', {
        position: toast.POSITION.TOP_RIGHT,
        autoClose: 2000, // Close the notification in 3 seconds
        hideProgressBar: false, // Display a progress bar
        closeOnClick: true, 
        style: {
          fontSize: '16px', // Adjust the font size
          padding: '16px',
          whiteSpace: 'nowrap', // Adjust the padding
        },// Close the notification when clicked
      });
    }
  };

  return (
    <div className="login-container"> {/* Apply the container class */}
    <h2>Staff Login</h2>
    <form onSubmit={handleStaffLogin}>
      <div className="form-group"> {/* Apply the form-group class */}
        <label htmlFor="name">Name:</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </div>
      <div className="form-group"> {/* Apply the form-group class */}
        <label htmlFor="password">Password:</label>
        <input
          type="password"
          id="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div className="form-group"> {/* Apply the form-group class */}
        <label htmlFor="department">Department:</label>
        <input
          type="text"
          id="department"
          value={department}
          onChange={(e) => setDepartment(e.target.value)}
        />
      </div>
      <button type="submit">Login</button>
    </form>
    <ToastContainer />
  </div>
  );
}

export default StaffLogin;
