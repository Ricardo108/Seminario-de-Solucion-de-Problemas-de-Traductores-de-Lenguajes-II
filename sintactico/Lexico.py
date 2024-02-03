class Lexico:
    def __init__(self, e=None):
        self.indice = 0
        self.simbolo_per = True
        self.fuente = e if e else ""
        self.estado = 0
        self.continuar = True
        self.simbolo = ""
        self.tipo = 0
        self.c = ''

    def entrada(self, e):
        self.indice = 0
        self.fuente = e

    def tipo_acad(self, tipo):
        simbolo_tipo = ""
        if tipo == 0:
            simbolo_tipo = "ID"
        elif tipo == 1:
            simbolo_tipo = "Entero"
        elif tipo == 2:
            simbolo_tipo = "Real"
        elif tipo == 3:
            simbolo_tipo = "Cadena"
        elif tipo == 4:
            simbolo_tipo = "TipoDato"
        elif tipo == 5:
            simbolo_tipo = "OpAdicion"
        elif tipo == 6:
            simbolo_tipo = "OpMul"
        elif tipo == 7:
            simbolo_tipo = "OpRelacional"
        elif tipo == 8:
            simbolo_tipo = "OpOr"
        elif tipo == 9:
            simbolo_tipo = "OpAnd"
        elif tipo == 10:
            simbolo_tipo = "OpNot"
        elif tipo == 11:
            simbolo_tipo = "OpComparacion"
        elif tipo == 12:
            simbolo_tipo = "PuntoComa"
        elif tipo == 13:
            simbolo_tipo = "Coma"
        elif tipo == 14:
            simbolo_tipo = "ParentesisIzq"
        elif tipo == 15:
            simbolo_tipo = "ParentesisDer"
        elif tipo == 16:
            simbolo_tipo = "LlaveIzq"
        elif tipo == 17:
            simbolo_tipo = "LlaveDer"
        elif tipo == 18:
            simbolo_tipo = "OpAsignacion"
        elif tipo == 19:
            simbolo_tipo = "IF"
        elif tipo == 20:
            simbolo_tipo = "WHILE"
        elif tipo == 21:
            simbolo_tipo = "RETURN"
        elif tipo == 22:
            simbolo_tipo = "ELSE"
        elif tipo == 23:
            simbolo_tipo = "FIN"
        else:
            simbolo_tipo = "ERROR"
        return simbolo_tipo

    def sig_simbolo(self):
        self.estado = 0
        self.continuar = True
        self.simbolo = ""

        while self.continuar:
            if self.simbolo_per:
                self.c = self.sig_caracter()
            self.simbolo_per = True

            if self.estado == 0:
                if self.es_letra(self.c):
                    self.sig_estado(1)
                elif self.es_digito(self.c):
                    self.sig_estado(3)
                elif self.es_adicion(self.c):
                    self.aceptacion(5)
                elif self.es_mul(self.c):
                    self.aceptacion(6)
                elif self.es_mayor_que(self.c) or self.es_menor_que(self.c):
                    self.sig_estado(6)
                elif self.es_or(self.c):
                    self.sig_estado(7)
                elif self.es_and(self.c):
                    self.sig_estado(8)
                elif self.es_exclamacion(self.c):
                    self.sig_estado(9)
                elif self.es_igual_que(self.c):
                    self.sig_estado(10)
                elif self.es_punto_coma(self.c):
                    self.aceptacion(12)
                elif self.es_coma(self.c):
                    self.aceptacion(13)
                elif self.es_parentesis_izq(self.c):
                    self.aceptacion(14)
                elif self.es_parentesis_der(self.c):
                    self.aceptacion(15)
                elif self.es_llave_izq(self.c):
                    self.aceptacion(16)
                elif self.es_llave_der(self.c):
                    self.aceptacion(17)
                elif self.es_pesos(self.c):
                    self.aceptacion(23)
                elif self.es_espacio(self.c):
                    self.sig_estado(0)
                elif self.es_comillas(self.c):
                    self.sig_estado(11)
                else:
                    self.aceptacion(-1)

            elif self.estado == 1:
                if self.es_letra(self.c):
                    self.sig_estado(1)
                elif self.es_digito(self.c):
                    self.sig_estado(2)
                else:
                    self.simbolo_per = False
                    self.aceptacion(self.rev_cadena())

            elif self.estado == 2:
                if self.es_letra(self.c) or self.es_digito(self.c):
                    self.sig_estado(2)
                else:
                    self.simbolo_per = False
                    self.aceptacion(0)

            elif self.estado == 3:
                if self.es_digito(self.c):
                    self.sig_estado(3)
                elif self.es_punto(self.c):
                    self.sig_estado(4)
                else:
                    self.simbolo_per = False
                    self.aceptacion(1)

            elif self.estado == 4:
                if self.es_digito(self.c):
                    self.sig_estado(5)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 5:
                if self.es_digito(self.c):
                    self.sig_estado(5)
                else:
                    self.simbolo_per = False
                    self.aceptacion(2)

            elif self.estado == 6:
                if self.es_igual_que(self.c):
                    self.aceptacion(7)
                else:
                    self.simbolo_per = False
                    self.aceptacion(7)

            elif self.estado == 7:
                if self.es_or(self.c):
                    self.aceptacion(8)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 8:
                if self.es_and(self.c):
                    self.aceptacion(9)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 9:
                if self.es_igual_que(self.c):
                    self.aceptacion(11)
                else:
                    self.simbolo_per = False
                    self.aceptacion(10)

            elif self.estado == 10:
                if self.es_igual_que(self.c):
                    self.aceptacion(11)
                else:
                    self.simbolo_per = False
                    self.aceptacion(18)

            elif self.estado == 11:
                if self.es_comillas(self.c):
                    self.aceptacion(3)
                elif self.isascii(self.c):
                    self.sig_estado(11)

        tipo = 0
        if self.estado == 0:
            tipo = 0
        elif self.estado == 1:
            tipo = 1
        elif self.estado == 2:
            tipo = 2
        elif self.estado == 3:
            tipo = 3
        elif self.estado == 4:
            tipo = 4
        elif self.estado == 5:
            tipo = 5
        elif self.estado == 6:
            tipo = 6
        elif self.estado == 7:
            tipo = 7
        elif self.estado == 8:
            tipo = 8
        elif self.estado == 9:
            tipo = 9
        elif self.estado == 10:
            tipo = 10
        elif self.estado == 11:
            tipo = 11
        elif self.estado == 12:
            tipo = 12
        elif self.estado == 13:
            tipo = 13
        elif self.estado == 14:
            tipo = 14
        elif self.estado == 15:
            tipo = 15
        elif self.estado == 16:
            tipo = 16
        elif self.estado == 17:
            tipo = 17
        elif self.estado == 18:
            tipo = 18
        elif self.estado == 19:
            tipo = 19
        elif self.estado == 20:
            tipo = 20
        elif self.estado == 21:
            tipo = 21
        elif self.estado == 22:
            tipo = 22
        elif self.estado == 23:
            tipo = 23
        else:
            tipo = -1

        return tipo

    def terminado(self):
        return self.indice >= len(self.fuente)

    def sig_caracter(self):
        c = self.fuente[self.indice]
        self.indice += 1
        if self.terminado():
            return '$'
        return c

    def sig_estado(self, e):
        self.estado = e

        if self.simbolo_per:
            self.simbolo += self.c

    def aceptacion(self, e):
        self.sig_estado(e)
        self.continuar = False

    def retroceso(self):
        if self.c != '$':
            self.indice -= 1
        self.continuar = False

    def rev_cadena(self):
        if self.simbolo == "int" or self.simbolo == "float" or self.simbolo == "void":
            return 4
        elif self.simbolo == "if":
            return 19
        elif self.simbolo == "while":
            return 20
        elif self.simbolo == "return":
            return 21
        elif self.simbolo == "else":
            return 22
        else:
            return 0

    def es_letra(self, c):
        return c.isalpha() or c == '_'

    def es_digito(self, c):
        return c.isdigit()

    def es_espacio(self, c):
        return c == ' ' or c == '\t' or c == '\n'

    def es_dos_puntos(self, c):
        return c == ':'

    def es_punto_coma(self, c):
        return c == ';'

    def es_coma(self, c):
        return c == ','

    def es_adicion(self, c):
        return c == '+' or c == '-'

    def es_mul(self, c):
        return c == '*' or c == '/'

    def es_parentesis_izq(self, c):
        return c == '('

    def es_parentesis_der(self, c):
        return c == ')'

    def es_llave_izq(self, c):
        return c == '{'

    def es_llave_der(self, c):
        return c == '}'

    def es_punto(self, c):
        return c == '.'

    def es_mayor_que(self, c):
        return c == '>'

    def es_menor_que(self, c):
        return c == '<'

    def es_igual_que(self, c):
        return c == '='

    def es_exclamacion(self, c):
        return c == '!'

    def es_or(self, c):
        return c == '|'

    def es_and(self, c):
        return c == '&'

    def es_pesos(self, c):
        return c == '$'

    def es_comillas(self, c):
        return c == '"'





class Lexico:
    ERROR = -1
    IDENTIFICADOR = 0
    ENTERO = 1
    REAL = 2
    CADENA = 3
    TIPO_FUNCION = 4
    OP_ADICION = 5
    OP_MUL = 6
    OP_RELACIONAL = 7
    OP_OR = 8
    OP_AND = 9
    OP_NOT = 10
    OP_IGUAL = 11
    PUNTOCOMA = 12
    COMA = 13
    PARENTESIS_IZQ = 14
    PARENTESIS_DER = 15
    LLAVE_IZQ = 16
    LLAVE_DER = 17
    OP_ASIGNACION = 18
    RES_IF = 19
    RES_WHILE = 20
    RES_RETURN = 21
    RES_ELSE = 22
    FIN = 23

    def __init__(self, e=None):
        self.simbolo = ""
        self.tipo = 0
        self.fuente = e if e else ""
        self.indice = 0
        self.continuar = True
        self.simbolo_per = True
        self.c = ""
        self.estado = 0

    def entrada(self, e):
        self.indice = 0
        self.fuente = e

    def tipo_acad(self, tipo):
        if tipo == 0:
            return "ID"
        elif tipo == 1:
            return "Entero"
        elif tipo == 2:
            return "Real"
        elif tipo == 3:
            return "Cadena"
        elif tipo == 4:
            return "TipoDato"
        elif tipo == 5:
            return "OpAdicion"
        elif tipo == 6:
            return "OpMul"
        elif tipo == 7:
            return "OpRelacional"
        elif tipo == 8:
            return "OpOr"
        elif tipo == 9:
            return "OpAnd"
        elif tipo == 10:
            return "OpNot"
        elif tipo == 11:
            return "OpComparacion"
        elif tipo == 12:
            return "PuntoComa"
        elif tipo == 13:
            return "Coma"
        elif tipo == 14:
            return "ParentesisIzq"
        elif tipo == 15:
            return "ParentesisDer"
        elif tipo == 16:
            return "LlaveIzq"
        elif tipo == 17:
            return "LlaveDer"
        elif tipo == 18:
            return "OpAsignacion"
        elif tipo == 19:
            return "IF"
        elif tipo == 20:
            return "WHILE"
        elif tipo == 21:
            return "RETURN"
        elif tipo == 22:
            return "ELSE"
        elif tipo == 23:
            return "FIN"
        else:
            return "ERROR"

    def sig_simbolo(self):
        self.estado = 0
        self.continuar = True
        self.simbolo = ""

        while self.continuar:
            if self.simbolo_per:
                self.c = self.sig_caracter()
            self.simbolo_per = True

            if self.estado == 0:
                if self.es_letra(self.c):
                    self.sig_estado(1)
                elif self.es_digito(self.c):
                    self.sig_estado(3)
                elif self.es_adicion(self.c):
                    self.aceptacion(5)
                elif self.es_mul(self.c):
                    self.aceptacion(6)
                elif self.es_mayor_que(self.c) or self.es_menor_que(self.c):
                    self.sig_estado(6)
                elif self.es_or(self.c):
                    self.sig_estado(7)
                elif self.es_and(self.c):
                    self.sig_estado(8)
                elif self.es_exclamacion(self.c):
                    self.sig_estado(9)
                elif self.es_igual_que(self.c):
                    self.sig_estado(10)
                elif self.es_punto_coma(self.c):
                    self.aceptacion(12)
                elif self.es_coma(self.c):
                    self.aceptacion(13)
                elif self.es_parentesis_izq(self.c):
                    self.aceptacion(14)
                elif self.es_parentesis_der(self.c):
                    self.aceptacion(15)
                elif self.es_llave_izq(self.c):
                    self.aceptacion(16)
                elif self.es_llave_der(self.c):
                    self.aceptacion(17)
                elif self.es_pesos(self.c):
                    self.aceptacion(23)
                elif self.es_espacio(self.c):
                    self.sig_estado(0)
                elif self.es_comillas(self.c):
                    self.sig_estado(11)
                else:
                    self.aceptacion(-1)

            elif self.estado == 1:
                if self.es_letra(self.c):
                    self.sig_estado(1)
                elif self.es_digito(self.c):
                    self.sig_estado(2)
                else:
                    self.simbolo_per = False
                    self.aceptacion(self.rev_cadena())

            elif self.estado == 2:
                if self.es_letra(self.c) or self.es_digito(self.c):
                    self.sig_estado(2)
                else:
                    self.simbolo_per = False
                    self.aceptacion(0)

            elif self.estado == 3:
                if self.es_digito(self.c):
                    self.sig_estado(3)
                elif self.es_punto(self.c):
                    self.sig_estado(4)
                else:
                    self.simbolo_per = False
                    self.aceptacion(1)

            elif self.estado == 4:
                if self.es_digito(self.c):
                    self.sig_estado(5)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 5:
                if self.es_digito(self.c):
                    self.sig_estado(5)
                else:
                    self.simbolo_per = False
                    self.aceptacion(2)

            elif self.estado == 6:
                if self.es_igual_que(self.c):
                    self.aceptacion(7)
                else:
                    self.simbolo_per = False
                    self.aceptacion(7)

            elif self.estado == 7:
                if self.es_or(self.c):
                    self.aceptacion(8)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 8:
                if self.es_and(self.c):
                    self.aceptacion(9)
                else:
                    self.simbolo_per = False
                    self.aceptacion(-1)

            elif self.estado == 9:
                if self.es_igual_que(self.c):
                    self.aceptacion(11)
                else:
                    self.simbolo_per = False
                    self.aceptacion(10)

            elif self.estado == 10:
                if self.es_igual_que(self.c):
                    self.aceptacion(11)
                else:
                    self.simbolo_per = False
                    self.aceptacion(18)

            elif self.estado == 11:
                if self.es_comillas(self.c):
                    self.aceptacion(3)
                elif self.isascii(self.c):
                    self.sig_estado(11)

        tipo = 0
        if self.estado == 0:
            tipo = self.IDENTIFICADOR
        elif self.estado == 1:
            tipo = self.ENTERO
        elif self.estado == 2:
            tipo = self.REAL
        elif self.estado == 3:
            tipo = self.CADENA
        elif self.estado == 4:
            tipo = self.TIPO_FUNCION
        elif self.estado == 5:
            tipo = self.OP_ADICION
        elif self.estado == 6:
            tipo = self.OP_MUL
        elif self.estado == 7:
            tipo = self.OP_RELACIONAL
        elif self.estado == 8:
            tipo = self.OP_OR
        elif self.estado == 9:
            tipo = self.OP_AND
        elif self.estado == 10:
            tipo = self.OP_NOT
        elif self.estado == 11:
            tipo = self.OP_IGUAL
        elif self.estado == 12:
            tipo = self.PUNTOCOMA
        elif self.estado == 13:
            tipo = self.COMA
        elif self.estado == 14:
            tipo = self.PARENTESIS_IZQ
        elif self.estado == 15:
            tipo = self.PARENTESIS_DER
        elif self.estado == 16:
            tipo = self.LLAVE_IZQ
        elif self.estado == 17:
            tipo = self.LLAVE_DER
        elif self.estado == 18:
            tipo = self.OP_ASIGNACION
        elif self.estado == 19:
            tipo = self.RES_IF
        elif self.estado == 20:
            tipo = self.RES_WHILE
        elif self.estado == 21:
            tipo = self.RES_RETURN
        elif self.estado == 22:
            tipo = self.RES_ELSE
        elif self.estado == 23:
            tipo = self.FIN
        else:
            tipo = self.ERROR

        return tipo

    def terminado(self):
        return self.indice >= len(self.fuente)

    def sig_caracter(self):
        c = self.fuente[self.indice]
        self.indice += 1
        if self.terminado():
            return '$'
        return c

    def sig_estado(self, e):
        self.estado = e

        if self.simbolo_per:
            self.simbolo += self.c

    def aceptacion(self, e):
        self.sig_estado(e)
        self.continuar = False

    def retroceso(self):
        if self.c != '$':
            self.indice -= 1
        self.continuar = False

    def rev_cadena(self):
        if self.simbolo == "int" or self.simbolo == "float" or self.simbolo == "void":
            return 4
        elif self.simbolo == "if":
            return 19
        elif self.simbolo == "while":
            return 20
        elif self.simbolo == "return":
            return 21
        elif self.simbolo == "else":
            return 22
        else:
            return 0

    def es_letra(self, c):
        return c.isalpha() or c == '_'

    def es_digito(self, c):
        return c.isdigit()

    def es_espacio(self, c):
        return c == ' ' or c == '\t' or c == '\n'

    def es_dos_puntos(self, c):
        return c == ':'

    def es_punto_coma(self, c):
        return c == ';'

    def es_coma(self, c):
        return c == ','

    def es_adicion(self, c):
        return c == '+' or c == '-'

    def es_mul(self, c):
        return c == '*' or c == '/'

    def es_parentesis_izq(self, c):
        return c == '('

    def es_parentesis_der(self, c):
        return c == ')'

    def es_llave_izq(self, c):
        return c == '{'

    def es_llave_der(self, c):
        return c == '}'

    def es_punto(self, c):
        return c == '.'

    def es_mayor_que(self, c):
        return c == '>'

    def es_menor_que(self, c):
        return c == '<'

    def es_igual_que(self, c):
        return c == '='

    def es_exclamacion(self, c):
        return c == '!'

    def es_or(self, c):
        return c == '|'

    def es_and(self, c):
        return c == '&'

    def es_pesos(self, c):
        return c == '$'

    def es_comillas(self, c):
        return c == '"'
