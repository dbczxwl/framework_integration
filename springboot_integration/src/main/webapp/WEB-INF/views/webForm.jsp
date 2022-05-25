<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	function showUseParam()
	{
	    document.commitForm.action="showBookNameUseRequestParam";
	    document.commitForm.submit();
	}

    function showBookName()
    {
	    document.dynamicForm.action="showBookName";
	    document.dynamicForm.submit();
    } 

    function showAllInfo()
    {
	    document.dynamicForm.action="showAllInfo";
	    document.dynamicForm.submit();
    }
</script>
</head>
<body>
	<h1>Form transfer model</h1>
	<form  name="commitForm" action="commitForm" method="GET">
		<input type="text" name="bookName" placeholder="name is ..."/>
		<input type="submit" />
		<input type="button" name="showParam" value="RequestParam传参" onClick="showUseParam()"/>
	</form>

	<form name="dynamicForm" action="">
		<input type="text" name="bookName" placeholder="name is ..." />
		<input type="button" name="showBook" value="显示书名" onClick="showBookName()"/>
		<input type="button" name="showAll" value="显示全部" onClick="showAllInfo()"/>
	</form>
</body>

</html>