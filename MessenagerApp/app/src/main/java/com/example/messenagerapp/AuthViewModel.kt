package com.example.messenagerapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AuthViewModel(private val api: MessengerApi) : ViewModel() {
    var authResponse: AuthResponse? = null
        private set

    fun register(credentials: Credentials, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.signUp(credentials)
                if (response.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, response.errorBody()?.string())
                }
            } catch (e: HttpException) {
                onResult(false, e.message())
            } catch (e: Exception) {
                onResult(false, e.localizedMessage)
            }
        }
    }

    fun login(credentials: Credentials, onResult: (AuthResponse?, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val response = api.signIn(credentials)
                if (response.isSuccessful) {
                    authResponse = response.body()
                    onResult(authResponse, null)
                } else {
                    onResult(null, response.errorBody()?.string())
                }
            } catch (e: HttpException) {
                onResult(null, e.message())
            } catch (e: Exception) {
                onResult(null, e.localizedMessage)
            }
        }
    }
}
