// **********************************************//
// voteshow 客户端脚本
// 
// @author lenovo
// @date 2019-01-16
// @id f9a19f830ea09d173937ece1c202a9d6
// **********************************************//
function createJS(head,src){
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.onload = script.onreadystatechange = function() {
        if (!this.readyState || this.readyState === "loaded"
                || this.readyState === "complete") {
            help();
            // Handle memory leak in IE
            script.onload = script.onreadystatechange = null;
        }
    };
    script.src = src;
    head.appendChild(script);
}
/**
 * onLoadClient(formf4145)
 * 
 * @param rc
 *            系统提供的AJAX调用对象
 */
function formf4145_onLoadClient(rc) {
	/*var head = document.getElementsByTagName('head')[0];
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js');
	createJS(head,'https://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js');
	createJS(head,'http://echarts.baidu.com/gallery/vendors/simplex.js');*/

	/*var script = document.createElement('script');
	script.type = 'text/javascript';
	script.onload = script.onreadystatechange = function() {
		if (!this.readyState || this.readyState === "loaded"
				|| this.readyState === "complete") {
			help();
			// Handle memory leak in IE
			script.onload = script.onreadystatechange = null;
		}
	};*/
	/*script.src = 'http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js';
	head.appendChild(script);*/

	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	var app = {};
	option = null;
	/*var dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上',
			'滑', '动', '能', '够', '自', '动', '缩', '放'];*/
	var dataAxis =new Array();
	/*var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210,
			122, 133, 334, 198, 123, 125, 220];*/
	
	var data = new Array();
	var yMax = 300;
	var dataShadow = [];
    var tr=$(".jqGrid-head-tr");
    var name=[];
    
	var inter = setInterval(function() {
		/*
		 * if(proCount >= 10) { clearInterval(inter); }
		 */
		
		//data[1]++;
		rc.send(function(res){
			
            var json=eval(res);
            //var name=json.name;
            var num=json.vote;
           // console.log(json);
            // console.log(json.name);
            if(name.length==0){
                name=json.name;
                for(i in name){
                     tr.append("<th><span id="+i+">"+name[i]+"</span></th>");
                	/*tr.append("<th>666</th>");*/
                }
               
            }
             if(data.length>0){
                dataAxis.splice(j,1,num[j]);
                  data.splice(j,1,num[j]);
             }
             else{
             for(  j in name) {
                  dataAxis.push(num[j]);
                  data.push(num[j]);
            }}
              
        })
		option = {
			title : {
				text : '特性示例：渐变色 阴影 点击缩放',
				subtext : 'Feature Sample: Gradient Color, Shadow, Click Zoom'
			},
			xAxis : {
				data : dataAxis,
				axisLabel : {
					inside : true,
					textStyle : {
						color : '#fff'
					}
				},
				axisTick : {
					show : false
				},
				axisLine : {
					show : false
				},
				z : 10
			},
			yAxis : {
				axisLine : {
					show : false
				},
				axisTick : {
					show : false
				},
				axisLabel : {
					textStyle : {
						color : '#999'
					}
				}
			},
			dataZoom : [{
						type : 'inside'
					}],
			series : [{ // For shadow
				type : 'bar',
				itemStyle : {
					normal : {
						color : 'rgba(0,0,0,0.05)'
					}
				},
				barGap : '-100%',
				barCategoryGap : '40%',
				data : dataShadow,
				animation : false
			}, {
				type : 'bar',
				itemStyle : {
					normal : {
						color : new echarts.graphic.LinearGradient(0, 0, 0, 1,
								[{
											offset : 0,
											color : '#83bff6'
										}, {
											offset : 0.5,
											color : '#188df0'
										}, {
											offset : 1,
											color : '#188df0'
										}])
					},
					emphasis : {
						color : new echarts.graphic.LinearGradient(0, 0, 0, 1,
								[{
											offset : 0,
											color : '#2378f7'
										}, {
											offset : 0.7,
											color : '#2378f7'
										}, {
											offset : 1,
											color : '#83bff6'
										}])
					}
				},
				data : data
			}]
		};

		// Enable data zoom when user click bar.
		var zoomSize = 6;
		myChart.on('click', function(params) {
			//console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
			myChart.dispatchAction({
						type : 'dataZoom',
						startValue : dataAxis[Math.max(params.dataIndex
										- zoomSize / 2, 0)],
						endValue : dataAxis[Math.min(params.dataIndex
										+ zoomSize / 2, data.length - 1)]
					});
		});;
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}

	}, 100);

	for (var i = 0; i < data.length; i++) {
		dataShadow.push(yMax);
	}

}