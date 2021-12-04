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
    private lateinit var ubicacionBsAs: Ubicacion
    private lateinit var ubicacionJujuy : Ubicacion
    private lateinit var llamadaJunio2021Habil : Llamada
    private lateinit var llamadaJunio2021NoHabil : Llamada
    private lateinit var llamadaNacOctubre2021 : Llamada


    @BeforeEach
    fun setUp(){
        clientePedro = Persona("Pedro")
        fechaHabilJunio = LocalDateTime.of(2021,Month.JUNE,2,9,10)
        fechaNoHabilJunio = LocalDateTime.of(2021,Month.JUNE,5,6,10)
        fechaOctubre = LocalDateTime.of(2021,Month.OCTOBER,5,6,10)
        ubicacionBsAs = Ubicacion("Argentina", "Buenos Aires")
        ubicacionJujuy = Ubicacion("Argentina","Jujuy",0.6)
        llamadaJunio2021Habil = LlamadaLocal(10,fechaHabilJunio,ubicacionBsAs)
        llamadaJunio2021NoHabil = LlamadaLocal(5,fechaNoHabilJunio,ubicacionBsAs)
        llamadaNacOctubre2021 = LlamadaNacional(2,fechaOctubre,ubicacionJujuy)
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
        val llamada2020Junio = LlamadaLocal(15,fecha2020Junio, ubicacionBsAs)

        clientePedro.agregarLlamada(llamada2020Junio)
        clientePedro.agregarLlamada(llamadaJunio2021Habil)
        clientePedro.agregarLlamada(llamadaNacOctubre2021)
        val facturaJunio = Factura(clientePedro,250.0,Month.JUNE,2021)

        Assertions.assertEquals(1,facturaJunio.llamadasDelMes.size)
        Assertions.assertTrue(facturaJunio.llamadasDelMes.contains(llamadaJunio2021Habil))
        Assertions.assertFalse(facturaJunio.llamadasDelMes.contains(llamada2020Junio))
        Assertions.assertFalse(facturaJunio.llamadasDelMes.contains(llamadaNacOctubre2021))
    }

    @Test
    fun facturaConClienteSinLlamadasEnElMesTieneElAbonoMensualComoMontoTotalDeLaFactura(){
        clientePedro.agregarLlamada(LlamadaNacional(10,fechaNoHabilJunio, ubicacionJujuy))
        val factura = Factura(clientePedro,250.5,Month.OCTOBER,2021)

        Assertions.assertEquals(250.5,factura.facturar())
    }

    @Test
    fun facturaConMesEnJunioConClienteQueRealizo3LlamadasYSolo2EnJunio(){
        val llamadaNacional = LlamadaNacional(1,fechaOctubre,ubicacionJujuy)
        clientePedro.agregarLlamada(llamadaJunio2021Habil)
        clientePedro.agregarLlamada(llamadaJunio2021NoHabil)
        clientePedro.agregarLlamada(llamadaNacional)

        val factura = Factura(clientePedro,250.0,Month.JUNE,2021)

        Assertions.assertEquals(252.5,factura.facturar())
    }


}