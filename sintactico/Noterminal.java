package sintactico;

public class Noterminal extends ElementoPila {

    public Noterminal(String simbolo) {
        super(simbolo);
    }

    @Override
    public void muestra() {
        System.out.print(simbolo + " ");
    }

    @Override
    public String regresar() {
        return simbolo;
    }
}
