package ste.go.mainfeaturemodule.ui

import io.reactivex.Single
import ste.go.basemodule.util.SchedulerProvider
import ste.go.datalayermodule.network.api.model.Data
import ste.go.datalayermodule.repository.Repository

class MainActivityViewModel(private val repository: Repository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApi(): Single<Data> = repository.getDataFromApi((0..10).random())
            .compose(schedulerProvider.getSchedulersForSingle<Data>())
}
