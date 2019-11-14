package app.example.marvelquiz

import android.os.CountDownTimer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fortnitequiz.R
import kotlinx.android.synthetic.main.activity_jugar.*

class Jugar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugar)

        Log.d("pantallajugar", "1")

        var puntos: TextView = findViewById(R.id.Puntos)
        var contador: TextView = findViewById(R.id.Cuenta)
        var vidas: TextView = findViewById(R.id.vidas)
        val txtcorrecto: TextView = findViewById(R.id.txtcorrecto)
        val txtincorrecto: TextView = findViewById(R.id.txtincorrecto)
        var imagen: ImageView = findViewById(R.id.imagen)
        var txtedit: EditText = findViewById(R.id.txtedit)
        val btnconfirmar: Button = findViewById(R.id.btnconfirmar)
        var nombre_pers = arrayOf("quick silver", "black widow", "carnage", "daredevil", "deadpool", "destroyer", "doom", "falcon", "galactus", "gambit", "ghost rider", "groot", "iron man", "magneto", "mysterio", "punisher", "red hulk", "she hulk", "spider man", "storm", "thanos", "thor", "ultron", "venom", "vision", "wolverine", "apocalypse")
        var nombre_pers2 = arrayOf("quicksilver", "blackwidow", "carnage", "daredevil", "dead pool", "destroyer", "doom", "falcon", "galactus", "gambit", "ghostrider", "groot", "ironman", "magneto", "mysterio", "punisher", "red hulk", "she hulk", "spiderman", "storm", "thanos", "thor", "ultron", "venom", "vision", "wolverine", "apocalypse")
        var imagen_pers = arrayOf("img1", "img2", "img3", "img4", "img5", "img6", "img7", "img8", "img9", "img10", "img11", "img12", "img13", "img14", "img15", "img16", "img17", "img18", "img19", "img20", "img21", "img22", "img23", "img24", "img25", "img26", "img27")
        var intpunto = 0
        var intvidas = 3
        var numerogenerado = 0


        establecer_imagen(numerogenerado,imagen_pers, imagen)

        btnconfirmar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val textoconfirmar = txtedit.getText().toString().toLowerCase()
                if (textoconfirmar.equals(nombre_pers[numerogenerado]) or textoconfirmar.equals(nombre_pers2[numerogenerado])) {
                    txtcorrecto.setVisibility(View.VISIBLE)
                    intpunto = intpunto + 1
                    puntos.setText("Puntos: $intpunto")
                    esperar1(contador,imagen_pers, imagen)
                } else {
                    txtincorrecto.setVisibility(View.VISIBLE)
                    intvidas = intvidas - 1
                    vidas.setText("Vidas: $intvidas")
                    esperar2()
                }
                if (intvidas == 0) {
                    finish()
                }
            }
        })
    }

     fun esperar2() {
        object : CountDownTimer(2000, 1) {
            override fun onTick(millisUntilFinished: Long) {
                btnconfirmar.setVisibility(View.GONE)
            }

            override fun onFinish() {
                btnconfirmar.setVisibility(View.VISIBLE)
                txtincorrecto.setVisibility(View.INVISIBLE)
                txtedit.setText("")
                txtedit.setHint("Ingrese el personaje")
            }
        }.start()
    }

     fun esperar1(contador:TextView,imagen_perso:Array<String>,imagen:ImageView) {

        object : CountDownTimer(4000, 1) {
            override fun onTick(millisUntilFinished: Long) {
                contador.setText("" + (millisUntilFinished / 1000 + 1))
                btnconfirmar.setVisibility(View.GONE)
            }

            override fun onFinish() {
                var numerogenerado = 0
                btnconfirmar.setVisibility(View.VISIBLE)
                numerogenerado = numerogenerado + 1
                contador.setText("")
                establecer_imagen(numerogenerado, imagen_perso,imagen)
                txtcorrecto.setVisibility(View.INVISIBLE)
                txtedit.setText("")
                txtedit.setHint("Ingrese el personaje")
            }
        }.start()
    }

     fun establecer_imagen(numero: Int,imagen_pers: Array<String>,imagen:ImageView) {

        val id = getResources().getIdentifier(imagen_pers[numero], "mipmap", getPackageName())
        imagen.setImageResource(id)
    }
}
