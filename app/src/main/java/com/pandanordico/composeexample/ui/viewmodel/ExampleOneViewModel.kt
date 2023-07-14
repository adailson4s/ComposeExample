package com.pandanordico.composeexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ExampleOneViewModel @Inject constructor() : ViewModel() {

    private val _example = MutableStateFlow("0")
    val example = _example.asStateFlow()

    private val _getRandomNumberControl = MutableStateFlow(false)
    val getRandomNumberControl = _getRandomNumberControl.asStateFlow()

    fun startOrPauseRandomNumber(boolean: Boolean) {
        _getRandomNumberControl.update { boolean }
        if (boolean) getRandomNumbers()
    }

    private fun getRandomNumbers() {
        viewModelScope.launch {
            while (getRandomNumberControl.value) {
                _example.update { Random.nextInt(0, 100).toString() }
                delay(100)
            }
        }
    }
}