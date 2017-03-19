<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
<!-- <script>        
    function getColumnDetail(column){   
        column.style.color = "blue";  //将被点击的单元格设置为蓝色  
        alert(column.innerHTML);  //弹出被点单元格里的内容  
    }         
    //trLineNumber为动态表格行数，tdData为动态表格每行单元格的数据，数据类型为数组-->  
    function setTable(trLineNumber,tdData){  
        var _table = document.getElementById("table");    
        var _row;    
        var _cell;            
        for (var i = 0; i < trLineNumber; i++) {   
            _row = document.createElement("tr");         
            document.getElementById("table").appendChild(_row);    
            for(var j = 0; j < tdData.length; j++) {    
                _cell = document.createElement("td");    
                _cell.onclick= function(){getColumnDetail(this)}; //为每个单元格增加单击事件  
                _cell.innerText = tdData[j];    
                _row.appendChild(_cell);    
            }  
  
        }  
    }         
</script>  --> 

<title>Insert title here</title>

</head>

<body>
<div class="container">
          <h1 class="page-header">用户管理</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
            <input type="button" style="background-image: url('../images/addUser.png'); width: 200px; height: 200px; 
            						 border-radius: 50%;
            						 background-color: white; border: 0 ;background-position: left;" onclick="location.href='add'">
              <!--  <img src="../images/addUser.png" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">-->
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped" id="table">
            
            </table>
          </div>
        </div>
</body>
</html>