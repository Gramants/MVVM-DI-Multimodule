package ste.go.mainfeaturemodule

import dagger.Module
import dagger.Provides
import ste.go.basemodule.util.SchedulerProvider
import ste.go.datalayermodule.repository.Repository
import ste.go.mainfeaturemodule.ui.MainActivityViewModel


@Module
class MainActivityModule {

    @Provides
    fun provideViewModel(repository: Repository, schedulerProvider: SchedulerProvider) = MainActivityViewModel(repository, schedulerProvider)
}