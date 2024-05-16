package com.example.toyopay.mainflow.account.util


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AccountViewModel @Inject constructor(private val repository: AccountRepository) :
    ViewModel() {

    private val _accountState = MutableStateFlow(AccountStates())
    val accountStates = _accountState.asStateFlow()

    fun fetchUserDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProfileDetails().collect {
                _accountState.value = _accountState.value.copy(userDetails = it)
            }
        }
    }

}