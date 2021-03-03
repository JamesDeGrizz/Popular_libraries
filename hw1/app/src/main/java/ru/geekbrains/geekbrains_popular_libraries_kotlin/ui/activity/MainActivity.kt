package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ActivityMainBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null

    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listenerFirstButton = View.OnClickListener {
            presenter.firstButtonClicked()
        }
        val listenerSecondButton = View.OnClickListener {
            presenter.secondButtonClicked()
        }
        val listenerThirdButton = View.OnClickListener {
            presenter.thirdButtonClicked()
        }

        vb?.btnCounter1?.setOnClickListener(listenerFirstButton)
        vb?.btnCounter2?.setOnClickListener(listenerSecondButton)
        vb?.btnCounter3?.setOnClickListener(listenerThirdButton)
    }

    override fun setFirstButtonText(text: String) {
        vb?.btnCounter1?.text = text
    }
    override fun setSecondButtonText(text: String) {
        vb?.btnCounter2?.text = text
    }
    override fun setThirdButtonText(text: String) {
        vb?.btnCounter3?.text = text
    }
}