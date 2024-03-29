package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface ITecnologiaDO extends DataObject {
	

	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	
	//---------------------------------------------------------------------------------
	
	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaRef();
	
	public abstract void setUnidadBasicaRef(Reference<IUnidadBasicaDO> unidadBasicaRef);
	
	//---------------------------------------------------------------------------------------------
	
	public abstract Reference<IAndroideDO> getAndroideRef();
	
	public abstract void setAndroideRef(Reference<IAndroideDO> andoideRef);
	
	//---------------------------------------------------------------------------------------------------
	
	public abstract List<ITecnologiaRecursoDO> getTecnologiaRecursoList();
	
	public abstract void setTecnologiaRecursoList (List<ITecnologiaRecursoDO> tecnologiaRecursoList);
	
	//------------------------------------------------------------------------------------------------------
	
	public abstract List<ITecnologiaPersonajeDO> getTecnologiaPersonajeList();
	
	public abstract void setTecnologiaPersonajeList(List<ITecnologiaPersonajeDO> tecnologiaPersonajeList);
	
	//---------------------------------------------------------------------------------------------------------
	
	

}
