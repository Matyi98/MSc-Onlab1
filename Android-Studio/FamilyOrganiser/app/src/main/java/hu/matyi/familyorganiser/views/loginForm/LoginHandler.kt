package hu.matyi.familyorganiser.views.loginForm

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.LoginDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginHandler(private var name: String, private var password: String) {



    fun sendLoginRequest() : Boolean
    {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val familyMemberControllersApi = FamilyMemberControllerApi()
                familyMemberControllersApi.loginUsingPOST(LoginDTO(name, password))
            }
            catch (e: Exception)
            {

            }
        }
        return name.isNotEmpty() && password.isNotEmpty()
    }
}