package com.parisubalan.mvvmpattern.room_database_elements

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [StudentTable::class],version = 4, exportSchema = false)
abstract class DatabaseAbstractClass : RoomDatabase(){

    abstract fun studentDao(): StudentDao

    companion object{
        @Volatile private var dbInstance : DatabaseAbstractClass? = null

        fun getDatabase(context: Context): DatabaseAbstractClass? {
            if (dbInstance == null)
            {
                val instance = Room.databaseBuilder(context.applicationContext,
                    DatabaseAbstractClass::class.java,"Student_Database").allowMainThreadQueries().build()
                dbInstance = instance
            }
            return dbInstance
        }
    }

}