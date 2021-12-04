package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class FacturaTestCase {
    private lateinit var clientePedro : Persona
    private lateinit var fechaHabilJunio : LocalDateTime
    private lateinit var fechaNoHabilJunio : LocalDateTime
    private lateinit var fechaOctubre : LocalDateTime

    @BeforeEach
    fun setUp(){
        clientePedro = Persona("Pedro")
        fechaHabilJunio = LocalDateTime.of(2021,Month.JUNE,2,9,10)
        fechaNoHabilJunio = LocalDateTime.of(2021,Month.JUNE,5,6,10)
        fechaOctubre = LocalDateTime.of(2021,Month.OCTOBER,5,6,10)
    }

    @Test
    fun unaFacturaTieneUnClienteUnAbonoMensualUnMesYUnAñoDeFacturacionYUnaListaDeLlamadasRealizadasEseMes(){
        val factura = Factura(clientePedro,250.0, Month.APRIL,2021)

        Assertions.assertEquals(clientePedro,factura.cliente)
        Assertions.assertEquals(250.0,factura.abonoMensual)
        Assertions.assertEquals("APRIL",factura.mesDeFacturacion.name)
        Assertions.assertEquals(2021,factura.añoDeFacturacion)
        Assertions.assertEquals(0,factura.llamadasDelMes.size)
    }

    @Test
    fun facturaSoloTieneLlamadasDelMesYAñoDeFacturacion(){
        val fecha2020Junio = LocalDateTime.of(2020,Month.JUNE,5,5,5)
        val llamada2021Junio = LlamadaLocal(5,fechaHabilJunio, Ubicacion("Argentina","Buenos Aires"))
        val llamada2021Octubre = LlamadaNacional(10,fechaOctubre,Ubicacion("Argentina","Cordoba"))
        val llamada2020Junio = LlamadaLocal(15,fecha2020Junio, Ubicacion("Argentina","Buenos Aires"))

        clientePedro.agregarLlamada(llamada2020Junio)
        clientePedro.agregarLlamada(llamada2021Junio)
        clientePedro.agregarLlamada(llamada2021Octubre)
        val facturaJunio = Factura(clientePedro,250.0,Month.JUNE,2021)

        Assertions.assertEquals(1,facturaJunio.llamadasDelMes.size)
        Assertions.assertTrue(facturaJunio.llamadasDelMes.contains(llamada2021Junio))
        Assertions.assertFalse(facturaJunio.llamadasDelMes.contains(llamada2020Junio))
        Assertions.assertFalse(facturaJunio.llamadasDelMes.contains(llamada2021Octubre))
    }

    @Test
    fun facturaConClienteSinLlamadasEnElMesTieneElAbonoMensualComoMontoTotalDeLaFactura(){
        clientePedro.agregarLlamada(LlamadaNacional(10,fechaNoHabilJunio, Ubicacion("Argentina","Jujuy")))
        val factura = Factura(clientePedro,250.5,Month.OCTOBER,2021)

        Assertions.assertEquals(1,clientePedro.llamadas.size)
        Assertions.assertEquals(0,factura.llamadasDelMes.size)
        Assertions.assertEquals(250.5,factura.facturar())
    }

    @Test
    fun facturaConMesEnJunioConClienteQueRealizo3LlamadasYSolo2EnJunio(){
        val ubicacionLlamadaLocal = Ubicacion("Argentina","Buenos Aires")
        val ubicacionNacional = Ubicacion("Argentina","Mendoza",0.6)
        val llamadaLocal1 = LlamadaLocal(5,fechaHabilJunio,ubicacionLlamadaLocal)
        val llamadaLocal2 = LlamadaLocal(2,fechaNoHabilJunio,ubicacionLlamadaLocal)
        val llamadaNacional = LlamadaNacional(1,fechaOctubre,ubicacionNacional)
        clientePedro.agregarLlamada(llamadaLocal1)
        clientePedro.agregarLlamada(llamadaLocal2)
        clientePedro.agregarLlamada(llamadaNacional)

        val factura = Factura(clientePedro,250.0,Month.JUNE,2021)

        Assertions.assertEquals(2,factura.llamadasDelMes.size)
        Assertions.assertEquals(251.2,factura.facturar())
    }


}