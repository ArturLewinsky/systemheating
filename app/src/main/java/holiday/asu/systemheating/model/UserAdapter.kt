package holiday.asu.systemheating.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import holiday.asu.systemheating.R


open class UserAdapter : RecyclerView.Adapter<UserAdapter.Holder> {


    private val mInflater : LayoutInflater
    private var mUsersList : ArrayList<UserModel>
    private var mListener : UserClickListener

    constructor(mListener : UserClickListener, inflater : LayoutInflater) {
        this.mInflater = inflater
        this.mUsersList = ArrayList<UserModel>()
        this.mListener = mListener
    }


    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int): Holder {
        return Holder(mInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: Holder , position: Int ) {
        val currUser = mUsersList.get(position)

        holder.mName.setText(currUser.name)
        holder.mSurrname.setText(currUser.surrname)
        holder.mTitle.setText(currUser.title)
        if(currUser.favorite.equals(true))
            holder.mFavorite.isChecked = true
    }

    fun addUsers(usersModel: List<UserModel>) {
        mUsersList.addAll(usersModel)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mUsersList.size
    }

    inner class Holder : RecyclerView.ViewHolder, View.OnClickListener {


        var mName: TextView
        var mSurrname: TextView
        var mTitle: TextView
        var mFavorite: CheckBox

        constructor(itemView : View) : super(itemView) {

            mName = itemView.findViewById<View>(R.id.name) as TextView
            mSurrname = itemView.findViewById<View>(R.id.surrname) as TextView
            mTitle = itemView.findViewById<View>(R.id.title) as TextView
            mFavorite = itemView.findViewById<View>(R.id.favorite) as CheckBox
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mListener.onClick(getLayoutPosition(), mUsersList.get(getAdapterPosition()).toString())

        }
    }

    interface UserClickListener {
        fun onClick(position: Int, name: String)
    }
}