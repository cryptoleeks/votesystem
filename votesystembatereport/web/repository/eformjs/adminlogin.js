// **********************************************//
// adminlogin 客户端脚本
// 
// @author lenovo
// @date 2019-01-08
// @id 7f3161679625d71756f2a0b21b32cf8d
// **********************************************//
/**
 * onClickClient(jqButtondda81)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtondda81_onClickClient (rc){
	Artery.get("jqFormAreaea824").submit(function(res){
		if(res=="ok"){
			Artery.showMessage("登录成功");
			Artery.openForm({
				"formId" : "3ef758846bdbfbf7572859ccfcb056a6",
				"formName" : "登录成功界面",
				"formType" : "1",
				"target" : "_self",
				"targetWidth" : 550,
				"targetHeight" : 450,
				"runTimeType" : "update"
			});
		}else{
			Artery.showError(res);
		}
	});
}