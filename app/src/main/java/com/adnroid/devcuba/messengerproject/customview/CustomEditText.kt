package com.adnroid.devcuba.messengerproject.customview

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Typeface
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.TransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.adnroid.devcuba.messengerproject.R
import com.adnroid.devcuba.messengerproject.databinding.CustomEditTextBinding

class CustomEditText @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    private var binding: CustomEditTextBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_edit_text, this, true)

    init {

        orientation = VERTICAL
        attrs?.let {

            getAndroidAttributes(it)

            val typedArray = context.obtainStyledAttributes(it,
                    R.styleable.CustomEditText, 0, 0)
            val title = resources.getText(typedArray
                    .getResourceId(R.styleable
                            .CustomEditText_custom_title_field,
                            R.string.email))
            val errorText = resources.getText(typedArray
                    .getResourceId(R.styleable
                            .CustomEditText_custom_error_field,
                            R.string.default_error))
            val inputText = typedArray.getString(R.styleable.CustomEditText_custom_input_field) ?:""
            binding.customTitle.text = title
            if (errorText != resources.getString(R.string.default_error)) {
                binding.customError.text = errorText
            }
            if (inputText != resources.getString(R.string.default_input)) {
                setInputText(inputText)
            }

            typedArray.recycle()
        }
    }

    private fun getAndroidAttributes(attributeSet: AttributeSet) {
        for (i in 1..attributeSet.attributeCount) {
            when (attributeSet.getAttributeName(i-1)) {
                "inputType" -> binding.inputField.inputType = attributeSet.getAttributeIntValue(i-1, binding.inputField.inputType)
                "maxLines" -> binding.inputField.maxLines = attributeSet.getAttributeIntValue(i-1, binding.inputField.maxLines)
                "hint" -> {
                    val stringResource = attributeSet.getAttributeResourceValue(i-1, -1)
                    if (stringResource != -1) {
                        binding.inputField.hint = resources.getString(stringResource)
                    }
                }
            }
        }
    }

    var text: String
        get() = binding.inputField.text.toString()
        set(value) {
            binding.inputField.setText(value)
        }

    fun addTextChangedListener(listener: TextWatcher) =
            binding.inputField.addTextChangedListener(listener)

    fun setInputText(inputTextField: String) {
        binding.inputField.setText(inputTextField)
    }

}
