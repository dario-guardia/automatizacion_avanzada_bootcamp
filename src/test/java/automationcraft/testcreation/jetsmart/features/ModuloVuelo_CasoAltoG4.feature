Feature: Modulo Vuelo Grupo 4
  Archivo gherkin que contiene todas las casuiticas del modulo vuelo de la web JetSmart

  Scenario: Paquete de ida y vuelta disponible

    Given Que soy un usuario e ingreso a la pagina JetSmart
    When ingreso al formulario de vuelo
    And selecciono  "SCL" en el campo de origen
    And selecciono  "IQQ" en el campo de destino
    And selecciono  "Mayo 12, 2021" como fecha de ida
    And selecciono  "Junio 1, 2021" como fecha de vuelta
    And selecciono "1 pasajero" en el campo de pasajeros
    And presiono el boton "Smart"
    And selecciono la hora de ida disponible
    And selecciono el "paquete ligero"
    And selecciono la hora de vuelta disponible
    And selecciono el "paquete ligero vuelta"
    And presiono el boton "Continuar"
    Then se encuentran paquetes disponibles
