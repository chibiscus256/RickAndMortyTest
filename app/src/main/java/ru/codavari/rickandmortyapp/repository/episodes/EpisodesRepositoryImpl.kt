package ru.codavari.rickandmortyapp.repository.episodes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.codavari.rickandmortyapp.api.EpisodesApi
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val api: EpisodesApi
) : EpisodesRepository {
    override suspend fun getAllEpisodes(page: Int?) = withContext(Dispatchers.IO) {
        api.getAllEpisodes(page).results
    }

    override suspend fun getEpisodes(episodeIds: List<Int>) = withContext(Dispatchers.IO) {
        api.getEpisodes(episodeIds)
    }

    override suspend fun getEpisode(episodeId: Int) = withContext(Dispatchers.IO) {
        api.getEpisode(episodeId)
    }
}