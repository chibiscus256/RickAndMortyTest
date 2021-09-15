package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.characters.CharactersRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val charactersRepository: CharactersRepository) {
    suspend operator fun invoke(characterIds: List<Int>) =
        charactersRepository.getCharacters(characterIds)
}