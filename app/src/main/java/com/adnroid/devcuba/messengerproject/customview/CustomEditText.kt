package com.adnroid.devcuba.messengerproject.customview

import android.content.Context
import android.databinding.DataBindingUtil
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

    private var binding: CustomEditTextBinding

    init {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_edit_text, this, true)

        orientation = VERTICAL
        attrs.let {
            binding.customTitle.text = "Text"
        }
    }
}
