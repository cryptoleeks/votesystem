package arteryServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.artery.util.ArteryWebUtil;

import mybatis.dao.ProgramMapper;
import mybatis.pojo.Program;
import net.sf.json.JSONArray;

/**
 * insertprogram 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-10
 * @id cba5b8f6414a191d3886ab600e7dba35
 */
/**
 * 
 public Object jqButtona0f02_onClickServer(Item item) {
        List<File> files = new ArrayList<File>();
        String raw = ArteryParamUtil.getString("jqUploadify7ca76") +","+ ArteryParamUtil.getString("jqUploadify56fcd");
        if(StringUtils.isBlank(raw)) return null;
        String[] randoms = raw.split(",");
        for (String random : randoms) {
            String folder = ArteryWebUtil.getWebPath()+"/artery/downloads/"+random;
            File uploadFolder = new File(folder);
            if (uploadFolder.exists()) {
                File[] subFiles = uploadFolder.listFiles();
                if (subFiles!=null) {
                    for(File subFile : subFiles){
                        files.add(subFile);
                    }
                }
            }
        }
        if(files.size()!=0){
            String[] arr = new String[files.size()];
            int i = 0 ;
            for (File file : files) {
                arr[i++] = file.getAbsolutePath();
            }
            return JSONArray.fromObject(arr);
        }
        return "success";
    }
 
 */
public class Insertprogram {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper programMapper;
    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButtona3592_onClickServer(Item item) {
        /*String url = "";
        HttpServletRequest request = context.getRequest();
        url = request.getScheme() +"://" + request.getServerName()  
                        + ":" +request.getServerPort() 
                        + request.getServletPath();
        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
        
        System.out.println(url);
        */
        return "";


    }


    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton26448_onClickServer(Item item) {
        String programidstr=ArteryParamUtil.getString("programid");//节目序号
    	String programinfo=ArteryParamUtil.getString("programinfo");//节目信息
        String imgadr=ArteryParamUtil.getString("imgadr");//图片路径
        
        Program program=new Program();
        program.setPictureadr(imgadr);
        program.setProgramid(Integer.parseInt(programidstr));
        program.setProgramname(programinfo);
        
        programMapper.insert(program);
    	System.out.println(programinfo);
    	return "ok";
    }



    /**
     *  超文本
     * 
     * @param item
     *            控件对象
     */
    public void jqHtmlArea3aed2_onShow(Item item) {
    
    }
	

}

