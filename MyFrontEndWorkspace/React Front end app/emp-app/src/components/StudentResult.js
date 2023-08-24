import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';


export default function ViewResult() {
  const [result, setResult] = useState({
    marks: 0,
    percentage: 0,
    sfirstName: '',
    slastName: '',
    std: 0,
    examName: '',
  });

  const { id } = useParams();

  useEffect(() => {
    loadResult();
  }, [id]); // Include 'id' in the dependency array

  const loadResult = async () => {
    try {
        debugger;
      const resp = await axios.get(`http://localhost:8080/students/results/${id}`);
      setResult(resp.data);
    } catch (error) {
      console.error('Error loading result:', error);
      setResult({
        marks: 0,
        percentage: 0,
        sfirstName: '',
        slastName: '',
        std: 0,
        examName: '',
        error: 'Error loading result. Please try again later.',
      });
    }
  };

  return (
    <div>
      <h2>Student Result</h2>
      
      <table className="table table-bordered">
      <thead>
    <tr>
     
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Exam</th>
      <th scope="col">Marks</th>
      <th scope="col">Percentage</th>
      <th scope="col">Standard</th>
      
    </tr>
  </thead>
        <tbody>
        <tr class="table-success">
<td >{result.sfirstName}</td>

<td >{result.slastName}</td>  

<td >{result.examName}</td>

<td >{result.marks}</td>


<td >{result.percentage}</td>

<td >{result.std}</td>



</tr>  
        </tbody>
      </table>
    </div>
  );
}