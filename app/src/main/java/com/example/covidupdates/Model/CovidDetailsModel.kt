package com.example.covidupdates.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CovidDetailsModel {
    @SerializedName("cases_time_series")
    @Expose
    private var casesTimeSeries: List<CasesTimeSeries?>? = null

    @SerializedName("statewise")
    @Expose
    private var statewise: List<Statewise?>? = null

    fun getCasesTimeSeries(): List<CasesTimeSeries?>? {
        return casesTimeSeries
    }

    fun setCasesTimeSeries(casesTimeSeries: List<CasesTimeSeries?>?) {
        this.casesTimeSeries = casesTimeSeries
    }

    fun getStatewise(): List<Statewise?>? {
        return statewise
    }

    fun setStatewise(statewise: List<Statewise?>?) {
        this.statewise = statewise
    }
    class CasesTimeSeries {
        @SerializedName("dailyconfirmed")
        @Expose
        var dailyconfirmed: String? = null

        @SerializedName("dailydeceased")
        @Expose
        var dailydeceased: String? = null

        @SerializedName("dailyrecovered")
        @Expose
        var dailyrecovered: String? = null

        @SerializedName("date")
        @Expose
        var date: String? = null

        @SerializedName("totalconfirmed")
        @Expose
        var totalconfirmed: String? = null

        @SerializedName("totaldeceased")
        @Expose
        var totaldeceased: String? = null

        @SerializedName("totalrecovered")
        @Expose
        var totalrecovered: String? = null

    }
    class Statewise {
        @SerializedName("active")
        @Expose
        var active: String? = null

        @SerializedName("confirmed")
        @Expose
        var confirmed: String? = null

        @SerializedName("deaths")
        @Expose
        var deaths: String? = null

        @SerializedName("deltaconfirmed")
        @Expose
        var deltaconfirmed: String? = null

        @SerializedName("deltadeaths")
        @Expose
        var deltadeaths: String? = null

        @SerializedName("deltarecovered")
        @Expose
        var deltarecovered: String? = null

        @SerializedName("lastupdatedtime")
        @Expose
        var lastupdatedtime: String? = null

        @SerializedName("migratedother")
        @Expose
        var migratedother: String? = null

        @SerializedName("recovered")
        @Expose
        var recovered: String? = null

        @SerializedName("state")
        @Expose
        var state: String? = null

        @SerializedName("statecode")
        @Expose
        var statecode: String? = null

        @SerializedName("statenotes")
        @Expose
        var statenotes: String? = null

        /*fun getActive(): String? {
            return active
        }

        fun setActive(active: String) {
            this.active = active
        }*/



    }
}