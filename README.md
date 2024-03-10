<h1 align="center"> CENTRO UNIVERSITARIO DE CIENCIAS EXACTAS E INGENIERIAS </h1>
 <h1 align="center"> DEPARTAMENTO DE CIENCIAS COMPUTACIONALES </h1>

 <h1 align="center"> UNIVERSIDAD DE GUADALAJARA </h1>

<div align="center">
  <img src="Imagenes/Image1.png" alt="Logo UDG" width="200" />
</div>


# Nombre: Rodriguez de León Ricardo Emmanuel

<h1 align="center"> Construcción de tu Traductor </h1>

<h1 style="color: red;"> Indice </h1>

* [Introducción](#Introducción)

* [Analizador Lexico](#Analizador-Lexico)

* [Analizador Sintactico](#Analizador-Sintactico)

* [Analizador Semantico](#Analizador-Semantico)

* [Mini diagrama](#Diagrama)

* [Conclusión](#Conclusión)

* [Bibliografía](#Bibliografía)

<h1 style="color: red;"> Introducción </h1>
Este es un proyecto a largo plazo, donde se realizara paso a paso un traductor, se podria decir que seria un "mini visual studio", se realizara el analisis lexioc, sintactico, semantico y se generara el codigo maquina. Se conocera mas sobre los analizadores que se realizaran y se hablara un poco de como funciona cada uno de ellos.

<h1 style="color: red;"> Contenido </h1>

## Analizador Lexico
Un analizador lexico es un modulo destinado a leer caracteres del archivo de entrada, donse se encuentra la cadena a analizar, reconocer subcadenas que correspondan a simbolos del lenguaje y retornar los tokens correspondientes y sus atributo.

    Escribir analizadores lexicos a mano es muy complicado.
    
Mencionando lo anterior, al ser tan complicado, se desarrollaron herramientas de software, para esto, los generadores de analizadores lexicos, que generan automaticamente un analizador lexico a partir de especificacion provista por el usuario.

### Funcion del analizador lexico

El analizador léxico forma parte de la primera fase de un compilador. Un compilador es un programa que lee un programa escrito en un lenguaje, el lenguaje fuente, y lo traduce a un programa equivalente en otro lenguaje, el lenguaje objeto. El proceso para construir un compilador se encuentra dividido en cuatro etapas: 

## Analizador Sintactico
Un analizador sintactico tiene como objetiovo encontrar las estructuras en su entrada. Estas estructuras se pueden representar mediane el arbol de analisis sintactico, que explica como se puede derivar la cadena de entrada en la gramatica que especifica el lenguaje.

### Funcion del analizador sintactico
El analizador sintactico, podria decirse que es la egunda etapa para el compilador, para la construccion de este mismo, se suelen emplear gramaticas incontextuales, generalmente restringidas para que el analisis se pueda realizar de manera eficiente.

## Analizador Semantico
*Proximamente*

# 1 - Analisis lexico.
    Transforma el codigo fuente en tokens.
* [Ir al analizador lexico](https://github.com/Ricardo108/Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II/tree/bbe044c5602044cc5c2c078dfbef22010137d307/Lexico)

# 2 - Analisis sintactico.
    Construye un arbol sintactico.
* [Ir al analizador sintactico](https://github.com/Ricardo108/Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II/tree/bbe044c5602044cc5c2c078dfbef22010137d307/sintactico)

# 3 - Analisis semantico.
    Realiza el chequeo de tipos.
* *Proximanente*

# 4 - Generacion de codigo
    Genera codigo de maquina.
* *Proximanente*

<h1 style="color: red;"> Diagrama </h1>

![image](https://github.com/Ricardo108/Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II/assets/75130733/cd41c71f-89a4-47d6-945b-e6d48cbb9816)

<h1 style="color: red;"> Conclusión </h1>
La función principal de los analizadores léxicos consiste en leer la secuencia de caracteres de entrada y dar como resultado una secuencia de componentes léxicos que utiliza el analizador sintáctico para hacer el análisis.
El analizador léxico puede realizar tareas secundarias en la interfaz del usuario, como eliminar espacios en blanco, tabulaciones y caracteres de fin de línea. En algunas ocasiones, los analizadores léxicos se dividen en una cascada de dos fases: la primera llamada “examen” y la segunda “análisis léxico”. El examinador se encarga de realizar tareas sencillas, mientras que el analizador léxico es el que realiza las operaciones más complejas.




<h1 style="color: red;"> Bibliografía </h1>
https://dc.exa.unrc.edu.ar/staff/fbavera/papers/TesisJTLex-Bavera-Nordio-02.pdf

https://repositori.uji.es/xmlui/bitstream/handle/10234/5877/lexico.apun.pdf?sequence=1

https://repositori.uji.es/xmlui/bitstream/handle/10234/22658/II26_analisis_sintactico.pdf?sequence=1&isAllowed=y