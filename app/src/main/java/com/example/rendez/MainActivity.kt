package com.example.rendez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonWriter
import android.util.Log
import android.util.Log.VERBOSE
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import com.example.rendez.databinding.ActivityMainBinding
import com.example.rendez.services.RetrofitFactory
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.*

class MainActivity : AppCompatActivity() {
    var newUser= RegisterBody()
    lateinit var email: TextInputLayout
    lateinit var name: TextInputLayout
    lateinit var password: TextInputLayout



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        sayHello()
        email = findViewById<TextInputLayout>(R.id.email)
        name= findViewById<TextInputLayout>(R.id.name)
        password = findViewById<TextInputLayout>(R.id.password)

//        newUser.name = findViewById<TextInputEditText>(R.id.name).text.toString()
//        newUser.password = findViewById<TextInputEditText>(R.id.password).text.toString()
        val button = findViewById<Button>(R.id.loginButton).setOnClickListener{
            newUser.email = email.editText?.text.toString()
            newUser.name = name.editText?.text.toString()
            newUser.password = password.editText?.text.toString()

//            register(newUser)
            sayHello()
//            Toast.makeText(this, "$newUser", Toast.LENGTH_SHORT).show()
        }

    }


    fun register(user: RegisterBody) {

        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.register(user)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        println("RESPONSE: ${response.body()}")
                    } else {
                        print("THE RESPONSE FAILED:   $response")
                    }
                } catch (e: HttpException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Oops: Something else went wrong")
                }
            }
        }
    }

    fun sayHello() {
        lateinit var chaine: String
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getHello()
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        println("RESPONSE: ${response.body()}")
                    } else {
                        print("THE RESPONSE FAILED:   $response")
                    }
                } catch (e: HttpException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Oops: Something else went wrong")
                }
            }
        }

    }

    fun login(user: LoginBody){
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.login(user)
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        println("RESPONSE: ${response.body()}")
                    } else {
                        print("THE RESPONSE FAILED:   $response")
                    }
                } catch (e: HttpException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Oops: Something else went wrong")
                }
            }
        }
    }


}