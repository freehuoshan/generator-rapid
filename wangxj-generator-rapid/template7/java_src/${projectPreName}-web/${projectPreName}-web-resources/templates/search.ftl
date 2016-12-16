<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>搜索</title>
    <!-- jquery -->
    <script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
    <!-- bootstrap -->
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 	<script src="js/ajaxfileupload.js"></script>
 	<script src="js/upload_file.js"></script>
 	<style>
		.col-sm-4{
	    position: absolute;
		  top: 50%;
		  left: 50%;
		  transform: translate(-50%, -20%);
	}
	
	</style>
  </head>
  <body>
  
	<div class="col-lg-6">
		<input type="file" name="file" id="upload_file"/>
		<input type="button" id="upload_button" value="上传"/>
	</div>
	  
    <div class="col-sm-4">
	   <div class="input-group">
	       <input type="text" class="form-control" onkeydown="onKeyDown(event)"/>
	       <span class="input-group-addon""><i class="glyphicon glyphicon-search"></i></span>
	   </div>
	</div>
             
             
     <script type="text/javascript">
     
         function onKeyDown(event){
             var e = event || window.event || arguments.callee.caller.arguments[0];
             if(e && e.keyCode==27){ // 按 Esc 
             	alert('esc');
                 //要做的事情
             }
             if(e && e.keyCode==113){ // 按 F2 
                  //要做的事情
                 alert('f2');
             }            
             if(e && e.keyCode==13){ // enter 键
                  alert(this.val);
             }
             
         }
      </script>
  </body>
</html>