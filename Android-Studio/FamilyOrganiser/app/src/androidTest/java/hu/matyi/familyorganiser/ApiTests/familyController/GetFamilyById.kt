package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.apis.FamilyMemberControllerApi
import org.junit.Test

class GetFamilyById {
    val existingId : Long = 1
    @Test
    fun getFamilyByIdNoErrorTest()
    {
        FamilyControllerApi().getEntityByIdUsingGET(existingId)
    }
}