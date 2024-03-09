package sintactico;

public class Lexico {
    // Constantes de tipo
    static final int ERROR = -1;
    static final int IDENTIFICADOR = 0;
    static final int ENTERO = 1;
    static final int REAL = 2;
    static final int CADENA = 3;
    static final int TIPO_FUNCION = 4;
    static final int OP_ADICION = 5;
    static final int OP_MUL = 6;
    static final int OP_RELACIONAL = 7;
    static final int OP_OR = 8;
    static final int OP_AND = 9;
    static final int OP_NOT = 10;
    static final int OP_IGUAL = 11;
    static final int PUNTOCOMA = 12;
    static final int COMA = 13;
    static final int PARENTESIS_IZQ = 14;
    static final int PARENTESIS_DER = 15;
    static final int LLAVE_IZQ = 16;
    static final int LLAVE_DER = 17;
    static final int OP_ASIGNACION = 18;
    static final int RES_IF = 19;
    static final int RES_WHILE = 20;
    static final int RES_RETURN = 21;
    static final int RES_ELSE = 22;
    static final int FIN = 23;

    String simbolo;
    int tipo;
    String fuente;

    int indice;
    boolean continuar;
    boolean simbolo_per;
    char c;
    int estado;

    // Constructor
    public Lexico() {
        indice = 0;
        simbolo_per = true;
    }

    // Constructor con parámetro para la entrada
    public Lexico(String e) {
        indice = 0;
        simbolo_per = true;
        fuente = e;
    }

    // Método para establecer la entrada
    public void setEntrada(String e) {
        indice = 0;
        fuente = e;
    }

    // Método para obtener el tipo académico de un tipo numérico
    public String getTipoAcademico(int tipo) {
        String simbolo_tipo;

        switch (tipo) {
            case IDENTIFICADOR:
                simbolo_tipo = "ID";
                break;
            case ENTERO:
                simbolo_tipo = "Entero";
                break;
            case REAL:
                simbolo_tipo = "Real";
                break;
            case CADENA:
                simbolo_tipo = "Cadena";
                break;
            case TIPO_FUNCION:
                simbolo_tipo = "TipoDato";
                break;
            case OP_ADICION:
                simbolo_tipo = "OpAdicion";
                break;
            case OP_MUL:
                simbolo_tipo = "OpMul";
                break;
            case OP_RELACIONAL:
                simbolo_tipo = "OpRelacional";
                break;
            case OP_OR:
                simbolo_tipo = "OpOr";
                break;
            case OP_AND:
                simbolo_tipo = "OpAnd";
                break;
            case OP_NOT:
                simbolo_tipo = "OpNot";
                break;
            case OP_IGUAL:
                simbolo_tipo = "OpComparacion";
                break;
            case PUNTOCOMA:
                simbolo_tipo = "PuntoComa";
                break;
            case COMA:
                simbolo_tipo = "Coma";
                break;
            case PARENTESIS_IZQ:
                simbolo_tipo = "ParentesisIzq";
                break;
            case PARENTESIS_DER:
                simbolo_tipo = "ParentesisDer";
                break;
            case LLAVE_IZQ:
                simbolo_tipo = "LlaveIzq";
                break;
            case LLAVE_DER:
                simbolo_tipo = "LlaveDer";
                break;
            case OP_ASIGNACION:
                simbolo_tipo = "OpAsignacion";
                break;
            case RES_IF:
                simbolo_tipo = "IF";
                break;
            case RES_WHILE:
                simbolo_tipo = "WHILE";
                break;
            case RES_RETURN:
                simbolo_tipo = "RETURN";
                break;
            case RES_ELSE:
                simbolo_tipo = "ELSE";
                break;
            case FIN:
                simbolo_tipo = "FIN";
                break;
            default:
                simbolo_tipo = "ERROR";
                break;
        }
        return simbolo_tipo;
    }

    // Método para obtener el siguiente símbolo del análisis léxico
    public int siguienteSimbolo() {
        estado = 0;
        continuar = true;
        simbolo = "";

        while (continuar) {
            if (simbolo_per)
                c = siguienteCaracter();
            simbolo_per = true;

            switch (estado) {
                case 0:
                    if (esLetra(c))
                        cambiarEstado(1);
                    else if (esDigito(c))
                        cambiarEstado(3);
                    else if (esAdicion(c))
                        aceptar(5);
                    else if (esMul(c))
                        aceptar(6);
                    else if (esMayorQue(c) || esMenorQue(c))
                        cambiarEstado(6);
                    else if (esOr(c))
                        cambiarEstado(7);
                    else if (esAnd(c))
                        cambiarEstado(8);
                    else if (esExclamacion(c))
                        cambiarEstado(9);
                    else if (esIgualQue(c))
                        cambiarEstado(10);
                    else if (esPuntoComa(c))
                        aceptar(12);
                    else if (esComa(c))
                        aceptar(13);
                    else if (esParentesisIzq(c))
                        aceptar(14);
                    else if (esParentesisDer(c))
                        aceptar(15);
                    else if (esLlaveIzq(c))
                        aceptar(16);
                    else if (esLlaveDer(c))
                        aceptar(17);
                    else if (esPesos(c))
                        aceptar(23);
                    else if (esEspacio(c))
                        cambiarEstado(0);
                    else if (esComillas(c))
                        cambiarEstado(11);
                    else
                        aceptar(-1);
                    break;

                case 1:
                    if (esLetra(c))
                        cambiarEstado(1);
                    else if (esDigito(c))
                        cambiarEstado(2);
                    else {
                        simbolo_per = false;
                        aceptar(revisarCadena());
                    }
                    break;

                case 2:
                    if (esLetra(c) || esDigito(c))
                        cambiarEstado(2);
                    else {
                        simbolo_per = false;
                        aceptar(0);
                    }
                    break;

                case 3:
                    if (esDigito(c))
                        cambiarEstado(3);
                    else if (esPunto(c))
                        cambiarEstado(4);
                    else {
                        simbolo_per = false;
                        aceptar(1);
                    }
                    break;

                case 4:
                    if (esDigito(c))
                        cambiarEstado(5);
                    else {
                        simbolo_per = false;
                        aceptar(-1);
                    }
                    break;

                case 5:
                    if (esDigito(c))
                        cambiarEstado(5);
                    else {
                        simbolo_per = false;
                        aceptar(2);
                    }
                    break;

                case 6:
                    if (esIgualQue(c))
                        aceptar(7);
                    else {
                        simbolo_per = false;
                        aceptar(7);
                    }
                    break;

                case 7:
                    if (esOr(c))
                        aceptar(8);
                    else {
                        simbolo_per = false;
                        aceptar(-1);
                    }
                    break;

                case 8:
                    if (esAnd(c))
                        aceptar(9);
                    else {
                        simbolo_per = false;
                        aceptar(-1);
                    }
                    break;

                case 9:
                    if (esIgualQue(c))
                        aceptar(11);
                    else {
                        simbolo_per = false;
                        aceptar(10);
                    }
                    break;

                case 10:
                    if (esIgualQue(c))
                        aceptar(11);
                    else {
                        simbolo_per = false;
                        aceptar(18);
                    }
                    break;

                case 11:
                    if (esComillas(c))
                        aceptar(3);
                    else if (c >= 0 && c <= 127) {
                        cambiarEstado(11);
                    }
                    break;

                default:
                    break;
            }
        }

        switch (estado) {
            case 0:
                tipo = IDENTIFICADOR;
                break;

            case 1:
                tipo = ENTERO;
                break;

            case 2:
                tipo = REAL;
                break;

            case 3:
                tipo = CADENA;
                break;

            case 4:
                tipo = TIPO_FUNCION;
                break;

            case 5:
                tipo = OP_ADICION;
                break;

            case 6:
                tipo = OP_MUL;
                break;

            case 7:
                tipo = OP_RELACIONAL;
                break;

            case 8:
                tipo = OP_OR;
                break;

            case 9:
                tipo = OP_AND;
                break;

            case 10:
                tipo = OP_NOT;
                break;

            case 11:
                tipo = OP_IGUAL;
                break;

            case 12:
                tipo = PUNTOCOMA;
                break;

            case 13:
                tipo = COMA;
                break;

            case 14:
                tipo = PARENTESIS_IZQ;
                break;

            case 15:
                tipo = PARENTESIS_DER;
                break;

            case 16:
                tipo = LLAVE_IZQ;
                break;

            case 17:
                tipo = LLAVE_DER;
                break;

            case 18:
                tipo = OP_ASIGNACION;
                break;

            case 19:
                tipo = RES_IF;
                break;

            case 20:
                tipo = RES_WHILE;
                break;

            case 21:
                tipo = RES_RETURN;
                break;

            case 22:
                tipo = RES_ELSE;
                break;

            case 23:
                tipo = FIN;
                break;

            default:
                tipo = ERROR;
        }

        return tipo;
    }

    // Método para verificar si la entrada ha terminado
    public boolean terminado() {
        return indice >= fuente.length();
    }

    // Método para obtener el siguiente caracter de la entrada
    public char siguienteCaracter() {
        char c = fuente.charAt(indice++);
        if (terminado())
            return '$';
        return c;
    }

    // Método para cambiar al siguiente estado del autómata
    public void cambiarEstado(int e) {
        estado = e;

        if (simbolo_per)
            simbolo += c;
    }

    // Método para procesar la aceptación de un estado
    public void aceptar(int e) {
        cambiarEstado(e);
        continuar = false;
    }

    // Método para retroceder en la entrada
    public void retroceder() {
        if (c != '$')
            indice--;
        continuar = false;
    }

    // Método para obtener el tipo académico de una cadena
    public int revisarCadena() {
        if (simbolo.equals("int") || simbolo.equals("float") || simbolo.equals("void"))
            return 4;
        else if (simbolo.equals("if"))
            return 19;
        else if (simbolo.equals("while"))
            return 20;
        else if (simbolo.equals("return"))
            return 21;
        else if (simbolo.equals("else"))
            return 22;
        else
            return 0;
    }

    // Métodos para verificar tipos de caracteres
    public boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }

    public boolean esDigito(char c) {
        return (c >= '1' && c <= '9') || c == '0';
    }

    public boolean esEspacio(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }

    public boolean esDosPuntos(char c) {
        return c == ':';
    }

    public boolean esPuntoComa(char c) {
        return c == ';';
    }

    public boolean esComa(char c) {
        return c == ',';
    }

    public boolean esAdicion(char c) {
        return c == '+' || c == '-';
    }

    public boolean esMul(char c) {
        return c == '*' || c == '/';
    }

    public boolean esParentesisIzq(char c) {
        return c == '(';
    }

    public boolean esParentesisDer(char c) {
        return c == ')';
    }

    public boolean esLlaveIzq(char c) {
        return c == '{';
    }

    public boolean esLlaveDer(char c) {
        return c == '}';
    }

    public boolean esPunto(char c) {
        return c == '.';
    }

    public boolean esMayorQue(char c) {
        return c == '>';
    }

    public boolean esMenorQue(char c) {
        return c == '<';
    }

    public boolean esIgualQue(char c) {
        return c == '=';
    }

    public boolean esExclamacion(char c) {
        return c == '!';
    }

    public boolean esOr(char c) {
        return c == '|';
    }

    public boolean esAnd(char c) {
        return c == '&';
    }

    public boolean esPesos(char c) {
        return c == '$';
    }

    public boolean esComillas(char c) {
        return c == '"';
    }
}
