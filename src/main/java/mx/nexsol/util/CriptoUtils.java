package mx.nexsol.util;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by ironhide on 14/09/16.
 */

@Service
public class CriptoUtils implements Serializable {

    private Validador validador = new Validador();


    public String generarContrasenia(int lengthContrasenia){

        String str= new String("QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR");
        StringBuilder contrasenia = new StringBuilder();
        Random rnd = new Random();
        int indexChar=0;

        for(int i=1; i<=lengthContrasenia; i++){

            indexChar=rnd.nextInt(62);
            contrasenia.append(str.charAt(indexChar));

        }

        return contrasenia.toString();
    }


    /*public String getNuevaContrasenia() {

        String constrasenia = this.generarContrasenia(8)

        for(;this.validador.isValidaContrasenia(constrasenia);) {

            constrasenia = this.generarContrasenia(8);

        }

        return constrasenia;

    }*/

}
