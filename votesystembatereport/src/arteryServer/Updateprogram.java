package arteryServer;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

import mybatis.dao.ProgramMapper;
import mybatis.pojo.Program;

/**
 * updateprogram 服务器端逻辑类
 * 
 * @author lenovo
 * @date 2019-01-11
 * @id e4ab614992e5990a14a53c009c611b01
 */
public class Updateprogram {

	protected LogicClassContext context = LogicClassContext.getInstance();

	   @Autowired
	   private ProgramMapper programMapper;
    /**
     * 数据源查询方法
     * 
     * @param qp
     *            查询参数，只在分页查询时可用，否则为null
     * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
     */
    public Object ds_rs1(IQueryInfo qp) {
        int programid=Integer.parseInt(ArteryParamUtil.getString("programid"));
        Program program = programMapper.selectById(programid);
        System.out.println(program);
        return program;
        
    }
    
    /**
     * 点击时脚本
     * 
     * @param item
     *            控件对象
     */
    public Object jqButton1f2ee_onClickServer(Item item) {
        String programinfo=ArteryParamUtil.getString("programname");//节目信息
        int programid=ArteryParamUtil.getInt("programid1");//节目序号
        
        //String imgadr=ArteryParamUtil.getString("imgadr");//图片路径
        
        Program program=new Program();
        //program.setPictureadr(imgadr);
        program.setProgramid(programid);
        program.setProgramname(programinfo);
        
        programMapper.updataProgramById(program);
        System.out.println("----------------------");
        return "ok";
    }
	

}