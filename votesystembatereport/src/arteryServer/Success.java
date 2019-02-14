package arteryServer;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.plugin.jquery.image.chart.ChartModel;
import com.thunisoft.artery.plugin.jquery.image.chart.Record;
import com.thunisoft.artery.util.ArteryDateUtil;

import mybatis.dao.ProgramMapper;
import mybatis.dao.UserMapper;
import mybatis.pojo.Program;
import mybatis.pojo.User;

/**
 * success 服务器端逻辑类
 * 
 * @author yxl
 * @date 2019-01-11
 * @id 411fa82b47f7c437dc75f87d67e3c7b9
 */
public class Success {
	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper programMapper;
	/**
	 * 加载脚本
	 * 
	 * @param item
	 *            控件对象
	 * @param model
	 *            数据模型
	 */
	//投票票数展示界面
	public void jqChart6799e_onLoad(Item item, ChartModel model) {
		model.setCaption("2019年南京研发中心年会投票结果:"+ArteryDateUtil.curDateTimeStr());
		model.setUseRoundEdges("2");
		List<Program> selectAll= programMapper.selectAll();
		for (Iterator iterator = selectAll.iterator(); iterator.hasNext();) {
			Program program = (Program) iterator.next();
			Record rec = model.createRecord();
			rec.setLabel(program.getProgramname());
			rec.setValue(String.valueOf(program.getProgramnum()));	
		}
		/*java.util.Random random = new java.util.Random();
		for(int i=0;i<6;i++){
			Record rec = model.createRecord();
			rec.setLabel("label"+i);
			rec.setValue(String.valueOf(random.nextInt(7)*100));
		}
*/
	}
}