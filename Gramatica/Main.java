import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String[] reglas = new String[53];
    static int cont = 0, fil = 0, col = 0;
    static int[][] tablaLR = new int[95][46];
    static String[] rreglaactual = new String[3];

    static void arrange2(String str) {
        int posicion = 0;
        String w = "";
        for (char x : str.toCharArray()) {
            if (x == ' ') {
                rreglaactual[posicion] = w;
                posicion++;
                w = "";
            } else {
                w = w + x;
            }
        }
        rreglaactual[posicion] = w;
        posicion++;
    }

    static void arrange(String str) {
        int num;
        String w = "";
        col = 0;
        for (char x : str.toCharArray()) {
            if (x == ' ') {
                num = Integer.parseInt(w);
                tablaLR[fil][col] = num;
                col++;
                w = "";
            } else {
                w = w + x;
            }
        }
        num = Integer.parseInt(w);
        tablaLR[fil][col] = num;
        col++;
        fil++;
    }

    public static void main(String[] args) {
        int estadoact;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\yo-22\\OneDrive\\Documentos\\Seminario-de-Solucion-de-Problemas-de-Traductores-de-Lenguajes-II\\Gramatica\\compilador.lr"))) {
            while ((line = reader.readLine()) != null) {
                if (cont <= 52) {
                    reglas[cont] = line;
                }
                if (cont >= 54) {
                    arrange(line);
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pila pila = new Pila();
        ElementoPila elemento;
        int fila, columna, accion;
        boolean aceptacion = false;
        Lexico lexico = new Lexico("int hola ; "); // cadena a analizar

        elemento = new Terminal(2, "$");
        pila.push(elemento); // Entra signo de pesos que inicializa la cadena
        elemento = new Estado(0);
        pila.push(elemento);
        lexico.sigSimbolo(); // analizamos el primer simbolo de la cadena

        fila = pila.top(); // para la fila tomamos en cuenta en top de la pila
        columna = lexico.getTipo(); // para la columna tomamos en el id del siguiente simbolo en la cadena
        System.out.println("Fila: " + fila);
        System.out.println("Columna: " + columna);
        accion = tablaLR[fila][columna]; // la accion es el valor que se encuentre entre la fila y la columna

        pila.muestra(); // mostramos la pila
        System.out.println("entrada: " + lexico.simbolo);
        System.out.println("accion: " + accion);

        while (accion != -1) { // mientras la accion sea diferente de aceptacion repetimos el proceso

            if (accion > 0) { // si la accion es mayor a 0 hacemos un desplazo
                System.out.println();
                System.out.println("Desplazamiento");
                elemento = new Terminal(lexico.tipo, lexico.simbolo);
                pila.push(elemento);
                elemento = new Estado(accion);
                pila.push(elemento);
                lexico.sigSimbolo();

                fila = pila.top();
                columna = lexico.getTipo();
                System.out.println("Fila: " + fila);
                System.out.println("Columna: " + columna);
                accion = tablaLR[fila][columna];

                pila.muestra();
                System.out.println("entrada: " + lexico.simbolo);
                System.out.println("accion: " + accion);
            }
            if (accion < 0) { // Si la accion es menor a 0 hacemos una reduccion
                System.out.println();
                System.out.println("REDUCCION");
                int reglaapp = Math.abs(accion) - 1;
                System.out.println("REGLA: " + reglaapp);
                int numborrados;
                StringBuilder reglastr = new StringBuilder(String.valueOf(reglas[reglaapp].charAt(3)));
                numborrados = Integer.parseInt(reglastr.toString()) * 2;

                if (accion == -1) {
                    break;
                } // si es -1 es aceptacion

                for (int i = 0; i < numborrados; i++) { // reducimos la pila el numero de veces que nos indica la regla
                    pila.pop();
                }

                pila.muestra();
                arrange2(reglas[reglaapp]);
                String prueba = rreglaactual[2];
                prueba = prueba + " ";
                Lexico lexico2 = new Lexico(prueba);
                lexico2.sigSimbolo();
                elemento = new NoTerminal(lexico2.tipo, lexico2.simbolo);
                estadoact = tablaLR[pila.top()][lexico2.tipo];
                pila.push(elemento); // el 3 es el entero que representa el no terminal E*
                elemento = new Estado(estadoact);
                pila.push(elemento);

                fila = pila.top();
                columna = lexico.getTipo();
                System.out.println("Fila: " + fila);
                System.out.println("Columna: " + columna);
                accion = tablaLR[fila][columna];
                pila.muestra();
                System.out.println("entrada: " + lexico.simbolo);
                System.out.println("accion: " + accion);
                System.out.println();
                // system("pause");
            }
            if (accion == 0) {
                break;
            }
        }
        System.out.println("Automata terminado");
        aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Estado Aceptacion");
        } else {
            System.out.println("Estado No aceptacion");
        }
    }
}
