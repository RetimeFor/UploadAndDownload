<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 上传文件的表单提交方式必须为post(get会放在地址栏里显示数据，但是地址栏里能存放的get的数据是255个字符)  而且必须在后面设置编码格式 enctype="multipart/form-data"-->
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		文件名:<input type="text" name="file_name">
		文件号:<input type="text" name="file_id"><br>
		<br>
		上传文件:<input type="file" name="the-file">
		<input type="submit" value="提交">
	</form>
	<br>
	<a href="DownloadServlet?filename=3.jpg">下载文件</a>
</body>
</html>