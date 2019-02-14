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
 * ����ȷ��ͶƱ ���������߼���
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
	 * ���ʱ�ű�
	 * 
	 * @param item
	 *            �ؼ�����
	 */
	public Object jqButtone6614_onClickServer(Item item) {
		String tj=ArteryParamUtil.getString("tj");
		String result=null;
		//��ȡͶƱ״̬
		List<Admin> selectAll = adminMapper.selectAll();
		int state=selectAll.get(0).getState();
		//��ֹͶƱ
		if(state==0){
			result="false";
			return result;
		}else{
			//��Ʊ��������program����
			String[] split = tj.split("\\*");
			//��Ʊ���ø��ĵ�user��
			User user=new User();
			String username=split[split.length-1];
			User vote = userMapper.vote(username);
			if(vote.getOption()!=null){
				//����ͶƱ���չʾ����
				return result="false";
			}
			Program tbook = new Program();
			for (int i=0;i<split.length-1;i++) {
				Integer num= Integer.parseInt(split[i]);
				tbook.setProgramid(num);
				mapper.updatenum(tbook);
			}
			//����������װ��user
			user.setName(username);	
			//��ȡѡ�н�Ŀ���ַ���
			int i;
			if(tj.length()==0){
				i=0;
			}else{
				i=tj.lastIndexOf("*");
			}
			String option=tj.substring(0,i);
			//��ѡ�н�Ŀ��װ��user
			user.setOption(option);
			//ѡ�н�Ŀ���ĵ����ݿ�
			userMapper.updatevote(user);
			//����ͶƱ���չʾ����
			return result="true";
		}
	}
}