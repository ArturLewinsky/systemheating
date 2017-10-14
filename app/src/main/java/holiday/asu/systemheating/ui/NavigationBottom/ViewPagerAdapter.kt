package holiday.asu.systemheating.ui.NavigationBottom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter : FragmentPagerAdapter {

    private var mFragmentList: ArrayList<Fragment>

    constructor(manager: FragmentManager): super(manager) {
        mFragmentList = ArrayList()
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }
}
