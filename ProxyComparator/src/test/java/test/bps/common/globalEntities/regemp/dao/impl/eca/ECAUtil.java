package test.bps.common.globalEntities.regemp.dao.impl.eca;

import bps.common.globalentities.regemp.Aportacion;
import bps.common.globalentities.regemp.Contribuyente;
import bps.common.globalentities.regemp.Empresa;
import bps.common.globalentities.regemp.EmpresaContribuyenteAportacion;

public final class ECAUtil {
	

	static EmpresaContribuyenteAportacion getEmptyECA(int idEmpresa, int idContribuyente, int codigoAportacion) {
		Empresa empresa = new Empresa(); empresa.setIdentificador(idEmpresa);
		Contribuyente contribuyente = new Contribuyente(); contribuyente.setIdentificador(idContribuyente);
		Aportacion aportacion = new Aportacion(); aportacion.setIdentificador(codigoAportacion);
		EmpresaContribuyenteAportacion eca = new EmpresaContribuyenteAportacion(empresa, contribuyente, aportacion);
		return eca;
	}

	public static EmpresaContribuyenteAportacion getEmptyECA(Integer[] id) {
		return getEmptyECA(id[0], id[1],  id[2]);
	}


}
