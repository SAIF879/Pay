package com.example.toyopay.mainflow.authentication.util

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.toyopay.networkServices.data.LoginRequestBody
import com.example.toyopay.networkServices.data.RegisterRequestBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val repository: AuthenticationRepository) :
    ViewModel() {


    private val _authenticationStates = MutableStateFlow(AuthenticationStates())
    val authenticationStates = _authenticationStates.asStateFlow()
    fun registerUser(
        details: RegisterRequestBody
    ) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.postUserRegistration(details).collect {
                _authenticationStates.value = _authenticationStates.value.copy(registerDetails = it)
                Log.d("AUTH_RESPONSE", "registerUser: $it ")
            }
        }
    }

    fun registerLogin(
        username: String,
        password: String,
    ) {
        val reqBody = LoginRequestBody(
            username,
            password
        )
        viewModelScope.launch(Dispatchers.IO) {
            repository.postUserLoginDetails(reqBody).collect {
                _authenticationStates.value = _authenticationStates.value.copy(loginDetails = it)
            }
        }
    }


}