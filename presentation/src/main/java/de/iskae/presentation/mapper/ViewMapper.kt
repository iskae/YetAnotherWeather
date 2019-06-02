package de.iskae.presentation.mapper

interface ViewMapper<in D, out V> {
  fun mapToView(domain: D): V
}