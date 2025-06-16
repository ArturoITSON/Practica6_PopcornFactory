package garcia.sergio.popcornfactory

import java.io.Serializable

data class Pelicula (var titulo: String,
                     var image: Int,
                     var header: Int,
                     var sinopsis: String,
                     var seats: ArrayList<Cliente>
) : Serializable
