package arteryServer;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;

import mybatis.dao.AdminMapper;
import mybatis.pojo.Admin;

/**
 * ȷ�Ͽ�ʼͶƱ ���������߼���
 * 
 * @author ����
 * @date 2019-01-11
 * @id f5f49fc6e23681d4e4f500ab2c7443dc
 */
public class Qrkstp {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
    private AdminMapper mapper;
    
    /**
     * ���ʱ�ű�
     * 
     * @param item
     *            �ؼ�����
     */
    public Object jqButton46450_onClickServer(Item item) {
        Admin tbook = new Admin();
        Integer integer=1;
        tbook.setState(integer);
        mapper.updatestate(tbook);
        return "ok";
    }
	

}