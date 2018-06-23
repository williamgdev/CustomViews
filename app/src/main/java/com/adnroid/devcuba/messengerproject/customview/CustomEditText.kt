package com.adnroid.devcuba.messengerproject.customview

import android.content.Context
import android.databinding.DataBindingUtil
import android.text.TextWatcher
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
        attrs.let {
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
    fun getText(): String = binding.inputField.text.toString()

    fun setText(text: String) = binding.inputField.setText(text)

    /**
     * The code bellow is replaced by the '=' in the xml layout
     * Just write instead of
     * @{viewModel.inputText} do
     * @={viewModel.inputText}
     */
//    fun addTextChangedListener(listener: TextWatcher) =
//            binding.inputField.addTextChangedListener(listener)

    fun setInputText(inputTextField: String) {
        binding.inputField.setText(inputTextField)
    }

}
