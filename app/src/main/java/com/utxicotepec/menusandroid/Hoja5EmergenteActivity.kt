package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja5EmergenteActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja5_emergente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        findViewById<ImageButton>(R.id.dropdown_menu).setOnClickListener { view ->
            showMenu(view) // Llama a la función de la ZONA B
        }
    }

    // ZONA B: AQUÍ VAN LAS DOS NUEVAS FUNCIONES

    fun showMenu(v: View) {
        PopupMenu(this, v).apply {
            // 2. CORREGIDO: Se cambia @MainActivity por @Hoja5EmergenteActivity
            setOnMenuItemClickListener(this@Hoja5EmergenteActivity)

            // 3. NOTA: Recuerda cambiar R.menu.actions por R.menu.menu_hoja5 si no tienes el archivo 'actions'
            inflate(R.menu.menu_hoja5)
            show()
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            // 4. NOTA: Asegúrate de cambiar estos IDs (R.id.archive) por los que declaraste dentro de tu XML de menú
            R.id.archive -> {
                archive(item)
                true
            }
            R.id.delete -> {
                delete(item)
                true
            }
            else -> false
        }
    }

    // Funciones auxiliares para que no marquen error en el 'when'
    private fun archive(item: MenuItem) {
        txtResultado.text = "Acción: Archivar"
    }

    private fun delete(item: MenuItem) {
        txtResultado.text = "Acción: Eliminar"
    }
}