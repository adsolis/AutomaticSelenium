package mx.nexsol.dto.proyecto;

import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CasoPruebaDTO implements Serializable {

	/**
	 * Propiedad para mantener el estado del objeto
	 */
	private static final long serialVersionUID = 5919272587484898506L;
	
	private long id;
	
	private String nombreCasoPrueba;
	
	private List<PasoCasoPruebaDTO> pasosCasoPrueba;

	private List<Map<String, String>> listaCampos;

	private String identificador;

	private String postCondiciones;

	private String preCondiciones;

	private int estimacionEntrada;

	private int estimacionSalida;

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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getPostCondiciones() {
		return postCondiciones;
	}

	public void setPostCondiciones(String postCondiciones) {
		this.postCondiciones = postCondiciones;
	}

	public String getPreCondiciones() {
		return preCondiciones;
	}

	public void setPreCondiciones(String preCondiciones) {
		this.preCondiciones = preCondiciones;
	}

	public int getEstimacionEntrada() {
		return estimacionEntrada;
	}

	public void setEstimacionEntrada(int estimacionEntrada) {
		this.estimacionEntrada = estimacionEntrada;
	}

	public int getEstimacionSalida() {
		return estimacionSalida;
	}

	public void setEstimacionSalida(int estimacionSalida) {
		this.estimacionSalida = estimacionSalida;
	}
}
