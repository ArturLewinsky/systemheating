package holiday.asu.systemheating.ui.Autor.Activity

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import holiday.asu.systemheating.R

class AutorActivity : LifecycleActivity() {

    @BindView(R.id.toolbar_autor)
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autor)
        AndroidInjection.inject(this)
        ButterKnife.bind(AutorActivity@ this)
        mToolbar.setTitle("SystemOfHeating")
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        mToolbar.setNavigationOnClickListener { view ->
            onBackPressed()
        }
    }
}




