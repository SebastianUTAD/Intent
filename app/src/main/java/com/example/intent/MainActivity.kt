package com.example.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun agregarContacto(view: View) {
        val bxNombre: EditText = findViewById(R.id.bxNombre)
        val bxMail: EditText = findViewById(R.id.bxMail)
        val bxNumero: EditText = findViewById(R.id.bxNumero)

        val nombre: String = bxNombre.text.toString()
        val email: String = bxMail.text.toString()
        val telefono = bxNumero.text.toString()
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, nombre)
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, telefono)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Contacto Agregado", Toast.LENGTH_SHORT).show()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Contacto Cancelado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}