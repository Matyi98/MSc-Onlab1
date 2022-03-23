package hu.matyi.familyorganiser.views.loginForm

import io.swagger.client.apis.FamilyMemberControllersApi
import io.swagger.client.models.LoginDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginHandler {
    private var name: String = ""
    private var password: String = ""
    fun setUsername(name : String)
    {
        this.name = name
    }
    fun setPassword(password : String)
    {
        this.password = password
    }

    fun sendLoginRequest() : Boolean
    {
        GlobalScope.launch(Dispatchers.IO) {
            val familyMemberControllersApi = FamilyMemberControllersApi()
            familyMemberControllersApi.loginUsingPOST(LoginDTO(password, "", name))
        }
        return true
    }

}