package ste.go.mainfeaturemodule.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ste.go.mainfeaturemodule.ui.MainActivity
import ste.go.mainfeaturemodule.MainActivityModule

@Module
abstract class MainFeatureBindModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}