package cn.edu.zust.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.upload.FormFile;

public class UpLoadUtil {
	public static String upLoadFile(FormFile formFile,
			HttpServletRequest request) throws Exception {
		String path = request.getSession(true).getServletContext().getRealPath(
				"/share");
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String shareUrl = path;
		if (formFile != null) {
			if (formFile.getFileName() != null) {
				if (!formFile.getFileName().equals("")) {
					UUID uuid = UUID.randomUUID();
					String str = uuid.toString();
					str = str.replace("-", "");
					String fileName = formFile.getFileName();
					fileName = str
							+ fileName.substring(fileName.indexOf("."),
									fileName.length());
					File ff = new File(path + "/" + fileName);
					OutputStream out = new FileOutputStream(ff);
					out.write(formFile.getFileData());
					out.flush();
					out.close();
					shareUrl = shareUrl + "\\" + fileName;
					String[] fs = shareUrl.split(path);
					System.out.println("++++++++++++++++");
					shareUrl = "/studyonline/share" + fs[1];
					System.out.println(shareUrl);
				}
			}
		}
		System.out.println(shareUrl);
		System.out.println("++++++++++++++++");
		return shareUrl;
	}
}
