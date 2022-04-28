package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.RegistrationDTO
import org.junit.Test
import java.time.LocalDate

class PostFamilyMemberSignIn {


    @Test
    fun postSignInNoErrorTest() {
        val user=FamilyMemberControllerApi().getEntityByIdUsingGET1(14)
        FamilyMemberControllerApi().registerUsingPOST(RegistrationDTO(user.uid,"alma","alma"))
    }


}