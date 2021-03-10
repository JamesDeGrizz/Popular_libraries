package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list

interface IUserPresenter<V> {
    fun bindView(view: V)
}