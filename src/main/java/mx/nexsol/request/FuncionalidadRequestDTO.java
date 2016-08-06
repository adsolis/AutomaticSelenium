package mx.nexsol.request;

import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.dto.proyecto.ProyectoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ironhide on 20/07/16.
 */

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FuncionalidadRequestDTO implements Serializable {

    @Autowired
    ProyectoDTO proyectoDTO;

    List<FuncionalidadDTO> funcionalidadesNuevas;

    List<FuncionalidadDTO> funcionalidadesEditadas;

    List<FuncionalidadDTO> funcionalidadesEliminadas;

    public ProyectoDTO getProyectoDTO() {
        return proyectoDTO;
    }

    public void setProyectoDTO(ProyectoDTO proyectoDTO) {
        this.proyectoDTO = proyectoDTO;
    }

    public List<FuncionalidadDTO> getFuncionalidadesNuevas() {
        return funcionalidadesNuevas;
    }

    public void setFuncionalidadesNuevas(List<FuncionalidadDTO> funcionalidadesNuevas) {
        this.funcionalidadesNuevas = funcionalidadesNuevas;
    }

    public List<FuncionalidadDTO> getFuncionalidadesEditadas() {
        return funcionalidadesEditadas;
    }

    public void setFuncionalidadesEditadas(List<FuncionalidadDTO> funcionalidadesEditadas) {
        this.funcionalidadesEditadas = funcionalidadesEditadas;
    }

    public List<FuncionalidadDTO> getFuncionalidadesEliminadas() {
        return funcionalidadesEliminadas;
    }

    public void setFuncionalidadesEliminadas(List<FuncionalidadDTO> funcionalidadesEliminadas) {
        this.funcionalidadesEliminadas = funcionalidadesEliminadas;
    }
}
