package de.iskae.ui.mapper

interface ViewMapper<in P, out V> {
  fun mapToView(presentation: P): V
}