Feature: Modulo Vuelo Grupo 4
  Archivo gherkin que contiene todas las casuiticas del modulo vuelo de la web JetSmart
@G2
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