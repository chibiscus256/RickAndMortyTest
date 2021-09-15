package ru.codavari.rickandmortyapp.reposiory.episodes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import javax.inject.Inject

class EpisodesRepositoryImpl @Inject constructor(
    private val repository: EpisodesRepository
) : EpisodesRepository {
    override suspend fun getAllEpisodes(page: Int?) = withContext(Dispatchers.IO) {
        repository.getAllEpisodes(page)
    }

    override suspend fun getEpisodes(episodeIds: List<Int>) = withContext(Dispatchers.IO) {
        repository.getEpisodes(episodeIds)
    }

    override suspend fun getEpisode(episodeId: Int) = withContext(Dispatchers.IO) {
        repository.getEpisode(episodeId)
    }
}