package com.example.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.pokemoninfo.data.DataModule
import com.example.pokemoninfo.data.PokeApiResponse
import com.example.pokemoninfo.presenter.ErrorScreen
import com.example.pokemoninfo.presenter.SingleScreenApp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val repositoryResponse: MutableList<PokeApiResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchPokemon()
    }

    private fun fetchPokemon() {

        val repository = DataModule.providePokeApi().getPokemon(889)

        repository
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repositoryInfo ->
                    repositoryResponse.add(repositoryInfo)
                    println(repositoryInfo)
                    println(repositoryResponse)

                    setContent {
                        SingleScreenApp()
                    }

                    println("WORKED")
                },
                {
                    val errorMessage = it.message

                    setContent {
                        ErrorScreen()
                        println(errorMessage)
                    }

                    println("DIDN'T WORK")
                }
            )
            .addTo(disposable)
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}
