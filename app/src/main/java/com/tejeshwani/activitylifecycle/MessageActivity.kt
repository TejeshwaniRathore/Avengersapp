package com.tejeshwani.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        if(intent!=null){
            val messageData=intent.getStringExtra("Message")
            val message:TextView=findViewById(R.id.etMessage)

            message.text=messageData
        }
        title="Your message"
    }
}