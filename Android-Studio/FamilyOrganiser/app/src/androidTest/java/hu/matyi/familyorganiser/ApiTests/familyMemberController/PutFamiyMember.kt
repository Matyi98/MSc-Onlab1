package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import org.junit.Test
import java.time.LocalDate

class PutFamiyMember {
    @Test
    fun putFamilyMemberNoErrorTest() {
        val createFamilyMember = CreateFamilyMember("almaSurname","almaLastName","alma@alma.alma",null,
            LocalDate.MAX,4)
        FamilyMemberControllerApi().updateEntityByIdUsingPUT1(createFamilyMember,5)
    }
}