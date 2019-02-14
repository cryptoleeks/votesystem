package arteryServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;

import mybatis.dao.ProgramMapper;
import mybatis.pojo.Program;
import net.sf.json.JSONObject;

/**
 * voteshow 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-16
 * @id f9a19f830ea09d173937ece1c202a9d6
 */
public class Voteshow {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper programMapper;
    
    /**
     * 加载时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object formf4145_onLoadServer(Item item) {
    	Map<String, List<Object>> mapjson=new HashMap<String, List<Object>>();
    	List<Object> programnamelist=new ArrayList<Object>();
    	List<Object> programvotelist=new ArrayList<Object>();
    	List<Program> programlist = programMapper.selectAllByIdAsc();
    	JSONObject json=new JSONObject();
    	for (Iterator iterator = programlist.iterator(); iterator.hasNext();) {
            Program program = (Program) iterator.next();
            programnamelist.add(program.getProgramname());
            programvotelist.add(program.getProgramnum());
            
        }
    	json.put("name", programnamelist);
    	json.put("vote",programvotelist);
    	return json;
    }
	

}