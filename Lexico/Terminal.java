public class Terminal extends ElementoPila {
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
