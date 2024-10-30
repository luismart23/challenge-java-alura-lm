# Challenge Conversor de Monedas Alura

## Descripción

Este proyecto es un **Conversor de Monedas** que permite a los usuarios convertir montos entre diferentes monedas utilizando tasas de cambio actualizadas desde una API. La aplicación consulta la API de tasas de cambio y presenta una lista de monedas con sus respectivos países, facilitando así la conversión entre ellas.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **HttpClient**: Para realizar solicitudes HTTP.
- **JSON**: Para manejar las respuestas de la API.
- **Gson**: Para la conversión de JSON a objetos Java.

## Configuración del Ambiente

1. **Instalar Java JDK**: Asegúrate de tener Java Development Kit (JDK) instalado en tu máquina. Puedes descargarlo desde [aquí](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Configurar el IDE**: Puedes usar cualquier IDE de Java como IntelliJ IDEA, Eclipse, o NetBeans.

3. **Agregar Dependencias**: Asegúrate de incluir la librería Gson en tu proyecto. Si estás utilizando Maven, agrega la siguiente dependencia en tu `pom.xml`:

   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.11.0</version>
   </dependency>

## 1. Creación del Proyecto
Crear Estructura de Proyecto: Organiza tu proyecto con la siguiente estructura:

```
CurrencyConverter/
├── src/
│     └── main/
│            ├── CurrencyConverterApp.java
│            ├── CurrencyService.java
│            ├── ConversionRates.java
│            └── CurrencyData.java
├── lib/
│   └── gson-2.11.0.jar
└── README.md
```

## 2. Consumo de la API
La aplicación utiliza la API de tasas de cambio en tiempo real. La URL de la API utilizada es:

```
https://v6.exchangerate-api.com/v6/6e2eaa4e34679957110179d3/latest/USD

```


## Análisis de la Respuesta JSON
La respuesta de la API es un objeto JSON que contiene la tasa de cambio de varias monedas. Se utiliza la librería Gson para analizar este JSON y mapearlo a objetos Java.

## Filtrado de Monedas
La aplicación filtra las monedas para mostrar solo aquellas que tienen un país asociado. Las monedas disponibles se enumeran en la consola para que el usuario pueda seleccionarlas fácilmente.

## Exhibición de Resultados a los Usuarios
Una vez que el usuario selecciona las monedas y la cantidad a convertir, la aplicación calcula y muestra la cantidad convertida en la moneda de destino.

## Contribuciones
Si deseas contribuir a este proyecto, siéntete libre de hacer un fork del repositorio y enviar tus mejoras o correcciones.

## Licencia
Este proyecto no tiene una licencia específica. Siéntete libre de usarlo y modificarlo según lo necesites.

