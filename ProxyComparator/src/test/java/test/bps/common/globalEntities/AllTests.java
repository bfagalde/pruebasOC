package test.bps.common.globalEntities;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.bps.common.globalEntities.regemp.dao.impl.aportacion.Aportacion_AllTests;
import test.bps.common.globalEntities.regemp.dao.impl.eca.ECA_AllTests;
import test.bps.common.globalEntities.regemp.dao.impl.empresa.Empresa_AllTests;

@RunWith(Suite.class)
@SuiteClasses({ Empresa_AllTests.class , Aportacion_AllTests.class, ECA_AllTests.class})
public class AllTests {

}
