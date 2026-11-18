package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja2GruposActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView
    private var miMenu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja2_grupos)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_hoja2, menu)
        miMenu = menu
        return true
    }



    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Control de elementos Checkable (Checkboxes / Radio buttons)
            R.id.vibrate -> {
                item.isChecked = !item.isChecked
                if (item.isChecked) {
                    miMenu?.findItem(R.id.dont_vibrate)?.isChecked = false
                }
                vibrate(item.isChecked)
                true
            }
            R.id.dont_vibrate -> {
                item.isChecked = !item.isChecked
                if (item.isChecked) {
                    miMenu?.findItem(R.id.vibrate)?.isChecked = false
                }
                dontVibrate(item.isChecked)
                true
            }
            R.id.red -> {
                item.isChecked = !item.isChecked
                red()
                true
            }
            R.id.blue -> {
                item.isChecked = !item.isChecked
                blue()
                true
            }

            R.id.menu_save -> {
                Toast.makeText(this, "Guardando...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_delete -> {
                Toast.makeText(this, "Eliminando...", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun vibrate(isCheck: Boolean) {
        if (isCheck) {
            txtResultado.text = "Estado: Vibrar al notificar - ACTIVADO"
        } else {
            txtResultado.text = "Estado: Vibrar al notificar - DESACTIVADO"
        }
    }

    private fun dontVibrate(isCheck: Boolean) {
        if (isCheck) {
            txtResultado.text = "Estado: Silenciar - ACTIVADO"
        } else {
            txtResultado.text = "Estado: Silenciar - DESACTIVADO"
        }
    }
    private fun red() {
        txtResultado.text = "Seleccionaste: Rojo"
    }
    private fun blue() {
        txtResultado.text = "Seleccionaste: Azul"
    }
}