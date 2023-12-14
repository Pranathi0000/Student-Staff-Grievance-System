import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify'; // Import ToastContainer and toast
import 'react-toastify/dist/ReactToastify.css';
import './Styles.css';

function StudentLogin() {
  const [regdNum, setRegdNum] = useState('');
  const [dob, setDob] = useState('');
  const [department, setDepartment] = useState('');
  const history = useNavigate();

  const handleStudentLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/auth/student', {
        regdNum,
        dob,
        department,
      });

      if (response.data === 'Student authentication successful') {
        // Show toast notification for successful login
        toast.success('Login Successful!', {
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
        

        // Redirect to another page after successful authentication
        history('/complaint-form');
      } else {
        console.log("error");
      }
    } catch (error) {
      console.error('Student login failed:', error);
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
    <div className="login-container">
      <h2>Student Login</h2>
      <form onSubmit={handleStudentLogin}>
        <div className="form-group">
          <label htmlFor="regdNum">Registration Number:</label>
          <input
            type="text"
            id="regdNum"
            value={regdNum}
            onChange={(e) => setRegdNum(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="dob">Date of Birth:</label>
          <input
            type="text"
            id="dob"
            value={dob}
            onChange={(e) => setDob(e.target.value)}
          />
        </div>
        <div className="form-group">
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

export default StudentLogin;
