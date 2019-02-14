package arteryServer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import com.thunisoft.artery.util.ArteryUtil;

import mybatis.dao.AdminMapper;
import mybatis.pojo.Admin;

/**
 * iandd ���������߼���
 * 
 * @author ����
 * @date 2019-01-04
 * @id 491e04c937fb353d4cbfe7935456f09a
 */
public class Xgtpgs {

    protected LogicClassContext context = LogicClassContext.getInstance();
    @Autowired
    private AdminMapper mapper;
    
    /**
     * ���ʱ�ű�
     * 
     * @param item
     *            �ؼ�����
     */
    public Object jqButtond71e0_onClickServer(Item item) {
        mybatis.pojo.Admin tbook = new mybatis.pojo.Admin();
        tbook.setSelectnum(ArteryParamUtil.getInteger("selectnumber"));
        mapper.update(tbook);
        /*String selectnum = tbook.getSelectnum();
        HttpSession session = context.getRequest().getSession();
        String userString=(String) session.getAttribute("selectnum");
        if(userString==null){
           session.setAttribute("selectnum", selectnum+"");
        }
        else if(!org.apache.commons.lang.StringUtils.equals(userString, selectnum+"")){
            session.setAttribute("selectnum", selectnum+"");
        }*/
        return "ok";
    }


    /**
     * @return
     */
    private Object Artery() {
        // TODO Auto-generated method stub
        return null;
    }


	/**
	 *  按钮
	 * 
	 * @param item
	 *            控件对象
	 */
	public void jqButtond71e0_onShow(Item item) {
	
	}


}