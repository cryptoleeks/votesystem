//**********************************************//
//vote �ͻ��˽ű�

//@author yxl
//@date 2019-01-10
//@id ca21ba559e07fe17b00b75e0dd1925e1
//**********************************************//

/**
 * onClickSingleClient(jqColumnCheckBox2fbdd)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
var checkn="";
function jqColumnCheckBox2fbdd_onClickSingleClient (rc){
	var test=new Array();
	test=Artery.get("jqGridcd761").getValuesArray("jqColumnCheckBox2fbdd");
	var number=new Array();
	number=Artery.get("jqGridcd761").getValuesArray("jqColumnStringselectnum");
	obj = document.getElementsByName("jqColumnCheckBox2fbdd");
	check_val = [];
	checkn="";
	for(k in obj){
		if(obj[k].checked)
		{
			check_val.push(obj[k].value);
			kt=k;
			kt++;
			checkn=checkn+kt+"*";
		}
	}
	var json= Artery.get("jqGridcd761").getSelectedRowJson();
	var grid=Artery.get("jqGridcd761");
	//console.log(json);
	//console.log(grid);
	var object=eval(json);
	//console.log(object);
	if(check_val.length==0){
	   alert("请投上您宝贵的一票！");
	   return;
	}
	if(check_val.length>number[0].value){
		alert("已勾选"+test.length+"项节目，请删除后再添加");
		var checkboxnum=0;
		//console.log(object);
		checkboxnum=object.jqColumnStringprogramid.value;
		//console.log(checkboxnum);
		var boxes = document.getElementsByName("jqColumnCheckBox2fbdd");
		//console.log(boxes[checkboxnum-1].checked);
		boxes[checkboxnum-1].checked = false;
		checkn="";
		for(k in test){
			kt=test[k].value;
			checkn=checkn+kt+"*";
		}
	}

	/*if(check_val.length>number[0].value)
	{

		alert("已勾选"+test.length+"项节目，请删除后再添加");
		var i=0;
		for(k in obj){
			if(obj[k].checked)
				obj[k].checked=false;
		}
		for(var k=0;k<test.length;k++){
			obj[test[k].value-1].checked=true;
		}
		checkn="";
		for(k in test){
			kt=test[k].value;
			checkn=checkn+kt+"*";
		}

	}*/
	$("input[name='votecheck']").val(checkn);
}

/**
 * onClickClient(jqButtonab045)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtonab045_onClickClient (rc){
	var votecheck=$("input[name='votecheck']").val();
	console.log(votecheck);
	var username=Artery.getParams();
	var  params = [];
	params.push({"votecheck":votecheck,"username":username});
	var json = JSON.stringify(params);
	Artery.openForm({
		"formId" : "861adab9f89342682b816c5b9ca94df5",
		"formName" : "观众确认票界面",
		"formType" : "1",
		"target" : "_window",
		"targetWidth" : 500,
		"targetHeight" : 400,
		"runTimeType" : "update",
		"params" : {"viewerjson" : json}
	}
	);

}