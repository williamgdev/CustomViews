package com.adnroid.devcuba.messengerproject.customview

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.databinding.InverseBindingListener
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.custom_edit_text.view.*


class CustomEditTextViewModel : ViewModel() {
    val inputText = MutableLiveData<String>()


}

@InverseBindingMethods(
        InverseBindingMethod(
                type = CustomEditText::class,
                attribute = "android:text",
//                event = "android:textAttrChanged",
                method = "getText"
        )
)
object CustomEditTextBinder {
    @JvmStatic
    @BindingAdapter(value = ["android:textAttrChanged"])
    fun setListener(editText: CustomEditText, listener: InverseBindingListener?) {
        if (listener != null) {
            editText.inputField.addTextChangedListener(object : TextWatcher {
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
        if (text != editText.getText()) {
            editText.setText(text)
        }
    }

    @BindingAdapter("custom_input_field")
    @JvmStatic
    fun getInputText(customEditText: CustomEditText, inputTextField: String?) {
        inputTextField?.let {
            if (inputTextField != customEditText.getText()) {
                customEditText.setInputText(it)
            }
        }
    }
}