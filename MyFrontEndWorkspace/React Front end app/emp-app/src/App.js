import { BrowserRouter, Routes, Route } from 'react-router-dom';
//import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import EmployeeList from './components/EmployeesList';
//import NotFound from './components/NotFound';
import 'bootstrap/dist/css/bootstrap.min.css';
//import AddEmployee from './components/AddEmployee';
import StudentSignin from './components/studentlogin';
import ViewResult from './components/StudentResult';
import ViewAttendance from './components/StudentAttendance';
import StudentSignup from './components/EnrollStudent';

function App() {
  return (
    <BrowserRouter>
      <div>
        <div>
          <Routes>
            <Route exact path='/ViewResult/:id' element={< ViewResult/>} />
            <Route exact path='/ViewAttendance/:id' element={< ViewAttendance/>} />
            <Route exact path='/' element={< StudentSignin/>} />
            <Route exact path='/Signup' element={< StudentSignup/>} />
            
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
