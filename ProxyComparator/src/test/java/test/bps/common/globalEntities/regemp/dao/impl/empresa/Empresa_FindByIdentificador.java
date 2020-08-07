package test.bps.common.globalEntities.regemp.dao.impl.empresa;

import java.io.Serializable;

import bps.common.globalentities.regemp.dao.impl.AportacionDAOImpl;
import bps.common.globalentities.regemp.dao.impl.EmpresaDAOImpl;
import common.dao.exceptions.NoDataFoundException;
import common.dao.exceptions.TooManyDataException;
import test.proxycomparator.AbstractTest;

public class Empresa_FindByIdentificador extends AbstractTest {

	static Integer[] todosLosIds = {12345, 0, 1234, 123456};

	@Override
	protected Serializable getLlamadaEspecifica() {
		Serializable[] salida = new Serializable[todosLosIds.length];
		EmpresaDAOImpl daoimpl = new EmpresaDAOImpl();
		for (int j = 0; j < todosLosIds.length; j++) {
			int id = todosLosIds[j];
			Serializable obj;
			try {
				obj = daoimpl.findByIdentificador(id);
			} catch (TooManyDataException e) {
				obj = e.toString();
			} catch (NoDataFoundException e) {
				obj = e.toString();
			}
			salida[j] = obj;
		}
		return salida;
	}

}
