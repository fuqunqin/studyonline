package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.FrontierTypeBiz;
import cn.edu.zust.entity.FrontierType;

public class FrontierTypeAction extends MappingDispatchAction {
	private FrontierTypeBiz frontierTypeBiz;

	public FrontierTypeBiz getFrontierTypeBiz() {
		return frontierTypeBiz;
	}

	public void setFrontierTypeBiz(FrontierTypeBiz frontierTypeBiz) {
		this.frontierTypeBiz = frontierTypeBiz;
	}

	// 查询所有的学科动态类型
	public ActionForward adminQueryFrontierTypes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<FrontierType> frontierTypes = frontierTypeBiz.query();
		request.setAttribute("frontierTypes", frontierTypes);
		return mapping.findForward("adminQueryFrontierTypesOk");
	}

	// 添加学科动态类型
	public ActionForward adminAddFrontierType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String frontierType = request.getParameter("frontierType");
		FrontierType ft = new FrontierType();
		ft.setFrontierType(frontierType);
		ft = frontierTypeBiz.addFrontierType(ft);
		return mapping.findForward("adminAddFrontierType");
	}
}
