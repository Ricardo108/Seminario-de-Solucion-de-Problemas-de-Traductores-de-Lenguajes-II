class ElementoPila:
    def __init__(self, tipo, valor):
        self.tipo = tipo
        self.valor = valor

class Lexico:
    def __init__(self):
        self.entrada_str = ""
        self.simbolo = ""
        self.tipo = 0
        self.indice = 0

    def entrada(self, cadena):
        self.entrada_str = cadena
        self.simbolo = ""
        self.tipo = 0
        self.indice = 0

    def sigSimbolo(self):
        if self.indice < len(self.entrada_str):
            self.simbolo = self.entrada_str[self.indice]

            # Lógica para determinar el tipo del símbolo
            if self.simbolo.isalpha():
                self.tipo = 1  # Letra
            elif self.simbolo.isdigit():
                self.tipo = 2  # Dígito
            elif self.simbolo in ['+', '-', '*', '/']:
                self.tipo = 3  # Operador
            else:
                self.tipo = 4  # Otro

            self.indice += 1
        else:
            self.simbolo = "$"
            self.tipo = 0

    def muestra(self):
        print(f"Símbolo: {self.simbolo}, Tipo: {self.tipo}")




class Pila:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def top(self):
        return self.items[-1]

    def muestra(self):
        for item in self.items:
            print(f"{item.tipo}: {item.valor}", end=" ")
        print()


class Terminal(ElementoPila):
    def __init__(self, valor):
        super().__init__("Terminal", valor)


class Estado(ElementoPila):
    def __init__(self, valor):
        super().__init__("Estado", valor)


class Noterminal(ElementoPila):
    def __init__(self, valor):
        super().__init__("NoTerminal", valor)


tablaR1 = [
    [2, 0, 0, 1],
    [0, 0, -1, 0],
    [0, 3, 0, 0],
    [4, 0, 0, 0],
    [0, 0, -2, 0]
]

tablaR2 = [
    [2, 0, 0, 1],
    [0, 0, -1, 0],
    [0, 3, -3, 0],
    [2, 0, 0, 4],
    [0, 0, -2, 0]
]

pila = Pila()
memory = Pila()
contadorinterno = 0
lexico = Lexico()
simbolo = []
tipo = []
fila, columna, accion = 0, 0, 0
aceptacion = False
entrada1 = "hola+mundo"
entrada2 = "a+b+c+d+e+f"


def r1(c):
    global contadorinterno, fila, columna, accion, aceptacion
    contadorinterno = 0

    pila = Pila()
    simbolo = None

    lexico.entrada(entrada1)

    pila.push(Terminal("$"))
    pila.push(Estado("0"))

    lexico.sigSimbolo()

    simbolo = pila.top()
    fila = int(simbolo.valor)
    columna = lexico.tipo
    accion = tablaR1[fila][columna]

    pila.muestra()
    print("entrada:", lexico.simbolo)

    while contadorinterno != 3:
        pila.push(Terminal(lexico.simbolo))
        pila.push(Estado(str(accion)))
        lexico.sigSimbolo()

        simbolo = pila.top()
        fila = int(simbolo.valor)
        columna = lexico.tipo
        accion = tablaR1[fila][columna]

        pila.muestra()
        print("entrada:", lexico.simbolo)
        print("accion:", accion)

        contadorinterno += 1

    if accion < 0:
        for _ in range(6):
            pila.pop()

    if accion == 0:
        print("Error")
    else:
        pila.muestra()
        simbolo = pila.top()
        fila = int(simbolo.valor)
        columna = 3
        accion = tablaR1[fila][columna]

        pila.push(Noterminal("E"))
        pila.push(Estado(str(accion)))
        pila.muestra()

        print("entrada:", lexico.simbolo)
        print("accion:", accion)

        simbolo = pila.top()
        fila = int(simbolo.valor)
        columna = lexico.tipo
        accion = tablaR1[fila][columna]

    pila.muestra()
    print("entrada:", lexico.simbolo)
    print("accion:", accion)

    aceptacion = accion == -1
    if aceptacion:
        print("Aceptacion")


def r2(c):
    global contadorinterno, fila, columna, accion, aceptacion
    contadorinterno = 0

    pila = Pila()
    simbolo = None

    lexico.entrada(entrada2)

    pila.push(Terminal("$"))
    pila.push(Estado("0"))

    lexico.sigSimbolo()

    simbolo = pila.top()
    fila = int(simbolo.valor)
    columna = lexico.tipo
    accion = tablaR2[fila][columna]

    pila.muestra()
    print("entrada:", lexico.simbolo)
    print("accion:", accion)

    while contadorinterno != 16:
        if accion > 0:
            pila.push(Terminal(lexico.simbolo))
            pila.push(Estado(str(accion)))
            lexico.sigSimbolo()

            simbolo = pila.top()
            fila = int(simbolo.valor)
            columna = lexico.tipo
            accion = tablaR2[fila][columna]

            pila.muestra()
            print("entrada:", lexico.simbolo)
            print("accion:", accion)

        if accion < 0:
            if accion == -3:
                pila.pop()
                pila.pop()

                simbolo = pila.top()
                fila = int(simbolo.valor)
                columna = 3

                accion = tablaR2[fila][columna]
                pila.push(Noterminal("E"))
                pila.push(Estado(str(accion)))

                pila.muestra()
                print("entrada:", lexico.simbolo)
                print("accion:", accion)

            elif accion == -2:
                pila.pop()
                pila.pop()

                simbolo = pila.top()
                fila = int(simbolo.valor)
                columna = 3

                accion = tablaR2[fila][columna]
                pila.push(Noterminal("E"))
                pila.push(Estado(str(accion)))

                pila.muestra()
                print("entrada:", lexico.simbolo)
                print("accion:", accion)

            elif accion == 4:
                while accion == 4:
                    for _ in range(6):
                        pila.pop()

                    simbolo = pila.top()
                    fila = int(simbolo.valor)
                    columna = 3
                    accion = tablaR2[fila][columna]

                    pila.push(Noterminal("E"))
                    pila.push(Estado(str(accion)))

                    pila.muestra()
                    print("entrada:", lexico.simbolo)
                    print("accion:", accion)

    aceptacion = accion == -1
    if aceptacion:
        print("Aceptacion")


if __name__ == "__main__":
    r1(entrada1)
    r2(entrada2)
