package com.example.foregroundserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.foregroundserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            val input = binding.editTextInput.text.toString()

            val serviceIntent = Intent(this, ExampleService::class.java)
            serviceIntent.putExtra("inputExtra", input)

            ContextCompat.startForegroundService(this, serviceIntent)
        }

        binding.stopBtn.setOnClickListener {
            val serviceIntent = Intent(this, ExampleService::class.java)
            stopService(serviceIntent)
        }
    }
}