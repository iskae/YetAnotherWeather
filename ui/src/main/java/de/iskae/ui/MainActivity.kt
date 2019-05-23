package de.iskae.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.iskae.ui.databinding.ActivityMainBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainActivity : AppCompatActivity(), KodeinAware {

  override val kodein: Kodein by lazy { (applicationContext as KodeinAware).kodein }

  private lateinit var binding: ActivityMainBinding
  private lateinit var navHostFragment: NavHostFragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    navHostFragment = supportFragmentManager.findFragmentById(R.id.uiMainContainer) as NavHostFragment
    findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
      .setupWithNavController(navController = navHostFragment.navController)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> {
        navHostFragment.navController.popBackStack()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

}