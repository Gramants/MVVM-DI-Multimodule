package ste.go.datalayermodule.network.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ste.go.datalayermodule.network.api.model.Data

interface ApiService {

    @GET("/api/unknown/{userid}")
    fun getJsonResponse(@Path("userid") userid: Int): Single<Data>
}