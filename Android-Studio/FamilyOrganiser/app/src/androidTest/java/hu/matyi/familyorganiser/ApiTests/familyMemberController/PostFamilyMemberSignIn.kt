package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.RegistrationDTO
import org.junit.Test
import java.time.LocalDate

class PostFamilyMemberSignIn {


    @Test
    fun postSignInNoErrorTest() {
        FamilyMemberControllerApi().registerUsingPOST(RegistrationDTO("aaaaaaaa","alma","alma"))
    }


}