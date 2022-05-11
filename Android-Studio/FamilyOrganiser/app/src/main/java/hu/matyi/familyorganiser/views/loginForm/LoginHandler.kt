package hu.matyi.familyorganiser.views.loginForm

import androidx.hilt.navigation.compose.hiltViewModel
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.LoginDTO
import io.swagger.client.models.Tokens
import kotlinx.coroutines.*


class LoginHandler() {
    companion object Token {
        var token: Tokens? = null
        var UID: String? = null
    }
    @DelicateCoroutinesApi
    fun sendLoginRequest(loginModel: LoginModel): Boolean {
        token = null
        var successToken = false;
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val familyMemberControllersApi = FamilyMemberControllerApi()

                token =
                     loginModel.getLoginLiveDto().value?.let {
                        LoginDTO(
                            it.username, it.password)
                    }?.let { familyMemberControllersApi.loginUsingPOST(it) }
            }
            catch (e: Exception)
            {

            }
            successToken = false

            if(token != null)
                if(token!!.accessToken.isNotEmpty())
                    successToken = true
        }
        return loginModel.getLoginLiveDto().value?.username?.isNotEmpty() == true
        && loginModel.getLoginLiveDto().value?.password?.isNotEmpty() == true
                && successToken
    }
}