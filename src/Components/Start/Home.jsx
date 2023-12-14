import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserGraduate, faPersonChalkboard, faUserTie, faUsers } from '@fortawesome/free-solid-svg-icons';
import './Styles.css'; // Import your CSS file
import { Link } from 'react-router-dom';

function YourComponent() {
  return (
    <div className="home-container">
      <div className="row">
        <div className="icon-container">
          <Link to="/studentlogin">
            <FontAwesomeIcon icon={faUserGraduate} className="icon" />
            <span>Student</span>
          </Link>
        </div>
        <div className="icon-container">
          <Link to="/stafflogin">
            <FontAwesomeIcon icon={faPersonChalkboard} className="icon" />
            <span>Staff</span>
          </Link>
        </div>
      </div>
      <div className="row">
        <div className="icon-container">
          <Link to="/hodlogin">
            <FontAwesomeIcon icon={faUserTie} className="icon" />
            <span>HOD</span>
          </Link>
        </div>
        <div className="icon-container">
          <Link to="/manglogin">
            <FontAwesomeIcon icon={faUsers} className="icon" />
            <span>Management</span>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default YourComponent;
