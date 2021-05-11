Feature: Modulo Hoteles Caso Bajo Nivel
  @g4
  Scenario: Numero de noches excedidas
    Given un usuario que ingresa a la pagina "JetSmart"
    When ingresa al formulario de hoteles
    And selecciona lugar de hospedaje "santiago"
    And selecciona fecha de llegada "hoy"
    And selecciona fecha de vuelta 30 dias a la fecha
    And selecciona numero de habitaciones "1"
    And selecciona numero personas adultas "2"
    Then pagina muestra una leyenda con error de reserva