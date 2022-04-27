package com.parisubalan.mvvmpattern.room_database_elements

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StudentDao {

    @Query("SELECT * FROM student")
    fun getAllDetails() : LiveData<List<StudentTable>>

    @Insert
    fun insertDetails(studentTable: StudentTable)

//    @Update
//    fun updateDetails(studentTable: StudentTable)

    @Query("Delete  From student")
    fun deleteDetails()

    @Query("UPDATE or Replace student SET name = :name WHERE id = id")
    fun updateRow(name : String)

//    @Query("UPDATE student SET name = :name WHERE ID= (SELECT MAX(ID) FROM student)")
//    fun updateRow(name : String)

/*
    @Query("delete * From student where id = :id")
    fun deleteRow(id : Int)
*/

}