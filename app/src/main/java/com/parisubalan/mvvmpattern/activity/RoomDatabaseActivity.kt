package com.parisubalan.mvvmpattern.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parisubalan.R
import com.parisubalan.mvvmpattern.adapter.DatabaseAdapter
import com.parisubalan.mvvmpattern.room_database_elements.StudentTable
import com.parisubalan.mvvmpattern.viewmodel.RoomDBViewModel


class RoomDatabaseActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var studentTable: StudentTable
    private var recyclerView: RecyclerView? = null
    private var adapter: DatabaseAdapter?=null
    private var etName : EditText?=null
    private var etNative : EditText?=null
    private var etAge : EditText?=null
    private var etMark : EditText?=null
    private var viewModel: RoomDBViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_database_activity)
        viewModel = ViewModelProvider(this)[RoomDBViewModel::class.java]
        initialize()
        detailsObserver()
    }

    private fun initialize() {
        etName    = findViewById(R.id.et_name)
        etNative  = findViewById(R.id.et_native)
        etAge     = findViewById(R.id.et_age)
        etMark    = findViewById(R.id.et_mark)
        recyclerView = findViewById(R.id.recyclerView)

        val insertBtn : Button = findViewById(R.id.insertBtn)
        val updateBtn : Button = findViewById(R.id.updateBtn)
        val deleteBtn : Button = findViewById(R.id.deleteBtn)

        insertBtn.setOnClickListener(this)
        updateBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
    }

    private fun detailsObserver()
    {
        viewModel!!.getAllDetails().observe(this,{
            adapterSet(it)
        })
    }

    private fun adapterSet(list: List<StudentTable>)
    {
        adapter = DatabaseAdapter(this,list)
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.adapter = adapter
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.insertBtn ->
            {
                // id is auto increment so give initially 0 then it will be generate automatically
                if (!emptyChecking()) {
                    studentTable = StudentTable(0,
                        etName!!.text.toString(),
                        etNative!!.text.toString(),
                        Integer.parseInt(etAge!!.text.toString()),
                        Integer.parseInt(etMark!!.text.toString()))
                    viewModel!!.insertDetails(studentTable)
                }
            }
            R.id.updateBtn ->
            {
                // to update the Particular row in the table
                if (!emptyChecking()) {
                    studentTable = StudentTable(5,
                        etName!!.text.toString(),
                        etNative!!.text.toString(),
                        Integer.parseInt(etAge!!.text.toString()),
                        Integer.parseInt(etMark!!.text.toString()))
                    viewModel!!.updateRowDetails(studentTable)
                }
            }
            R.id.deleteBtn ->
            {
                // To delete all records in the table
                viewModel!!.deleteDetails()
            }
        }
    }
    // Check for Edittext Fields are empty or not
    private fun emptyChecking() : Boolean {
        when {
            etName!!.text.toString().isEmpty() -> {
                Toast.makeText(this, "Enter Your name", Toast.LENGTH_SHORT).show()
                return true
            }
            etNative!!.text.toString().isEmpty() -> {
                Toast.makeText(this, "Enter Your Native", Toast.LENGTH_SHORT).show()
                return true
            }
            etAge!!.text.toString().isEmpty() -> {
                Toast.makeText(this, "Enter Your Age", Toast.LENGTH_SHORT).show()
                return true
            }
            etMark!!.text.toString().isEmpty() -> {
                Toast.makeText(this, "Enter Your Mark", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return false
        }
    }

}