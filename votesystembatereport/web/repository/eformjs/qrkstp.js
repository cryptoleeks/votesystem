//**********************************************//
//ȷ�Ͽ�ʼͶƱ �ͻ��˽ű�

//@author ����
//@date 2019-01-11
//@id f5f49fc6e23681d4e4f500ab2c7443dc
//**********************************************//
/**
 * onClickClient(jqButton2c87d)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton2c87d_onClickClient (rc){
	Artery.getWin().close();
}
/**
 * onClickClient(jqButton46450)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton46450_onClickClient (rc){
	Artery.get("jqFormArea48eb5").submit(function(result){
		if(result=="ok")
		{
			Artery.showMessage("已开始投票");
		}
		else
		{
			Artery.showMessage("开始投票失败");
			Artery.getWin().close();
		}
	});
}