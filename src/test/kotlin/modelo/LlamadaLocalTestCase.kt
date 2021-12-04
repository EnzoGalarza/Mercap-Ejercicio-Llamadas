package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaLocalTestCase {

    @Test
    fun unaLlamadaLocalEnDiaYHorarioHabilesTieneUnMontoEquivalenteA20Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021, Month.OCTOBER,18,9,0)
        val nuevaLlamada = LlamadaLocal(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(0.20,nuevaLlamada.costoPorTipo())
    }

    @Test
    fun unaLLamadaLocalEnDiaNoHabilTieneUnMontoEquivalenteA10Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021, Month.OCTOBER,17,9,0)
        val nuevaLlamada = LlamadaLocal(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(0.10,nuevaLlamada.costoPorTipo())
    }

    @Test
    fun unaLlamadaEnHorarioNoHabilTieneUnMontoEquivalenteA10Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021, Month.OCTOBER,18,2,0)
        val nuevaLlamada = LlamadaLocal(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(0.10,nuevaLlamada.costoPorTipo())
    }
}