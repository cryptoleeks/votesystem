//**********************************************//
//ȷ�Ͻ���ͶƱ �ͻ��˽ű�

//@author ����
//@date 2019-01-11
//@id 9e19b6f0f7afbcdd94c6f522c26f68ec
//**********************************************//
/**
 * onClickClient(jqButton9ea4d)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton9ea4d_onClickClient (rc){
	Artery.getWin().close();
}
/**
 * onClickClient(jqButton7e851)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton7e851_onClickClient (rc){
	Artery.get("jqFormAreaa6c22").submit(function(result){
		if(result=="ok")
		{
			Artery.showMessage("已结束投票");
		}
		else
		{
			Artery.showMessage("结束投票失败");
			Artery.getWin().close();
		}
	});
}