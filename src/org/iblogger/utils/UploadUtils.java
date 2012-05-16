package org.iblogger.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iblogger.utils.upload.File;
import org.iblogger.utils.upload.SmartUpload;

public class UploadUtils {

	private SmartUpload smart;

	private ServletConfig config;

	public UploadUtils() {

	}

	public void initial(ServletConfig config, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			this.config = config;
			smart = new SmartUpload();
			smart.initialize(config, request, response);
			smart.setAllowedFilesList("jpg,gif,bmp,jpeg,png");
			smart.upload("GBK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 上传文件
	public String upload(int i, String path) throws Exception {
		int num = 0;
		Calendar c = Calendar.getInstance();
		// 格式化时间
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName = sf.format(c.getTime());

		File myFile;
		try {
			myFile = smart.getFiles().getFile(i);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw e1;
		}

		// 获取上传文件扩展名
		String fileExt = myFile.getFileExt();

		// 若上传失败重试9次
		for (int j = 0; j < 3; j++) {
			try {
				if (!(myFile.isMissing()))// 如果上传文件存在
					myFile.saveAs(path + fileName + "." + fileExt);
				break;
			} catch (Exception e) {
				num++;
				fileName = fileName + j;
				continue;
			}
		}

		if (num == 3)
			return null;
		else {
			if (myFile.isMissing())
				return "";
			else
				return fileName + "." + fileExt;
		}

	}

	// 获取单值输入参数（文本框、密码框、单选钮、单选下拉列表等）
	public String getParameter(String s) {
		return smart.getRequest().getParameter(s);
	}

	// 获取多值输入参数（复选框、多选下拉列表等）
	public String[] getParameterValues(String s) {
		return smart.getRequest().getParameterValues(s);
	}

	// 获取上传文件原名
	public String getFileOriginalName(int i) {
		try {
			return new String(smart.getFiles().getFile(i).getFileName()
					.getBytes(), "GBK");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 下载文件
	public void download(String file) {
		try {
			smart.setContentDisposition(null);
			smart.downloadFile(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 删除文件
	public boolean delete(String url) {
		java.io.File f = new java.io.File(config.getServletContext()
				.getRealPath(url));
		return f.delete();
	}

}
