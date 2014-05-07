<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="HtmlEditor/editorArea.css">
		<title>演示及说明</title>
	</head>
	<body>
		<form method=post action="result.php">
			编辑器调用开始
			<!-- 注意 TEXTAREA 的 NAME 应与 ID=??? 相对应-->
			<textarea name="content" style="display: none">&nbsp;</textarea>
			<iframe ID="Editor" name="Editor"
				src="HtmlEditor/index.html?ID=content" frameBorder="0"
				marginHeight="0" marginWidth="0" scrolling="No"
				style="height: 320px; width: 100%"></iframe>
			<!-- 编辑器调用结束 -->
			<input type="submit">
			<input type="reset">
		</form>
	</body>
</html>
