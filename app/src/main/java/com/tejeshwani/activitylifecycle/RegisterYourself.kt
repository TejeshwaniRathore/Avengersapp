package com.tejeshwani.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class RegisterYourself : AppCompatActivity() {

    lateinit var btnregister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_yourself)

        btnregister=findViewById(R.id.btnregister)

        btnregister.setOnClickListener{
            Toast.makeText(this@RegisterYourself,"Registered",Toast.LENGTH_LONG).show()
        }

    }




}