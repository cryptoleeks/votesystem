
/**
 * onClickClient(jqButtona3592) var uploadFile = new FormData();
 * uploadFile.append("file", $("#single")[0].files[0]);//单张上传获得FormData
 * console.log(uploadFile); if("undefined" != typeof(uploadFile) && uploadFile !=
 * null && uploadFile != ""){ $.ajax({ url:'/ssm/picture/save', type:'POST',
 * data:uploadFile, async: false,   cache: false, contentType: false, //不设置内容类型
 * processData: false, //不处理数据 success:function(data){ console.log(data);
 * alert(data.msg); }, error:function(){ alert("上传失败！"); } }) }else {
 * alert("选择的文件无效！请重新选择"); }
 * 
 * 
 * @param rc
 *            系统提供的AJAX调用对象
 */
function jqButtona3592_onClickClient(rc) {
	var uploadFile = new FormData();
	var imgadr=$("input[name='imgadr']");
	uploadFile.append("file", $("#single")[0].files[0]);// 单张上传获得FormData
	console.log(uploadFile);
	if ("undefined" != typeof(uploadFile) && uploadFile != null
			&& uploadFile != "") {
		$.ajax({
					url : '/ssm/picture/save',//www.loveyx815.cn
					type : 'POST',
					data : uploadFile,
					async : false,
					cache : false,
					contentType : false, // 不设置内容类型
					processData : false, // 不处理数据
					success : function(data) {
						alert("上传：" + data);
						console.log(data);
						var json=JSON.parse(data);
						
						imgadr.attr("value",json.img);
						console.log(imgadr.val());
						alert("上传成功");
					},
					error : function() {
						alert("上传失败！");
					}
				})
	} else {
		alert("选择的文件无效！请重新选择");
	}

}
/**
 * onClickClient(jqButton26448)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton26448_onClickClient (rc){
	       Artery.get("jqFormAreae5f09").submit(function(res){
        if(res=="ok"){
            Artery.showMessage("添加成功");
            
            Artery.getWin().close();
        }else{
            Artery.showError(res);
        }
    });
	Artery.getWin().get("jqGridd64d2").reload();
    Artery.openForm({
  "formId" : "2c7d9463b770ea8b348b81cb4b38b66d",
  "formName" : "节目列表",
  "formType" : "1",
  "title" : "节目列表",
  
  "target" : "_parent",
 
  "runTimeType" : "update"
});
	
}
/**
 * onMouseEnterClient(jqButtona3592)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtona3592_onMouseEnterClient (rc){
	
}