package modelo

import java.time.LocalDateTime

abstract class Llamada(val duracion: Int, val fecha: LocalDateTime, val ubicacion: Ubicacion) {

    fun costoLlamada(): Double {
        return duracion * costoPorTipo()
    }

    abstract fun costoPorTipo() : Double

}
