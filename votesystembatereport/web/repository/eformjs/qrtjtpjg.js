//**********************************************//
//ȷ���ύͶƱ��� �ͻ��˽ű�

//@author ����
//@date 2019-01-11
//@id 5c3e86073c0d977206b7d6670adcc9eb
//**********************************************//

/**
 * onClickClient(jqButtond4270)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtond4270_onClickClient (rc){
	Artery.getWin().close();
}
/**
 * onClickClient(jqButton2bf76)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton2bf76_onClickClient (rc){
	//document.write("<script language=javascript src='/votesystem/repository/eformjs/admin.js'></script>");
	//obj = document.getElementsByName("jqColumnCheckBoxd1898")
	var obj=sessionStorage.getItem('key');
	// var object=$("input[name=checkname]")[0];
	// object.val(obj);
	var object=document.getElementsByName("checkname")[0];
	object.value=obj;
//	console.log(object.value);
	Artery.get("jqFormArea8f853").submit(function(result){
		if(result=="ok")
		{
			Artery.showMessage("投票成功");
			Artery.openForm({
				"formId" : "3ef758846bdbfbf7572859ccfcb056a6",
//				"formName" : "界面",
				"formType" : "1",
				"target" : "_parent",
//				"targetWidth" : 550,
//				"targetHeight" : 450,
				"runTimeType" : "update"
			});
		}
		else
		{
			Artery.showMessage("投票失败");
			Artery.getWin().close();
		}
	});
}