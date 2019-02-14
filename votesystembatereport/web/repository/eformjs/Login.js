//**********************************************//
//Login �ͻ��˽ű�

//@author yxl
//@date 2019-01-08
//@id 8326a048d4a16f2e2edc42cc97f4129c
//**********************************************//
/**
 * onClickClient(jqButton73f6d)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */

function rem(doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'onorientationchange' in window ? 'onorientationchange' : 'resize',
        recalc = function() {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            if (clientWidth >= 750) {
                docEl.style.fontSize = '100px';
            } else {
                docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
            }
        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
}
rem(document, window);
function jqButton73f6d_onClickClient (rc){
	//获取观众名
	var username=$("input[name='username']").val();
	//$("input[name='username']").val("");
	Artery.get("jqFormArea432e7").submit(function(res){
		if(res=="true"){
			Artery.openForm({
				"formId" : "ca21ba559e07fe17b00b75e0dd1925e1",
				"formName" : "投票界面",
				"formType" : "1",
				"target" : "_self",
				"targetWidth" : 550,
				"targetHeight" : 450,
				"runTimeType" : "update",
				"params" : {"viewername" : username}
			}
			);
		}else if(res=="success"){
			Artery.openForm({
				"formId" : "7409bde5ec66fe4e5b38085fe3a1f048",
				"formName" : "投票成功界面",
				"formType" : "1",
				"target" : "_self",
				"targetWidth" : 550,
				"targetHeight" : 450,
				"runTimeType" : "update",
				"params" : {"viewername" : username}
			}
			);
		}else{
			$("#username-hint").html("登录失败，请<br>检查登录名！");
		}
	});

}