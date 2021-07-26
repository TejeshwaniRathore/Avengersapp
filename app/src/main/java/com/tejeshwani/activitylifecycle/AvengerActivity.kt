package com.tejeshwani.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class AvengerActivity : AppCompatActivity() {

    lateinit var etMessage:EditText
    lateinit var btnMessage:Button
    lateinit var btnLogOut:Button

    var titleName:String?="Avengers"

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        etMessage=findViewById(R.id.etMessage)
        btnMessage=findViewById(R.id.btnMessage)
        btnLogOut=findViewById(R.id.btnLogOut)

        titleName=sharedPreferences.getString("Title","The Avengers")


        println("onCreate called")
        title=titleName

        btnMessage.setOnClickListener{
            val message=etMessage.text.toString()

            val intent=Intent(this@AvengerActivity,MessageActivity::class.java)
            intent.putExtra("Message",message)
            startActivity(intent)
        }

        btnLogOut.setOnClickListener{
            sharedPreferences.edit().clear().apply()
            val intent=Intent(this@AvengerActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }



}