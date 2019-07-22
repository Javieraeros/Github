package es.fjruiz.github.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.fjruiz.domain.bo.User
import es.fjruiz.github.R
import kotlinx.android.synthetic.main.row_organization.view.*

class OrganizationAdapter(private val organizationListener: OrganizationListener) : RecyclerView.Adapter<OrganizationAdapter.OrganizationViewHolder>() {

    //region Static
    companion object {
        val TAG = OrganizationAdapter::class.java.simpleName
    }
    //endregion

    //region Fields
    private val userList: ArrayList<User> = ArrayList()
    //endregion

    //region Constructors & Initialization

    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        return OrganizationViewHolder(parent)
    }

    override fun getItemCount(): Int =
        userList.size

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        holder.paintUsers(userList[position], organizationListener)
    }
    //endregion

    //region Methods

    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes
    inner class OrganizationViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row_organization, parent, false
        )
    ) {
        fun paintUsers(user: User, listener: OrganizationListener) {
            itemView.apply {
                Glide.with(this).load(user.image).into(imageViewAvatar)
                textViewNickname.text = user.nickName
                textViewName.text = user.name
                setOnClickListener {
                    listener.onUserClick(user)
                }
            }

        }
    }

    interface OrganizationListener {
        fun onUserClick(user: User)
    }
    //endregion

    //region Getter & Setter
    fun setUsers(list: List<User>) {
        this.userList.clear()
        this.userList.addAll(list)
        notifyDataSetChanged()
    }
    //endregion


}