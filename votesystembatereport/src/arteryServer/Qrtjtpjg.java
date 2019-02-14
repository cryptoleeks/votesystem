package arteryServer;

import javax.swing.SpinnerListModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.AdminMapper;
import mybatis.dao.ProgramMapper;
import mybatis.pojo.Admin;
import mybatis.pojo.Program;

/**
 * 确认提交投票结果 服务器端逻辑类
 * 
 * @author 华宇
 * @date 2019-01-11
 * @id 5c3e86073c0d977206b7d6670adcc9eb
 */
public class Qrtjtpjg {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
    private ProgramMapper mapper;
    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton2bf76_onClickServer(Item item) {
        String obj=ArteryParamUtil.getString("checkname");
//        System.out.println(obj);
        String[] split = obj.split("\\*");
        Program tbook = new Program();
//        System.out.println(split.length);
//        for (int i=0;i<split.length;i++){
//            System.out.println("*"+split[i]);
//        }
        for (int i=0;i<split.length;i++) {
//          System.out.println("33"+split[i]);
          Integer num= Integer.parseInt(split[i]);
//          System.out.println(num);
          tbook.setProgramid(num);
          mapper.updatenumber(tbook);
        }
        /* Admin tbook = new Admin();
        Integer integer=0;
        tbook.setState(integer);
        mapper.updatestate(tbook);*/
        return "ok";
    }
}