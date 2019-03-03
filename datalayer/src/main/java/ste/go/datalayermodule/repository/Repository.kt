package ste.go.datalayermodule.repository

import io.reactivex.Single
import ste.go.datalayermodule.network.api.ApiService
import ste.go.datalayermodule.network.api.model.Data
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

    fun getDataFromApi(userid: Int): Single<Data> = apiService.getJsonResponse(userid)

}