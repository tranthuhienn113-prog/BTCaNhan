
package com.example.studentmvvm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.studentmvvm.model.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    // 1. Thêm sinh viên
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    // 2. Cập nhật thông tin sinh viên
    @Update
    suspend fun updateStudent(student: Student)

    // 3. Xóa sinh viên
    @Delete
    suspend fun deleteStudent(student: Student)

    // 4. Lấy tất cả sinh viên
    @Query("SELECT * FROM students_table ORDER BY id DESC")
    fun getAllStudents(): Flow<List<Student>>

    // 5. Tìm sinh viên theo MSSV
    @Query("SELECT * FROM students_table WHERE student_code = :code LIMIT 1")
    suspend fun getStudentByCode(code: String): Student?
}
