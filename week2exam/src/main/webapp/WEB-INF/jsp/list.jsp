<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/7/16
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>列表</title>

    <!-- jquery核心库 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.min.js"></script>
    <!-- easyui核心库 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
    <!-- easyui核心UI文件 css -->
    <link href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"/>
    <!-- easyui图标 -->
    <link href="<%=request.getContextPath() %>/easyui/themes/icon.css" rel="stylesheet" type="text/css"/>
    <!--加入中文 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">

        //添加操作按钮
        function fmtButton(cellVal, rowObj, rowIndex) {

            // cellVal：字段值。 rowObj：行记录数据。rowIndex: 行索引。 
            var fmt = '<input value="详情" type="button"  onclick="particulars(' + rowIndex + ')">';
            /* fmt+='<input value="修改" type="button" onclick="update('+rowIndex+')">'; */

            return fmt;
        }


        //文档就绪函数
        $(document).ready(function () {

            $('#win').window('close');
        });

        //关闭添加窗口
        function closeWindow() {
            $('#win').window('close');
        }

        //弹框添加和动态回显多选框
        function toSave() {
            $("#bc").linkbutton({
                disabled:false,
            })

            $("#cname").textbox('setValue',"");
            $("#type").textbox('setValue',"");
            $.ajax({
                url:"<%=request.getContextPath() %>/qing/toSave",
                type:"post",
                dataType:"json",
                success:function (ja) {
                    $("#guo").empty();
                    for (var i in ja) {
                        $("#guo").append("<input type='checkbox' name='gid' value="+ja[i].gid+">"+ja[i].gname)
                    }
                },
                error:function () {
                    alert("error");
                },
            })
            $("#win").window('open');
        }

        //添加
        function submit() {
            $('#form').form('submit', {
                url: "/qing/save",
                success: function (param) {
                    $.messager.alert('提示','添加成功','info')
                    $("#dg").datagrid("reload");
                    $('#win').window('close');
                }
            });
        }


        //批量删除
        function batchDelete() {
            //获得选中的行
            var selObj = $("#dg").datagrid("getSelections");
            if(selObj.length<=0){
                $.messager.alert('提示','请选择一个删除','info');
            }else{
                $.messager.confirm('警告','确定要删除吗？？？',function (isDelete) {
                    if(isDelete){
                        var ids = "";
                        for (var i = 0; i < selObj.length; i++) {
                            ids += selObj[i].cid + ",";
                        }
                        $.ajax({
                            url:"<%=request.getContextPath() %>/qing/batchDelete",
                            type:"post",
                            data:{ids:ids},
                            dataType:"json",
                            success:function (ja) {
                                $.messager.alert('提示','删除成功','info')
                                $("#dg").datagrid("reload");
                            },
                            error:function () {
                                alert("error");
                            },
                        })
                    }
                })
            }

        }

        //详情
        function particulars(rowIndex) {

            //获得所有的行
          var objRows =   $("#dg").datagrid("getRows");
            var obj = objRows[rowIndex];
            var sel =obj.gid;
            $.ajax({
                url:"<%=request.getContextPath() %>/qing/toSave",
                type:"post",
                dataType:"json",
                success:function (ja) {
                    $("#guo").empty();
                    for (var i = 0; i < ja.length; i++) {
                        if(sel.indexOf(ja[i].gid)>=0){
                            $("#guo").append("<input type='checkbox' name='gid' value="+ja[i].gid+" checked>"+ja[i].gname)
                        }else{
                            $("#guo").append("<input type='checkbox' name='gid' value="+ja[i].gid+">"+ja[i].gname)
                        }

                    }
                },
                error:function () {
                    alert("error");
                },
            })

            $("#cname").textbox('setValue',obj.cname);
            $("#type").textbox('setValue',obj.type);
            $("#bc").linkbutton({
                disabled:true,
            })
            $("#win").window('open');
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
               data-options="url:'<%=request.getContextPath() %>/qing/list',fitColumns:true,pagination:true,singleSelect:false,striped:true,toolbar:'#batn',striped:true,">
            <thead>
            <tr>
                <th data-options="field:'cid',width:100,checkbox:true,singleSelect:false">全选</th>
                <th data-options="field:'cname',width:100">企业名称</th>
                <th data-options="field:'type',width:100">行业</th>
                <th data-options="field:'gname',width:100">国家</th>
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
                    <label for="cname">企业名称:</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input id="cname" name="cname" class="easyui-textbox" style="width:300px">
                </div>
                <div style="margin-top: 12px" align="left">
                    <label for="type">行业:</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input id="type" name="type" class="easyui-textbox" style="width:300px">
                </div>
                <div style="margin-top: 12px" align="left">
                    <label for=" ">用户组:&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <span id="guo"></span>
                </div>
                <div style="margin-top: 12px" align="center">
                    <a id="bc" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit()">保存</a>
                    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeWindow()">关闭</a>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="batn">
    <!-- 添加按钮 -->
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toSave()">添加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="batchDelete()">批量删除</a>
</div>
</body>
</html>
