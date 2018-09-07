package br.com.veronezitecnologia.demofragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btPrimeiro.setOnClickListener {

            val primeiroFragment = PrimeiroFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragment 1")
            primeiroFragment.arguments = bundle

            trocaFragment(primeiroFragment)
        }

        btSegundo.setOnClickListener {
            val segundoFragment = SegundoFragment()
            val bundle = Bundle()
            bundle.putString("mensagem", "Sou o fragment 2")
            segundoFragment.arguments = bundle

            trocaFragment(segundoFragment)
        }
    }

    private fun trocaFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.contentFragment, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}
