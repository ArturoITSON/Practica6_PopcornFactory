package garcia.sergio.popcornfactory

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sumary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sumary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras

        var btn : Button = findViewById(R.id.confirm2)
        var peli : TextView = findViewById(R.id.sumary_title_name)
        var seat : TextView = findViewById(R.id.sumary_seat_name)
        var pago : String = ""
        var cash: RadioButton = findViewById(R.id.pagoCash)
        var card: RadioButton = findViewById(R.id.pagoCard)


        var asiento : Int = 0
        var nombrePeli : String = ""


        if (bundle != null){
            asiento = bundle.getInt("asiento" ,0)
            nombrePeli = bundle.getString("name", "")




        }


        peli.setText(nombrePeli)
        seat.setText(asiento.toString())




        btn.setOnClickListener{




            if(cash.isChecked){
                pago = "cash"
            }
            else{
                pago = "card"
            }



          //  var cliente: Cliente = Cliente("Arturo", pago, asiento)



            Toast.makeText(this, "Enjoy the movie", Toast.LENGTH_LONG).show()

        }




    }
}