<h1 align="center"> CENTRO UNIVERSITARIO DE CIENCIAS EXACTAS E INGENIERIAS </h1>
 <h1 align="center"> DEPARTAMENTO DE CIENCIAS COMPUTACIONALES </h1>

 <h1 align="center"> UNIVERSIDAD DE GUADALAJARA </h1>

 <h1 align="center"> ![image](https://github.com/Ricardo108/Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II/assets/75130733/5ec13a68-b2ae-4980-9e0e-068ae81e5f24) </h1>


# Nombre: Rodriguez de Leon Ricardo Emmanuel
  <h1 align="center"> Analizador Lexico </h1>

# Contenido
Un analizador lexico es un modulo destinado a leer caracteres del archivo de entrada, donse se encuentra la cadena a analizar, reconocer subcadenas que correspondan a simbolos del lenguaje y retornar los tokens correspondientes y sus atributo.

    Escribir analizadores lexicos a mano es muy complicado.
    
Mencionando lo anterior, al ser tan complicado, se desarrollaron herramientas de software, para esto, los generadores de analizadores lexicos, que generan automaticamente un analizador lexico a partir de especificacion provista por el usuario.

# Funcion del analizador lexico

El analizador léxico forma parte de la primera fase de un compilador. Un compilador es un programa que lee un programa escrito en un lenguaje, el lenguaje fuente, y lo traduce a un programa equivalente en otro lenguaje, el lenguaje objeto. El proceso para construir un compilador se encuentra dividido en cuatro etapas: 

# 1 - Analisis lexico.
    Transforma el codigo fuente en tokens.
# 2 - Analisis sintactico.
    Construye un arbol sintactico.
# 3 - Analisis semantico.
    Realiza el chequeo de tipos
# 4 - Generacion de codigo
    Genera codigo de maquina.

# Diagrama

![image](https://github.com/Ricardo108/Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II/assets/75130733/cd41c71f-89a4-47d6-945b-e6d48cbb9816)

La función principal de los analizadores léxicos consiste en leer la secuencia de caracteres de entrada y dar como resultado una secuencia de componentes léxicos que utiliza el analizador sintáctico para hacer el análisis.
El analizador léxico puede realizar tareas secundarias en la interfaz del usuario, como eliminar espacios en blanco, tabulaciones y caracteres de fin de línea. En algunas ocasiones, los analizadores léxicos se dividen en una cascada de dos fases: la primera llamada “examen” y la segunda “análisis léxico”. El examinador se encarga de realizar tareas sencillas, mientras que el analizador léxico es el que realiza las operaciones más complejas.




# Bibliografía
https://dc.exa.unrc.edu.ar/staff/fbavera/papers/TesisJTLex-Bavera-Nordio-02.pdf
https://repositori.uji.es/xmlui/bitstream/handle/10234/5877/lexico.apun.pdf?sequence=1
