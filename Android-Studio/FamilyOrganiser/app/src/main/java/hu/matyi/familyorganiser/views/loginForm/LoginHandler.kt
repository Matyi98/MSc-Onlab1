package hu.matyi.familyorganiser.views.loginForm

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
    fun sendLoginRequest() : Boolean = runBlocking{
        token = null
        var successToken = false;
        val job = GlobalScope.launch(Dispatchers.IO) {
            try {
                val familyMemberControllersApi = FamilyMemberControllerApi()

                token =
                    familyMemberControllersApi.loginUsingPOST(LoginDTO(LoginModel.loginDTO.username, LoginModel.loginDTO.password))
            }
            catch (e: Exception)
            {

            }
            successToken = false

            if(token != null)
                if(token!!.accessToken.isNotEmpty())
                    successToken = true
        }
        job.join()
        return@runBlocking LoginModel.loginDTO.username.isNotEmpty() && LoginModel.loginDTO.password.isNotEmpty() && successToken
    }
}