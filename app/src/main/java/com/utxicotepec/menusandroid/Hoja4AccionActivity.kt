package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView
    private var actionMode: ActionMode? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))

        txtResultado = findViewById(R.id.txtResultado)

        setSupportActionBar(findViewById(R.id.toolbar))
        txtResultado = findViewById(R.id.txtResultado)


        txtResultado.setOnLongClickListener { view ->
            when (actionMode) {
                null -> {
                    // Iniciamos el modo de acción usando el Callback de la ZONA B
                    // Si usas 'ActionMode' de AppCompat usa: startSupportActionMode(actionModeCallback)
                    actionMode = startActionMode(actionModeCallback)
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }

        // ZONA A: aquí van las instrucciones del tutorial que van dentro de onCreate
    }

    // ZONA B: aquí van las funciones del tutorial que van FUERA de onCreate
    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.menu_hoja4, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.share -> {
                    shareCurrentItem()
                    mode.finish()
                    true
                }
                R.id.edit -> {
                    editCurrentItem()
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }

    private fun shareCurrentItem() {
        txtResultado.text = "Acción: Compartir"
    }
    private fun editCurrentItem() {
        txtResultado.text = "Acción: Editar"
    }
}