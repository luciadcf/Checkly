package com.luciadcf.checkly.feature.home.ui.home.strings

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.luciadcf.checkly.feature.home.R

enum class HomeStringKeys(@StringRes val resId: Int) {
    AppName(R.string.app_name);

    @Composable
    fun value(): String {
        return stringResource(resId)
    }
}