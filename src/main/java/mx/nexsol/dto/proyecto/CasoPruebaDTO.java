package mx.nexsol.dto.proyecto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class CasoPruebaDTO implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 5919272587484898506L;
	
	private long id;
	
	private String nombreCasoPrueba;
	
	private List<PasoCasoPruebaDTO> pasosCasoPrueba;

	private List<Map<String, String>> listaCampos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCasoPrueba() {
		return nombreCasoPrueba;
	}

	public void setNombreCasoPrueba(String nombreCasoPrueba) {
		this.nombreCasoPrueba = nombreCasoPrueba;
	}

	public List<PasoCasoPruebaDTO> getPasosCasoPrueba() {
		return pasosCasoPrueba;
	}

	public void setPasosCasoPrueba(List<PasoCasoPruebaDTO> pasosCasoPrueba) {
		this.pasosCasoPrueba = pasosCasoPrueba;
	}

	public List<Map<String, String>> getListaCampos() {
		return listaCampos;
	}

	public void setListaCampos(List<Map<String, String>> listaCampos) {
		this.listaCampos = listaCampos;
	}
	
	

}
