package cn.edu.zust.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.struts.upload.FormFile;

public class LoadFile {
	public static String upload(FormFile file, String dir) {
		File f = new File(dir);
		if (!f.isDirectory()) {
			f.mkdir();
		}
		OutputStream os = null;
		InputStream is = null;
		// 得到文件名
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString().replace("-", "");
		String fname = file.getFileName();
		fname = fname.substring(fname.lastIndexOf("."), fname.length());
		// 要上传的文件的大小
		try {
			is = file.getInputStream();
			os = new FileOutputStream(dir + File.separator + name + fname);
			byte[] b = new byte[1024];
			int size = 0;
			// 上传文件的核心代码
			while ((size = is.read(b)) != -1) {
				os.write(b, 0, size);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		file.destroy();
		return name + fname;
	}
}
