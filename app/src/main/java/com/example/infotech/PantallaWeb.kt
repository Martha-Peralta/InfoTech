package com.example.infotech

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaWeb : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_web)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(findViewById(R.id.toolbar))
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white)) // Cambia el color a blanco

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navegacion)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    val intent = Intent(this, Inicio::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_web -> {
                    val intent = Intent(this, PantallaWeb::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_movil -> {
                    val intent = Intent(this, PantallaMovil::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_back -> {
                    val intent = Intent(this, PantallaBackend::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val list_config : ListView = findViewById(R.id.listview_id)

        // Obtener el array de strings desde los recursos
        val arraySettings = resources.getStringArray(R.array.ArrayWeb)

        // Crear un ArrayAdapter para enlazar los datos del array con el ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraySettings)

        // Establecer el adapter en el ListView
        list_config.adapter = adapter
    }
}