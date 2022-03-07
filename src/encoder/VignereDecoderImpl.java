package encoder;

public class VignereDecoderImpl implements Decoder{

    private String palabraClave = "lima";
    private String llave;

    @Override
    public String encripta(String texto) {

        palabraClave = this.palabraClave.toUpperCase();
        texto = texto.toUpperCase();
        llave = generarLlave(texto,palabraClave);
        String textoCifrado = cifrarTexto(texto,llave);

        System.out.println(textoCifrado);

        return textoCifrado;
    }

    @Override
    public String desencripta(String textoCifrado) {
        String textoOriginal = "";

        for (int i = 0 ; i < textoCifrado.length() &&
                i < llave.length(); i++)
        {
            // Convertirlo en rango de 0-25
            int x = (textoCifrado.charAt(i) - llave.charAt(i) + 26) %26;

            // Convertirlo al alfabeto ASCII
            x += 'A';
            textoOriginal += (char)(x);
        }

        System.out.println(textoOriginal);

        return textoOriginal;
    }

    private String generarLlave(String texto, String llave){
        int x = texto.length();

        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (llave.length() == texto.length())
                break;
            llave+=(llave.charAt(i));
        }
        return llave;
    }

    private String cifrarTexto(String texto, String llave)
    {
        String textoCrifrado = "";

        for (int i = 0; i < texto.length(); i++)
        {
            // Convertirlo en rango de 0-25
            int x = (texto.charAt(i) + llave.charAt(i)) %26;

            // Convertirlo al alfabeto ASCII
            x += 'A';

            textoCrifrado += (char)(x);
        }
        return textoCrifrado;
    }

}
