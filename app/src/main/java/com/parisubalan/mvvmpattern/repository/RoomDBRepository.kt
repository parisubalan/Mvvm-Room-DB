package com.parisubalan.mvvmpattern.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.parisubalan.mvvmpattern.room_database_elements.DatabaseAbstractClass
import com.parisubalan.mvvmpattern.room_database_elements.StudentDao
import com.parisubalan.mvvmpattern.room_database_elements.StudentTable

class RoomDBRepository (context: Application) {

    private var studentDetails : LiveData<List<StudentTable>>
    private var studentDao : StudentDao? = null

    init {
        val studentDatabase = DatabaseAbstractClass.getDatabase(context)
        studentDao = studentDatabase!!.studentDao()
        studentDetails = studentDao!!.getAllDetails()
    }

    fun insertDetails(studentTable: StudentTable)
    {
        studentDao!!.insertDetails(studentTable)
    }
    fun updateRowDetails(studentTable: StudentTable)
    {
        studentDao!!.updateRow(studentTable.name)
    }
    fun deleteDetails()
    {
        studentDao!!.deleteDetails()
    }
    fun getAllDetails() : LiveData<List<StudentTable>>
    {
        return studentDetails
    }

}