import httpClient from '../http-common';



const studentLogin = (data) => {
  return httpClient.post('/students/login', data);
};

const studentRegister = (data) => {
  return httpClient.post('/admin/students', data);
};


const getAttendance = (id) => {
  return httpClient.get('/students/attendance'`${id}`);
};

export default {  studentLogin,studentRegister,getAttendance};
