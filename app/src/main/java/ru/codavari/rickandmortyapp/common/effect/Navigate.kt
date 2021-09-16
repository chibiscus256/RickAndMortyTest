package ru.codavari.rickandmortyapp.common.effect

import ru.codavari.rickandmortyapp.base.UIEffect
import ru.gazpromneft.tenders.base.Navigator

data class Navigate (
    val navigate: (Navigator) -> Unit
): UIEffect()
