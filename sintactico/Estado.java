package sintactico;

public class Estado extends ElementoPila {

    public Estado(String simbolo) {
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
