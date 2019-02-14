package arteryServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.AdminMapper;
import mybatis.dao.ProgramMapper;
import mybatis.dao.UserMapper;
import mybatis.pojo.Admin;
import mybatis.pojo.Program;
import mybatis.pojo.User;
import net.sf.json.JSONObject;

/**
 * 观众确认投票 服务器端逻辑类
 * 
 * @author yxl
 * @date 2019-01-12
 * @id 861adab9f89342682b816c5b9ca94df5
 */
public class Gzqrtp {
	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper mapper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButtone6614_onClickServer(Item item) {
		String tj=ArteryParamUtil.getString("tj");
		String result=null;
		//获取投票状态
		List<Admin> selectAll = adminMapper.selectAll();
		int state=selectAll.get(0).getState();
		//终止投票
		if(state==0){
			result="false";
			return result;
		}else{
			//将票数更改在program表中
			String[] split = tj.split("\\*");
			//将票数该更改到user表
			User user=new User();
			String username=split[split.length-1];
			User vote = userMapper.vote(username);
			if(vote.getOption()!=null){
				//进入投票结果展示界面
				return result="false";
			}
			Program tbook = new Program();
			for (int i=0;i<split.length-1;i++) {
				Integer num= Integer.parseInt(split[i]);
				tbook.setProgramid(num);
				mapper.updatenum(tbook);
			}
			//将观众名封装到user
			user.setName(username);	
			//获取选中节目的字符串
			int i;
			if(tj.length()==0){
				i=0;
			}else{
				i=tj.lastIndexOf("*");
			}
			String option=tj.substring(0,i);
			//将选中节目封装到user
			user.setOption(option);
			//选中节目更改到数据库
			userMapper.updatevote(user);
			//进入投票结果展示界面
			return result="true";
		}
	}
}