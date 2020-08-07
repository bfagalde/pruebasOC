package test.bps.common.globalEntities.regemp.dao.impl.aportacion;

import java.io.Serializable;

import bps.common.globalentities.regemp.dao.impl.AportacionDAOImpl;
import common.dao.exceptions.NoDataFoundException;
import common.dao.exceptions.TooManyDataException;
import test.proxycomparator.AbstractTest;

public class Aportacion_FindByIdentificador extends AbstractTest {

	static Integer[] todasLasAps = {1,2,48, 99};

	@Override
	protected Serializable getLlamadaEspecifica() {
		Serializable[] salida = new Serializable[todasLasAps.length];
		AportacionDAOImpl daoimpl = new AportacionDAOImpl();
		for (int j = 0; j < todasLasAps.length; j++) {
			int id = todasLasAps[j];
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
