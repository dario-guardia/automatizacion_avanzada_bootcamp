Feature: Modulo Hoteles Caso Bajo Nivel
  @G4 @Caso5
  Scenario: Numero de noches excedidas
    Given un usuario que ingresa a la pagina "JetSmart"
    When ingresa al formulario de hoteles
    And selecciona lugar de hospedaje "santiago"
    And selecciona fecha de llegada "hoy"
    And selecciona fecha de vuelta 30 dias a la fecha
    And selecciona numero de habitaciones "1"
    And selecciona numero personas adultas "1"
    Then pagina muestra una leyenda con error de reserva

  @G4 @Caso4
  Scenario: Numero de habitaciones erroneas
    Given una persona que ingresa a la pagina "JetSmart"
    When ingresa a la pestaña de hoteles
    And seleccionar lugar de hospedaje "santiago"
    And seleccionar fecha de llegada "2021-5-11"
    And seleccionar fecha de vuelta "2021-mayo-13"
    And selecciona "30 habitaciones"
    And selecciona "2 adultos"
    And presiono boton buscar
    And script cambia de pagina
    Then script muestra mensaje en consola

  @G4 @Caso6
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