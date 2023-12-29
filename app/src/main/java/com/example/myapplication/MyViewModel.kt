package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: MainRepository) :ViewModel(){
private val _mlist=MutableLiveData<List<Result>>()
      val mList:LiveData<List<Result>> get() =_mlist



      fun getListFromServer(){
            viewModelScope.launch{
                              val data = repository.getContentList()
                if (data.isSuccessful){
                    _mlist.value = data.body()?.results

                }else{
                    //handling error
                }


            }
      }
}