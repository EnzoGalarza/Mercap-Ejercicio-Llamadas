package modelo

class Persona(var nombre : String) {
    var llamadas = mutableListOf<Llamada>()

    fun agregarLlamada(llamada : Llamada){
        llamadas.add(llamada)
    }

}
