package modelo

import java.time.LocalDateTime

open class Llamada(val duracion: Int, val fecha: LocalDateTime, val ubicacion: Ubicacion) {

    fun costoLlamada(): Double {
        val esDiaHabil = fecha.dayOfWeek.name == "MONDAY"
        val esHorarioHabil = fecha.hour in 8..20
        var costoLlamada = 0.10

        if(esDiaHabil && esHorarioHabil){
            costoLlamada = 0.20
        }

        return duracion * costoLlamada
    }

}
