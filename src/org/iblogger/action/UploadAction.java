package org.iblogger.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.iblogger.dao.ProductDao;
import org.iblogger.dao.impl.ProductDaoImpl;
import org.iblogger.model.Product;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 21, 2012 11:01:03 PM
 */
public class UploadAction extends HttpServlet {

	/**
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 这个方法过时了可用下面的代替方法
		// String path = request.getRealPath("/upload");
		String path = this.getServletContext().getRealPath("/upload");

		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);

		ProductDao dao = new ProductDaoImpl();
		Product p = new Product();
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(request);

			for (FileItem item : list) {

				// 方法isFormField()是用来看提交的数据是否为简单数据类型
				// 也就是说是不是文件类型的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					if ("pName".equals(name)) {
						p.setPrdctName(value);
					} else if ("pModel".equals(name)) {
						p.setPrdctModel(value);
					} else if ("pParam".endsWith(name)) {
						p.setPrdctParam(value);
					} else if ("sequence".equals(name)) {
						p.setPrdctSeq(Integer.parseInt(value));
					} else if ("company".equals(name)) {
						p.setCpnCode(Integer.parseInt(value));
					} else if ("productType".equals(name)) {
						p.setPrdctKindCode(Integer.parseInt(value));
					} else if ("descrip".equals(name)) {
						p.setPrdctIntro(value);
					}
				} else {
					// String name = item.getFieldName();
					String value = item.getName();// 客户端提交过的文件的路径命名

					int start = value.lastIndexOf("\\");
					String fileName = value.substring(start + 1);
					// 这是一种简单的上传方式
					// item.write(new File(path,fileName));
					File upfile = new File(path, fileName);
					String tpath = upfile.getPath();
					p.setPrdctPath(tpath.substring(tpath.indexOf("upload")));
					OutputStream os = new FileOutputStream(upfile);

					InputStream is = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = is.read(buffer)) > 0) {
						os.write(buffer, 0, len);
						os.flush();
					}

					os.close();
					is.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean ok = dao.updateProduct(p, 1);
		if (ok) {
			response.sendRedirect("productAction?action=all");
		} else {
			response.sendRedirect("404.html");
		}
		// request.getRequestDispatcher("/").forward(request,
		// response);
	}
}
