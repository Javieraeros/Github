package es.fjruiz.github.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.fjruiz.domain.bo.User
import es.fjruiz.domain.bo.UserDetail
import es.fjruiz.domain.repository.UserRepository
import es.fjruiz.github.vo.Resource
import es.fjruiz.github.vo.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    //region Static
    companion object {
        val TAG = UserDetailViewModel::class.java.simpleName
    }
    //endregion

    //region Constants

    //endregion

    //region Inject

    //endregion

    //region Bind

    //endregion

    //region Fields
    private val userLiveData: MutableLiveData<Resource<UserDetail>> = MutableLiveData()
    //endregion

    //region Constructors & Initialization

    //endregion

    //region Methods for/from SuperClass/Interfaces

    //endregion

    //region Methods
    fun loadUser(user: User): MutableLiveData<Resource<UserDetail>> {
        viewModelScope.launch {
            val userDetail = userRepository.getUserRepos(user)
            userLiveData.postValue(Resource(Status.LOADING, null, ""))
            if (!userDetail.repos.isNullOrEmpty()) {
                userLiveData.postValue(Resource(Status.SUCCESS, userDetail, ""))
            } else {
                userLiveData.postValue(Resource(Status.ERROR, null, "No se han encontrado repositorios"))
            }
        }
        return userLiveData
    }
    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion

}
