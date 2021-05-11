Feature: Modulo Transporte Grupo 4
  Archivo gherkin que contioene todas las casuliticas del modulo transporte de la web JetSmart

  @G4 @Caso10
  Scenario: Busqueda sin fecha

    Given Ingreso a la pagina JetSmart e ingreso al modulo de transporte
    When Se cierra ventana emergente de suscribir
    And Ingreso al modulo de vuelo
    And Selecciono recuadro de solo "Ida"
    And Escribo en la casilla lugar de origen de traslado "99999999999"
    Then Valido leyenda "no se encuetran resultados"

  @G4 @Caso11
  Scenario: Ubicacion de origen Busqueda sin fecha

    Given Ingreso a la pagina JetSmart e ingreso al modulo de transporte
    When Se cierra ventana emergente de suscribir
    And Ingreso al modulo de vuelo
    And Selecciono recuadro de solo "Ida"
    And Escribo en la casilla lugar de origen de traslado2 "Aeropuerto Arturo Merino Benítez (Santiago de Chile)"
    And Escribo en la casilla lugar de Destino de traslado "Llano Subercaseaux, San Miguel, Chile"
    And No se selecciona la fecha de recogida
    And Selecciono con un click la hora de recogida
    And Selecciono el numero de pasajeros con un click "1 pasajero"
    And Click en el botono "Buscar"
    Then No avanza a la siguiente ventana porque falta rellenar campo de fecha

  @G4 @Caso12
  Scenario: Validacion de trazabilidad hasta pago

    Given Ingreso a la pagina JetSmart e ingreso al modulo de transporte
    When Se cierra ventana emergente de suscribir
    And Ingreso al modulo de vuelo
    And Selecciono recuadro de solo "Ida"
    And Escribo en la casilla lugar de origen de traslado2 "Aeropuerto Arturo Merino Benítez (Santiago de Chile)"
    And Escribo en la casilla lugar de Destino de traslado "Llano Subercaseaux, San Miguel, Chile"
    And Selecciono con un click el la fecha de recogida
    And Selecciono con un click la hora de recogida
    And Selecciono el numero de pasajeros con un click "1 pasajero"
    And Click en el botono "Buscar"
    And switcheo de pagina
    And Click boton Reserva "Reservar ahora"
    And Escribo en la casilla Nombre del pasajero "Marcelo Letelier Palomares"
    And Escribo en la casilla Correo electronico del pasajero "mletelierpalomares@gmail.com"
    And Escribo en la casilla Confirmar Correo electronico del pasajero "mletelierpalomares@gmail.com"
    And Escribo en la casilla numero de movil "964567406"
    And Escribo en la casilla Numero de vuelo "AB147"
    And Click en boton Ir a caja
    Then Valida que este en la vista de Pago con "Resumen del pago"
