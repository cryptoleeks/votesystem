// **********************************************//
// program 客户端脚本
// 
// @author lenovo
// @date 2019-01-09
// @id 2c7d9463b770ea8b348b81cb4b38b66d
// **********************************************//
/**
 * onClickClient(jqButton52731)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton52731_onClickClient (rc){
	var programid=$("input[programid]").val();
	/*console.log(programid);
	Artery.openForm({

    "formId" : "e4ab614992e5990a14a53c009c611b01",

    "formName" : "编辑form",

    "formType" : "1",

    "params" : {

        "programid" : "{rs1.programid}"

    },

    "target" : "_window",

    "targetWidth" : 550,

    "targetHeight" : 450,

    "runTimeType" : "insert"

});*/
	
}
/**
 * onClickClient(jqButton17bd8)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton17bd8_onClickClient (rc,programid){
	//var programid=$("input[programid]").val();
	//var data = sessionStorage.getItem('imgadr');
	//进行提示，点击确定后再删除
Artery.confirmMsg("删除","此操作不可恢复，确定要删除吗？",function(btn){
  if(btn == "yes"){
    rc.put("programid",programid);
    rc.send(function(result){
      if(result=="ok"){
        //提示成功
        Artery.showMessage("删除成功，请继续！");
        //刷新列表
        Artery.get("loopAread9e19").reload();
      } 
    })
    }
})
	
}
/**
 * onLoadClient(form62ac3)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function form62ac3_onLoadClient (rc){
	var programid=$("input[programid]").val();
	sessionStorage.setItem('programid', programid);
	Artery.getWin().get("jqGridd64d2").reload();
	
}
/**
 * onClickClient(jqButton13d30)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton13d30_onClickClient (rc){
	 var json= Artery.get("jqGridd64d2").getSelectedRowJson();
	 var obj=json.jqColumnNumericf64fb;
	 //jqColumnNumericf64fb
	// console.log(json);
	Artery.confirmMsg("删除","此操作不可恢复，确定要删除吗？",function(btn){
  if(btn == "yes"){
    rc.put("programid",obj.text);
    rc.send(function(result){
      if(result=="ok"){
        //提示成功
        Artery.showMessage("删除成功，请继续！");
        //刷新列表
        Artery.get("jqGridd64d2").reload();
      } 
    })
    }
})
    
}
/**
 * onClickClient(jqButtoneadca)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtoneadca_onClickClient (rc){
	Artery.openForm({
		"formId" : "3ef758846bdbfbf7572859ccfcb056a6",
		"formName" : "成功界面",
		"formType" : "1",
		"target" : "_self",
		"runTimeType" : "update"
	});
}
/**
 * onClickClient(jqButton5a46a)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton5a46a_onClickClient (rc){
	
}