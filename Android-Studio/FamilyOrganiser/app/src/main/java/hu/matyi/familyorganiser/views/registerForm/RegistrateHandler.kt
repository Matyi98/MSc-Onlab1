package hu.matyi.familyorganiser.views.registerForm

import hu.matyi.familyorganiser.views.loginForm.LoginActivity
import hu.matyi.familyorganiser.views.loginForm.LoginHandler
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.RegistrationDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDate

class RegistrationHandler(private val username: String, private val password: String, private val password2: String) {
    fun sendRegistrationRequest() : Boolean = runBlocking{
        val job = GlobalScope.launch(Dispatchers.IO) {
           try {
                if(LoginHandler.UID == null)
                {
                    LoginHandler.UID =
                        FamilyMemberControllerApi().addEntityUsingPOST1(
                            CreateFamilyMember(
                                "",
                                "",
                                "",
                                null,
                                LocalDate.now(),
                                null
                            )
                        ).uid
                }
                FamilyMemberControllerApi().registerUsingPOST(RegistrationDTO(LoginHandler.UID!!,username,password))
           }
            catch (e: Exception)
            {
                System.out.println(e.message)
            }
        }
        job.join()
        return@runBlocking (password == password2 && password.isNotEmpty() && username.isNotEmpty())
    }
}


