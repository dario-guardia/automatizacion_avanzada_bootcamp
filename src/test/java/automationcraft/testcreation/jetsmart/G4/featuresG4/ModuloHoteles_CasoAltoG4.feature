Feature: Modulo Hoteles Caso Alto Nivel
  Scenario: Reserva Hotel hasta formulario de datos
    Given un cliente que ingresa a la pagina "JetSmart"
    When ingreso a la pestaña de hoteles
    And selecciono lugar de hospedaje "santiago"
    And selecciono fecha de llegada "2021-5-11"
    And selecciono fecha de vuelta "2021-mayo-13"
    And selecciono "1 habitación"
    And selecciono personas "2 adultos"
    And presionar boton buscar
    And script cambio de pagina
    And clickeo filtro 5 estrellas
    And selecciono hotel sheraton
    And cambia de pagina nuevamente
    And clickeo boton reservar hotel
    And confirma "1 habitación"
    And confirma reserva
    Then se llega hasta el formulario de datos