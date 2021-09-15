package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class GetEpisodes @Inject constructor(private val episodesRepository: EpisodesRepository) {
    suspend operator fun invoke(episodeIds: List<Int>) =
        episodesRepository.getEpisodes(episodeIds)
}