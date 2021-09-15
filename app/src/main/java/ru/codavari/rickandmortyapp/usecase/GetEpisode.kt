package ru.codavari.rickandmortyapp.usecase


import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class GetEpisode @Inject constructor(
    private val episodesRepository: EpisodesRepository
) {
    suspend operator fun invoke(episodeId: Int) = episodesRepository.getEpisode(episodeId)
}