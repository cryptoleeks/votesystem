package arteryServer;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.AdminMapper;
import mybatis.pojo.Admin;

/**
 * ȷ�Ͻ���ͶƱ ���������߼���
 * 
 * @author ����
 * @date 2019-01-11
 * @id 9e19b6f0f7afbcdd94c6f522c26f68ec
 */
public class Qrjstp {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
    private AdminMapper mapper;
    
    /**
     * ���ʱ�ű�
     * 
     * @param item
     *            �ؼ�����
     */
    public Object jqButton7e851_onClickServer(Item item) {
        Admin tbook = new Admin();
        Integer integer=0;
        tbook.setState(integer);
        mapper.updatestate(tbook);
        return "ok";
    }
	

}