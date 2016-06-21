package mx.nexsol.bean.funcionalidades;

import java.util.List;

import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.service.proyecto.impl.FuncionalidadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by ironhide on 21/06/16.
 */

@Controller
@ManagedBean(name = "funcionalidadBean")
@Scope(value = "request")
@ViewScoped
public class FuncionalidadBean implements Serializable {


    @ManagedProperty(value="#{funcionalidadesDTO}")
    private List<FuncionalidadDTO> funcionalidadesDTO;

    @ManagedProperty(value = "funcionalidadDTO")
    private FuncionalidadDTO funcionalidadDTO;

    @Autowired
    private FuncionalidadServiceImpl funcionalidadService;

    @PostConstruct
    public void init() {
        HttpServletRequest request =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if(request.getParameter("id")!=null) {
            Long id = Long.parseLong(request.getParameter("id"));
            try {
                funcionalidadDTO = funcionalidadService.recuperarFuncionalidad(id);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<FuncionalidadDTO> getFuncionalidadesDTO() {
        return funcionalidadesDTO;
    }

    public void setFuncionalidadesDTO(List<FuncionalidadDTO> funcionalidadesDTO) {
        this.funcionalidadesDTO = funcionalidadesDTO;
    }

    public FuncionalidadDTO getFuncionalidadDTO() {
        return funcionalidadDTO;
    }

    public void setFuncionalidadDTO(FuncionalidadDTO funcionalidadDTO) {
        this.funcionalidadDTO = funcionalidadDTO;
    }

    public FuncionalidadServiceImpl getFuncionalidadService() {
        return funcionalidadService;
    }

    public void setFuncionalidadService(FuncionalidadServiceImpl funcionalidadService) {
        this.funcionalidadService = funcionalidadService;
    }

}
