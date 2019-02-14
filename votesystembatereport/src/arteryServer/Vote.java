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
 * vote ���������߼���
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
	 *  ��ѡ����
	 * 
	 * @param item
	 *            �ؼ�����
	 */
	public void jqColumnCheckBox2fbdd_onClickSingleServer(Item item) {
	}
	/**
	 * ���ʱ�ű�
	 * 
	 * @param item
	 *            �ؼ�����
	 */
	public String jqButtonab045_onClickServer(Item item) {
		String result=null;
		//��ȡͶƱ״̬
		List<Admin> selectAll = adminMapper.selectAll();
		int state=selectAll.get(0).getState();
//		System.out.println("״̬"+state);
//		HttpSession session = context.getRequest().getSession();
		//��ֹͶƱ
		if(state==0){
			result="false";
//			session.setAttribute("result",result);
		}
		return result;
	}
	
}