import modelo.*
import java.time.LocalDateTime
import java.time.Month

fun main(){
        val fechaLlamada1 = LocalDateTime.of(2021,10,15,17,0)
        val fechaLlamada2 = LocalDateTime.of(2021,10,17,19,0)
        val fechaLlamadaLocal = LocalDateTime.of(2021,11,18,9,0)
        val llamadaNacional = LlamadaNacional(10,fechaLlamada1,Ubicacion("Argentina","Wilde",0.6))
        val llamadaInternacional = LlamadaInternacional(5,fechaLlamada2,Ubicacion("Brasil","Sao Paulo",1.0))
        val llamadaLocal = LlamadaLocal(15,fechaLlamadaLocal,Ubicacion("Argentina","Quilmes"))
        val cliente = Persona("Jorge")
        cliente.agregarLlamada(llamadaNacional)
        cliente.agregarLlamada(llamadaInternacional)
        cliente.agregarLlamada(llamadaLocal)

        val factura = Factura(cliente, 250.0,Month.OCTOBER,2021)

        println("Factura")
        println("Nombre cliente: ${factura.cliente.nombre}")
        println("Mes de facturacion: ${factura.mesDeFacturacion}")
        println("Año facturacion: ${factura.añoDeFacturacion}")
        println("Llamadas del mes: ${factura.llamadasDelMes.map { "${it.javaClass.simpleName}( duracion : ${it.duracion}m, " +
                "costo: $${it.costoLlamada()})" }}")
        println("Monto base: $${factura.abonoMensual}")
        println("Monto total: $${factura.facturar()}")
}