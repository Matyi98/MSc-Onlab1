package hu.matyi.familyorganiser.views.loginForm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp

import dagger.hilt.android.lifecycle.HiltViewModel
import io.swagger.client.models.LoginDTO
import javax.inject.Inject

@HiltViewModel
class LoginModel @Inject constructor(): ViewModel() {
        private val loginLiveDTO = MutableLiveData<LoginDTO>(null)
        fun getLoginLiveDto() = loginLiveDTO
        fun setLoginLiveDto(loginDto : LoginDTO) {
            loginLiveDTO.value = loginDto
        }
}

@HiltAndroidApp
class LoginApplication : Application()

//entry point, manifest, = HiltViewModel()