package arteryServer;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.report.crs.common.util.kit.FileUtils;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.ProgramMapper;

/**
 * program 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-09
 * @id 2c7d9463b770ea8b348b81cb4b38b66d
 */
public class Program {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private ProgramMapper programMapper;
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public byte[] jqImage8d638_onClickServer(Item item) {
        String pathname = "/web/img/沙漠.jpg";
       // File file = new File(pathname);
        return FileUtils.getFileData(pathname);

    }

    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton17bd8_onClickServer(Item item) {
    	int id=ArteryParamUtil.getInt("programid");
    	int deleteState = programMapper.deleteProgramById(id);
    	return "ok";
    }



    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton13d30_onClickServer(Item item) {
        int id=ArteryParamUtil.getInt("programid");
        System.out.println(id);
        int deleteState = programMapper.deleteProgramById(id);
        return "ok";
    }


    /**
     * 数据源查询方法
     * 
     * @param qp
     *            查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Object ds_rs2(IQueryInfo qp) {
    	return programMapper.selectAll();
    }
	

}