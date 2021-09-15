package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.characters.CharactersRepository
import javax.inject.Inject

class GetCharacter @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(characterId: Int) = charactersRepository.getCharacter(characterId)
}