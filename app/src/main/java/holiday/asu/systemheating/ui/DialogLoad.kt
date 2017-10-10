package holiday.asu.systemheating.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.widget.ProgressBar
import holiday.asu.systemheating.R

class DialogLoad : DialogFragment() {

    private var mProgressBar: ProgressBar? = null
    private var startedShowing: Boolean = false
    private var mStartMillisecond: Long = 0
    private var mStopMillisecond: Long = 0

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(getActivity())
        val inflater = getActivity().getLayoutInflater()
        builder.setView(inflater.inflate(R.layout.dialog_progress, null))
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        mProgressBar = getDialog().findViewById(R.id.progress)

        if (getDialog().getWindow() != null) {
            val px: Int = (PROGRESS_CONTENT_SIZE_DP * getResources().getDisplayMetrics().density).toInt()
            getDialog().getWindow().setLayout(px, px)
            getDialog().getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun show(fm: FragmentManager, tag: String) {
        mStartMillisecond = System.currentTimeMillis()
        startedShowing = false
        mStopMillisecond = java.lang.Long.MAX_VALUE

        val handler = Handler()
        handler.postDelayed(Runnable {
            if (mStopMillisecond > System.currentTimeMillis())
                showDialogAfterDelay(fm, tag)
        }, DELAY_MILLISECOND.toLong())
    }

    private fun showDialogAfterDelay(fm: FragmentManager, tag: String) {
        startedShowing = true
        super.show(fm, tag)
    }

    fun cancel() {
        mStopMillisecond = System.currentTimeMillis()

        if (startedShowing) {
            if (mProgressBar != null) {
                cancelWhenShowing()
            } else {
                cancelWhenNotShowing()
            }
        }
    }

    private fun cancelWhenShowing() {
        if (mStopMillisecond < mStartMillisecond + DELAY_MILLISECOND + SHOW_MIN_MILLISECOND) {
            val handler = Handler()
            handler.postDelayed(Runnable { dismissAllowingStateLoss() }, SHOW_MIN_MILLISECOND.toLong())
        } else {
            dismissAllowingStateLoss()
        }
    }

    private fun cancelWhenNotShowing() {
        val handler = Handler()
        handler.postDelayed(Runnable { dismissAllowingStateLoss() }, DELAY_MILLISECOND.toLong())
    }

    companion object {
        private val DELAY_MILLISECOND: Int = 450
        private val SHOW_MIN_MILLISECOND: Int = 300
        private val PROGRESS_CONTENT_SIZE_DP: Int = 80
    }
}