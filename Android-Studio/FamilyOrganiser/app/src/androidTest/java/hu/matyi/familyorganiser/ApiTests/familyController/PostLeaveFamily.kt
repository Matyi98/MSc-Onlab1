package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.models.CreateFamily
import org.junit.Test

class PostLeaveFamily {
    @Test
    fun postLeaveFamilyNoErrorTest() {
        FamilyControllerApi().leaveFamilyUsingPOST(1,1)
    }
}