#language: es

@Cucumber
Característica: Ejercicio 1, Ingreso a Demoblaze (Registración, logeo y compra)



  @CP1
  Esquema del escenario: Registrarse en DemoBlaze
    Dado Que abro la pagina de Demoblaze
    Cuando Me registro con <USER> y <PASSWORD>
    Entonces El Alertbox devuelve <ALERTBOX>

    Ejemplos:
    |USER                 |PASSWORD|ALERTBOX           |
    |DemoblazeFinalTestJP |1234    |Sign up successful.|


  @CP2
  Esquema del escenario: Hacer LogIn y LogOut
    Dado Que abro la pagina de Demoblaze
    Cuando Ingresamos con <USER> y <PASSWORD>
    Entonces Se realiza correctamente el Logout
    Ejemplos:
    |USER                 |PASSWORD|
    |DemoblazeFinalTestJP |1234    |

  @CP3
  Esquema del escenario: Agregar producto al carrito y validar que se agrego
    Dado Que abro la pagina de Demoblaze
    Cuando Ingresamos con <USER> y <PASSWORD>
    Y Seleccionamos Sony Vaio I5
    Y Agregamos Sony Vaio I5 al carrito
    Y Ingresamos al carrito
    Entonces Deberia mostrar el precio total correcto correspondiente al de Sony Vaio i5: <PRECIOSONYVAIOI5>
    Ejemplos:
    |USER                 |PASSWORD|PRECIOSONYVAIOI5|
    |DemoblazeFinalTestJP |1234    |790             |

