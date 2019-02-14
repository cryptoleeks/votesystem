package arteryServer;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.UserMapper;
import mybatis.pojo.User;

/**
 * Login ���������߼���
 * 
 * @author yxl
 * @date 2019-01-08
 * @id 8326a048d4a16f2e2edc42cc97f4129c
 */
public class Login {
	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private UserMapper userMapper;
	/**
	 * ���ʱ�ű�
	 * 
	 * @param item
	 *            �ؼ�����
	 */
	public Object jqButton73f6d_onClickServer(Item item) {
		//��ȡ�ύ���û���
		String username = ArteryParamUtil.getString("username").trim();
		//Object obj = ArteryParamUtil.getString("username");
		//System.out.println("username:"+username);
		//�Ӻ�̨��ȡ�����û����������list��
		List<User> selectAll = userMapper.selectAll();
		HttpSession session = context.getRequest().getSession();
		StringBuffer name=new StringBuffer();
		String userString=(String) session.getAttribute("userlist");
		//�����ݿ��û����������ַ�����ʽ�洢��session��
		if(userString==null){
			for (Iterator iterator = selectAll.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				name.append("-"+user.getName());	
			}
			session.setAttribute("userlist", name.toString());
			userString= (String) session.getAttribute("userlist");
		}
		User vote = userMapper.vote(username);
		//�ж��Ƿ��¼�ɹ�
		String result=null;
//		System.out.print("Ʊ"+vote.getOption());
		if(StringUtils.contains(userString, username)&&!username.equals("")){
			if(vote.getOption()==null){
				//����ͶƱ����
				return result="true";
			}else{
				//����ɹ�����
				return result="success";
			}
		}else{
			//���ر�����
			return result="false";
		}

	}


}