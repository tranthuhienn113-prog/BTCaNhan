
package com.example.studentmvvm.repository

import com.example.studentmvvm.data.StudentDao
import com.example.studentmvvm.model.Student
import kotlinx.coroutines.flow.Flow

class StudentRepository(
    private val studentDao: StudentDao
) {

    // Lấy danh sách sinh viên
    val allStudents: Flow<List<Student>> =
        studentDao.getAllStudents()

    // Thêm sinh viên
    suspend fun insert(student: Student) {
        studentDao.insertStudent(student)
    }

    // Xóa sinh viên
    suspend fun delete(student: Student) {
        studentDao.deleteStudent(student)
    }
}
