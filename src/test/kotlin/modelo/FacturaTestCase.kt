package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class FacturaTestCase {

    @Test
    fun unaFacturaTieneUnClienteUnAbonoMensualUnMesYUnAñoDeFacturacionYUnaListaDeLlamadasRealizadasEseMes(){
        val clientePedro = Persona("Pedro")
        val factura = Factura(clientePedro,250.0, Month.APRIL,2021)

        Assertions.assertEquals(clientePedro,factura.cliente)
        Assertions.assertEquals(250.0,factura.abonoMensual)
        Assertions.assertEquals("APRIL",factura.mesDeFacturacion.name)
        Assertions.assertEquals(2021,factura.añoDeFacturacion)
        Assertions.assertEquals(0,factura.llamadasDelMes.size)
    }

    @Test
    fun facturaConMesEnJunioConClienteQueRealizo3LlamadasYSolo2EnJunio(){
        val fechaLlamadaHabil = LocalDateTime.of(2021,Month.JUNE,2,9,10)
        val fechaLlamadaNoHabil = LocalDateTime.of(2021,Month.JUNE,5,6,10)
        val fechaLlamadaNacional = LocalDateTime.of(2021,Month.OCTOBER,5,6,10)
        val ubicacionLlamadaLocal = Ubicacion("Argentina","Buenos Aires")
        val ubicacionNacional = Ubicacion("Argentina","Mendoza")
        val clientePedro = Persona("Pedro")
        val llamadaLocal1 = LlamadaLocal(5,fechaLlamadaHabil,ubicacionLlamadaLocal)
        val llamadaLocal2 = LlamadaLocal(2,fechaLlamadaNoHabil,ubicacionLlamadaLocal)
        val llamadaNacional = LlamadaNacional(1,fechaLlamadaNacional,ubicacionNacional)
        clientePedro.agregarLlamada(llamadaLocal1)
        clientePedro.agregarLlamada(llamadaLocal2)
        clientePedro.agregarLlamada(llamadaNacional)

        val factura = Factura(clientePedro,250.0,Month.JUNE,2021)

        Assertions.assertEquals(2,factura.llamadasDelMes.size)
        Assertions.assertEquals(251.2,factura.facturar())
    }
}