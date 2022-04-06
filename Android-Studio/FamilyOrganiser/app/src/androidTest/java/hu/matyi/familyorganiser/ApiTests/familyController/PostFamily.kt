package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamily
import io.swagger.client.models.RegistrationDTO
import org.junit.Assert
import org.junit.Test

class PostFamily {
    @Test
    fun postFamilyNoErrorTest() {
            FamilyControllerApi().addEntityUsingPOST(CreateFamily("testFamily1","t3stF4m1ly1",null,null))
    }
}