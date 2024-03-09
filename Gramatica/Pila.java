import java.util.LinkedList;
import java.util.List;

class ElementoPila {
    protected int valor;

    public void muestra() {
    }

    public void muestra2() {
    }

    public int numero() {
        return 0;
    }
}

class Terminal extends ElementoPila {
    protected String literal;

    public Terminal(int valor, String literal) {
        this.valor = valor;
        this.literal = literal;
    }

    public void muestra() {
        System.out.println("Terminal");
        System.out.println("valor: " + valor);
        System.out.println("Literal: " + literal + "\n");
    }

    public void muestra2() {
        System.out.print("Ter-");
    }

    public int numero() {
        return valor;
    }
}

class NoTerminal extends ElementoPila {
    protected String literal;

    public NoTerminal(int valor, String literal) {
        this.valor = valor;
        this.literal = literal;
    }

    public void muestra() {
        System.out.println("NoTerminal");
        System.out.println("valor: " + valor);
        System.out.println("Literal: " + literal + "\n");
    }

    public void muestra2() {
        System.out.print("NoTer-");
    }

    public int numero() {
        return valor;
    }
}

class Estado extends ElementoPila {
    public Estado(int valor) {
        this.valor = valor;
    }

    public void muestra() {
        System.out.println("Estado");
        System.out.println("valor: " + valor);
    }

    public void muestra2() {
        System.out.print("Est-");
    }

    public int numero() {
        return valor;
    }
}

class Pila {
    private List<ElementoPila> lista = new LinkedList<>();

    public void push(ElementoPila x) {
        lista.add(x);
    }

    public int top() {
        return lista.get(lista.size() - 1).numero();
    }

    public ElementoPila pop() {
        return lista.remove(lista.size() - 1);
    }

    public void muestra() {
        for (ElementoPila elemento : lista) {
            elemento.muestra2();
        }
        System.out.println();
    }
}
