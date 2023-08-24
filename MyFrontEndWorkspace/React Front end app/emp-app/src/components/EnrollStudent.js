//import axios from 'axios';
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useEffect } from 'react';
import employeeService from '../services/employee.service';

const StudentSignup = () => {

     var navigate=useNavigate();
 
     const [formData, setFormData] = useState({
        email: '',
        password: '',
        dob: '',
        gender: '',
        address: '',
        mobileNo: '',
        dateOfJoin: '',
        sFirstName: '',
        sLastName: '',
        myParent: '',
        std: '',
        division: '',
      });
    const [invalidCredentials, setInvalidCredentials] = useState(false);

  
  const studsignup=(e)=>{
    e.preventDefault();
    
   
    employeeService.studentRegister(formData)
    .then((response)=>{
        
         console.log(response.data) 
       
    })
    .catch((error) => {
        console.log('Something went wrong', error);
        setInvalidCredentials(true);

        setTimeout(() => {
          setInvalidCredentials(false);
        }, 3000);
      });

  }

  var handleInputChange=(args)=>{
    var copyOfStudent = {...formData};
    copyOfStudent[args.target.name] = 
                args.target.value;
   setFormData(copyOfStudent);
}

  useEffect(() => {
    
   // login();
    
  }, []);
  return (
    <div className="container mt-5">
    <h2>Student Registration Form</h2>
    <form onSubmit={studsignup}>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">Email</label>
        <input
          type="email"
          className="form-control"
          id="email"
          name="email"
          value={formData.email}
          onChange={handleInputChange}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">Password</label>
        <input
          type="password"
          className="form-control"
          id="password"
          name="password"
          value={formData.password}
          onChange={handleInputChange}
        />
      </div>
      <div className="mb-3">
  <label htmlFor="dob" className="form-label">Date of Birth</label>
  <input
    type="date"
    className="form-control"
    id="dob"
    name="dob"
    value={formData.dob}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="gender" className="form-label">Gender</label>
  <select
    className="form-select"
    id="gender"
    name="gender"
    value={formData.gender}
    onChange={handleInputChange}
  >
    <option value="">Select gender</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>
  </select>
</div>
<div className="mb-3">
  <label htmlFor="address" className="form-label">Address</label>
  <textarea
    className="form-control"
    id="address"
    name="address"
    value={formData.address}
    onChange={handleInputChange}
  ></textarea>
</div>
<div className="mb-3">
  <label htmlFor="mobileNo" className="form-label">Mobile Number</label>
  <input
    type="tel"
    className="form-control"
    id="mobileNo"
    name="mobileNo"
    value={formData.mobileNo}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="dateOfJoin" className="form-label">Date of Joining</label>
  <input
    type="date"
    className="form-control"
    id="dateOfJoin"
    name="dateOfJoin"
    value={formData.dateOfJoin}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="sFirstName" className="form-label">Student First Name</label>
  <input
    type="text"
    className="form-control"
    id="sFirstName"
    name="sFirstName"
    value={formData.sFirstName}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="sLastName" className="form-label">Student Last Name</label>
  <input
    type="text"
    className="form-control"
    id="sLastName"
    name="sLastName"
    value={formData.sLastName}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="myParent" className="form-label">Parent's Name</label>
  <input
    type="text"
    className="form-control"
    id="myParent"
    name="myParent"
    value={formData.myParent}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="std" className="form-label">Standard</label>
  <input
    type="number"
    className="form-control"
    id="std"
    name="std"
    value={formData.std}
    onChange={handleInputChange}
  />
</div>
<div className="mb-3">
  <label htmlFor="division" className="form-label">Division</label>
  <input
    type="text"
    className="form-control"
    id="division"
    name="division"
    value={formData.division}
    onChange={handleInputChange}
  />
</div>

      <button type="submit" className="btn btn-primary">Submit</button>
    </form>
  </div>
);
}
    
    
  

export default  StudentSignup;


