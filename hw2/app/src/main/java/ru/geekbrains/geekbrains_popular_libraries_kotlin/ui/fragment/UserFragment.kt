package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentUserBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.GithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.UserView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackClickListener

class UserFragment : MvpAppCompatFragment(), UserView, BackClickListener {

    companion object {
        fun newInstance() = UserFragment()
    }

    private val presenter by moxyPresenter {
        UserPresenter(GithubUsersRepo(), App.instance.router)
    }

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.tvUser?.text = "hey"
    }

    override fun backPressed() = presenter.backClick()

}