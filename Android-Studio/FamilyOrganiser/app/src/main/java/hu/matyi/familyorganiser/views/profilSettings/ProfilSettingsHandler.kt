package hu.matyi.familyorganiser.views.profilSettings

import hu.matyi.familyorganiser.views.loginForm.LoginHandler
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfilSettingsHandler {
    fun ProfilSettingsHandler(
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            if (LoginHandler.UID != null) {
                val familyMemberControllerApi = FamilyMemberControllerApi()
                LoginHandler.UID =
                    familyMemberControllerApi.addEntityUsingPOST1(
                        CreateFamilyMember(
                            ProfilModel.createFamilyMember.firstName,
                            ProfilModel.createFamilyMember.lastName,
                            ProfilModel.createFamilyMember.email,
                            ProfilModel.createFamilyMember.photo,
                            ProfilModel.createFamilyMember.birthDate
                        )
                    ).uid
            } else {
                val familyMemberControllerApi = FamilyMemberControllerApi()
                familyMemberControllerApi.updateEntityByIdUsingPUT1(
                    CreateFamilyMember(
                        ProfilModel.createFamilyMember.firstName,
                        ProfilModel.createFamilyMember.lastName,
                        ProfilModel.createFamilyMember.email,
                        ProfilModel.createFamilyMember.photo,
                        ProfilModel.createFamilyMember.birthDate
                    ),
                    LoginHandler.UID!!.toLong()
                ).toString()
            }
        }
    }
}