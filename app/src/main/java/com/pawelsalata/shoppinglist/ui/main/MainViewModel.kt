package com.pawelsalata.shoppinglist.ui.main

import com.pawelsalata.shoppinglist.data.DataManager
import com.pawelsalata.shoppinglist.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by LETTUCE on 29.12.2017.
 */
class MainViewModel @Inject constructor(dataManager: DataManager) :
        BaseViewModel<MainActivityNavigator>(dataManager) {


}