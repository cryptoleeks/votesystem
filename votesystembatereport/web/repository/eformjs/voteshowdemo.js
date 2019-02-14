// **********************************************//
// voteshowdemo 客户端脚本
// 
// @author lenovo
// @date 2019-01-16
// @id dbc68060eba9a0390fab33cc4a25bcad
// **********************************************//
/**
 * onLoadClient(form70caf)
 * 
 * @param rc
 *            系统提供的AJAX调用对象
 */
function form70caf_onLoadClient(rc) {
    var divobj=$("body");
  
    var divcontentobj=$("#divnum0").text();
    
    var inter = setInterval(function(){
/*         location.reload();
    */
    	rc.send(function(res) {
                var obj = eval(res);
                //console.log(obj);
                if(divcontentobj==""){
                       for (var key in obj) { // 第一层循环取到各个list
                    var List = obj[key];
                    var json=eval(List);
                    //for (var id in List) { // 第二层循环取list中的对象
                        divobj.append("<div  id='divnum"+key+"'>"+"<span class='num' name='num'>"+json.programnum+
                        "</span>"+"</div>"+"<div id='divname"+key+"'>"+"<span class='name' name='name'>"+json.programname+
                        "</span>"+"</div>");        
                        
                    //}
                    } 
                    divcontentobj=$("#divnum0").text();
                }
                else{
                     for (var key in obj) { // 第一层循环取到各个list
                    var List = obj[key];
                    var json=eval(List);
                    
                    var contentnum=$("div#divnum"+key+" span[name=num]");
                     var    contentname=$("div#divname"+key+" span[name=name]");
                     contentnum.text(json.programnum+"");
                     contentname.text(json.programname);
                    //}
                    } 
                }
               
            });
    	
    	},100);
	

}

