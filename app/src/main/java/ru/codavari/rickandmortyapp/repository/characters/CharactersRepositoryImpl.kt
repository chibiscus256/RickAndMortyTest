package ru.codavari.rickandmortyapp.repository.characters

import retrofit2.HttpException
import ru.codavari.rickandmortyapp.api.CharactersApi
import ru.codavari.rickandmortyapp.data.Character

class CharactersRepositoryImpl(private val api: CharactersApi) : CharactersRepository {
    override suspend fun getAllCharacters(page: Int?): List<Character> = try {
        api.getAllCharacters(page).results
    } catch (exception: HttpException) {
        if (exception.code() == 404) listOf() else throw exception
    }
    override suspend fun getCharacters(characterIds: List<Int>) = api.getCharacters(characterIds)
    override suspend fun getCharacter(characterId: Int) = api.getCharacter(characterId)
}