package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaLocalTestCase {

    lateinit var ubicacion: Ubicacion
    lateinit var fechaLlamadaDiaHabil : LocalDateTime
    lateinit var fechaLlamadaDiaNoHabil : LocalDateTime
    lateinit var fechaLlamadaHorarioNoHabil : LocalDateTime

    @BeforeEach
    fun setUp(){
        ubicacion = Ubicacion("Argentina","Quilmes")
        fechaLlamadaDiaHabil = LocalDateTime.of(2021, Month.OCTOBER,18,9,0)
        fechaLlamadaDiaNoHabil = LocalDateTime.of(2021, Month.OCTOBER,17,9,0)
        fechaLlamadaHorarioNoHabil = LocalDateTime.of(2021, Month.OCTOBER,18,2,0)
    }

    @Test
    fun unaLlamadaLocalEnDiaYHorarioHabilesTieneUnMontoEquivalenteA20Centavos(){
        val llamadaLocalDiaHabil = LlamadaLocal(10,fechaLlamadaDiaHabil,ubicacion)

        Assertions.assertEquals(0.20,llamadaLocalDiaHabil.costoPorTipo())
    }

    @Test
    fun unaLLamadaLocalEnDiaNoHabilTieneUnMontoEquivalenteA10Centavos(){
        val fechaLlamada = LocalDateTime.of(2021, Month.OCTOBER,17,9,0)
        val nuevaLlamada = LlamadaLocal(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(0.10,nuevaLlamada.costoPorTipo())
    }

    @Test
    fun unaLlamadaLocalEnHorarioNoHabilTieneUnMontoEquivalenteA10Centavos(){
        val llamadaHorarioNoHabil = LlamadaLocal(10,fechaLlamadaHorarioNoHabil,ubicacion)

        Assertions.assertEquals(0.10,llamadaHorarioNoHabil.costoPorTipo())
    }
}