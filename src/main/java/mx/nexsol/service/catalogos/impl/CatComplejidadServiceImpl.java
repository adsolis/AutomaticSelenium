package mx.nexsol.service.catalogos.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nexsol.dao.catalogos.CatComplejidadDAO;
import mx.nexsol.dto.catalogos.CatComplejidadDTO;
import mx.nexsol.entity.catalogos.CatComplejidad;
import mx.nexsol.service.catalogos.CatComplejidadService;

@Service
public class CatComplejidadServiceImpl implements CatComplejidadService {
	
	@Autowired
	private CatComplejidadDAO catComplejidadDAO;

	@Override
	public List<CatComplejidadDTO> listarCatalogoComplejidad() {
		List<CatComplejidadDTO> catalogoComplejidadDTO = null;
		try {
			List<CatComplejidad> catalogoComplejidadEntity = 
					catComplejidadDAO.listarRegistros();
			if(catalogoComplejidadEntity != null && !catalogoComplejidadEntity.isEmpty()) {
				catalogoComplejidadDTO = new ArrayList<CatComplejidadDTO>();
				for(CatComplejidad complejidad: catalogoComplejidadEntity) {
					catalogoComplejidadDTO.add(mapearEntityADto(complejidad));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catalogoComplejidadDTO;
	}
	
	private CatComplejidadDTO mapearEntityADto(CatComplejidad complejidad) {
		CatComplejidadDTO catComplejidadDTO = new CatComplejidadDTO();
		
		catComplejidadDTO.setId(complejidad.getId());
		catComplejidadDTO.setDescripcionComplejidad(complejidad.getCriterio());
		catComplejidadDTO.setLimiteTiempoMiutos(complejidad.getMinutos());
		
		return catComplejidadDTO;
	}

	public CatComplejidadDAO getCatComplejidadDAO() {
		return catComplejidadDAO;
	}

	public void setCatComplejidadDAO(CatComplejidadDAO catComplejidadDAO) {
		this.catComplejidadDAO = catComplejidadDAO;
	}

}