package holiday.asu.systemheating.ui.NavigationBottom.Fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.AndroidSupportInjection
import holiday.asu.systemheating.R
import holiday.asu.systemheating.service.WebSocketClass
import okhttp3.OkHttpClient
import okhttp3.Request
import android.widget.Toast
import holiday.asu.systemheating.model.Temp
import android.arch.lifecycle.Observer
import android.util.Log
import holiday.asu.systemheating.core.factory.TempViewModel
import holiday.asu.systemheating.core.factory.ViewTempModelFactory
import holiday.asu.systemheating.service.UserService
import holiday.asu.systemheating.utilly.BaseFragment
import holiday.asu.systemheating.utilly.DialogLoad
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class OptionNavigationFragment : BaseFragment<TempViewModel>() {

    @Inject
    lateinit var mServiceApi: UserService

    @BindView(R.id.option_button)
    lateinit var mOptionButton: Button

    @BindView(R.id.option_edit)
    lateinit var mOptionEdit: EditText

    @BindView(R.id.option_tempset)
    lateinit var mTextSet: TextView

    private lateinit var client: OkHttpClient

    @Inject
    lateinit var mViewTempModelFactory: ViewTempModelFactory

    val progressDialog = DialogLoad()

    lateinit var mTemp: ArrayList<Temp>

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    var mLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        initViewModel()

        this.mTemp = ArrayList<Temp>()

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.fragment_option_navigation, container, false)!!
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mOptionButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                if(!mOptionEdit.text.toString().equals("")) {
                    var temp: Temp = Temp(mOptionEdit.text.toString().toFloat())
                    temp.id = 1
                    compositeDisposable.add(
                            mServiceApi.putTemp(temp)
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.io())
                                    .doOnSubscribe({ progressDialog.show(childFragmentManager, "tag") })
                                    .doAfterTerminate({ progressDialog.cancel() })
                                    .subscribe({result ->
                                        Log.d("Result", "")}, { error -> error.printStackTrace() } )
                    )

                    val request = Request.Builder().url("ws://agile-savannah-63688.herokuapp.com/asu").build()
                    val listener = WebSocketClass(mOptionEdit.text.toString())
                    client = OkHttpClient()
                    mTextSet.text = mOptionEdit.text.toString()
                    client.newWebSocket(request, listener)
                    client.dispatcher().executorService().shutdown()
                }
                else {
                    Toast.makeText(context, "Value of temperature is not correct", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
    private fun initViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewTempModelFactory).get(TempViewModel::class.java)
        observeLoadingStatus()
        observeResponse()
    }

    private fun observeResponse() {
        mViewModel.getData().observe(this, Observer<List<Temp>> { response -> processResponse(response) })
    }

    private fun observeLoadingStatus() {
        mViewModel.getLoadingStatus().observe(this, Observer{ loading -> isLoading(loading) })
    }

    private fun processResponse(response: List<Temp>?) {
        this.mTemp = response as ArrayList<Temp>
        mTextSet.text = mTemp!!.get(0).temp.toString()
    }

    private fun isLoading(loading: Boolean?) {
        if (loading!!)
            progressDialog.show(childFragmentManager, "tag")
        else
            progressDialog.cancel()
    }
}