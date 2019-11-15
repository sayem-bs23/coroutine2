package com.bs.corooutine2

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.AndroidViewModel

class MainViewModel : ViewModel(){
    private val _userId: MutableLiveData<String> = MutableLiveData()
    val user: LiveData<User> = Transformations.switchMap(_userId){
        Repository.getUser(it)
    }

    //act as trigger
    fun setUserId(userId:String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJob(){
        Repository.cancelJobs()
    }
}