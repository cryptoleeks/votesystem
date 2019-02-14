/**
 * onClickClient(jqButtond71e0)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtond71e0_onClickClient (rc){
	Artery.get("jqFormAreae64b3").submit(function(result)
			{
		if(result == "ok")
		{
			Artery.showMessage("添加成功");	
			Artery.getWin().get("jqGrid76fd7").reload();
			Artery.getWin().close();
			//close the window
		}
		else
		{
			Artery.showMessage("添加失败");
		}

			});

}
/**
 * onLoadClient(formab9df)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function formab9df_onLoadClient (rc){
	//154532ck68dheew98h2qdv1yudu9gw9g
	
}
/**
 * onUnloadClient(formab9df)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function formab9df_onUnloadClient (rc){
	Artery.getWin().close();
	
}