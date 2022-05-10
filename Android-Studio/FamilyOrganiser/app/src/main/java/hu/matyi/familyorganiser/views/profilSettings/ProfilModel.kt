package hu.matyi.familyorganiser.views.profilSettings

import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.LoginDTO
import java.time.LocalDate

public class ProfilModel()
{
    companion object {
        var createFamilyMember = CreateFamilyMember("","","",null, LocalDate.now(),0)
    }
}


