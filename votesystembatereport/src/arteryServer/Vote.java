package arteryServer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.artery.util.ArteryUtil;

import mybatis.dao.AdminMapper;
import mybatis.dao.ProgramMapper;
import mybatis.dao.UserMapper;
import mybatis.pojo.Admin;
import mybatis.pojo.User;

/**
 * vote 服务器端逻辑类
 * 
 * @author yxl
 * @date 2019-01-10
 * @id ca21ba559e07fe17b00b75e0dd1925e1
 */
public class Vote {
	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private AdminMapper adminMapper;
	/**
	 *  复选框列
	 * 
	 * @param item
	 *            控件对象
	 */
	public void jqColumnCheckBox2fbdd_onClickSingleServer(Item item) {
	}
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public String jqButtonab045_onClickServer(Item item) {
		String result=null;
		//获取投票状态
		List<Admin> selectAll = adminMapper.selectAll();
		int state=selectAll.get(0).getState();
//		System.out.println("状态"+state);
//		HttpSession session = context.getRequest().getSession();
		//终止投票
		if(state==0){
			result="false";
//			session.setAttribute("result",result);
		}
		return result;
	}
	
}