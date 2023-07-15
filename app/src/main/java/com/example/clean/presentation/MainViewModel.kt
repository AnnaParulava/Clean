package com.example.clean.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase
import kotlin.math.log

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameParamUseCase: SaveUserNameUseCase
) : ViewModel() {

    val resultLive = MutableLiveData<String>()

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM created")
        super.onCleared()
    }

    fun save(text: String) {
        val params = com.example.clean.domain.models.SaveUserNameParam(name = text)
        val result = saveUserNameParamUseCase.execute(param = params)
        resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName: com.example.clean.domain.models.Username = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName} ${userName.lastName}"
    }
}