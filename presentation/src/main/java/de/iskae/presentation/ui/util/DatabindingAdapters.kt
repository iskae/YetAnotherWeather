package de.iskae.presentation.ui.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import de.iskae.presentation.R

object DatabindingAdapters {
  @JvmStatic
  @BindingAdapter("visibleOrGone")
  fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
  }

  @JvmStatic
  @BindingAdapter("loadIcon")
  fun loadWeatherIcon(iv: ImageView, icon: String?) {
    icon?.let {
      Picasso.get().load(iv.context.getString(R.string.open_weather_map_icon_url, it)).into(iv)
    }
  }
}