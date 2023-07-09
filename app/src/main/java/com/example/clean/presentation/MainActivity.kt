package com.example.clean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.clean.R
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.Username
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            SharedPrefUserStorage(applicationContext)
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.clean.domain.usecase.GetUserNameUseCase(
            userRepository
        )
    }
    private val saveUserNameParamUseCase by lazy(LazyThreadSafetyMode.NONE) {
        com.example.clean.domain.usecase.SaveUserNameUseCase(
            userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = com.example.clean.domain.models.SaveUserNameParam(name = text)
            val result = saveUserNameParamUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName: com.example.clean.domain.models.Username = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}