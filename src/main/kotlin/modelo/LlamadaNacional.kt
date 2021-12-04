package modelo

import java.time.LocalDateTime

class LlamadaNacional(duracion: Int, fechaLlamada: LocalDateTime, ubicacion: Ubicacion) : LlamadaLargaDistancia(duracion,fechaLlamada, ubicacion) {

}
