package arteryServer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.service.organ.domain.User;
import com.thunisoft.artery.util.ArteryParamUtil;

import antlr.StringUtils;
import mybatis.dao.AdminMapper;
import mybatis.dao.ProgramMapper;
import mybatis.dao.UserMapper;
import mybatis.pojo.Program;
import net.sf.json.JSONObject;
//import mybatis.pojo.Admin;

/**
 * admin ���������߼���
 * 
 * @author ����
 * @date 2019-01-09
 * @id 3ef758846bdbfbf7572859ccfcb056a6
 */
public class Admin {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
    private AdminMapper mapper;
	@Autowired
    private ProgramMapper pmapper;
	@Autowired
	private UserMapper umapper;	

    
    /**
     * ���ʱ�ű�
     * 
     * @param item
     *            �ؼ�����
     */
    public Object jqButtonb970a_onClickServer(Item item) {
    	 String obj=ArteryParamUtil.getString("checkname");
//       System.out.println(obj);
       String[] split = obj.split("\\*");
       Program tbook = new Program();
//       System.out.println(split.length);
//       for (int i=0;i<split.length;i++){
//           System.out.println("*"+split[i]);
//       }
       for (int i=0;i<split.length;i++) {
//         System.out.println("33"+split[i]);
         Integer num= Integer.parseInt(split[i]);
//         System.out.println(num);
         tbook.setProgramid(num);
         pmapper.updatenumber(tbook);
       }
       /* Admin tbook = new Admin();
       Integer integer=0;
       tbook.setState(integer);
       mapper.updatestate(tbook);*/
       return "ok";
    }


    /**
     *  ��ѡ����
     * 
     * @param item
     *            �ؼ�����
     */
    public void jqColumnCheckBoxd1898_onClickSingleServer(Item item) {
    
    }


    /**
     *  ��ѡ����
     * 
     * @param item
     *            �ؼ�����
     */
    public void jqColumnCheckBoxd1898_onShow(Item item) {
    
    }


    /**
     *  �б�����
     * 
     * @param item
     *            �ؼ�����
     */
    public void jqGrida2f7a_onShow(Item item) {
    }

    /**
     *  ��
     * 
     * @param item
     *            �ؼ�����
     */
    public void formcbbde_onShow(Item item) {
        HttpSession session= context.getRequest().getSession();
        session.removeAttribute("admin");
    }


    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton19b97_onClickServer(Item item) {
    	return null;
    }


	
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButtondf647_onClickServer(Item item) {
		mybatis.pojo.Admin tbook = new mybatis.pojo.Admin();
        Integer integer=1;
        tbook.setState(integer);
        mapper.updatestate(tbook);
		return "ok";
	}


	
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButtona0bbd_onClickServer(Item item) {
		 	mybatis.pojo.Admin tbook = new mybatis.pojo.Admin();
		 	
	        Integer integer=0;
	        tbook.setState(integer);
	        mapper.updatestate(tbook);
	        return "ok";
	}


	
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButtona55b9_onClickServer(Item item) {
        pmapper.updateall();
        return "ok";
	}
}