package com.example.covidupdates.View

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covidupdates.Service.CovidApiDetailsClient
import com.example.covidupdates.Model.CovidDetailsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CovidViewModel : ViewModel() {

    private val _activeNo = MutableLiveData<String>()

    fun activeNo():LiveData<String>{
        return _activeNo
    }
    private val _recoveredNo = MutableLiveData<String>()

    fun recoveredNo():LiveData<String>{
        return _recoveredNo
    }
    private val _deathsNo = MutableLiveData<String>()

    fun deathsNo():LiveData<String>{
        return _deathsNo
    }
    fun getCovidDetails() {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.covid19india.org/")
                .build()
            val covidApiDetailsClient = retrofit.create(CovidApiDetailsClient::class.java)
            val myCall: Call<CovidDetailsModel> = covidApiDetailsClient.getCovidDetails()
            myCall.enqueue(object : retrofit2.Callback<CovidDetailsModel> {
                override fun onFailure(call: Call<CovidDetailsModel>, t: Throwable) {
                    Log.e("error..", t.message.toString());
                }

                override fun onResponse(
                    call: Call<CovidDetailsModel>,
                    response: Response<CovidDetailsModel>
                ) {
                    val Details: List<CovidDetailsModel> = listOf(response.body()!!)
                    var count : Int = 0
                    for (details in Details) {
                        _activeNo.value = details.getStatewise()?.get(count)?.confirmed
                        _recoveredNo.value = details.getStatewise()?.get(count)?.recovered
                        _deathsNo.value = details.getStatewise()?.get(count)?.deaths
                        count = count.plus(1)
                    }
                }
            })
    }


}