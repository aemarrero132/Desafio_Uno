# Desafío 1: Periodos perdidos

El desafío consiste en lo siguiente:

-	Existe un servicio REST que llamaremos Generador De Datos o GDD.
	-	El servicio responde con una lista de fechas generadas aleatoriamente. Estas fechas se encuentran en un lapso definidos por dos valores: fechaCreacion y fechaFin.
	-	Cada fecha generada corresponde al primer día de un mes.
	-	La respuesta contienen un máximo de 100 fechas. 
	-	El servicio no entrega todas las fechas dentro del periodo, omite algunas de forma también aleatoria.
-	El objetivo de este ejercicio es que determines cuáles son los periodos que faltan.

Este es un ejemplo de la respuesta que entrega este servicio:

```json
{
    "id": 6,
    "fechaCreacion": "1968-08-01",
    "fechaFin": "1971-06-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1971-05-01"]
}
```

Acá se puede apreciar que el servicio generó fechas entre el 1 de agosto de 1968 y el 1 de junio de 1971. Sólo se generaron 4 fechas en este caso. 
De acuerdo a esto, faltarían 5 fechas de 1968, 9 fechas de 1969 y 5 fechas de 1971.
Una versión del GDD se encuentra en este repositorio en GitHub:
https://github.com/previred/Generador_Datos_Desafio_Uno

El desafío puede ser resuelto de tres maneras distintas. 
Tú eliges cuál es la que más te acomoda entre estos tres niveles:


## Nivel 3:

Implementar un nuevo servicio REST. Este servicio REST debe invocar al servicio GDD y entregar la respuesta en formato JSON con las fechas recibidas y las fechas faltantes.
Ejemplo de la respuesta que debería entregar:

```json
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"],
    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"]

}
```

SOLUCION NIVEL 3

SOLUCION FUE DESARROLLADA CON SPRINGBOOT Y GRADLE CON INTELLIJIDEA

ENDPOINT CONSUMIENDO LA API: http://localhost:8086/ms-previred/desafio/get
ENDPOINT DE PRUEBA QUE RECIBE JSON DE ENTRADA: http://localhost:8086/ms-previred/desafio/test

SE ADJUNTA ARCHIVO JSON DE POSTMAN PARA REALIZAR LAS PRUEBAS. NOMBRE DEL ARCHIVO: PREVIRED.POSTMAN_COLLECTION 

1. Descargar archivo zip "Desafio_Uno" y descomprimir
2. Abrir proyecto desde IntelliJIdea como un proyecto Gradle.
3. Ejecutar aplicacion mediante SpringBoot.
4. Verificar desde Postman con el endpoint http://localhost:8086/ms-previred/desafio/get 