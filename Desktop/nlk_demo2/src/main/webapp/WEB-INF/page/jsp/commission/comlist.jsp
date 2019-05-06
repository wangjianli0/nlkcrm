<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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


	<script type="text/javascript">
	$(function() {
		//指定数据表格发送ajax请求的地址
		
		//页面加载完成后，创建数据表格datagrid
		$("#mytable").datagrid(
				
				    
						{
							url:'listcomm',
							height:window.innerHeight-100,
							fitColumns:true,//列自适应
							nowrap:false,//禁止文字自动换行
							loadMsg:'正在加载信息',
							//定义标题行所有的列，
							//单选框
							checkOnSelect : true,
								//显示分页条
							pagination : true,
							pageSize:5,//页大小，一页有多少数据
							pageNumber:1,//默认当前的页面
							singleSelect:true,//是否单行选择
							pagePosition:'bottom',//分页符在底部，可选参数为top，bottom
                                                                 //显示分页的条数
							pageList : [ 3, 5, 7, 10 ],//一页可显示数据的条目
							
							
							queryParams:{},//往后台传递参数，json格式
							columns : [ [ {
								title : '编号',
								field : 'id',
								align:'center',
								
								checkbox : true,width:100,align:'center',
								formatter:function(value,row,index){
							    	   return index + 1;
								}
							},
							 {
								title : '地区',
								field : 'areaName',width:100,align:'center'
							}, {
								title : '业务类型',
								field : 'type',width:100,align:'center'
							}, {
								title : '提成规则',
								field : 'rule',width:100,align:'center'
							},{
								title : '最小范围',
								field : 'minNum',width:100,align:'center'
								
								
							},{
								title : '最大范围',
								field : 'maxNum',width:100,align:'center'
								
							},{
								title : '提成比例(公司资源)',
								field : 'ratioCompany',width:100,align:'center'
							},{
								title : '提成比例(客户介绍)',
								field : 'ratioCustom',width:100,align:'center'
								
							},{
								field : 'c',
								title:'操作',width:100,align:'center',formatter : function(value,row,index){
									var str = "";
									 str += "<a href='javascripat:void(0);' onlick='updateBC("+row.id+")'>修改</a>&nbsp | &nbsp";
							    	   str += "<a href='javascripat:void(0);' onlick='deleteBC("+row.id+");'>删除</a>";
							    	   
							    	   return str;
								}
							} ] ],
						

                            rownumbers : true,
							singleSelect : true,
							//定义工具栏
							toolbar : [ {
								text : '添加',
								iconCls : 'icon-add',
								width:100,align:'center',
								handler : function (){
									$('#win').window({    
									    width:600,    
									    height:400,    
									    modal:true ,
									 	url:'addcomm'
									});  
									
									
								}
								
							}, {
								text : '删除',
								iconCls : 'icon-remove',
								
								
							}, {
								text : '修改',
								iconCls : 'icon-edit'
							}, {
								text : '查询',
								iconCls : 'icon-search'
							}
							
							],
						
						});
		
	}); 
	

	
	
	//删除
	function delectBC(id){
		if(confirm('确认删除')){
			$.ajax({
				url:"listcomm",
				type:"post",
				data:{"id":id},
				success:function(data){
					$("mytable").datagrid("reload");
				}
			})
		}
	}
	
	function addCA(){
		$ajax({
			url :"addcomm",
			data:data,
			type:"post",
			success:function(data){
				$('#win').window('close');  
				$("mytable").datagrid("reload");
			}
		})
		
	}
	
	
</script>

</head>
<body>


	<table id="mytable" ></table>
	
	<div closed="true" class="easyui-window" >
	<form id="win" method="post" action="addcomm" class="centers">

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
		<input class="easyui-textbox" type="submit" onclick="addCA()" value="添加">
	
	</form>
</div>
</body>

</html>