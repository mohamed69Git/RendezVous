package com.example.rendez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    //Mor variables
    lateinit var emailView: TextInputLayout;
    lateinit var passwordView: TextInputLayout;
    lateinit var loginBtn: Button;
    lateinit var spinner: ProgressBar;

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailView = binding.email
        passwordView = binding.password
        loginBtn = binding.loginButton
        spinner = binding.spinner
        loginBtn.setOnClickListener {
            this.login()
        }



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.unRv = RendezVous()
//        binding.saveButton.setOnClickListener {
////            var str: String = binding.idRendezVous.toString()
//            binding.unRv = RendezVous(
//                binding.idRendezvous.toString(),
//                binding.lieu.toString(),
//                binding.description.toString(),
//                Date(
//                    binding.dateRendezVous.year, binding.dateRendezVous.month, binding.dateRendezVous.dayOfMonth
//                ),
//
//            )
//            Toast.makeText(this,binding.unRv.toString(), Toast.LENGTH_SHORT).show()
//        }
    }

    private fun login() {
        val email = emailView
        val password = passwordView

        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.login(LoginBody(email.toString(), password.toString()))
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        println("RESPONSE: ${response.body()}")
                    } else {
                        println("RESPONSE NOT: $response");
                    }
                } catch (e: HttpException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Ooops: Something else went wrong")
                }
            }
        }
    }


}