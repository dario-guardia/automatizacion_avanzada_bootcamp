Feature: Modulo Transporte Grupo 4
  Archivo gherkin que contioene todas las casuliticas del modulo transporte de la web JetSmart

  Scenario: Ubicacion de origen Busqueda sin fecha

    Given Ingreso a la pagina JetSmart e ingreso al modulo de transporte
    When Ingreso al modulo de vuelo
    And Se cierra ventana emergente de suscribir
    And Selecciono recuadro de solo "Ida"
    And Escribo en la casilla lugar de origen de traslado "Aeropuerto Arturo Merino Benítez (Santiago de Chile)"
    And Escribo en la casilla lugar de Destino de traslado "Llano Subercaseaux, San Miguel, Chile"
    And No se selecciona la fecha de recogida
    And Selecciono con un click la hora de recogida
    And Selecciono el numero de pasajeros con un click "1 pasajero"
    And Click en el botono "Buscar"
    Then No avanza a la siguiente ventana porque falta rellenar campo de fecha