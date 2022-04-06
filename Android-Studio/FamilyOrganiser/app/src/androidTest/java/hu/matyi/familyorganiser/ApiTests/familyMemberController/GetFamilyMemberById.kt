package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyMemberControllerApi
import org.junit.Assert
import org.junit.Test

class GetFamilyMemberById {
    @Test
    fun getFamilyMemberByIdTest() {
        Assert.assertTrue(
            FamilyMemberControllerApi().getEntityByIdUsingGET1(3).lastName.isNotEmpty()
        )
    }
}