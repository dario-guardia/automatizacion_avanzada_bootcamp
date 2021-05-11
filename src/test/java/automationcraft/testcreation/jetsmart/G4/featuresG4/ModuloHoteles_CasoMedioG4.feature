Feature: Modulo Hoteles Caso Medio Nivel
  @g4
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