package proxycomparator.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import org.apache.log4j.Logger;

import bps.common.globalentities.regemp.Aportacion;
import bps.common.util.Fecha;
import common.util.Serializer;

public class FileManager {
	private static Logger logger = Logger.getLogger(FileManager.class);

	public static void main(String[] args) {
		System.out.println("main");
		Aportacion a = new Aportacion();
		Aportacion b = new Aportacion();
		long l1 = System.currentTimeMillis();
		
		a.setFechaDesde(new Fecha(new Date(l1)));
		b.setFechaDesde(new Fecha(new Date(l1)));
		
		byte[] aa = Serializer.serialize(a);
		byte[] bb = Serializer.serialize(b);
		String f1Name="c:\\tmp\\a.ser", f2Name="c:\\tmp\\b.ser";
		
		FileOutputStream fwa, fwb;
		try {
			String folder = "c:\\tmp";
			f1Name = printToFile(folder, a, "xyz1");
			f2Name = printToFile(folder, b, "xyz2");
			System.out.println("son iguales: " + ComparadorBinario.comparefiles(f1Name, f2Name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String printToFile(String prefijoPath, Serializable obj, String tag) throws IOException {
		String fileName = null;
		if (obj!=null) {
			boolean createdDir = crearFolder(prefijoPath);
			logger.debug("printToFile - created: " + createdDir);
			fileName= prefijoPath + "\\" + obj.getClass().getName() + "-" + tag + ".ser";
			byte[] bytes = Serializer.serialize(obj);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(fileName);
				fos.write(bytes);
			} finally {
				if (fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return fileName;
	}

	private static boolean crearFolder(String pathname) {
		File file = new File(pathname);
		boolean created = file.mkdir();
		return created;
	}
}
