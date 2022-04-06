package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.apis.FamilyMemberControllerApi
import org.junit.Test

class DeleteFamilyMember {
    val existingId : Long = 1
    @Test
    fun deleteFamilyMemberNoErrorTest() {
        FamilyMemberControllerApi().deleteByIdUsingDELETE1(6)
    }
}