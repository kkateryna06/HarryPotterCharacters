package com.example.harrypottercharacters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _characterState = mutableStateOf(CharacterState())
    val charactersState: State<CharacterState> =_characterState

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = characterService.getCharacters()
                _characterState.value = _characterState.value.copy(
                    loading = false,
                    list = response,
                    error = null
                )
            } catch (e: Exception) {
                _characterState.value =_characterState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }

    data class CharacterState(
        val loading: Boolean = true,
        val list: List<Character> = emptyList(),
        val error: String? = null
    )
}