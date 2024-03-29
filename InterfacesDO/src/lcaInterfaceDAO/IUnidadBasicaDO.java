package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;


public interface IUnidadBasicaDO extends DataObject{
	
	
	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	
	//-------------------------------------------------
	
	public abstract int getDefensa();
	
	public abstract void setDefensa(int defensa);
	
	//----------------------------------------------------------------------------------------
	
	public abstract int getAtaque();
	
	public abstract void setAtaque(int ataque);
	//-------------------------------------------------------------------------------------------
	
	public abstract int getTipo();
	
	public abstract void setTipo(int tipo);
	
	//--------------------------------------------------------------------------------------------------
	
	public abstract List<IUnidadBasicaPersonajeDO> getUnidadBasicaPersonajeList();
	
	public abstract void setUnidadBasicaPersonajeList(List<IUnidadBasicaPersonajeDO> unidadBasicaPersonajeList);
	
	//---------------------------------------------------------------------------------------------------------
	
	public abstract Reference<ITecnologiaDO> getTecnologiaRef();
	
	public abstract void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef);
	
	//----------------------------------------------------------------------------------------------------------
	
	public abstract List<IUnidadBasicaRecursoDO> getUnidadBasicaRecursoList();
	
	public abstract void setUnidadBasicaRecursoList(List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList);
	
	//-------------------------------------------------------------------------------------------------------
	

	public abstract String getImagenUnidadBasica();
	
	public  abstract void setImagenUnidadBasica(String imagenUnidadBasica);
	
	//--------------------------------------------------------------------------------------------------------------
	
		
	
}
