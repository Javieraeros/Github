package es.fjruiz.github.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.fjruiz.domain.bo.Repository
import es.fjruiz.github.R
import kotlinx.android.synthetic.main.row_repository.view.*

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.UserViewHolder>() {

    //region Static
    companion object {
        val TAG = OrganizationAdapter::class.java.simpleName
    }
    //endregion

    //region Fields
    private val repositorys: ArrayList<Repository> = ArrayList()
    //endregion

    //region Constructors & Initialization

    //endregion

    //region Methods for/from SuperClass/Interfaces
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent)
    }

    override fun getItemCount(): Int =
        repositorys.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.paintRepos(repositorys[position])
    }
    //endregion

    //region Methods

    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes
    // TODO: 22/07/19 Create two viewholder!

    inner class UserViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.row_repository, parent, false
        )
    ) {
        fun paintRepos(repository: Repository) {
            itemView.apply {
                textViewStar.text = repository.stars.toString()
                textViewLanguage.text = repository.language ?: "Multiple"
                textViewFork.text = repository.forksCount.toString()
                if (repository.fork) {
                    setBackgroundColor(itemView.resources.getColor(R.color.primaryLightColor))
                } else {
                    setBackgroundColor(itemView.resources.getColor(R.color.white))
                }
                textViewRepoName.text = repository.name
                textViewRepoDes.text = repository.description
            }
        }
    }

    //endregion

    //region Getter & Setter
    fun setRepos(list: List<Repository>) {
        this.repositorys.clear()
        this.repositorys.addAll(list)
        notifyDataSetChanged()
    }
    //endregion


}