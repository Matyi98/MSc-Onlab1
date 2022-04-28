package hu.matyi.familyorganiser.views.registerForm

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.RegistrationDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegistrationHandler(private val username: String, private val password: String, private val password2: String) {
    fun sendRegistrationRequest() : Boolean
    {
        GlobalScope.launch(Dispatchers.IO) {
           try {
                FamilyMemberControllerApi().registerUsingPOST(RegistrationDTO("aaaaaaaa",username,password))
                System.out.println(FamilyMemberControllerApi().getEntitiesUsingGET1(2,5)[0].firstName)
           }
            catch (e: Exception)
            {

            }
        }
        return (password == password2 && password.isNotEmpty() && username.isNotEmpty())
    }
}


