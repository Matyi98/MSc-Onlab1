package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class PostFamilyMember {

    @Test
    fun postFamilyMemberNoErrorTest() {
        val createFamilyMember = CreateFamilyMember("almaSurname","almaLastName","alma@alma.alma",null,
            LocalDate.MAX,2)
        FamilyMemberControllerApi().addEntityUsingPOST1(createFamilyMember)
    }
}