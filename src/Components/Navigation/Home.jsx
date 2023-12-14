import React from 'react';
import {Link} from 'react-router-dom';
import './Styles.css';

function Home() {
  return (
    <div className="button-container">
      <Link to="/complaint-form" className="button">Add</Link>
      <Link to="/complaints-display" className="button">Status link</Link>
    </div>
  )
}

export default Home;
