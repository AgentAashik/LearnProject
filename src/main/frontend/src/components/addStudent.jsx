import React, { useState } from 'react';
import { studentService } from '../services/studentService';

const AddStudent = ({ onStudentAdded }) => {
    const [formData, setFormData] = useState({
        id: '',
        fullName: '',
        branch: '',
        marks: '',
        institution: ''
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await studentService.addStudent({
                ...formData,
                id: parseInt(formData.id),
                marks: parseInt(formData.marks)
            });
            setFormData({ id: '', fullName: '', branch: '', marks: '', institution: '' });
            onStudentAdded();
        } catch (error) {
            alert('Failed to add student');
        }
    };

    return (
        <div className="card mb-4">
            <div className="card-body">
                <h3 className="card-title text-center">Add Student</h3>
                <form onSubmit={handleSubmit}>
                    <input type="number" className="form-control mb-2" name="id" placeholder="ID" value={formData.id} onChange={handleChange} required />
                    <input type="text" className="form-control mb-2" name="fullName" placeholder="Full Name" value={formData.fullName} onChange={handleChange} required />
                    <input type="text" className="form-control mb-2" name="branch" placeholder="Branch" value={formData.branch} onChange={handleChange} required />
                    <input type="number" className="form-control mb-2" name="marks" placeholder="Marks" value={formData.marks} onChange={handleChange} required />
                    <input type="text" className="form-control mb-2" name="institution" placeholder="Institution" value={formData.institution} onChange={handleChange} required />
                    <button type="submit" className="btn btn-primary w-100">Add Student</button>
                </form>
            </div>
        </div>
    );
};

export default AddStudent;
