package beans;

import encoder.Decoder;
import org.springframework.beans.factory.annotation.Autowired;

public class MySpringDecoderBeanWithDependency {

    private Decoder decoder;
    @Autowired
    public void setDecoder (Decoder pDecoder){
        this.decoder = pDecoder;
    }
    public void run(String s){
        String cifrado = decoder.encripta(s);
        //Colocar el texto correspondiente para descifrar segunda el cifrado elegido
        decoder.desencripta("GSHMKSWIGVIXS");
    }
}
