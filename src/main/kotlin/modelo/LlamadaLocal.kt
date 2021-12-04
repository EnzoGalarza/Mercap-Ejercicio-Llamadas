package modelo

import java.time.LocalDateTime

class LlamadaLocal(duracion: Int, fecha : LocalDateTime, ubicacion: Ubicacion) : Llamada(duracion,fecha,ubicacion){
    val diasNoHabiles = listOf("SATURDAY","SUNDAY")

    override fun costoPorTipo(): Double {
        var costo = 0.10

        if(esDiaHabil() && esHorarioHabil()){
            costo = 0.20
        }
        return costo
    }

    private fun esDiaHabil() : Boolean{
        return !diasNoHabiles.contains(fecha.dayOfWeek.name)
    }

    private fun esHorarioHabil() : Boolean{
        return fecha.hour in 8..20
    }
}
