package app.example.marvelquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.fortnitequiz.R

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnjugar: Button= findViewById(R.id.btnjugar)
        val btnrespuestas: Button= findViewById(R.id.respuestas)
        val btnacerca: Button=findViewById(R.id.acerca)


        btnjugar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {

                val pagina2 = Intent(this@Inicio, Jugar::class.java)
                startActivity(pagina2)
            }
        })
        btnrespuestas.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val pagina3 = Intent(this@Inicio, Respuestas::class.java)
                startActivity(pagina3)
            }
        })
        btnacerca.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val pagina4 = Intent(this@Inicio, Acerca::class.java)
                startActivity(pagina4)
            }
        })
    }
}
