package org_student_servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//set request encoding
		response.addHeader("content-Type", "application/octet-stream");
		String fileName = request.getParameter("filename");//set filename is the name which download file's name
		
		
		response.addHeader("content-Disposition", "attachment; fileName="+fileName);
		
		String agent = request.getHeader("User-Agent");//get request header
		System.out.println(agent);

		//response.addHeader("content-Disposition", "attachment; fileName="+URLEncoder.encode(fileName, "UTF-8"));
		
		//response.addHeader("content-Disposition", "attachment; fileName==?UTF-8?B?"+new String(Base64.encodeBase64(fileName.getBytes("UTF-8")) ) +"?=");
		InputStream in = getServletContext().getResourceAsStream("/download/3.jpg");
		
		OutputStream out = response.getOutputStream();
		byte[] bt = new byte[1024];
		int len = -1;
		while( (len=in.read(bt)) != -1 ){
			out.write(bt,0,len);
		}
		out.close();
		in.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
