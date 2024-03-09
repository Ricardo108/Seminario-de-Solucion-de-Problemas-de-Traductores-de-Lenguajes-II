public class Lexico {
    private int ind;
    private String fuente;
    private String c;
    public String simbolo;
    private int estado;
    private boolean continua;
    public int tipo;

    public Lexico(String fuente) {
        this.ind = 0;
        this.fuente = fuente;
    }

    public Lexico() {
        this.ind = 0;
    }

    public int getTipo() {
    return tipo;
    }

    public String tipoAcad(int tipo) {
        String cad = "";

        switch (tipo) {
            case TipoSimbolo.IDENTIFICADOR:
                cad = "Identificador";
                break;
            case TipoSimbolo.OPADIC:
                cad = "Op. Adicion";
                break;
            case TipoSimbolo.OPMULT:
                cad = "Op. Multiplicacion";
                break;
            case TipoSimbolo.PESOS:
                cad = "Fin de la Entrada";
                break;
            case TipoSimbolo.ENTERO:
                cad = "Entero";
                break;
            case TipoSimbolo.REAL:
                cad = "Real";
                break;
            case TipoSimbolo.OPRELAC:
                cad = "Op. Relacional";
                break;
            case TipoSimbolo.OPOR:
                cad = "Op. Or";
                break;
            case TipoSimbolo.OPAND:
                cad = "Op. And";
                break;
            case TipoSimbolo.OPNOT:
                cad = "Op. Not";
                break;
            case TipoSimbolo.OPIGUALDAD:
                cad = "Op. Igualdad";
                break;
            case TipoSimbolo.PUNTOYCOMA:
                cad = "Punto y coma";
                break;
            case TipoSimbolo.COMA:
                cad = "Coma";
                break;
            case TipoSimbolo.PARENABI:
                cad = "Parentesis abierto";
                break;
            case TipoSimbolo.PARENCER:
                cad = "Parentesis cerrado";
                break;
            case TipoSimbolo.CORCHETEABI:
                cad = "Corchete abierto";
                break;
            case TipoSimbolo.CORCHETECER:
                cad = "Corchete cerrado";
                break;
            case TipoSimbolo.IGUAL:
                cad = "Igual";
                break;
            case TipoSimbolo.IF:
                cad = "If";
                break;
            case TipoSimbolo.WHILE:
                cad = "While";
                break;
            case TipoSimbolo.RETURN:
                cad = "Return";
                break;
            case TipoSimbolo.ELSE:
                cad = "Else";
                break;
            case TipoSimbolo.CADENA:
                cad = "Cadena";
                break;
            case TipoSimbolo.TIPO:
                cad = "Tipo";
                break;
            case TipoSimbolo.ESPACIO:
                cad = "Espacio";
                break;
        }
        return cad;
    }

    public void entrada(String fuente) {
        ind = 0;
        this.fuente = fuente;
    }

    public int sigSimbolo() {
        estado = 0;
        continua = true;
        simbolo = "";
        boolean entero = true;
        boolean reales = true;
        boolean cadena = false;

        while (continua) {
            c = sigCaracter();
            int longitud = c.length();

            switch (estado) {
                case 0:
                    if (c.equals("+") || c.equals("-")) {
                        aceptacion(2);
                        break;
                    } else if (c.equals("*") || c.equals("/")) {
                        aceptacion(5);
                        break;
                    } else if (c.equals("<") || c.equals("<=") || c.equals(">") || c.equals(">=")) {
                        aceptacion(7);
                        break;
                    } else if (c.equals("||")) {
                        aceptacion(8);
                        break;
                    } else if (c.equals("&&")) {
                        aceptacion(9);
                        break;
                    } else if (c.equals("!")) {
                        aceptacion(10);
                        break;
                    } else if (c.equals("!=") || c.equals("==")) {
                        aceptacion(11);
                        break;
                    } else if (c.equals(";")) {
                        aceptacion(12);
                        break;
                    } else if (c.equals(",")) {
                        aceptacion(13);
                        break;
                    } else if (c.equals("(")) {
                        aceptacion(14);
                        break;
                    } else if (c.equals(")")) {
                        aceptacion(15);
                        break;
                    } else if (c.equals("{")) {
                        aceptacion(16);
                        break;
                    } else if (c.equals("}")) {
                        aceptacion(17);
                        break;
                    } else if (c.equals("=")) {
                        aceptacion(18);
                        break;
                    } else if (c.equals("if")) {
                        aceptacion(19);
                        break;
                    } else if (c.equals("while")) {
                        aceptacion(20);
                        break;
                    } else if (c.equals("return")) {
                        aceptacion(21);
                        break;
                    } else if (c.equals("else")) {
                        aceptacion(22);
                        break;
                    } else if (c.equals("int") || c.equals("float") || c.equals("void") || c.equals("char")) {
                        aceptacion(24);
                        break;
                    } else if (c.equals("programa")) {
                        aceptacion(27);
                        break;
                    } else if (c.equals("ListaVar")) {
                        aceptacion(26);
                        break;
                    } else if (c.equals("Definiciones")) {
                        aceptacion(28);
                        break;
                    } else if (c.equals("Definicion")) {
                        aceptacion(29);
                        break;
                    } else if (c.equals("DefVar")) {
                        aceptacion(30);
                        break;
                    } else if (c.equals("DefFunc")) {
                        aceptacion(31);
                        break;
                    } else if (c.equals("Parametros")) {
                        aceptacion(32);
                        break;
                    } else if (c.equals("ListaParam")) {
                        aceptacion(33);
                        break;
                    } else if (c.equals("BloqFunc")) {
                        aceptacion(34);
                        break;
                    } else if (c.equals("DefLocales")) {
                        aceptacion(35);
                        break;
                    } else if (c.equals("DefLocal")) {
                        aceptacion(36);
                        break;
                    } else if (c.equals("Sentencias")) {
                        aceptacion(37);
                        break;
                    } else if (c.equals("Sentencia")) {
                        aceptacion(38);
                        break;
                    } else if (c.equals("Otro")) {
                        aceptacion(39);
                        break;
                    } else if (c.equals("Bloque")) {
                        aceptacion(40);
                        break;
                    } else if (c.equals("ValorRegresa")) {
                        aceptacion(41);
                        break;
                    } else if (c.equals("Argumentos")) {
                        aceptacion(42);
                        break;
                    } else if (c.equals("ListaArgumentos")) {
                        aceptacion(43);
                        break;
                    } else if (c.equals("Termino")) {
                        aceptacion(44);
                        break;
                    } else if (c.equals("LlamadaFunc")) {
                        aceptacion(45);
                        break;
                    } else if (c.equals("SentenciaBloque")) {
                        aceptacion(46);
                        break;
                    } else if (c.equals("Expresion")) {
                        aceptacion(47);
                        break;
                    } else if (c.equals("$")) {
                        aceptacion(3);
                        break;
                    } else if (c.equals(" ") || c.equals("\t")) {
                        aceptacion(25);
                        break;
                    }

                    for (int i = 0; i < longitud; i++) {
                        boolean x = Character.isDigit(c.charAt(i));
                        if (x == false && c.charAt(i) != '-') {
                            entero = false;
                        }
                        if (x == false && c.charAt(i) != '.' && c.charAt(i) != '-') {
                            reales = false;
                        }
                        if (x == false && c.charAt(i) == '\"') {
                            cadena = true;
                        }
                    }

                    if (entero == true) {
                        aceptacion(4);
                        break;
                    } else if (reales == true) {
                        aceptacion(6);
                        break;
                    } else if (cadena == true) {
                        aceptacion(23);
                        break;
                    } else {
                        aceptacion(1);
                        break;
                    }
            }
        }

        switch (estado) {
            case 1:
                tipo = TipoSimbolo.IDENTIFICADOR;
                break;
            case 2:
                tipo = TipoSimbolo.OPADIC;
                break;
            case 3:
                tipo = TipoSimbolo.PESOS;
                break;
            case 4:
                tipo = TipoSimbolo.ENTERO;
                break;
            case 5:
                tipo = TipoSimbolo.OPMULT;
                break;
            case 6:
                tipo = TipoSimbolo.REAL;
                break;
            case 7:
                tipo = TipoSimbolo.OPRELAC;
                break;
            case 8:
                tipo = TipoSimbolo.OPOR;
                break;
            case 9:
                tipo = TipoSimbolo.OPAND;
                break;
            case 10:
                tipo = TipoSimbolo.OPNOT;
                break;
            case 11:
                tipo = TipoSimbolo.OPIGUALDAD;
                break;
            case 12:
                tipo = TipoSimbolo.PUNTOYCOMA;
                break;
            case 13:
                tipo = TipoSimbolo.COMA;
                break;
            case 14:
                tipo = TipoSimbolo.PARENABI;
                break;
            case 15:
                tipo = TipoSimbolo.PARENCER;
                break;
            case 16:
                tipo = TipoSimbolo.CORCHETEABI;
                break;
            case 17:
                tipo = TipoSimbolo.CORCHETECER;
                break;
            case 18:
                tipo = TipoSimbolo.IGUAL;
                break;
            case 19:
                tipo = TipoSimbolo.IF;
                break;
            case 20:
                tipo = TipoSimbolo.WHILE;
                break;
            case 21:
                tipo = TipoSimbolo.RETURN;
                break;
            case 22:
                tipo = TipoSimbolo.ELSE;
                break;
            case 23:
                tipo = TipoSimbolo.CADENA;
                break;
            case 24:
                tipo = TipoSimbolo.TIPO;
                break;
            case 26:
                tipo = TipoSimbolo.LISTAVAR;
                break;
            case 27:
                tipo = TipoSimbolo.PROGRAMA;
                break;
            case 28:
                tipo = TipoSimbolo.DEFINICIONES;
                break;
            case 29:
                tipo = TipoSimbolo.DEFINICION;
                break;
            case 30:
                tipo = TipoSimbolo.DEFVAR;
                break;
            case 31:
                tipo = TipoSimbolo.DEFFUNC;
                break;
            case 32:
                tipo = TipoSimbolo.PARAMETROS;
                break;
            case 33:
                tipo = TipoSimbolo.LISTAPARAM;
                break;
            case 34:
                tipo = TipoSimbolo.BLOQFUNC;
                break;
            case 35:
                tipo = TipoSimbolo.DEFLOCALES;
                break;
            case 36:
                tipo = TipoSimbolo.DEFLOCAL;
                break;
            case 37:
                tipo = TipoSimbolo.SENTENCIAS;
                break;
            case 38:
                tipo = TipoSimbolo.SENTENCIA;
                break;
            case 39:
                tipo = TipoSimbolo.OTRO;
                break;
            case 40:
                tipo = TipoSimbolo.BLOQUE;
                break;
            case 41:
                tipo = TipoSimbolo.VALORREGRESA;
                break;
            case 42:
                tipo = TipoSimbolo.ARGUMENTOS;
                break;
            case 43:
                tipo = TipoSimbolo.LISTAARGUMENTOS;
                break;
            case 44:
                tipo = TipoSimbolo.TERMINO;
                break;
            case 45:
                tipo = TipoSimbolo.LLAMADAFUNC;
                break;
            case 46:
                tipo = TipoSimbolo.SENTENCIABLOQUE;
                break;
            case 47:
                tipo = TipoSimbolo.EXPRESION;
                break;
            default:
                tipo = TipoSimbolo.ERROR;
        }

        return tipo;
    }

    private String sigCaracter() {
        String palabra;
        if (terminado()) {
            return "$";
        }

        if (fuente.charAt(ind) == '$') {
            return "$";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (fuente.charAt(ind) != ' ') {
                stringBuilder.append(fuente.charAt(ind));
                ind++;
            }
            if (fuente.charAt(ind) == ' ') {
                ind++;
            }
            palabra = stringBuilder.toString();
            return palabra;
        }
    }

    private void sigEstado(int estado) {
        this.estado = estado;
        simbolo += c;
    }

    private void aceptacion(int estado) {
        sigEstado(estado);
        continua = false;
    }

    private boolean terminado() {
        return ind >= fuente.length();
    }
}
