package sintactico;

public class Terminal extends ElementoPila {

    public Terminal(String simbolo) {
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
