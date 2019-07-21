package es.fjruiz.github.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.fjruiz.domain.bo.User
import es.fjruiz.domain.repository.UserRepository
import es.fjruiz.github.vo.Resource
import es.fjruiz.github.vo.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    //region Static
    companion object {
        val TAG = UserViewModel::class.java.simpleName
    }
    //endregion

    //region Inject

    //endregion

    //region Bind

    //endregion

    //region Fields
    private val userLiveData: MutableLiveData<Resource<List<User>>> = MutableLiveData()
    //endregion

    //region Methods for/from SuperClass/Interfaces

    //endregion

    //region Methods
    fun loadUsers() {
        viewModelScope.launch {
            val users = userRepository.getUsers()
            userLiveData.postValue(Resource(Status.LOADING, null, ""))
            if (users.isNotEmpty()) {
                userLiveData.postValue(Resource(Status.SUCCESS, users, ""))
            } else {
                userLiveData.postValue(Resource(Status.ERROR, null, "No se han encontrado usuarios"))
            }
        }
    }
    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion

}