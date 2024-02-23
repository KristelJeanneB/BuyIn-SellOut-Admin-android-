package com.kristeljeanne.bautista.block1.p1.buyinselloutadmin

import android.app.Notification.Action
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open_nav,R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null){
            replaceFragment(DashboardFragment())
            navigationView.setCheckedItem(R.id.nav_dashboard)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_dashboard -> replaceFragment(DashboardFragment())
            R.id.nav_category -> replaceFragment(CategoryFragment())
            R.id.nav_sub_category -> replaceFragment(SubCategoryFragment())
            R.id.nav_brands -> replaceFragment(BrandsFragment())
            R.id.nav_products -> replaceFragment(ProductsFragment())
            R.id.nav_shipping -> replaceFragment(ShippingFragment())
            R.id.nav_orders -> replaceFragment(OrdersFragment())
            R.id.nav_discount -> replaceFragment(DiscountFragment())
            R.id.nav_users -> replaceFragment(UsersFragment())
            R.id.nav_pages -> replaceFragment(SignupFragment())
            R.id.nav_logout -> Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show()


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
        super.onBackPressed()
    }
}