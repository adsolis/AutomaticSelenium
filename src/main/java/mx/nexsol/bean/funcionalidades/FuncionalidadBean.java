package mx.nexsol.bean.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import mx.nexsol.dto.proyecto.CasoPruebaDTO;
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

    @ManagedProperty(value = "funcionalidadDTO")
    private FuncionalidadDTO funcionalidadDTO;

    @ManagedProperty(value = "casosPruebaDTO")
    private List<CasoPruebaDTO> casosPruebaDTO;

    @Autowired
    @ManagedProperty(value = "casoPruebaDTO")
    private CasoPruebaDTO casoPruebaDTO;

    @Autowired
    private FuncionalidadServiceImpl funcionalidadService;

    @ManagedProperty(value = "idProyecto")
    private long idProyecto;

    @ManagedProperty(value = "nombreProyecto")
    private String nombreProyecto;

    @PostConstruct
    public void init() {
        HttpServletRequest request =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        if(request.getParameter("id")!=null) {
            Long id = Long.parseLong(request.getParameter("id"));
            try {
                funcionalidadDTO = funcionalidadService.recuperarFuncionalidad(id);
                idProyecto = Long.parseLong(request.getParameter("idProyecto"));
                nombreProyecto = request.getParameter("nombreProyecto");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void generarListaCasosPrueba() {
        HttpServletRequest request =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        casosPruebaDTO = (List<CasoPruebaDTO>)session.getAttribute("listaCasosPrueba");

        if(casosPruebaDTO==null)
            casosPruebaDTO = new ArrayList<CasoPruebaDTO>();

        casosPruebaDTO.add(casoPruebaDTO);
        session.setAttribute("listaCasosPrueba", casosPruebaDTO);
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

    public List<CasoPruebaDTO> getCasosPruebaDTO() {
        return casosPruebaDTO;
    }

    public void setCasosPruebaDTO(List<CasoPruebaDTO> casosPruebaDTO) {
        this.casosPruebaDTO = casosPruebaDTO;
    }

    public CasoPruebaDTO getCasoPruebaDTO() {
        return casoPruebaDTO;
    }

    public void setCasoPruebaDTO(CasoPruebaDTO casoPruebaDTO) {
        this.casoPruebaDTO = casoPruebaDTO;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}
