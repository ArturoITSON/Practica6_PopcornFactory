package garcia.sergio.popcornfactory

import java.io.Serializable

data class Cliente (var nombre: String,
                    var tipoPago: String,
                    var asiento: Int
) : Serializable