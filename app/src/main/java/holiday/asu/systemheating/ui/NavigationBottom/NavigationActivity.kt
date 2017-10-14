package holiday.asu.systemheating.ui.NavigationBottom

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector


class NavigationActivity : LifecycleActivity(),
        BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener,
        HasSupportFragmentInjector {

    @BindView(R.id.viewpager)
    lateinit var mViewPager: ViewPager

    @BindView(R.id.bottom_navigation)
    lateinit var mBottomNavigationView: BottomNavigationView

    lateinit var mMainNavigationFragment: MainNavigationFragment
    lateinit var mOptionNavigationFragment: OptionNavigationFragment

    var mMenuItem: MenuItem? = null

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        AndroidInjection.inject(this)
        ButterKnife.bind(NavigationActivity@this)
        mBottomNavigationView.setOnNavigationItemSelectedListener(this)
        mViewPager.addOnPageChangeListener(this)
        setupViewPager(mViewPager)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> mViewPager.setCurrentItem(0)
            R.id.navigation_dashboard -> mViewPager.setCurrentItem(1)
        }
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

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}