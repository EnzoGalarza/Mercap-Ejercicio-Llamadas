package modelo

import java.time.LocalDateTime
import java.time.Month

class Factura(val cliente : Persona, var abonoMensual : Double, val mesDeFacturacion : Month, val añoDeFacturacion : Int) {
    val llamadasDelMes = cliente.llamadas.filter { fechaCorrespondiente(it.fecha) }

    private fun fechaCorrespondiente(fecha : LocalDateTime) : Boolean{
        return fecha.year == añoDeFacturacion && fecha.month == mesDeFacturacion
    }

    fun facturar(): Double {
        var montoTotal = abonoMensual
        llamadasDelMes.forEach {
            montoTotal+= it.costoLlamada()
        }
        return montoTotal
    }
}