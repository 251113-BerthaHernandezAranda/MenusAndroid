package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
        registerForContextMenu(txtResultado)
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_hoja3, menu)
    }


    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // Al usar 'as?' evitamos que la aplicación falle si no proviene de una lista
        val info = item.menuInfo as? AdapterView.AdapterContextMenuInfo
        val idSeleccionado = info?.id ?: -1L

        return when (item.itemId) {
            R.id.edit -> {
                editNote(idSeleccionado)
                true
            }
            R.id.delete -> {
                deleteNote(idSeleccionado)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun editNote(id: Long) {
        txtResultado.text = "Acción: Editar (ID del elemento: $id)"
    }

    private fun deleteNote(id: Long) {
        txtResultado.text = "Acción: Eliminar (ID del elemento: $id)"
    }
}