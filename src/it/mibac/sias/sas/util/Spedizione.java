package it.mibac.sias.sas.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Spedizione {
	private String percorso; // percorso della directory da comprimere
	private String fileZip; // nome completo del file zip da produrre

	public String getPercorso() {
		return percorso;
	}

	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}

	public String getFileZip() {
		return fileZip;
	}

	public void setFileZip(String fileZip) {
		this.fileZip = fileZip;
	}

	public Spedizione(String percorso, String fileZip) {
		super();
		setPercorso(percorso);
		setFileZip(fileZip);
	}

	public void comprimi() {
		try {
			FileOutputStream fos = new FileOutputStream(getFileZip());
			ZipOutputStream zos = new ZipOutputStream(fos);
			ZipEntry ze;

			File dir = new File(getPercorso());
			if (dir.isDirectory()) {
				File[] lista = dir.listFiles();
				for (int i = 0; i < lista.length; i++) {
					File entry = lista[i];
					ze = new ZipEntry(entry.getName());
					FileInputStream fis; // dichiaraxione
					fis = new FileInputStream(entry); // istanziazione
					byte[] buffer = new byte[2048];
					BufferedInputStream bis = new BufferedInputStream(fis, 2048);
					zos.putNextEntry(ze);
					int count;
					while ((count = bis.read(buffer, 0, 2048)) != -1) {
						zos.write(buffer, 0, count);

					}
					zos.flush();
					zos.closeEntry();
				}
				zos.flush();
				zos.close();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
