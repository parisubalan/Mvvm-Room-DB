package com.parisubalan.mvvmpattern.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parisubalan.R
import com.parisubalan.mvvmpattern.room_database_elements.StudentTable

class DatabaseAdapter(private var context: Context, private var studentList : List<StudentTable>) :
    RecyclerView.Adapter<DatabaseAdapter.DatabaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatabaseViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.student_list,parent,false)
        return DatabaseViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DatabaseViewHolder, position: Int) {
        holder.studentList.text = studentList[position].id.toString() + " " + studentList[position].name + " " +
                studentList[position].nativePlace + " " + studentList[position].age + " " + studentList[position].mark
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class DatabaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var studentList: TextView = itemView.findViewById(R.id.studentList)
    }
}