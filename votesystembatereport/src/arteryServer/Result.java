package arteryServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;

import mybatis.dao.ProgramMapper;
import mybatis.pojo.Program;
import net.sf.json.JSONObject;

/**
 * result 服务器端逻辑类
 * 
 * @author yxl
 * @date 2019-01-15
 * @id 7409bde5ec66fe4e5b38085fe3a1f048
 */
public class Result {
	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper programMapper;
	/**
	 * 加载时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object form07631_onLoadServer(Item item) {
		List<Program> selectAll = programMapper.selectAll();
		Map<Integer, Double> map=new HashMap<Integer, Double>();
		int sum=0;
		for (Program program : selectAll) {
			sum+=program.getProgramnum();	
		}
		for (Program program : selectAll) {
			int id=program.getProgramid();
			int num=program.getProgramnum();
			Double percent=(double) (num*1.0/sum*100);
			map.put(id, percent);
		}
		Gson gson = new Gson();
		String s = gson.toJson(map);
		return s;
	}
}