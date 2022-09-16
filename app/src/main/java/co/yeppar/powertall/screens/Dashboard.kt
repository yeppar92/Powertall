package co.yeppar.powertall.screens

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import co.yeppar.powertall.R
import co.yeppar.powertall.common.Common
import co.yeppar.powertall.databinding.ActivityDashboardBinding
import co.yeppar.powertall.screens.fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationView
import es.dmoral.toasty.Toasty


class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var fragmentTransaction: FragmentTransaction
    private var doubleBackToExitPressedOnce = false
    private var fragment: Fragment? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.navigationBarColor = resources.getColor(R.color.bottombackcolor)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        init()
    }

    private fun init() {
        setSupportActionBar(binding.toolbar)
        binding.bottomNavigation.inflateMenu(R.menu.bottom_nav)

        //if (Common.isInternetOn(applicationContext)) {
            binding.bottomNavigation.setSelectedItemId(R.id.bottomhome)
            fragmentTransaction = supportFragmentManager.beginTransaction()
            fragment = Home()
            fragmentTransaction.replace(R.id.main_container, fragment as Home)
            fragmentTransaction.commit()
       // } else {
          /*  Toasty.error(
                applicationContext,
                "Please check your internet connection.",
                Toasty.LENGTH_SHORT
            ).show()
            finish()*/
      //  }


        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                /*R.id.bottomhome -> {
                    if (supportFragmentManager.backStackEntryCount > 0) {
                        supportFragmentManager.popBackStack()
                    }
                    fragment = Home()
                    binding.dashlogo.setText(R.string.app_name)
                }
                  R.id.bottomhelp -> {
                      if (supportFragmentManager.backStackEntryCount > 0) {
                          supportFragmentManager.popBackStack()
                      }
                      fragment = Notification()
                      binding.dashlogo.setText("Notification")
                  }
                R.id.bottomcontact -> {

                }*/

            }
            fragmentTransaction = supportFragmentManager.beginTransaction()
            fragment?.let { fragmentTransaction.replace(R.id.main_container, it) }
            fragmentTransaction.commit()
            true
        })




    }











    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                overridePendingTransition(R.anim.enter1, R.anim.exit1)
                return
            }
            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        }
    }


}