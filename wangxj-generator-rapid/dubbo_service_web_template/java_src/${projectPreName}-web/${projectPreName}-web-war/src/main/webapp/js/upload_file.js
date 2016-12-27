$(function(){
	
	$("#upload_button").click(function(){
		//开始上传文件时显示一个图片,文件上传完成将图片隐藏  
	    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});  
	    //执行上传文件操作的函数  
	    $.ajaxFileUpload({  
	        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
	        url:'upload',  
	        secureuri:false,                           //是否启用安全提交,默认为false   
	        fileElementId:'upload_file',               //文件选择框的id属性  
	        dataType:'text',                           //服务器返回的格式,可以是json或xml等  
	        success:function(data, status){            //服务器响应成功时的处理函数  
	           alert(data);
	        },  
	        error:function(data, status, e){ //服务器响应失败时的处理函数  
	            $('#result').html('图片上传失败，请重试！！');  
	        }  
	    });
	})
	
	
})

