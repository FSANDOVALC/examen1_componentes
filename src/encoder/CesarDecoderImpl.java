package encoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CesarDecoderImpl implements Decoder{

    private List<String> abecedario = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y");
    private List<String> abecedario_reordenado = new ArrayList<String>();
    /**
     * Posicion de izquierda a derecha en el abecedario para el cifrado Cesar
     */
    int posicion = 4;

    public CesarDecoderImpl(){
        crearListaSegunPosicion(posicion);
    }

    @Override
    public String encripta(String texto) {

        String textoUpperCase = texto.toUpperCase();
        List<Character> textoToChars = textoUpperCase.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<String> textoEncriptado = new ArrayList<String>();
        String result;

        for(int i=0;i<textoToChars.size();i++){
            int indiceRefChar = abecedario.indexOf(textoToChars.get(i).toString());
            textoEncriptado.add(abecedario_reordenado.get(indiceRefChar));
        }

        result = textoEncriptado.toString();
        System.out.println("Texto encriptado: " + result);

        return result;
    }

    @Override
    public String desencripta(String texto) {

        String textoUpperCase = texto.toUpperCase();
        List<Character> textoToChars = textoUpperCase.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<String> textoDesencriptado = new ArrayList<String>();
        String result;

        for(int i=0;i<textoToChars.size();i++){
            int indiceRefChar = abecedario_reordenado.indexOf(textoToChars.get(i).toString());
            textoDesencriptado.add(abecedario.get(indiceRefChar));
        }

        result = textoDesencriptado.toString();
        System.out.println("Texto desencriptado: " + result);

        return result;
    }

    public void crearListaSegunPosicion(int posicion){
        //Crear nueva lista con las sublistas en el corte donde esta el descrifrado
        //Para posteriormente solo recorrer indices.
        this.abecedario_reordenado.addAll(abecedario.subList(posicion,abecedario.size()));
        this.abecedario_reordenado.addAll(abecedario.subList(0,posicion));
    }

}
