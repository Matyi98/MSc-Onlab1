package hu.matyi.familyorganiser.views.profilSettings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.swagger.client.models.CreateFamilyMember
import io.swagger.client.models.FamilyMemberGet
import io.swagger.client.models.LoginDTO
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProfilModel @Inject constructor() : ViewModel()
{
    private val familyMemberLiveDTO = MutableLiveData<FamilyMemberGet>(null)
    fun getFamilyMemberLiveDTO() = familyMemberLiveDTO;
    fun setFamilyMemberLiveDto(familyMemberGet: FamilyMemberGet)
    {
        familyMemberLiveDTO.value = familyMemberGet
    }

    private val createFamilyMemberLiveDTO = MutableLiveData<CreateFamilyMember>(null)
    fun getcreateFamilyMemberLiveDTO() = createFamilyMemberLiveDTO;
    fun setcreateFamilyMemberLiveDto(createFamilyMemberGet: CreateFamilyMember)
    {
        createFamilyMemberLiveDTO.value = createFamilyMemberGet
    }

}


