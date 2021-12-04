package modelo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month

class LlamadaLargaDistanciaTestCase {

    @Test
    fun elCostoDeUnaLlamadaALargaDistanciaNacionalDependeDeLaUbicacion(){
        val ubicacion = Ubicacion("Argentina","Wilde",0.5)
        val fechaLlamada = LocalDateTime.of(2021, Month.APRIL,10,8,9)
        val llamadaNacional : LlamadaLargaDistancia = LlamadaNacional(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(0.5,llamadaNacional.costoPorTipo())
        Assertions.assertEquals(5.0,llamadaNacional.costoLlamada())
    }

    @Test
    fun elCostoDeUnaLlamadaALargaDistanciaInternacionalDependeDeLaUbicacion(){
        val ubicacion = Ubicacion("Brasil","Sao Paulo",1.0)
        val fechaLlamada = LocalDateTime.of(2021, Month.APRIL,10,8,9)
        val llamadaNacional : LlamadaLargaDistancia = LlamadaInternacional(10,fechaLlamada,ubicacion)

        Assertions.assertEquals(1.0,llamadaNacional.costoPorTipo())
        Assertions.assertEquals(10.0,llamadaNacional.costoLlamada())
    }
}