package com.adnroid.devcuba.messengerproject.customview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods
import android.text.Editable
import android.text.TextWatcher


class CustomEditTextViewModel : ViewModel() {
    val inputText = MutableLiveData<String>()

}

@InverseBindingMethods(
        InverseBindingMethod(
                type = CustomEditText::class,
                attribute = "android:text",
                method = "getText"
        )
)
object CustomEditTextBinder {
    @JvmStatic
    @BindingAdapter(value = ["android:textAttrChanged"])
    fun setListener(editText: CustomEditText, listener: InverseBindingListener?) {
        if (listener != null) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun afterTextChanged(editable: Editable) {
                    listener.onChange()
                }
            })
        }
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun setText(editText: CustomEditText, text: String) {
        if (text != editText.text) {
            editText.text = (text)
        }
    }
}