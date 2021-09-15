package ru.codavari.rickandmortyapp.repository.episodes

import ru.codavari.rickandmortyapp.data.Episode

interface EpisodesRepository {
    suspend fun getAllEpisodes(page: Int? = null): List<Episode>
    suspend fun getEpisodes(episodeIds: List<Int>): List<Episode>
    suspend fun getEpisode(episodeId: Int): Episode
}