package mx.nexsol.bean.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import mx.nexsol.dto.proyecto.CasoPruebaDTO;
import mx.nexsol.dto.proyecto.FuncionalidadDTO;
import mx.nexsol.service.proyecto.impl.CasoPruebaServiceImpl;
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
@Data
public class FuncionalidadBean implements Serializable {

    @Autowired
    @ManagedProperty(value = "funcionalidadDTO")
    private FuncionalidadDTO funcionalidadDTO;

    @ManagedProperty(value = "casosPruebaDTO")
    private List<CasoPruebaDTO> casosPruebaDTO;

    @Autowired
    @ManagedProperty(value = "casoPruebaDTO")
    private CasoPruebaDTO casoPruebaDTO;

    @Autowired
    private FuncionalidadServiceImpl funcionalidadService;

    @Autowired
    private CasoPruebaServiceImpl casoPruebaService;

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

    public void guardarCasosPrueba() {
        HttpServletRequest request =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        casosPruebaDTO = (List<CasoPruebaDTO>)session.getAttribute("listaCasosPrueba");
        funcionalidadDTO = funcionalidadService.guardarCasosPrueba(casosPruebaDTO, funcionalidadDTO);
    }

}
