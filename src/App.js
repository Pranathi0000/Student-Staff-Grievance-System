
import {  Routes, Route } from 'react-router-dom';
import ComplaintsDisplay from './Components/Display/ComplaintsDisplay';
import ComplaintForm from './Components/Complaint/ComplaintForm';
import Home from './Components/Start/Home';
import StudentLogin from './Components/StudentAuth/StudentLogin';
import StaffLogin from './Components/StaffAuth/StaffLogin';
import HODLogin from './Components/HODAuth/HODLogin';
import ManagementLogin from './Components/MangAuth/ManagementLogin';
import ComplaintsByDepartment from './Components/Display/ComplaintsByDepartment';

function App() {

  return (
    
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/complaint-form" element={<ComplaintForm />} />
      <Route path="/complaints-display" element={<ComplaintsDisplay />} />
      <Route path="/studentlogin" element={<StudentLogin/>}/>
      <Route path="/stafflogin" element={<StaffLogin/>}/>
      <Route path="/hodlogin"  element={<HODLogin />}/>
      <Route path="/deptcomplaints/:department" element={<ComplaintsByDepartment/>}/>
      <Route path="/manglogin" element={<ManagementLogin/>}/>
    </Routes>
    
  );
}

export default App;
