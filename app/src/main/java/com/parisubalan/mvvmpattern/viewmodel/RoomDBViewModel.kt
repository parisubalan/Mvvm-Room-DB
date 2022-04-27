package com.parisubalan.mvvmpattern.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.parisubalan.mvvmpattern.repository.RoomDBRepository
import com.parisubalan.mvvmpattern.room_database_elements.StudentTable


class RoomDBViewModel(context: Application) : AndroidViewModel(context) {

    private var roomDBRepository : RoomDBRepository = RoomDBRepository(context)
    private val studentDetails : LiveData<List<StudentTable>> = roomDBRepository.getAllDetails()

    fun insertDetails(studentTable: StudentTable)
    {
        roomDBRepository.insertDetails(studentTable)
    }
    fun getAllDetails() : LiveData<List<StudentTable>>
    {
        return studentDetails
    }
    fun updateRowDetails(studentTable: StudentTable)
    {
        roomDBRepository.updateRowDetails(studentTable)
    }
    fun deleteDetails()
    {
        roomDBRepository.deleteDetails()
    }
}