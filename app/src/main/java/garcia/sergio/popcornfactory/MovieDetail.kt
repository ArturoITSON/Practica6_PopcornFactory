package garcia.sergio.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var titulo: String = getIntent().getStringExtra("titulo") as String
        var image: Int = getIntent().getIntExtra("imagen", 0) as Int
        var sinopsis: String = getIntent().getStringExtra("sinopsis") as String

        var imagen : ImageView = findViewById(R.id.image_movie_only)
        var title : TextView = findViewById(R.id.movie_tittle_only)
        var sinops: TextView = findViewById(R.id.movie_description_only)


        imagen.setImageResource(image.toInt())
        title.setText(titulo)
        sinops.setText(sinopsis)






    }



}