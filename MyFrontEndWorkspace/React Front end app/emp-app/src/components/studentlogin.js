//import axios from 'axios';
import { useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { useEffect } from 'react';
import employeeService from '../services/employee.service';

const StudentSignin = () => {

     var navigate=useNavigate();
 
    const [student, setstudent] =   
    useState({email: "", password: ""});
    const [invalidCredentials, setInvalidCredentials] = useState(false);

  
  const login=(e)=>{
    e.preventDefault();
    console.log("inlogin function")
   
    employeeService.studentLogin(student)
    .then((response)=>{
        
         console.log(response.data)
        console.log("Loginsuccessfully")
        navigate("/ViewResult");
       
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
    var copyOfStudent = {...student};
    copyOfStudent[args.target.name] = 
                args.target.value;
    setstudent(copyOfStudent);
}

  useEffect(() => {
    
   // login();
    
  }, []);
  return (
    <div className='container'>
      <h3>Student Login</h3>
      <hr />
      <form>
        
        <div className='form-group'>
          <input
            type='text'
            className='form-control col-4'
            id='email'
            name="email"
            value={student.email}
            onChange={handleInputChange}
            placeholder='Enter email'
            required
          />
        </div>
        <hr />
        <div className='form-group'>
          <input
            type='password'
            className='form-control col-4'
            id='password'
            name="password"
            value={student.password}
            onChange={handleInputChange}
            placeholder='Enter Password'
            required
          />
        </div>
        <hr />
       
        <div>
          <button onClick={login} className='btn btn-primary'>
            LOGIN
          </button>
        </div>
        <hr />
        <div className='form-group'>
        {invalidCredentials && <p style={{ color: 'red' }}>Invalid Credentials</p>}
        </div>
      </form>
      
      <Link to='/'>Back to Home</Link>
    </div>
  );
};

export default  StudentSignin;


