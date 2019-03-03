package ste.go.mainfeaturemodule.ui

import android.os.Bundle
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import ste.go.mainfeaturemodule.R

import javax.inject.Inject

class MainActivity : DaggerActivity() {

    private val compositeDisposable by lazy { CompositeDisposable() }

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRandomName()

        button.setOnClickListener {
            getRandomName()
        }
    }

    private fun getRandomName() {
        compositeDisposable.add(mainActivityViewModel.showDataFromApi()
                .subscribeBy(onSuccess = {
                    tv.text = it.data?.name ?: "empty!"
                }, onError = {
                    tv.text = it.message
                }))
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}
