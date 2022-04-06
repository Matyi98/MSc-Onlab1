package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.LoginDTO
import org.junit.Test
import java.time.LocalDate

class PostLogin {

    @Test
    fun postLoginNoErrorTest() {
        FamilyMemberControllerApi().loginUsingPOST(LoginDTO("alma", "alma"))
    }
}



