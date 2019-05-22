package de.iskae.presentation.mapper

interface PresentationMapper<in D, out V> {
    fun mapToView(domain: D): V
}