package modelo

import java.time.LocalDateTime

abstract class LlamadaLargaDistancia(duracion : Int, fechaLlamada : LocalDateTime,ubicacion: Ubicacion) : Llamada(duracion,fechaLlamada,ubicacion) {

    override fun costoPorTipo(): Double {
        return ubicacion.costoPorDistancia
    }
}
