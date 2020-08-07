package test.bps.common.globalEntities.regemp.dao.impl.eca;

import java.io.Serializable;

import bps.common.globalentities.regemp.EmpresaContribuyenteAportacion;
import bps.common.globalentities.regemp.dao.impl.EmpresaContribuyenteAportacionDAOImpl;
import bps.common.util.Fecha;
import common.dao.exceptions.NoDataFoundException;
import test.proxycomparator.AbstractTest;

public class ECA_ObtenerUltimaFechaClausuraAnterior extends AbstractTest {

	//4 ecas y 4 fechas
	static Integer[][] todosLosIds = {{12345, 0, 1}, {123456, 0, 1}, {1234, 0, 1}, {99, 99, 3}};
	static Fecha[] fechas = {new Fecha(1990, 1, 1), null, new Fecha(2000, 5, 5), new Fecha()}; 
	
	@Override
	protected Serializable getLlamadaEspecifica() {
		Serializable[] salida = new Serializable[todosLosIds.length];
		EmpresaContribuyenteAportacionDAOImpl daoimpl = new EmpresaContribuyenteAportacionDAOImpl();
		for (int j = 0; j < todosLosIds.length; j++) {
			Integer[] id = todosLosIds[j];
			Serializable obj;
			try {
				EmpresaContribuyenteAportacion eca = ECAUtil.getEmptyECA(id);
				obj = daoimpl.obtenerUltimaFechaClausuraAnterior(eca, fechas[j]);
			} catch (NoDataFoundException e) {
				obj = e.toString();
			}
			salida[j] = obj;
		}
		return salida;
	}

}
