package hu.matyi.familyorganiser.views.registerForm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.swagger.client.models.LoginDTO
import io.swagger.client.models.RegistrationDTO
import javax.inject.Inject

@HiltViewModel
class RegisterModel @Inject constructor() : ViewModel() {
    private val registerLiveDTO = MutableLiveData<RegistrationDTO>(null)
    fun getRegisterLiveDto() = registerLiveDTO
    fun setRegisterLiveDto(registrationDTO: RegistrationDTO)
    {
        registerLiveDTO.value = registrationDTO
    }
    fun setUID(_uid: String) {
        registerLiveDTO.value?.uid = _uid
    }
}