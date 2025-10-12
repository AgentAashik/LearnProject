import React, { useState, useEffect } from 'react';
import { studentService } from '../services/studentService';    
import 'bootstrap/dist/css/bootstrap.min.css';
import AddStudent from './addStudent';
import EditStudentModal from './EditStudentModal';

const StudentList = () => {
    const [students, setStudents] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [showEditModal, setShowEditModal] = useState(false);
    const [selectedStudent, setSelectedStudent] = useState(null);

    useEffect(() => {
        fetchStudents();
    }, []);

    const fetchStudents = async () => {
        try {
            setLoading(true);
            const data = await studentService.getAllStudents();
            setStudents(data);
            setError(null);
        } catch (err) {
            setError('Error loading student data');
        } finally {
            setLoading(false);
        }
    };

    const handleEdit = (student) => {
        setSelectedStudent(student);
        setShowEditModal(true);
    };

    const handleSaveEdit = async (updatedStudent) => {
        try {
            await studentService.updateStudent(updatedStudent.id, updatedStudent);
            setShowEditModal(false);
            fetchStudents();
        } catch (error) {
            alert('Failed to update student');
        }
    };

    const handleDelete = async (id) => {
        if (window.confirm('Are you sure you want to delete this student?')) {
            try {
                await studentService.deleteStudent(id);
                fetchStudents();
            } catch (error) {
                alert('Failed to delete student');
            }
        }
    };

    if (loading) {
        return (
            <div className="container mt-5">
                <div className="text-center">Loading...</div>
            </div>
        );
    }

    if (error) {
        return (
            <div className="container mt-5">
                <div className="alert alert-danger text-center">{error}</div>
            </div>
        );
    }

    return (
        <div style={{ backgroundColor: '#f8f9fa', padding: '20px', minHeight: '100vh' }}>
            <div style={{ maxWidth: '1200px', margin: '0 auto' }}>
                <AddStudent onStudentAdded={fetchStudents} />
                
                <div style={{
                    backgroundColor: 'white',
                    padding: '30px',
                    borderRadius: '8px',
                    boxShadow: '0 2px 10px rgba(0,0,0,0.1)',
                    marginTop: '20px'
                }}>
                    <h2 className="text-center mb-4" style={{ color: '#333' }}>Student List</h2>
                    <table className="table table-striped table-bordered">
                        <thead className="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Full Name</th>
                                <th>Branch</th>
                                <th>Marks</th>
                                <th>Institution</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {students.map((student) => (
                                <tr key={student.id}>
                                    <td>{student.id}</td>
                                    <td>{student.fullName}</td>
                                    <td>{student.branch}</td>
                                    <td>{student.marks}</td>
                                    <td>{student.institution}</td>
                                    <td>
                                        <button
                                            className="btn btn-sm btn-warning me-2"
                                            onClick={() => handleEdit(student)}
                                        >
                                            Edit
                                        </button>
                                        <button
                                            className="btn btn-sm btn-danger"
                                            onClick={() => handleDelete(student.id)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>

                <EditStudentModal
                    show={showEditModal}
                    onHide={() => setShowEditModal(false)}
                    student={selectedStudent}
                    onSave={handleSaveEdit}
                />
            </div>
        </div>
    );
};

export default StudentList;
