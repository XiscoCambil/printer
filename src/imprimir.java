/**
 * Created by fjcambilr on 25/02/16.
 */
public class imprimir {
    public static void main(String[] args) {

        String data =
                        "  _     __    _     __   ___   ___    __                                                    __    __    __    __   ___                                ___   _    \n" +
                        " /_|   / _)  / )   /  ) (_    (_     / _   )__/   /      /   /__/  /     /|/|  /| )  /  )  /__)  /  )  /__)  (     /     /  / (  /  (   /  \\_)  (__/   _/    )   \n" +
                        "(  |  /(_)  (__   /(_/  /__   /     (__)  /  /   (    (_/   /  )  (__   /   | / |/  (__/  /     (__\\  / (   __)   (     (__/  |_/   |/|/  ( \\    /    /__   .    ";

        Printer p = new Printer(data);
       System.out.print(p.render("Avui fa bon dia"));

    }
}

class Printer{
    private String alfabeto;
    private int contador;

    public Printer(String alfabeto) {
        this.alfabeto = alfabeto;

        for (int i = 0; i < alfabeto.length(); i++) {
            if (alfabeto.charAt(i) == '\n') contador++;

        }
        contador++;
    }

    public String render(String s){
        s = s.toUpperCase();
        String resultado = "";
        int nuevaLinea = alfabeto.length()/contador+1;
        int Vletra;
        int AnchoCaracter = ((alfabeto.length()/27)/contador)+1;
        for (int i = 0,x = 0; i < contador; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) > 64 && s.charAt(j) < 91) {
                    Vletra = (s.charAt(j) - 'A') * (AnchoCaracter);
                    resultado += alfabeto.substring(Vletra+x, (Vletra + AnchoCaracter)+x);
                }
                else if(s.charAt(j) == 32){

                    resultado+= " ";

                }else{
                    Vletra = nuevaLinea - AnchoCaracter-1;
                    resultado += alfabeto.substring(Vletra+x, (Vletra +(AnchoCaracter-2))+x);
                }
            }
            x += nuevaLinea;
            resultado += "\n";
        }
        return resultado;
    }

}



