//**********************************************//
//admin �ͻ��˽ű�

//@author ����
//@date 2019-01-09
//@id 3ef758846bdbfbf7572859ccfcb056a6
//**********************************************//
var checkn="";
/**
 * 加载时脚本(jqGrida2f7a)
 */

function jqGrida2f7a_onLoad (){
}
/**
 * onClickClient(jqButtonb970a)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtonb970a_onClickClient (rc){
	//document.write("<script language=javascript src='/votesystem/repository/eformjs/admin.js'></script>");
	//obj = document.getElementsByName("jqColumnCheckBoxd1898")
	var obj=sessionStorage.getItem('key');
	// var object=$("input[name=checkname]")[0];
	// object.val(obj);
	var object=document.getElementsByName("checkname")[0];
	object.value=obj;
//	console.log(object.value);
	Artery.get("jqFormAreacda9b").submit(function(result){
		if(result=="ok")
		{
			Artery.showMessage("投票成功");
			Artery.openForm({
				"formId" : "3ef758846bdbfbf7572859ccfcb056a6",
//				"formName" : "界面",
				"formType" : "1",
				"target" : "_self",
//				"targetWidth" : 550,
//				"targetHeight" : 450,
				"runTimeType" : "update"
			});
		}
		else
		{
			Artery.showMessage("投票失败");
		}
	});
}
/**
 * onClickSingleClient(jqColumnCheckBoxd1898)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqColumnCheckBoxd1898_onClickSingleClient (rc){
	var test=new Array();
	test=Artery.get("jqGrida2f7a").getValuesArray("jqColumnCheckBoxd1898");
	var number=new Array();
	number=Artery.get("jqGrid76fd7").getValuesArray("jqColumnStringselectnum");
	obj = document.getElementsByName("jqColumnCheckBoxd1898");
	/*var obj=$(":checkbox");
	var temp=eval(obj);*/
	check_val = [];
	checkn="";
	for(k in obj){
		if(obj[k].checked)
		{
			check_val.push(obj[k].value);
//			console.log(obj[k].value);
			kt=k;
			kt++;
			checkn=checkn+kt+"*";
		}
	}
	/*限制投票个数*/
	/*var json= Artery.get("jqGrida2f7a").getSelectedRowJson();
	var object=eval(json);
	if(check_val.length>number[0].value){
		alert("已勾选"+test.length+"项节目，请删除后再添加");
		var checkboxnum=0;
		checkboxnum=object.jqColumnStringprogramid.value;
		console.log(checkboxnum);
		var boxes = document.getElementsByName("jqColumnCheckBoxd1898");
		console.log(boxes[checkboxnum-1].checked);
		boxes[checkboxnum-1].checked = false;
	}*/
	
	//alert(check_val);
	//console.log(test);
	//console.log(obj.checked);
	//console.log(this);
	/*if(check_val.length>number[0].value)
	{
		var json= Artery.get("jqGrida2f7a").getSelectedRowJson();
		var object=eval(json);
		var checkboxnum=0;
		checkboxnum=object.jqColumnStringprogramid.value;
		obj[checkboxnum].checked=false;
//		obj[1].attr("checked","false");
		//this.hidden=true;
		alert("已勾选"+test.length+"项节目，请删除后再添加");
		var i=0;
		for(k in obj){
			if(obj[k].checked)
				obj[k].checked=false;
		}
		for(var k=0;k<test.length;k++){
//			console.log(test[k].value);
			obj[test[k].value-1].checked=true;
		}
		checkn="";
		for(k in test){
			kt=test[k].value;
			checkn=checkn+kt+"*";
		}
		//var k=0;
		while(1)
					    	{
					    	console.log(i);
					    		//k=test[i].value;
					    		if((test[i]==undefined)&&(obj[i].checked==true))
					    			{
					    				//console.log(i);
					    				obj[i].checked=false;
					    				break;
					    			}
					    		i++;
					    	}
		//this.value.checked = false;
		//Artery.get("jqGrida2f7a")。deselectAllCheckbox("jqColumnCheckBoxd1898");
	}*/
	sessionStorage.removeItem('key');
	sessionStorage.setItem('key',checkn);
//	console.log(checkn);
}
/**
 * onClickClient(jqButtona0bbd)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtona0bbd_onClickClient (rc){
	rc.send(function(result){
		if(result=="ok")
		{
			Artery.showMessage("已结束投票");
		}
		else
		{
			Artery.showMessage("结束投票失败");
		}
	});
}
/*
function checknumber(){
	var data=sessionStorage.getItem('key');
	console.log(data);
	return data;
}*/

/**
 * onClickClient(jqButton0cb50)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton0cb50_onClickClient (rc){
	Artery.openForm({
		"formId" : "2c7d9463b770ea8b348b81cb4b38b66d",
		"formName" : "成功界面",
		"formType" : "1",
		"target" : "_self",
		"runTimeType" : "update"
	});
}
/**
 * onClickClient(jqButton19b97)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButton19b97_onClickClient (rc){
	window.opener=null;
	window.open('','_self');
	window.close();
}
/**
 * onClickClient(jqButtondf647)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtondf647_onClickClient (rc){
	rc.send(function(res){
		if(res=="ok")
		{
			Artery.showMessage("已开始投票");
		}
		else
		{
			Artery.showMessage("开始投票失败");
		}
	});
}
/**
 * onClickClient(jqButtona55b9)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtona55b9_onClickClient (rc){
	rc.send(function(res){
		if(res=="ok")
		{
			Artery.showMessage("清除成功");
			Artery.getWin().get("jqGrida2f7a").reload();
		}
		else
		{
			Artery.showMessage("清除失败");
		}
	});
	
}