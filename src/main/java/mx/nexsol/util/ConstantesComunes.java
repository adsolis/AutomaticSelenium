package mx.nexsol.util;

public class ConstantesComunes {
	
	//Rutas para las redirecciones de pantalla
	
	public static final String REGISTRO_PROYECTO = "/pages/registro/registro.xhtml";
	
	public static final String DETALLE_PROYECTO = "/pages/registro/detalle_proyecto.xhtml";

	public static final String DETALLE_USUARIO = "/pages/seguridad/detalle_usuario.xhtml";
	
	
	//Estatus de proyecto
	
	public static final int CODIGO_ESTATUS_PROYECTO_PENDIENTE = 1;
	
	public static final int CODIGO_ESTATUS_PROYECTO_EN_CURSO = 2;
	
	public static final int CODIGO_ESTATUS_PROYECTO_FINALIZADO = 3;
	
	public static final String ESTATUS_PROYECTO_PENDIENTE = "Pendiente";
	
	public static final String ESTATUS_PROYECTO_EN_CURSO = "En curso";
	
	public static final String ESTATUS_PROYECTO_FINALIZADO = "Finalizado";
	
	//Constantes para codigos de error y exito
	
	public static final int CODIGO_EXITO = 0;
	
	public static final int CODIGO_ERROR = 1;

	//Constantes para mensajes de error y exito

	public static final String MENSAJE_EXITO = "El registro se guardo con exito";

	public static final String MENSAJE_ERROR = "Ha ocurrido un error, favor de contactar al administrador del sistema";

}
