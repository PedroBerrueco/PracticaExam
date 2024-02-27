package com.pberrueco.practicaexam.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.pberrueco.practicaexam.R
import com.pberrueco.practicaexam.databinding.ActivityInitialBinding
import com.pberrueco.practicaexam.ui.recycler.MainActivity

class InitialActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityInitialBinding
    private val binding: ActivityInitialBinding get() = _binding

    private val ViewModel: InitialViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btUsername.setOnClickListener{//Funcion para guardar en DataStore al pulsar el boton
            saveUser()
        }
    }

    private fun saveUser() {
        val user = binding.etUsername.text.toString().trim()
        if(!user.isNullOrEmpty()){
            ViewModel.saveUserName(this, user)
            goToRecycler()
        }else{
            Toast.makeText(this, "user nulo o vacio", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToRecycler() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}