<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="add_from" method="post" action="addcomm">

		<div>
			<label for="areaName">地区</label> <input class="easyui-textbox"
				type="text" name="areaName" id="add_name">
		</div>
		<div>
			<label for="type">业务类型</label> <input class="easyui-textbox"
				type="text" name="type">
		</div>
		<div>
			<label for="rule">提成规则</label> <input class="easyui-textbox"
				type="text" name="rule">
		</div>
		<div>
			<label for="minNum">最小范围</label> <input class="easyui-textbox"
				type="text" name="minNum">
		</div>
		<div>
			<label for="maxNum">最大范围</label> <input class="easyui-textbox"
				type="text" name="maxNum">
		</div>
		<div>
			<label for="ratioCompany">提成比例(公司资源)</label> <input
				class="easyui-textbox" type="text" name="ratioCompany">
		</div>
		<div>
			<label for="ratioCustom">提成比例(客户介绍)</label> <input
				class="easyui-textbox" type="text" name="ratioCustom">
		</div>
		<input class="easyui-textbox" type="submit" onclick="add()" value="添加">
	
	</form>
</body>
</html>