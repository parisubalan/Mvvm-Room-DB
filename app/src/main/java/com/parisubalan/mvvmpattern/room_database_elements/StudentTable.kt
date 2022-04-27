package com.parisubalan.mvvmpattern.room_database_elements

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
class StudentTable (
    @PrimaryKey (autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "Name")
    var name : String,
    @ColumnInfo(name = "Native")
    var nativePlace : String,
    @ColumnInfo(name = "Age")
    var age : Int,
    @ColumnInfo(name = "Mark")
    var mark : Int)
