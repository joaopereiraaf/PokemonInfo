package com.example.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import com.example.pokemoninfo.data.DataModule
import com.example.pokemoninfo.data.PokemonInfo
import com.example.pokemoninfo.presenter.ErrorScreen
import com.example.pokemoninfo.presenter.SingleScreenApp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val pokemonResponse: MutableList<PokemonInfo> = mutableListOf()
    private val listOfPokemonsName: MutableList<String> = mutableListOf()

    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchPokemon()
    }

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    private fun fetchPokemon(id: Int) {

        val repository = DataModule.providePokeApi().getListOfPokemonName()
        val pokemon = DataModule.providePokeApi().getPokemon(id = id)

        pokemon
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repositoryInfo ->
                    pokemonResponse.add(repositoryInfo)
                    println(pokemonResponse)
                    println("worked")
                    setContent {
                        SingleScreenApp(listOfPokemonsName)
                    }
                },
                {
                    val errorMessage = it.message

                    setContent {
                        println("didn't work")
                        ErrorScreen()
                        println(errorMessage)
                    }
                }
            )
            .addTo(disposable)


//        repository
//            .subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { repositoryInfo ->
//                    listOfPokemonsName.addAll(
//                        repositoryInfo.results.map {
//                            it.name
//                        }
//                    )
////                    println(repositoryInfo.results)
//                    setContent {
//                        SingleScreenApp(listOfPokemonsName)
//                    }
//                },
//                {
//                    val errorMessage = it.message
//
//                    setContent {
//                        ErrorScreen()
//                        println(errorMessage)
//                    }
//                }
//            )
//            .addTo(disposable)
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    companion object {

        const val ARG_ITEM_ID = "item_id"
    }

}
