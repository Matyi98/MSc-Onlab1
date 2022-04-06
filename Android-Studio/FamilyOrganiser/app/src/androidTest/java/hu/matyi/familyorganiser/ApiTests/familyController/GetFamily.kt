package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.apis.FamilyMemberControllerApi
import org.junit.Assert.assertTrue
import org.junit.Test

class GetFamily {
    @Test
    fun getFamilyReturnSomethingTest() {
        assertTrue(
            FamilyControllerApi().getEntitiesUsingGET(1,1)[0].name.isNotEmpty()
        )
    }

}