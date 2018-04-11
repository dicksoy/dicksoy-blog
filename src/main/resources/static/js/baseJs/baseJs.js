function ajaxRequest(type, url, data, before, complete, async, success, error) {
	$.ajax({  
		type: type,//使用post方法访问后台  
		dataType: "json",//返回json格式的数据  
		url: url,//要访问的后台地址
		data: data,//要发送的数据
		async: async,
		beforeSend: function() {
			before
		},
		complete: function(){
			complete
     	},//AJAX请求完成时
		success: success,
		error: function() {
			error
		}  
	});
}