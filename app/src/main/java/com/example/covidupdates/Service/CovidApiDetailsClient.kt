package com.example.covidupdates.Service

import com.example.covidupdates.Model.CovidDetailsModel
import retrofit2.Call
import retrofit2.http.GET


interface CovidApiDetailsClient {


    @GET("data.json")
    fun getCovidDetails(): Call<CovidDetailsModel>


}