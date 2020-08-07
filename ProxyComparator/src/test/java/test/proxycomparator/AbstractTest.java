package test.proxycomparator;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import proxycomparator.utils.ComparadorBinario;
import proxycomparator.utils.FileManager;

public abstract class AbstractTest {

	private static Logger logger = Logger.getLogger(AbstractTest.class);
	private static final String ROOT_FOLDER = "C:\\tmp\\";
	private static String runningTag = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		runningTag = new String(""+System.currentTimeMillis()+"-");
		logger.debug("setUpBeforeClass: " + runningTag);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("tearDownAfterClass: " + runningTag);
	}

	@Before
	public void setUp() throws Exception {
		logger.debug("setUp: " + getTestingMethod());
	}

	@After
	public void tearDown() throws Exception {
		logger.debug("tearDown: " + getTestingMethod());
	}

	public String getTestingMethod() {
		return getClass().getName();
	}
	
	@Test
	public void test() {
		logger.info("test - start");
		boolean b = false;
		try {
			logger.debug("test - previo a ejecutar las consultas");
			Serializable[] sers = { ejecutarQueryNueva(), ejecutarQueryVieja() };
			String[] tags = { "viejo", "nuevo" };
			String[] archivos = { "", "" };
			for (int j = 0; j < tags.length; j++) {
				String tag = tags[j];
				logger.debug("test - vamos a guardar archivo " + tag);
				archivos[j] = FileManager.printToFile(ROOT_FOLDER+getTestingMethod(), sers[j], runningTag+tags[j]);
			}

			b = ComparadorBinario.comparefiles(archivos[0], archivos[1]);
			if (!b) {
				logger.info("Hay diferencias en: " + archivos[0]);
			}
			logger.debug("test - comparacion: " + b);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.fatal("test - error fatal: " + e);
		} 
		logger.info("test - end");
		assertTrue(b);
	}

	protected Serializable ejecutarQueryNueva() throws Exception {
		logger.info("ejecutarQueryNueva - start");
		System.setProperty("BACKEND_HOME", "C:\\tmp\\daosNuevos");
		Serializable salida = getLlamadaEspecifica(); 
		logger.info("ejecutarQueryNueva - end");
		return salida;
	}

	protected abstract Serializable getLlamadaEspecifica() throws Exception;

	protected Serializable ejecutarQueryVieja() throws Exception {
		logger.info("ejecutarQueryVieja - start");
		System.setProperty("BACKEND_HOME", "C:\\tmp\\daosViejos");
		Serializable salida = getLlamadaEspecifica(); 
		logger.info("ejecutarQueryVieja - end");
		return salida;
	}

}
