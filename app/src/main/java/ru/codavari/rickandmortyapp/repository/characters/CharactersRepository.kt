package ru.codavari.rickandmortyapp.repository.characters

import ru.codavari.rickandmortyapp.data.Character

interface CharactersRepository {
    suspend fun getAllCharacters(page: Int? = null): List<Character>
    suspend fun getCharacters(characterIds: List<Int>): List<Character>
    suspend fun getCharacter(characterId: Int): Character
}
