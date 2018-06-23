package com.adnroid.devcuba.messengerproject.customview

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter


class CustomEditTextViewModel: ViewModel() {
    val inputText = MutableLiveData<String>()

    companion object {
        @BindingAdapter("custom_input_field")
        @JvmStatic
        fun getInputText(customEditText: CustomEditText, inputTextField: String?) {
            inputTextField?.let {
                customEditText.setInputText(it)
            }
        }
    }

}