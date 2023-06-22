package com.jindvir.blue

import android.R.drawable
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.jindvir.blue.databinding.ActivityMainBinding
import com.jindvir.blue.fragments.FavoritesPage
import com.jindvir.blue.fragments.HomePage
import com.jindvir.blue.fragments.ProfilePage
import com.jindvir.blue.fragments.SettingsPage
import com.jindvir.blue.fragments.ShopPage


class MainActivity : AppCompatActivity() {

    private lateinit var color : Color
    private lateinit var _binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)


        fragmentOpen(HomePage())
        fragmentOpenHandler()


    }

    private fun removeDecorationNavBar(view : View){
        when (view.id) {
            R.id.home_fragment -> {
                //Profile TextView Decoration Removing
                val profileTextView = _binding.profileFragment
                profileTextView.text = ""
                profileTextView.setBackgroundResource(R.color.transparent)
                profileTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //shop TextView Decoration Removing
                val shopTextView = _binding.shopFragment
                shopTextView.text = ""
                shopTextView.setBackgroundResource(R.color.transparent)
                shopTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //settings TextView Decoration Removing
                val settingsTextView = _binding.favoriteFragment
                settingsTextView.text = ""
                settingsTextView.setBackgroundResource(R.color.transparent)
                settingsTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

            }
            R.id.profile_fragment -> {
                //Home TextView Decoration Removing
                val homeTextView = _binding.homeFragment
                homeTextView.text = ""
                homeTextView.setBackgroundResource(R.color.transparent)
                homeTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //shop TextView Decoration Removing
                val shopTextView = _binding.shopFragment
                shopTextView.text = ""
                shopTextView.setBackgroundResource(R.color.transparent)
                shopTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //settings TextView Decoration Removing
                val settingsTextView = _binding.favoriteFragment
                settingsTextView.text = ""
                settingsTextView.setBackgroundResource(R.color.transparent)
                settingsTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )
            }

            R.id.shop_fragment -> {
                //Home TextView Decoration Removing
                val homeTextView = _binding.homeFragment
                homeTextView.text = ""
                homeTextView.setBackgroundResource(R.color.transparent)
                homeTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                val profileTextView = _binding.profileFragment
                profileTextView.text = ""
                profileTextView.setBackgroundResource(R.color.transparent)
                profileTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //settings TextView Decoration Removing
                val settingsTextView = _binding.favoriteFragment
                settingsTextView.text = ""
                settingsTextView.setBackgroundResource(R.color.transparent)
                settingsTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )
            }

            R.id.favorite_fragment -> {
                //Home TextView Decoration Removing
                val homeTextView = _binding.homeFragment
                homeTextView.text = ""
                homeTextView.setBackgroundResource(R.color.transparent)
                homeTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                val profileTextView = _binding.profileFragment
                profileTextView.text = ""
                profileTextView.setBackgroundResource(R.color.transparent)
                profileTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )

                //shop TextView Decoration Removing
                val shopTextView = _binding.shopFragment
                shopTextView.text = ""
                shopTextView.setBackgroundResource(R.color.transparent)
                shopTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.black),
                    PorterDuff.Mode.SRC_IN
                )
            }
        }
    }
    private fun changeViewNavBar(view: View){
        when (view.id) {
            R.id.home_fragment -> {
                val homeTextView = _binding.homeFragment
                homeTextView.setBackgroundResource(R.drawable.nav_item_background)
                homeTextView.text = getString(R.string.home)
                homeTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.blue_primary),
                    PorterDuff.Mode.SRC_IN
                )
            }
            R.id.profile_fragment -> {
                val profileTextView = _binding.profileFragment
                profileTextView.text = getString(R.string.profile)
                profileTextView.setBackgroundResource(R.drawable.nav_item_background)
                profileTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.blue_primary),
                    PorterDuff.Mode.SRC_IN
                )


            }
            R.id.shop_fragment -> {
                val shopTextView = _binding.shopFragment
                shopTextView.text = getString(R.string.shop)
                shopTextView.setBackgroundResource(R.drawable.nav_item_background)
                shopTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.blue_primary),
                    PorterDuff.Mode.SRC_IN
                )
            }

            R.id.favorite_fragment -> {
                val settingsTextView = _binding.favoriteFragment
                settingsTextView.text = getString(R.string.favorites)
                settingsTextView.setBackgroundResource(R.drawable.nav_item_background)
                settingsTextView.getCompoundDrawables()[0].colorFilter = PorterDuffColorFilter(
                    getColor(R.color.blue_primary),
                    PorterDuff.Mode.SRC_IN
                )
            }
        }
    }
    private fun fragmentOpenHandler(){



        _binding.homeFragment.setOnClickListener {
            changeViewNavBar(it)
            removeDecorationNavBar(it)
            fragmentOpen(HomePage())
        }

        _binding.profileFragment.setOnClickListener {
            changeViewNavBar(it)
            removeDecorationNavBar(it)
            fragmentOpen(ProfilePage())
        }

        _binding.shopFragment.setOnClickListener {
            changeViewNavBar(it)
            removeDecorationNavBar(it)
            fragmentOpen(ShopPage())
        }

        _binding.favoriteFragment.setOnClickListener {
            changeViewNavBar(it)
            removeDecorationNavBar(it)
            fragmentOpen(FavoritesPage())
        }


    }

    private fun fragmentOpen(fragment : Fragment){
        supportFragmentManager.inTransaction {
            replace(R.id.fragment_container, fragment)
        }
    }
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }


}