# votesystem
本系统基于Artery5开发的投票系统
VoteSystem 
Artery方面:
	ArteryParmUtils.getString(key)--会获取前端传递过来的值（值可以是表单中的属性或者自己ajax提交的rc.send的内容），
	一般是返回字符串对象，在特定情况下（可能有缓存的问题），会缓存上次的历史输入记录值，最终对返回一个对象（数组），
	需要清项目和就浏览器缓存，重新打开表单
	
	Artery项目重新启动偶尔会出现	login.error.authentication.error 的错误，刷新页面即可
	
图片上传:
	使用FormData实现图片上传后台
	前端使用ajax异步提交uploadFile：
	
	var uploadFile = new FormData();
	//var imgadr=$("input[name='imgadr']");
	uploadFile.append("file", $("#single")[0].files[0]);// 单张上传获得FormData
	if ("undefined" != typeof(uploadFile) && uploadFile != null
			&& uploadFile != "") {
		$.ajax({
					url : '/ssm/picture/save',//www.loveyx815.cn
					type : 'POST',
					data : uploadFile,
					async : false,
					cache : false,
					contentType : false, // 不设置内容类型
					processData : false, // 不处理数据
					success : function(data) {
						alert("上传：" + data);
						console.log(data);
						var json=JSON.parse(data);
						
						imgadr.attr("value",json.img);
						console.log(imgadr.val());
						alert("上传成功");
					},
					error : function() {
						alert("上传失败！");
					}
				})
	} else {
		alert("选择的文件无效！请重新选择");
	}


#ssm
  图片服务器
	后台接受文件，返回JSON数据：
	@RequestMapping(value = "/save")
    @ResponseBody
    public Object uploadAuthImages(@RequestParam(value = "file", required = false) MultipartFile files, 
                HttpServletRequest request) {
            Map<String, Object> map = new HashMap<String, Object>();
            //保存文件  
           // for(int i=0; i<files.length; i++){
            String INTERNET_IP=SystemUtil.INTERNET_IP;//获取外网ip
            String path = request.getContextPath();//项目路径
          
                String filePath = request.getSession().getServletContext().getRealPath("/")  + "upload/";
                UUID uuid = UUID.randomUUID();
                String fileName = new Date().getTime() + uuid.toString() + ".jpg";
                System.out.println("图片地址："+filePath);
                File targetFile = new File(filePath, fileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                // 保存
                try {
                    files.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //添加图片路径到map集合http://localhost:8080/ssm/upload/15472639306217846b116-568c-4e72-b398-38f2eb7804b9.jpg
                map.put("img", "http://172.23.22.154:8080"+path+"/upload/" + fileName);
              String jsonString = JSONUtils.toJSONString(map);
               
          //  }
           /* map.put("photo4", request.getParameter("photo4"));
            map.put("photo5", request.getParameter("photo5"));*/
            return jsonString;

        }
		
	补充：在上传中需要设置文件上传的大小限制，不然文件太大会直接抛出异常（未处理）
	在图片服务器的项目的spring配置文件中配置上传大小
		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<property name="maxUploadSize" value="10485760" />
			<property name="defaultEncoding" value="UTF-8" />
		</bean>

