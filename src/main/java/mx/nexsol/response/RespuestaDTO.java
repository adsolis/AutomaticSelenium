package mx.nexsol.response;

/**
 * Clase padre que funciona para definir las propiedades que se utilizar como
 * respuesta entre las capas
 * Esta clase contendra un codigo de respuesta para identificar si determinada
 * operacion en una clase de servicio se efectuo correctamente o bien si hubo
 * algun fallo
 * Se contendra el mensaje de error
 * Esta clase sera heredada de otras clases de respuesta anadiendo los tipos de objetos
 * que tienen que retornar
 * Created by ironhide on 28/06/16.
 */

public class RespuestaDTO {

    public int codigoRespuesta;

    public String mensajeRespuesta;

}
