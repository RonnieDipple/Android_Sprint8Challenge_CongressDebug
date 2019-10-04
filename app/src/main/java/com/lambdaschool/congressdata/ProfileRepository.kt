package com.lambdaschool.congressdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log

import com.lambdaschool.congressdataapiaccess.CongressDao

object ProfileRepository {
    fun getProfile(id: String?): LiveData<CongresspersonProfile> {
        Log.i("Repository", "Retreiving Data")
        val profileLiveData = MutableLiveData<CongresspersonProfile>()

        id?.let {
            val profile = CongresspersonProfile(CongressDao.getMemberDetails(id))
            profile.image = CongressDao.getImage(profile.id)
            profileLiveData.value = profile
        }
        return profileLiveData
    }
}
