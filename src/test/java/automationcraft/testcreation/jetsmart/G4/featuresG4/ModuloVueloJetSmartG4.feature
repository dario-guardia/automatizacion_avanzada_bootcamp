Feature: Modulo Vuelo Grupo 4
  Archivo gherkin que contiene todas las casuiticas del modulo vuelo de la web JetSmart
  @G4 @Caso3
  Scenario: Lugar de origen Invalido

    Given Que soy un usuario e ingreso a la pagina JetSmart caso bajo
    When Ingreso al formulario vuelo
    Then selecciono "Inglaterra" en campo origen se muestra leyenda que el lugar no existe

  @G4 @Caso2
  Scenario: Paquete de ida

    Given Que soy un usuario e ingreso a la pagina JetSmartVuelos
    When selecciono el check "IDA"
    And selecciono en el campo de origen   "SCL"
    And selecciono en el campo de destino "IQQ"
    And selecciono como fecha de ida  "Junio 9, 2021"
    And selecciono en el campo de pasajeros "1"
    And presiono el boton Smart para continuar
    And selecciono la hora de ida disponible para salir
    Then se encuentran paquetes disponibles de ida

  @G4 @Caso1
  Scenario: Paquete de ida y vuelta disponible

    Given Que soy un usuario e ingreso a la pagina JetSmart
    When selecciono1  "SCL" en el campo de origen
    And selecciono1  "IQQ" en el campo de destino
    And selecciono1  "Mayo 12, 2021" como fecha de ida
    And selecciono  "Junio 1, 2021" como fecha de vuelta
    And selecciono "1" pasajero en el campo de pasajeros
    And presiono el boton smart
    And selecciono la hora de ida disponible
    And selecciono el paquete ida paquete ligero
    And selecciono la hora de vuelta disponible
    And selecciono el paquete vuelta paquete ligero vuelta
    And presiono el boton Continuar
    Then se encuentran paquetes disponibles
