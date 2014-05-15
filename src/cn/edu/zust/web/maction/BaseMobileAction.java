package cn.edu.zust.web.maction;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.MappingDispatchAction;

import com.alibaba.fastjson.JSON;

public class BaseMobileAction extends MappingDispatchAction {

	
	public void renderJson(HttpServletResponse response,Map<String, Object> map) throws Exception{
		
		PrintWriter out = response.getWriter();
		String str = JSON.toJSONString(map);
		out.write(str);
		out.close();
	}
}
