package sintactico;

public abstract class ElementoPila {
    protected String simbolo;

    public ElementoPila(String simbolo) {
        this.simbolo = simbolo;
    }

    public abstract void muestra();

    public abstract String regresar();
}
