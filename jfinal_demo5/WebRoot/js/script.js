/**
 * 
 */
$(document).ready(function(){
	$("#change").click(function(){
		$.post("/form/edit",function(data){
			$.each(data,function(i,item){
				console.log($("#form_person input"))
			})
		})
	})
});