package mx.nexsol.bean.seguridad;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.servlet.ServletException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import javax.faces.bean.ManagedProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

@RequestScoped
@ManagedBean(name = "loginBean")
@Component
public class Login {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private String usuario;
    private String contrasenia;
    
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager;
	
	/**
    *
    * Redirects the login request directly to spring security check.
    * Leave this method as it is to properly support spring security.
    * 
    * @return
    * @throws ServletException
    * @throws IOException
    */
   public void loging() throws ServletException, IOException {
	   try {
           Authentication request = new UsernamePasswordAuthenticationToken(this.getUsuario(), this.getContrasenia());
           Authentication result = authenticationManager.authenticate(request);
           System.out.println("Usuario " + usuario + " es valido.");
           SecurityContextHolder.getContext().setAuthentication(result);
       } catch (AuthenticationException e) {
           e.printStackTrace();
       }
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       externalContext.redirect(externalContext.getRequestContextPath()
               .concat("/index.xhtml"));
   }
   
   public void logout() throws IOException{
       SecurityContextHolder.clearContext();
       System.out.println("Usuario " + usuario + " ha cerrado sesion.");
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
       externalContext.redirect(externalContext.getRequestContextPath()
               .concat("/"));
   }

   public void afterPhase(PhaseEvent event) {
   }

   /* (non-Javadoc)
    * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
    * 
    * Do something before rendering phase.
    */
   public void beforePhase(PhaseEvent event) {
       Exception e = (Exception) FacesContext.getCurrentInstance().
         getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);

       if (e instanceof BadCredentialsException) {
           logger.debug("Found exception in session map: "+e);
           FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                   WebAttributes.AUTHENTICATION_EXCEPTION, null);
           FacesContext.getCurrentInstance().addMessage(null, 
             new FacesMessage(FacesMessage.SEVERITY_ERROR,
               "Username or password not valid.", "Username or password not valid"));
       }
   }
   
   public String getUsuarioLogueado(){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       return auth.getName();
   }


   /* (non-Javadoc)
    * @see javax.faces.event.PhaseListener#getPhaseId()
    * 
    * In which phase you want to interfere?
    */
   public PhaseId getPhaseId() {
       return PhaseId.RENDER_RESPONSE;
   }

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getContrasenia() {
	return contrasenia;
}

public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}

public AuthenticationManager getAuthenticationManager() {
    return authenticationManager;
}

public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	this.authenticationManager = authenticationManager;
}

}
