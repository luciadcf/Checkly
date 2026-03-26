package com.luciadcf.checkly.feature.home.ui.home

interface HomeScreenStatus

class LoadingStatus : HomeScreenStatus

class SuccessStatus : HomeScreenStatus

class ErrorStatus(val error: String? = null) : HomeScreenStatus