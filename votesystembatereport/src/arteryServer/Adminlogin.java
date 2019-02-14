package arteryServer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.AdminMapper;
import mybatis.pojo.Admin;

/**
 * adminlogin 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-08
 * @id 7f3161679625d71756f2a0b21b32cf8d
 */
public class Adminlogin {

	protected LogicClassContext context = LogicClassContext.getInstance();

    /**
     * 
     */
    @Autowired
    private AdminMapper adminMapper;
    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    /**
     * @param item
     * @return
     */
    public Object jqButtondda81_onClickServer(Item item) {
    	String adminname=ArteryParamUtil.getString("adminname");
    	String adminpassword=ArteryParamUtil.getString("adminpassword");
    	List<Admin> adminlist = adminMapper.selectAll();
    	Admin admin=adminlist.get(0);
    	 HttpSession session= context.getRequest().getSession();
    	//登录成功会保存在session中admin
    	if(StringUtils.equals(adminname, admin.getAdminname())&&StringUtils.equals(adminpassword, admin.getAdminpassword())) {
    	    session.setAttribute("admin", "admin");//
    	}
    	else {
            return "false";
        }
    	return "ok";
    	
    }
	

}