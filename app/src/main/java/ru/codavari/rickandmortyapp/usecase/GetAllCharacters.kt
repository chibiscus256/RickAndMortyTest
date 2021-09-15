package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.characters.CharactersRepository
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class GetAllCharacters @Inject constructor(
    private val charactersRepository: CharactersRepository,
    private val episodesRepository: EpisodesRepository
) {
    suspend operator fun invoke(page: Int? = null) = charactersRepository.getAllCharacters(page)

}