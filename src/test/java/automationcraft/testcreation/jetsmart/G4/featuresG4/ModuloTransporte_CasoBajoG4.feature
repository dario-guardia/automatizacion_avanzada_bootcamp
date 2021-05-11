Feature: Modulo Transporte Grupo 4
  Archivo gherkin que contioene todas las casuliticas del modulo transporte de la web JetSmart

  Scenario: Busqueda sin fecha

    Given Ingreso a la pagina JetSmart e ingreso al modulo de transporte
    When Se cierra ventana emergente de suscribir
    And Ingreso al modulo de vuelo
    And Selecciono recuadro de solo "Ida"
    And Escribo en la casilla lugar de origen de traslado "99999999"
    Then Valido leyenda "no se encuetran resultados"