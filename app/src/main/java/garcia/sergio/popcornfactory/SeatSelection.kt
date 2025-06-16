package garcia.sergio.popcornfactory

import android.content.Intent
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

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val row1: RadioGroup = findViewById(R.id.rowl1)
        val row2: RadioGroup = findViewById(R.id.rowl2)
        val row3: RadioGroup = findViewById(R.id.rowl3)
        val row4: RadioGroup = findViewById(R.id.rowl4)

        var selectedRadioButtonId: Int = -1

        row1.setOnCheckedChangeListener{group, checkId ->

            if(checkId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkId)

                selectedRadioButtonId = checkId
            }

        }

        row2.setOnCheckedChangeListener{group, checkId ->

            if(checkId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkId)

                selectedRadioButtonId = checkId
            }

        }

        row3.setOnCheckedChangeListener{group, checkId ->

            if(checkId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkId)

                selectedRadioButtonId = checkId
            }

        }

        row4.setOnCheckedChangeListener{group, checkId ->

            if(checkId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkId)

                selectedRadioButtonId = checkId
            }

        }




        val title: TextView = findViewById(R.id.titleSeat)
        var posMovie = -1


        val bundle = intent.extras


        if(bundle != null){

            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("movie")


        }


        val confirm : Button = findViewById(R.id.confirm)

        confirm.setOnClickListener{



            //TODO añadir logica para reservar el lugar selecccionado por el usuario
            //Hacer una nueva actividad donde se vea un resumen de la compra, es decir que se agregue el nombre del cliente, se agrugue el asiento que se seleccione

            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedText = selectedRadioButton.text.toString()




            val intent: Intent = Intent(this,Sumary::class.java)

            intent.putExtra("name", bundle?.getString("name"))
            intent.putExtra("asiento", selectedText.toInt())





            this.startActivity(intent)



        }


    }
}