// **********************************************//
// result �ͻ��˽ű�
// 
// @author yxl
// @date 2019-01-15
// @id 7409bde5ec66fe4e5b38085fe3a1f048
// **********************************************//
/**
 * onStartClient(jqProgress227b2)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */

function run(key,value){  
        var bar = $("#bar"+key); 
        var total = $("#total"+key); 
    total.text(parseInt(value)+"%");  
    var proCount = 0;
    var value=value;
    var inter = setInterval(function() {
        if(proCount >= value) {
            clearInterval(inter);
        }
        bar.width(parseInt(proCount)+ "%");
        proCount++;
    }, 100);

  } 
  
/**
 * onLoadClient(form07631)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function form07631_onLoadClient (rc){
	var obj;
	rc.send(function (result){
		//后台获取节目id和票数的json解析
		 var jsonObj=eval(result);
		 for(var key in jsonObj){
			  var bar=$("#bar"+key);
			  run(key, jsonObj[key]);
			}
	});	
}