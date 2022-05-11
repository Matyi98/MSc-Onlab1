package hu.matyi.familyorganiser.views.profilSettings

import hu.matyi.familyorganiser.views.loginForm.LoginHandler
import io.swagger.client.apis.FamilyMemberControllerApi
import io.swagger.client.models.CreateFamilyMember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfilSettingsHandler {
    fun sendProfilSettingsRequest(profilModel: ProfilModel) {
        GlobalScope.launch(Dispatchers.IO) {
            if (LoginHandler.UID != null) {
                val familyMemberControllerApi = FamilyMemberControllerApi()
                try {


                ProfilModel().setFamilyMemberLiveDto(
                    familyMemberControllerApi.addEntityUsingPOST1(
                        CreateFamilyMember(
                            profilModel.getFamilyMemberLiveDTO().value?.firstName?:"",
                            profilModel.getFamilyMemberLiveDTO().value?.lastName?:"",
                            profilModel.getFamilyMemberLiveDTO().value?.email?:"",
                            profilModel.getFamilyMemberLiveDTO().value?.photo,
                            profilModel.getFamilyMemberLiveDTO().value?.birthDate
                        )
                    ))
                }
                catch (e : Exception)
                {
                    System.out.println("Error: "+e.message)
                }
                LoginHandler.UID = ProfilModel().getFamilyMemberLiveDTO().value?.uid?:""

            } else {
                val familyMemberControllerApi = FamilyMemberControllerApi()
                try {

                    familyMemberControllerApi.updateEntityByIdUsingPUT1(
                        CreateFamilyMember(
                            profilModel.getFamilyMemberLiveDTO().value?.firstName ?: "",
                            profilModel.getFamilyMemberLiveDTO().value?.lastName ?: "",
                            profilModel.getFamilyMemberLiveDTO().value?.email ?: "",
                            profilModel.getFamilyMemberLiveDTO().value?.photo,
                            profilModel.getFamilyMemberLiveDTO().value?.birthDate
                        ),
                        profilModel.getFamilyMemberLiveDTO().value?.id ?: 0
                    ).toString()
                }
                catch (e : Exception)
                {
                    System.out.println("Error: " + e.message)
                }
            }
        }
    }
}