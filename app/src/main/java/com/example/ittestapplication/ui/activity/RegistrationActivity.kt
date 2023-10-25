package com.example.ittestapplication.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.ittestapplication.R
import com.example.ittestapplication.data.datasource.ServiceBuilder
import com.example.ittestapplication.data.interfaces.UserInterface
import com.example.ittestapplication.data.model.ApiResponse
import com.example.ittestapplication.data.model.User
import retrofit2.Call
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val signIn : Button = findViewById(R.id.signInButton)
        val reg : Button = findViewById(R.id.regButton)
        val nameEdit : EditText = findViewById(R.id.nameEditText)
        val loginEdit : EditText = findViewById(R.id.loginEditText)
        val passwordLayout : EditText = findViewById(R.id.passwordEditText)
        val doublePasswordLayout: EditText = findViewById(R.id.doublePasswordEditText)

        signIn.setOnClickListener{
            val intent = Intent(this@RegistrationActivity, AuthActivity::class.java)
            startActivity(intent) }
        reg.setOnClickListener{
            val firstName = nameEdit.text.toString().trim()
            val login=loginEdit.text.toString().trim()
            val password=passwordLayout.text.toString().trim()
            val doublepassword=doublePasswordLayout.text.toString().trim()
            reg(login,password,firstName,lastName="",middleName="")
        }
    }

     fun reg(login: String, password: String, firstName: String, lastName: String, middleName: String) {
        val retrofit = ServiceBuilder.buildService(UserInterface::class.java)
         val regCall: Call<ApiResponse<User>> = retrofit.createUser(login, password, firstName, lastName,  middleName)
         regCall.enqueue(object : retrofit2.Callback<ApiResponse<User>>{
             override fun onResponse(
                 call: Call<ApiResponse<User>>,
                 response: Response<ApiResponse<User>>
             ) {
                 var resultQuery=response.body()
                 if (resultQuery!=null){
                     val intent = Intent(this@RegistrationActivity, AuthActivity::class.java)
                     startActivity(intent)
                 }
             }

             override fun onFailure(call: Call<ApiResponse<User>>, t: Throwable) {
                 TODO("Not yet implemented")
             }

         })
    }
}