package com.example.ittestapplication.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ittestapplication.R
import com.example.ittestapplication.data.datasource.ServiceBuilder
import com.example.ittestapplication.data.interfaces.UserInterface
import com.example.ittestapplication.data.model.ApiResponse
import com.example.ittestapplication.data.model.User
import retrofit2.Call
import retrofit2.Response

class AuthActivity : AppCompatActivity() {
    private var resultQuery:Boolean?=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val signIn :Button = findViewById(R.id.singInBtn)
        val reg :Button = findViewById(R.id.regBtn)
        val loginLayout :EditText = findViewById(R.id.loginEitText)
        val passwordLayout :EditText = findViewById(R.id.passwordEditText)
        reg.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent) }
        signIn.setOnClickListener{
            val login=loginLayout.text.toString().trim()
            val password=passwordLayout.text.toString().trim()
            Sign(login,password) }
    }

     fun Sign(login: String, password: String) {
        if(login.isNotEmpty() && password.isNotEmpty()){
            val signIn = ServiceBuilder.buildService(UserInterface::class.java)
            val logCall: Call<ApiResponse<User>> =signIn.getAuth(login,password)
            logCall.enqueue(object : retrofit2.Callback<ApiResponse<User>> {
                override fun onResponse(
                    call: Call<ApiResponse<User>>,
                    response: Response<ApiResponse<User>>
                ) {
                    resultQuery=response.body()!!.success
                    Log.e("",resultQuery.toString())
                    if(resultQuery==true){
                        val intent = Intent(this@AuthActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this@AuthActivity,"Некорректные данные", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ApiResponse<User>>, t: Throwable) {
                    Toast.makeText(this@AuthActivity,"Не все поляляляля заполнены",Toast.LENGTH_LONG).show()
                }

            })
        } else{
            Toast.makeText(this,"Не все поля заполнены",Toast.LENGTH_LONG).show()
        }
    }
}

