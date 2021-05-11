Feature: Modulo Vuelo Grupo 4
  Archivo gherkin que contiene todas las casuiticas del modulo vuelo de la web JetSmart
@G3
  Scenario: Lugar de origen Invalido

    Given Que soy un usuario e ingreso a la pagina JetSmart caso bajo
    When Ingreso al formulario vuelo
    Then selecciono "Inglaterra" en campo origen se muestra leyenda que el lugar no existe