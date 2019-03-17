package org_student_servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
				try {
					//String ext = fileName.substring(fileName.indexOf(".")+1)
					upload.setSizeMax(3*1024*1024);
					List<FileItem> items = upload.parseRequest(request);
					Iterator<FileItem> iter = items.iterator();
					while(iter.hasNext()){
						FileItem item= iter.next();
						String itemName = item.getFieldName();
						String Name = null;
						int Id = -1;
						if(item.isFormField()){
							if(itemName.equals("student_name")){
								Name = item.getString("UTF-8");
								System.out.println(Name);
							}else{
								Id=Integer.parseInt(item.getString("UTF-8"));
								System.out.println(Id);
							}
						}
						else{
							String fileName = item.getName();
							
							String path = "E:\\eclipse\\workspace\\UploadAndDownload\\WebContent\\upload";
							
							
							File file = new File(path,fileName);
							try {
								item.write(file);
								System.out.println(fileName+"上传文件");
								return;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
