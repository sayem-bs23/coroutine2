package com.bs.corooutine2

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.*

object Repository{
    val AppId= "bb4dd20e432ae754a84c5b91ee475854"
    val lat = "23"
    val lon = "90"
    val units = "metric"

    var job:CompletableJob? = null //more control on asynchronous job
    fun getUser(userId: String): LiveData<User>{
        job = Job()

        return object : LiveData<User>(){
            override fun onActive() {
                super.onActive() //when the method is called, I want to get the value

                job?.let{theJob->
                    CoroutineScope(IO + theJob).launch{
//                        val user = MyRetrofitBuilder.apiService.getUser(lat, lon, AppId, units).execute().body()
                        val user = MyRetrofitBuilder.apiService.getUser(lat, lon, AppId, units)
//                        val user = MyRetrofitBuilder.apiService.getUser(userId)
                        withContext(Main){
                            value = user //setValue in live data

                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(){
        job?.cancel() //later in the view model, when the activity is destroyed, we want to cancel

    }
}