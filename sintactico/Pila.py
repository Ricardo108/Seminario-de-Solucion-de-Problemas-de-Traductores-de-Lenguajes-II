
class Pila:
    def __init__(self):
        self.lista = []

    def push(self, x):
        self.lista.insert(0, x)

    def pop(self):
        x = self.lista[0]
        self.lista.pop(0)
        return x

    def top(self):
        return self.lista[0]

    def muestra(self):
        print("Pila: ", end="")
        for x in reversed(self.lista):
            x.muestra()
        print()


if __name__ == "__main__":
    
    pass






class ElementoPila:
    def __init__(self):
        self.simbolo = ""

    def muestra(self):
        pass

    def regresar(self):
        return "0"


class Terminal(ElementoPila):
    def __init__(self, simbolo):
        super().__init__()
        self.simbolo = simbolo

    def muestra(self):
        print(self.simbolo, end="")


class Noterminal(ElementoPila):
    def __init__(self, simbolo):
        super().__init__()
        self.simbolo = simbolo

    def muestra(self):
        print(self.simbolo, end="")


class Estado(ElementoPila):
    def __init__(self, simbolo):
        super().__init__()
        self.simbolo = simbolo

    def muestra(self):
        print(self.simbolo, end="")


class Pila:
    def __init__(self):
        self.lista = []

    def push(self, x):
        self.lista.insert(0, x)

    def top(self):
        return self.lista[0]

    def pop(self):
        x = self.lista[0]
        self.lista.pop(0)
        return x

    def muestra(self):
        print("Pila: ", end="")
        for x in reversed(self.lista):
            x.muestra()
        print()


if __name__ == "__main__":
    
    pass
