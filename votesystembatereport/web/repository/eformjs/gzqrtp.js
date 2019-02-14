//**********************************************//
//����ȷ��ͶƱ �ͻ��˽ű�

//@author yxl
//@date 2019-01-12
//@id 861adab9f89342682b816c5b9ca94df5
//**********************************************//
/**
 * onClickClient(jqButtona89be)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtona89be_onClickClient (rc){
	Artery.getWin().close();
}
/**
 * onClickClient(jqButtone6614)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtone6614_onClickClient (rc){
	var json=Artery.getParams();
	var temp=json.viewerjson;
	//console.log(temp);
	var str=eval(temp);
	//获得上一个页面的观众名和投票节目
	var username=str[0].username.viewername;
	var votecheck=str[0].votecheck;
	var object=document.getElementsByName("tj")[0];
	object.value=votecheck+username;
	Artery.get("jqFormAreabbc9f").submit(function(res){
		if(res=="false"){
			Artery.openForm({
				"formId" : "7409bde5ec66fe4e5b38085fe3a1f048",
				"formName" : "投票成功界面",
				"formType" : "1",
				"target" : "_parent",
				"targetWidth" : 550,
				"targetHeight" : 450,
				"runTimeType" : "update"
			});	
		}else if(res=="true"){
			Artery.openForm({
				"formId" : "7409bde5ec66fe4e5b38085fe3a1f048",
				"formName" : "投票成功界面",
				"formType" : "1",
				"target" : "_parent",
				"targetWidth" : 550,
				"targetHeight" : 450,
				"runTimeType" : "update",
				"params" : {"username" : username,
					"votecheck":votecheck
				}
			});
		}
		Artery.getWin().close();
	});

}
/**
 * onUnloadClient(formc921d)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function formc921d_onUnloadClient (rc){
	Artery.getWin().close();
}