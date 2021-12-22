package com.example.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.pokemoninfo.data.DataModule
import com.example.pokemoninfo.data.PokeApiResponse
import com.google.accompanist.coil.rememberCoilPainter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val repoLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()
    private val repositoryResponse: MutableList<PokeApiResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchPokemon()
    }

    private fun fetchPokemon() {

        val repository = DataModule.providePokeApi().getPokemon(889)

        repository
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repositoryInfo ->
                    loading.value = false
                    repoLoadError.value = false
                    repositoryResponse.add(repositoryInfo)
                    println(repositoryInfo)
                    println(repositoryResponse)

                    setContent {
                        Column() {
                            Row() {
                                Text(text = "TEST")
                            }
                            Row() {
                                ShowImage(url = repositoryResponse[0].spritesResponse.otherResponse.officialArtworkResponse.frontDefaultResponse, size = 400)
                            }
                        }
                    }

                    println("WORKED")
                },
                {
                    val errorMessage = it.message
                    loading.value = false
                    repoLoadError.value = true
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

@Composable
fun ShowImage(url: String, size: Int) {
    
    Image(
        painter = rememberCoilPainter(
            request = url),
        modifier = Modifier.size(size = size.dp),
        contentDescription = "Profile picture description",
    )
}
