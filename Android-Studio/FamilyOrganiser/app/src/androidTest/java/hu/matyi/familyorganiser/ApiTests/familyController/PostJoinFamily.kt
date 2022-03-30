package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.models.CreateFamily
import org.junit.Test

class PostJoinFamily {
    val existingId : Long = 1

    @Test
    fun postJoinToFamilyNoErrorTest() {
        FamilyControllerApi().joinFamilyUsingPOST(existingId,1)
    }
}