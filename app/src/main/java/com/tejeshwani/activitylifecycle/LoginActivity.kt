package com.tejeshwani.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast


class LoginActivity : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etpassword: EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotpassword:TextView
    lateinit var txtregister:TextView
    val validMobileNumber="0123456789"
    val validPassword=arrayOf("tony","steve","bruce","thanos")

    lateinit var sharedPreferences:SharedPreferences





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val  isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            val intent=Intent(this@LoginActivity,AvengerActivity::class.java)
            startActivity(intent)
            finish()
        }



        title="Log In"

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etpassword=findViewById(R.id.etpassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotpassword=findViewById(R.id.txtForgotpassword)
        txtregister=findViewById(R.id.txtregister)




        btnLogin.setOnClickListener{
            val mobileNumber=etMobileNumber.text.toString()

            val password=etpassword.text.toString()
            var nameOfAvenger="Avenger"




            val intent= Intent(this@LoginActivity,AvengerActivity::class.java)


            if ((mobileNumber==validMobileNumber)){
                if(password==validPassword[0]) {

                    nameOfAvenger="Iron man"

                    savePreferences(nameOfAvenger)




                    startActivity(intent)

                }else if(password==validPassword[1]){
                    nameOfAvenger="Captain America"

                    savePreferences(nameOfAvenger)


                    startActivity(intent)
                }else if(password==validPassword[2]){
                    nameOfAvenger="Hulk"

                    savePreferences(nameOfAvenger)


                    startActivity(intent)
                }else if(password==validPassword[3]){
                    nameOfAvenger="The avengers"
                    savePreferences(nameOfAvenger)
                    startActivity(intent)
                }


            }else {
                Toast.makeText(this@LoginActivity,
                    "Incorrect cridentials",
                    Toast.LENGTH_LONG
                ).show()
            }




        }
        txtForgotpassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPassword::class.java)
            startActivity(intent)
        }

        txtregister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterYourself::class.java)
            startActivity(intent)
        }



    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(nameOfAvenger: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title", title as String?).apply()


    }

}