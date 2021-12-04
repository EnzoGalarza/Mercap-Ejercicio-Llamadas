package modelo

import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaLocalTestCase {

    @Test
    fun unaLlamadaLocalEnDiaHabilTieneUnMontoEquivalenteA20Centavos(){
        val ubicacion = Ubicacion("Argentina","Quilmes")
        val fechaLlamada = LocalDateTime.of(2021, Month.OCTOBER,17,1,0)
        val nuevaLlamada = LlamadaLocal(10,fechaLlamada,ubicacion)

    }
}