package holiday.asu.systemheating.ui.NavigationBottom.Activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.view.MenuItem

import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.MainNavigationFragment
import holiday.asu.systemheating.ui.NavigationBottom.Fragments.OptionNavigationFragment
import holiday.asu.systemheating.model.ViewPagerAdapter

class NavigationActivity :  AppCompatActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener,
        NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.viewpager)
    lateinit var mViewPager: ViewPager

    @BindView(R.id.bottom_navigation)
    lateinit var mBottomNavigationView: BottomNavigationView

    @BindView(R.id.drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout

    @BindView(R.id.nav_view)
    lateinit var mNavigationView: NavigationView

    @BindView(R.id.toolbar_navi)
    lateinit var mToolbar: Toolbar

    lateinit var mMainNavigationFragment: MainNavigationFragment
    lateinit var mOptionNavigationFragment: OptionNavigationFragment

    var mMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        AndroidInjection.inject(this)
        ButterKnife.bind(NavigationActivity@this)
        mBottomNavigationView.setOnNavigationItemSelectedListener(this)
        mViewPager.addOnPageChangeListener(this)
        setupViewPager(mViewPager)

        setSupportActionBar(mToolbar)
        val toggle = ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        mNavigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> mViewPager.setCurrentItem(0)
            R.id.navigation_dashboard -> mViewPager.setCurrentItem(1)
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    override fun onPageSelected(position: Int) {
        if (mMenuItem != null)
            mMenuItem!!.setChecked(false)
        else
            mBottomNavigationView.getMenu().getItem(0).setChecked(false);

        mBottomNavigationView.getMenu().getItem(position).setChecked(true)
        mMenuItem = mBottomNavigationView.getMenu().getItem(position)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        mMainNavigationFragment = MainNavigationFragment()
        mOptionNavigationFragment = OptionNavigationFragment()
        adapter.addFragment(mMainNavigationFragment)
        adapter.addFragment(mOptionNavigationFragment)
        viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}