package arteryServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;

import mybatis.dao.ProgramMapper;
import mybatis.pojo.Program;
import net.sf.json.JSONArray;

/**
 * voteshowdemo 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-16
 * @id dbc68060eba9a0390fab33cc4a25bcad
 */
public class Voteshowdemo {

    protected LogicClassContext context = LogicClassContext.getInstance();

    @Autowired
    private ProgramMapper mapper;

    /**
     * 加载时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object form70caf_onLoadServer(Item item) {
        List<Program> list = mapper.selectAllByNum();
        
        return JSONArray.fromObject(list).toString();
    }

}