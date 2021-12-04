package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaTestCase {

    @Test
    fun unaLlamadaTieneUnaDuracionUnaFechaYUnaUbicacion(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021,Month.OCTOBER,17,1,0)
        val nuevaLlamada = Llamada(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(10,nuevaLlamada.duracion)
        Assertions.assertEquals(ubicacion,nuevaLlamada.ubicacion)
        Assertions.assertEquals(fechaLlamada,nuevaLlamada.fecha)
    }

    @Test
    fun unaLlamadaTieneUnCostoEquivalenteA10Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021,Month.OCTOBER,17,1,0)
        val nuevaLlamada = Llamada(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(1.0,nuevaLlamada.costoLlamada())
    }

    @Test
    fun unaLlamadaTieneUnCostoEquivalenteA20Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021,Month.OCTOBER,18,8,0)
        val nuevaLlamada = Llamada(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(2.0,nuevaLlamada.costoLlamada())
    }
}