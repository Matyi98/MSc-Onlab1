package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.models.CreateFamily
import org.junit.Test

class PutFamily {
    val existingId : Long = 1
    @Test
    fun putFamilyNoErrorTest() {
        FamilyControllerApi().updateEntityByIdUsingPUT(CreateFamily("testFamily1","t3stF4m1ly1",null,null),1)
    }
}