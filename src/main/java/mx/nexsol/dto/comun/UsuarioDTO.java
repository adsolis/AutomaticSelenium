package mx.nexsol.dto.comun;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ironhide on 28/06/16.
 */

@EqualsAndHashCode(callSuper = false, of = {"id"})
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Data
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String username;

    private String contrasena;

    private boolean habilitado;

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private Date fechaNacimiento;

    private String correoElectronico;

    private String numeroTelefonico;

    private String rol;

}
