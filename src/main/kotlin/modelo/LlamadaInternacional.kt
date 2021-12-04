package modelo

import java.time.LocalDateTime

class LlamadaInternacional(duracion: Int, fechaLlamada: LocalDateTime, ubicacion: Ubicacion) : LlamadaLargaDistancia(duracion,fechaLlamada,ubicacion) {

}
