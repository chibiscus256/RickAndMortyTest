package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class GetAllEpisodes @Inject constructor(private val episodesRepository: EpisodesRepository) {
    suspend operator fun invoke(page: Int? = null) = episodesRepository.getAllEpisodes(page)
}