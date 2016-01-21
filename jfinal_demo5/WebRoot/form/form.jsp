<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head xmlns="http://www.w3.org/1999/xhtml">
<title>index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
console.log("123456789")
$.post( "/form/getPersonJson", function( data ) {
	$.each(data,function(i, item) {		       			 	       	
		      $("#persontable tr:last").after(
		       		'<tr class="trclass"><td>' + item.LastName +item.FirstName+
		       		'</td><td>'+ item.Address +
		       		'</td><td>'+ item.City + 
		       		'</td><td>'+ ((item.Age==null)?"":item.Age) +
		       		'</td><td><a href="/form/delete/'+
		       		''+item.ID+'">删除     </a>'+
		       		'<a id="change" href="/form/edit/'+item.ID+'">修改</a></td></tr>').html();
		  }
	)		        
}
	,"json");
	
	function seachByCity(){
		var str=$("#searchInput").val()
		$.post( "/form/searchCity",{City:str},function( data ) {
			$("#persontable tr:gt(0)").remove();
			$.each(data,function(i, item) {				
				$("#persontable tr:last").after(
				       		'<tr class="trclass"><td>' + item.LastName +item.FirstName+
				       		'</td><td>'+ item.Address +
				       		'</td><td>'+ item.City + 
				       		'</td><td>'+ ((item.Age==null)?"":item.Age) +
				       		'</td><td><a href="/form/delete/'+
				       		''+item.ID+'">删除     </a>'+
				       		'<a id="change" href="/form/edit/'+item.ID+'">修改</a></td></tr>');
				  }
			)		        
		}
			,"json");
	}
	</script>

</head>
<body>
 <a href="/form/add">添加</a>
 <input id="searchInput" type="text" name="search"><button id="searchButton" type="button" onclick="seachByCity()">搜索</button>
        <table id="persontable" border="1">
            <tr>
                <td>
                    姓名
                </td>
                <td>
                   地址
                </td>
                <td>
                   城市
                </td>
                <td>
                  年龄                      
                </td>
                <td>
                  操作                      
                </td>
            </tr>
       </table>
       
       <div style="display: none;" >
       <button id="searchButton" type="button" style="hidden" onclick="print()">打印</button></div> 
</body>
<script>
console.log("123456789")

function print(){
/**	console.log("99999");
	$("#persontable tr:gt(0)").css( "color", "red" );
	$("#persontable tr:gt(0)").remove();*/
	console.log($("#searchInput").val())
}
</script>
</html>