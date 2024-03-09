package sintactico;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Pila {
    private List<ElementoPila> lista = new LinkedList<>();

    // Método para agregar un elemento a la pila
    public void push(ElementoPila x) {
        lista.add(0, x);
    }

    // Método para quitar y devolver el elemento superior de la pila
    public ElementoPila pop() {
        ElementoPila x = lista.get(0);
        lista.remove(0);
        return x;
    }

    // Método para obtener el elemento superior de la pila sin quitarlo
    public ElementoPila top() {
        return lista.get(0);
    }

    // Método para mostrar la pila
    public void muestra() {
        ListIterator<ElementoPila> it = lista.listIterator(lista.size());

        ElementoPila x;
        System.out.print("Pila: ");

        while (it.hasPrevious()) {
            x = it.previous();
            x.muestra();
        }

        System.out.println();
    }
}
