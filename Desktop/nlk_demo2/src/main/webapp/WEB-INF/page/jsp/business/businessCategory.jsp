<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath+"/" %>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务类别</title>

<script type="text/javascript"
	src="static/jquery-easyui-1.5.5/jquery.min.js"></script>
<script type="text/javascript"
	src="static/jquery-easyui-1.5.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="static/jquery-easyui-1.5.5/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="static/jquery-easyui-1.5.5/themes/default/easyui.css"
	type="text/css" />
<link rel="stylesheet" href="static/jquery-easyui-1.5.5/themes/icon.css"
	type="text/css" />

<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	html body{
		width: 100%;
		height: 100%;
	}
	.centers{
		/* text-align:center */
		margin-left: 100px
	}
	.centerss{
		/* text-align:center */
		margin-right: 70px
	} 

	.easyui-window{
		height:350px;
		width:420px;
	}
	.headercss {
	    margin-top: 10px;
	    margin-left: 10px;
	    margin-right: 10px;
	    margin-bottom: 0px;
	    
}
	#search_form{
	overflow: hidden;
	
	}
	.searchdiv{
	float: left;
	margin:40px auto;
	}
	.form_fieldset{
	height:100px;
	}
	.button_size{
	margin:40px auto;
	}
	.inputstyle,.ui_font{
		margin-left: 10px;
	}
	.inputstyle{
		margin-right: 10px;
	}
</style>

<script type="text/javascript">
$(function(){
	init();
});

//查看所有的业务类别
function init(){
	$("#listABC").datagrid({
		url:"listCategory",//请求查看所有业务类别的地址
		height:window.innerHeight-100,
		fitColumns:true,//列自适应
		nowrap:false,//禁止文字自动换行
		loadMsg:'正在加载信息',
		pagination:true,//是否有分页
		singleSelect:true,//是否单行选择
		pagePosition:'bottom',//分页符在底部，可选参数为top，bottom
		pageSize:10,//页大小，一页有多少数据
		pageNumber:1,//默认当前的页面
		pageList:[5,8,10,15,20],//一页可显示数据的条目
		queryParams:{},//往后台传递参数，json格式
		columns:[[
		       {field:'index',title:'序号',width:100,align:'center',formatter:function(value,row,index){
		    	   return index + 1;
		       }},
		       {field:'name',title:'业务类别名称',width:100,align:'center'},
		       {field:'code',title:'业务类别编号',width:100,align:'center'},
		       {field:'opt',title:'操作',width:100,align:'center',formatter:function(valur,row,index){
		    	   var str = "";
		    	   
		    	   str += "<a href='javascripat:void(0);' onlick='updateBC("+row.id+")'>修改</a>&nbsp | &nbsp";
		    	   str += "<a href='javascripat:void(0);' onlick='deleteBC("+row.id+")'>删除</a>";
		    	   
		    	   return str;
		       }}
		]]
	});
}

//打开窗口
function open_addWindow(){
	$("open_addWindow").window("open");
}

//添加业务类别
function addBC(){
	var data = $("#add_from").serialize();
	if($('add_name').textbox('getValue') == ''){
		alert("业务类别名称不能为空")
	}else if($('add_code').textbox('getValue') == ''){
		alert("业务类别编码不能为空")
	}else{
		$ajax({
			url:"addBC",
			data:data,
			type:"post",
			success:function(data){
				$("#add_form").form("clear");
				$("#open_addWindow").window("close");
				$("listABC").datagrid("reload");
			}
		})
	}
}

//删除
function delectBC(id){
	if(confirm('确认删除')){
		$.ajax({
			url:"deleteBC",
			type:"post",
			data:{"id":id},
			success:function(data){
				$("listABC").datagrid("reload");
			}
		})
	}
}

//模糊查询
function getABC(){
	var param = $("listABC").datagrid("options").queryParams;
	var sea = $("search_from").serializeArray();
	$.each(sea,function(i,e){
		param[e.name] = e.vale;
	});
	$("listABC").datagrid("relod");
}

//修改业务类别
function updateBC(id){
	$.ajax({
		url:'updateBC',
		async:true,
		type:'post',
		data:{'id':id},
		success:function(data){
			$("bc_name").textebox("setValue",data.name);
			$("bc_code").textebox("setValue",data.code);
		}
	})
	$('updateBC').window('open');
}

function close_updateBC(){
	$('#updateBC').window('close');
}
</script>
<!-- style="width:500px;height:250px;" -->
</head>
<body>
<!-- <div  id="ywlx" class="easyui-tabs" > -->
	<div class="headercss">
	<form id="search_form" action="BC" method="post">
		<fieldset class="form_fieldset">
			<div class="searchdiv">
				<label class="ui_font">名称：</label><input name="name" type="text" class="easyui-textbox">
			</div>
			<div class="searchdiv">
				<label class="ui_font">编号：</label><input name="code" type="text" class="easyui-textbox">
			</div>
			
			<div class="button_size">
				
				<input type="button" class="inputstyle" onclick="getABC()" value="查询">|
				<input type="button" class="inputstyle" onclick="open_addWindow()" value="添加">
			</div>
		</fieldset>
	</form>
	</div>
	
	<table id="listABC" title="查询结果"></table>
	
	<div id="open_addWindow" class="easyui-window" class="centers" title="添加" closed="true">
		<from id="add_from" method="post" class="centers">
			<div class="searchdiv">
				<label class="ui_font">业务类别名称：</label><input name="name" type="text" class="easyui-textbox" id="add_name">
			</div>
			<div class="searchdiv">
				<label class="ui_font">业务类别编号：</label><input name="code" type="text" class="easyui-textbox" id="add_code">
			</div>
			
			<div class="bcwiondow">
				<input class="centerss" type="submit" onclick="addBC()" value="保存">
			</div>
		</from>
	</div>
	
	<div id="updateWindow" class="easyui-window" title="修改" closed="true">
		<from id="update_from" method="post" class="centers" action="category/updateBC">
		<input type="hidden" id="eid" name="id">
			<div class="searchdiv">
				<label class="ui_font">业务类别名称：</label><input name="name" type="text" class="easyui-textbox" id="bc_name">
			</div>
			<div class="searchdiv">
				<label class="ui_font">业务类别编号：</label><input name="code" type="text" class="easyui-textbox" id="bc_code">
			</div>
			
			<div class="bcwiondow">
				<input class="centerss" type="submit" value="保存">
			</div>
		</from>
	</div>
	
	
<!-- </div> -->
</body>
</html>