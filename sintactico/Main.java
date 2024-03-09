package sintactico;

import java.util.Stack;
import java.util.Vector;


public class Main {
    static Stack<ElementoPila> pila = new Stack<>();
    static Stack<ElementoPila> memory = new Stack<>();
    static int contadorinterno = 0;
    static Lexico lexico = new Lexico();
    static Vector<String> simbolo = new Vector<>();
    static Vector<Integer> tipo = new Vector<>();
    static int fila, columna, accion;
    static boolean aceptacion = false;

    public static void main(String[] args) {
        r1("hola+mundo");
        r2("a+b+c+d+e+f");
    }

    static void r1(String c) {
        contadorinterno = 0;
        // Se inicia la pila que servirá de buffer
        pila.clear();
        ElementoPila simbolo;
        // Se introduce la entrada correspondiente
        lexico.setEntrada(c);
        // Se aplica el $0
        pila.push(new Terminal("$"));
        pila.push(new Estado("0"));
        // Se empieza a recorrer la entrada
        lexico.siguienteSimbolo();

        simbolo = pila.peek();
        fila = Integer.parseInt(simbolo.regresar());
        columna = lexico.tipo;
        accion = TablaR1.TABLA_R1[fila][columna];
        // Se muestan los datos de la pila
        muestraPila(pila);
        System.out.println("Entrada: " + lexico.simbolo);

        contadorinterno++;
        System.out.println();
        // Basados en la regla de la tabla, se hace el recorrido por posiciones que no tienen E
        System.out.println("Accion: " + accion);
        lexico.siguienteSimbolo();
        if (accion > 0) {
            while (contadorinterno < 3) {
                pila.push(new Terminal(lexico.simbolo));
                pila.push(new Estado(Integer.toString(accion)));
                lexico.siguienteSimbolo();

                simbolo = pila.peek();
                fila = Integer.parseInt(simbolo.regresar());
                columna = lexico.tipo;
                accion = TablaR1.TABLA_R1[fila][columna];

                muestraPila(pila);
                System.out.println("Entrada: " + lexico.simbolo);
                System.out.println("Accion: " + accion);
                contadorinterno++;
            }
        }
        // En base a las acciones efectuadas se empiezan a hacer eliminaciones para completar el proceso
        if (accion < 0) {
            for (int i = 0; i < 6; i++) {
                pila.pop();
            }
        }
        if (accion == 0)
            System.out.println("Error");
        else {
            muestraPila(pila);
            simbolo = pila.peek();
            fila = Integer.parseInt(simbolo.regresar());
            columna = 3;
            accion = TablaR1.TABLA_R1[fila][columna];

            pila.push(new Noterminal("E"));
            pila.push(new Estado(Integer.toString(accion)));
            muestraPila(pila);

            System.out.println("Entrada: " + lexico.simbolo);
            System.out.println("Accion: " + accion);

            simbolo = pila.peek();
            fila = Integer.parseInt(simbolo.regresar());
            columna = lexico.tipo;
            accion = TablaR1.TABLA_R1[fila][columna];
        }
        muestraPila(pila);
        System.out.println("Entrada: " + lexico.simbolo);
        System.out.println("Accion: " + accion);

        aceptacion = accion == -1;
        if (aceptacion)
            System.out.println("Aceptacion");
    }

    static void r2(String c) {
        contadorinterno = 0;
        System.out.println("\n\n\n");
        ElementoPila simbolo;
        // Se introduce la entrada correspondiente al proceso
        lexico.setEntrada(c);
        // Se introduce el $0
        pila.clear();
        pila.push(new Terminal("$"));
        pila.push(new Estado("0"));
        // Se empieza a recorrer la entrada
        lexico.siguienteSimbolo();
        simbolo = pila.peek();
        fila = Integer.parseInt(simbolo.regresar());
        columna = lexico.tipo;
        accion = TablaR2.TABLA_R2[fila][columna];

        muestraPila(pila);
        System.out.println("Entrada: " + lexico.simbolo);
        System.out.println("Accion: " + accion);
        // Se empiezan a recorrer todas las posiciones
        while (contadorinterno < 16) {
            if (accion > 0) {
                pila.push(new Terminal(lexico.simbolo));
                pila.push(new Estado(Integer.toString(accion)));
                lexico.siguienteSimbolo();

                simbolo = pila.peek();
                fila = Integer.parseInt(simbolo.regresar());
                columna = lexico.tipo;
                accion = TablaR2.TABLA_R2[fila][columna];

                muestraPila(pila);
                System.out.println("Entrada: " + lexico.simbolo);
                System.out.println("Accion: " + accion);
            }
            // En base a las acciones definidas se empiezan a realizar operaciones específicas
            if (accion < 0) {
                if (accion == -3 || accion == 4) {
                    int popCount = accion == -3 ? 2 : 6;
                    for (int y = 0; y < popCount; y++) {
                        pila.pop();
                    }
                    simbolo = pila.peek();
                    fila = Integer.parseInt(simbolo.regresar());
                    columna = 3;
                    accion = TablaR2.TABLA_R2[fila][columna];
                    pila.push(new Noterminal("E"));
                    pila.push(new Estado(Integer.toString(accion)));

                    muestraPila(pila);
                    System.out.println("Entrada: " + lexico.simbolo);
                    System.out.println("Accion: " + accion);
                }
            }
            contadorinterno++;
        }

        aceptacion = accion == -1;
        if (aceptacion)
            System.out.println("Aceptacion");
    }

    static void muestraPila(Stack<ElementoPila> pila) {
        Stack<ElementoPila> reversed = new Stack<>();
        reversed.addAll(pila);
        System.out.print("Pila: ");
        for (ElementoPila elemento : reversed) {
            elemento.muestra();
        }
        System.out.println();
    }
}
