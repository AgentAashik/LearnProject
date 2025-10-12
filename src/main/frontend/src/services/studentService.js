const API_BASE_URL = 'http://localhost:8080/api/students';

export const studentService = {
    getAllStudents: async () => {
        try {
            const response = await fetch(`${API_BASE_URL}/list`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error fetching students:', error);
            throw error;
        }
    },

    addStudent: async (student) => {
        try {
            const response = await fetch(`${API_BASE_URL}/addstudent`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(student),
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error adding student:', error);
            throw error;
        }
    },

    updateStudent: async (id, student) => {
        try {
            const response = await fetch(`${API_BASE_URL}/update/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(student),
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error updating student:', error);
            throw error;
        }
    },

    deleteStudent: async (id) => {
        try {
            const response = await fetch(`${API_BASE_URL}/remove/${id}`, {
                method: 'DELETE',
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('Error deleting student:', error);
            throw error;
        }
    }
};

export default studentService;