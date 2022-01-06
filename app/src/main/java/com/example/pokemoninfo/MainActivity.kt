package com.example.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
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
    private val listOfPokemonsName: MutableList<String> = mutableListOf()

    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchPokemon()
    }

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    private fun fetchPokemon() {

        val repository = DataModule.providePokeApi().getListOfPokemonName()

        repository
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repositoryInfo ->
//                    repositoryResponse.add(repositoryInfo)
//                    println(repositoryResponse[0].nameResponse)

                    listOfPokemonsName.addAll(
                        repositoryInfo.results.map {
                            it.name
                        }
                    )

//                    println(repositoryInfo.results)

                    setContent {
                        SingleScreenApp(listOfPokemonsName)
                    }
                },
                {
                    val errorMessage = it.message

                    setContent {
                        ErrorScreen()
                        println(errorMessage)
                    }
                }
            )
            .addTo(disposable)
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}
