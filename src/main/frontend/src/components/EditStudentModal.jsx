import React, { useState, useEffect } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

const EditStudentModal = ({ show, onHide, student, onSave }) => {
    const [formData, setFormData] = useState({
        id: '',
        fullName: '',
        branch: '',
        marks: '',
        institution: ''
    });

    useEffect(() => {
        if (student) {
            setFormData(student);
        }
    }, [student]);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onSave({
            ...formData,
            id: parseInt(formData.id),
            marks: parseInt(formData.marks)
        });
    };

    return (
        <Modal show={show} onHide={onHide}>
            <Modal.Header closeButton>
                <Modal.Title>Edit Student</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3">
                        <Form.Label>Student ID</Form.Label>
                        <Form.Control type="number" name="id" value={formData.id} onChange={handleChange} disabled />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Full Name</Form.Label>
                        <Form.Control type="text" name="fullName" value={formData.fullName} onChange={handleChange} required />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Branch</Form.Label>
                        <Form.Control type="text" name="branch" value={formData.branch} onChange={handleChange} required />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Marks</Form.Label>
                        <Form.Control type="number" name="marks" value={formData.marks} onChange={handleChange} required min="0" max="100" />
                    </Form.Group>

                    <Form.Group className="mb-3">
                        <Form.Label>Institution</Form.Label>
                        <Form.Control type="text" name="institution" value={formData.institution} onChange={handleChange} required />
                    </Form.Group>

                    <Button variant="primary" type="submit">Save Changes</Button>
                </Form>
            </Modal.Body>
        </Modal>
    );
};

export default EditStudentModal;
