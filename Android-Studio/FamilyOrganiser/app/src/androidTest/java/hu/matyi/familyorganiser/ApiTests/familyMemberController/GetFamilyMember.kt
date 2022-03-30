package hu.matyi.familyorganiser.ApiTests.familyMemberController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.apis.FamilyMemberControllerApi
import org.junit.Assert
import org.junit.Test

class GetFamilyMember {

    @Test
    fun getAllFamilyMemberTest() {
        Assert.assertTrue(
            FamilyMemberControllerApi().getEntitiesUsingGET1(1, 1)[0].lastName.isNotEmpty()
        )
    }
}