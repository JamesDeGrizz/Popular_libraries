package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.CountersModel
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainPresenter(val mainView: MainView) {
    val model = CountersModel()

    fun firstButtonClicked() {
        mainView.setFirstButtonText(model.next(0).toString())
    }

    fun secondButtonClicked() {
        mainView.setSecondButtonText(model.next(1).toString())
    }

    fun thirdButtonClicked() {
        mainView.setThirdButtonText(model.next(2).toString())
    }
}