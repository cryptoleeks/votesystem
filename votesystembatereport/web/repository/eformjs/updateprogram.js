// **********************************************//
// updateprogram 客户端脚本
// 
// @author lenovo
// @date 2019-01-11
// @id e4ab614992e5990a14a53c009c611b01
// **********************************************//
/**
 * onClickClient(jqButton3eaaf)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton3eaaf_onClickClient (rc){
	var uploadFile = new FormData();
    var imgadr=$("input[name='imgadr']");
    var programid=$("input[name='programid']");
    var programname=$("input[name='programname']");
     sessionStorage.setItem('programid', programid.val());
     sessionStorage.setItem('programname', programname.val());
    //var imgadr=$("input[name='imgadr']");
    /*uploadFile.append("file", $("#single")[0].files[0]);// 单张上传获得FormData
    console.log(uploadFile);
    if ("undefined" != typeof(uploadFile) && uploadFile != null
            && uploadFile != "") {
        $.ajax({
                    url : '/ssm/picture/save',
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
                        //alert(data.msg);
                    },
                    error : function() {
                        alert("上传失败！");
                    }
                })
    } else {
        alert("选择的文件无效！请重新选择");
    }*/

}
/**
 * onClickClient(jqButton1f2ee)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton1f2ee_onClickClient (rc){
	                    // 从sessionStorage获取数据
                        //var data = sessionStorage.getItem('imgadr');
                       /* if(data!=null){
                              var imgadr=$("input[name='imgadr']");
                               imgadr.attr("value",json.img);
                                // 从sessionStorage删除保存的数据
                            sessionStorage.removeItem('imgadr');
                        }*/
                        
                       
	Artery.get("jqFormArea54e49").submit(function(res){
        if(res=="ok"){
            Artery.showMessage("更改成功！");
            
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
 * onLoadClient(formd6db8)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function formd6db8_onLoadClient(rc) {
    /*var picset = $(".picset");
    var programid = $("input[name='programid']");
    var programname = $("input[name='programname']");
	var picsetsession = sessionStorage.getItem('imgadr');//获得更新后的图片路径
	var idsession=sessionStorage.getItem('programid');
	var namesession=sessionStorage.getItem('programname');
	if (picsetsession != null) {
		
		picset.attr("src", picsetsession);
		// 从sessionStorage删除保存的数据
		sessionStorage.removeItem('imgadr');
	}
	if(idsession!=null){
	   programid.val(idsession);
	   sessionStorage.removeItem('idsession');
	}
	if(namesession!=null){
	   programname.val(namesession);
	   sessionStorage.removeItem('namesession');
	}*/

}