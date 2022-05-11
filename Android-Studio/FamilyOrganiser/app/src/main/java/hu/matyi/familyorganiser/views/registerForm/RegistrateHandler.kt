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

class RegistrationHandler() {
    fun sendRegistrationRequest(registerModel: RegisterModel) : Boolean {
        GlobalScope.launch(Dispatchers.IO) {
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
                    registerModel.setUID(LoginHandler.UID?:"")
                }
           FamilyMemberControllerApi().registerUsingPOST(RegistrationDTO(LoginHandler.UID!!,
               registerModel.getRegisterLiveDto().value?.username?:"",
               registerModel.getRegisterLiveDto().value?.password?:""
                   )
           )
           }
            catch (e: Exception)
            {
                System.out.println(e.message)
            }
        }
        return(registerModel.getRegisterLiveDto().value?.username?.isNotEmpty() == true &&
                registerModel.getRegisterLiveDto().value?.password?.isNotEmpty() == true)
    }
}


