# BitCoin App

Aplicacion java Webflux que muestra el precio del bitcoin, el promedio en determinado tiempo y la diferencia porcentual entre ese valor promedio y el valor máximo almacenado para toda la serie temporal disponible.

## Instalando🔧

* Instalación Java
* Seteo de variables de entorno para java
* Clonar el repo
```
git clone https://github.com/francoscolari/btc-webflux.git
```

### Comenzando 🚀

Comando para pruebas locales 

```
mvn spring-boot:run o run Application desde el IDE
```

Comando para generar el ejecutable

```
open cmd
cd c:/project
mvn clean install
java -jar -Dapple.awt.UIElement="true" target/myproject-1.0-SNAPSHOT.jar -h

```
## Endpoints 📦

Retorna el ultimo precio del bitcoin y en caso de pasarle fecha retorna el precio de la fecha indicada

GET /api/btc  -> params date NO requerido 

example: /api/btc?date=2021-09-28T10:53:28

Response
{
    "date": "2021-09-28T10:53:28",
    "price": 42023.00
}

------------------------------------------------------------------------------

GET /api/btc/detail -> params dateStart  dateEnd REQUERIDOS

example:  /api/btc/detail?dateStart=2021-09-28T10:20:40&dateEnd=2021-09-28T10:22:04

Response
```
{
    "average": 42115.7,
    "max": 42161.90,
    "percentage": -0.1095776044248500
}

```
## Formato Fecha📦

el formato de busqueda en los parametros es : 
```
YYYY-MM-DDTHH:SS:ss
```
example: 2021-09-28T10:20:40


## Construido con 🛠️

Extensiones: Java, Maven, WebFlux Reactor

## Autor ✒️
* **Franco Scolari** 
