
package com.example.studentmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.studentmvvm.model.Student
import com.example.studentmvvm.repository.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    // Lấy danh sách sinh viên và chuyển Flow sang LiveData
    val allStudents: LiveData<List<Student>> =
        repository.allStudents.asLiveData(Dispatchers.IO)

    // Thêm sinh viên
    fun insert(student: Student) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(student)
        }

    // Xóa sinh viên
    fun delete(student: Student) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(student)
        }
}
