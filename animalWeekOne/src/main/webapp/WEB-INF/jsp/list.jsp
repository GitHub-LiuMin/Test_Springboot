<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>列表</title>
		<link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css"> 
		<link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css"> 
		<script type="text/javascript" src="/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="/easyui/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
		
			//添加操作按钮
			function fmtButton(cellVal,rowObj,rowIndex){
				
				// cellVal：字段值。 rowObj：行记录数据。rowIndex: 行索引。 
				var fmt='<input value="详情" type="button"  onclick="update('+rowIndex+')">';
				/* fmt+='<input value="修改" type="button" onclick="update('+rowIndex+')">'; */
				
				return fmt;
			}
			
			//修改
			function update(rowIndex){
				//返回当前页的所有行。
				var rows=$('#dg').datagrid('getRows');
				//匹配选中的行
				var rowObj = rows[rowIndex];
				$.ajax({
					url:"/qing/toSave",
					type:"post",
					data:{},
					dataType:"json",
					success:function(ja){
						$("#type").empty("");
						for ( var i in ja) {
							//动态回显
							$("#type").append("<input id='ridaa' name='rid' type='checkbox' value="+ja[i].rid+">"+ja[i].rname+"</input>&nbsp;&nbsp; ")
								
						}
					},
					error:function(){
						alert("回调失败");
					}
				})
				
				var se = rowObj.rid;// 3,4
				alert(se);
				 for (var i = 0; i < se.length; i++) {  
					 alert(se[i])
			            $('#maingrid').datagrid('selectRecord', se[i]); //根据id选中行   
			        }  
					
				$('#aname').textbox('setValue',rowObj.aname);
				$('#weight').textbox('setValue',rowObj.weight);
				//$('#type').combobox('select',rowObj.rid);
				$('#win').window('open');
			}
			//文档就绪函数
			$(document).ready(function(){
				
				$('#win').window('close');
			});
			
			//关闭添加窗口
			function closeWindow() {
				$('#win').window('close');
			}
			
			//弹框添加和动态回显多选框
			function toSave(){
			
				$.ajax({
					url:"/qing/toSave",
					type:"post",
					data:{},
					dataType:"json",
					success:function(ja){
						$("#type").empty("");
						for ( var i in ja) {
							//动态回显
							$("#type").append("<input name='rid' type='checkbox' value="+ja[i].rid+">"+ja[i].rname+"</input>&nbsp;&nbsp; ")
						}
					},
					error:function(){
						alert("回调失败");
					}
				})
				//打开add窗口
				$('#win').window('open');
			}
			
			//添加
			 function submit(){
				$('#form').form('submit', {    
				    url:"/qing/save",    
				    success: function(param){    
				       $("#dg").datagrid("reload");
				       $('#win').window('close');      
				    }    
				});  
			}
			//详情
			function particulars(rowIndex){
				var rows = $('#dg').datagrid('getRows');
				var rowObj = rows[rowIndex];
				var id = rowObj.bid;
				alert(id);
				var url = "/html/"+id+".html";
				window.open(url,"_blank");
			}
			//批量删除
			function batchDelete(){
				var selRow=$('#dg').datagrid('getSelections');
				if (selRow.length <= 0) {
					//请选择数据提示的操作
					$.messager.alert('提示', '请选择要删除的数据!', 'info');
					return false;
				}else{
					$.messager.confirm('提示', '确定删除数据？', function(aa){
						
						if(aa){
							var ids="";
							for (var i = 0; i < selRow.length; i++) {
								ids+=selRow[i].aid+",";
								
							}
							$.ajax({
								url:"/qing/batchDelete",
								data:{"ids":ids},
								type:"post",
								dataType:"json",
								success:function(boo){
									if(boo == true){
										alert("删除成功");
										$("#dg").datagrid("reload");
									}else{
										alert("删除失败");
									}
								},
								error:function(){
									alert("回调失败");
								},
							})
						}
					});
				}
			}
		</script>
	</head>
	<body class="easyui-layout">
	<!--布局  -->
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">   
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>   
    <!-- 中间 -->
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    	<!-- 表格 -->
    <table id="dg" class="easyui-datagrid" style="width:100%;height:100%"   
	       data-options="url:'/qing/list',fitColumns:true,pagination:true,singleSelect:false,striped:true,toolbar:'#batn'">   
	    <thead>   
	        <tr>   
	            <th data-options="field:'aid',width:100,checkbox:true,singleSelect:false">全选</th>   
	            <th data-options="field:'aname',width:100">动物名称</th>   
	            <th data-options="field:'rname',width:100">分布范围</th>   
	            <th data-options="field:'weight',width:100">体重</th>   
	            <th data-options="field:' ',width:100,formatter:fmtButton">操作</th>   
	        </tr>   
	    </thead>   
	</table> 
    </div>   
    </div>
<!-- 定义窗口，用于保存和新增博文 -->
		<div id="win" class="easyui-window" title="添加页面" style="width:600px;height:400px"   
		        data-options="iconCls:'icon-save',modal:true">   
		    <div class="easyui-layout" data-options="fit:true">   
		        <div data-options="region:'center'">
		        	<!-- 定义Form表单 -->
					<form id="form" method="post">   
					    <div style="margin-top: 12px" align="left">   
					        <label for="aname">动物名称:</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
					        <input id="aname" name="aname" class="easyui-textbox"  style="width:300px">  
					    </div>   
					    <div style="margin-top: 12px" align="left">   
					        <label for="weight">体重:</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
					        <input id="weight" name="weight" class="easyui-textbox"  style="width:300px">  
					    </div>   
					    <div style="margin-top: 12px" align="left">   
					        <label for="rid"  >分布范围:&nbsp;&nbsp;&nbsp;&nbsp;</label> 
					   		    <span id="type"></span>
					    </div>   
					    <div style="margin-top: 12px" align="center">   
							<a   class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit()" >保存</a>  
			    			<a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeWindow()">关闭</a>
					    </div>   
				</form>  
		        </div>   
		    </div>   
		</div>
<div id="batn">
	<!-- 添加按钮 -->
    		<a   class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toSave()">添加</a>  
    		<a  class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="batchDelete()">批量删除</a>  
</div>
	</body>
</html>