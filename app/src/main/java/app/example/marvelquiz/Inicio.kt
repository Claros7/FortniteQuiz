package app.example.marvelquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelquiz.R

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnjugar: Button= findViewById(R.id.btnjugar)
        val btnrespuestas: Button= findViewById(R.id.respuestas)
        val btnacerca: Button=findViewById(R.id.acerca)


        btnjugar.setOnClickListener {
            val pagina2 = Intent(this@Inicio, Jugar::class.java)
            startActivity(pagina2)
        }
        btnrespuestas.setOnClickListener {
            val pagina3 = Intent(this@Inicio, Respuestas::class.java)
            startActivity(pagina3)
        }
        btnacerca.setOnClickListener {
            val pagina4 = Intent(this@Inicio, Acerca::class.java)
            startActivity(pagina4)
        }
    }
}
