package hu.matyi.familyorganiser.ApiTests.familyController

import io.swagger.client.apis.FamilyControllerApi
import io.swagger.client.models.CreateFamily
import org.junit.Test


class DeleteFamily {
    val existingId : Long = 1
    @Test
    fun deleteFamilyNoErrorTest() {
        //FamilyControllerApi().deleteByIdUsingDELETE(2)
          FamilyControllerApi().deleteByIdUsingDELETE(20)
    }
}