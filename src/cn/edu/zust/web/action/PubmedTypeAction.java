package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.PubmedTypeBiz;
import cn.edu.zust.entity.PubmedType;

public class PubmedTypeAction extends MappingDispatchAction {
	private PubmedTypeBiz pubmedTypeBiz;

	public PubmedTypeBiz getPubmedTypeBiz() {
		return pubmedTypeBiz;
	}

	public void setPubmedTypeBiz(PubmedTypeBiz pubmedTypeBiz) {
		this.pubmedTypeBiz = pubmedTypeBiz;
	}

	public ActionForward adminQueryPubmedTypes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<PubmedType> pubmedTypes = pubmedTypeBiz.query();
		request.setAttribute("pubmedTypes", pubmedTypes);
		return mapping.findForward("adminQueryPubmedTypesOk");
	}

	public ActionForward adminAddPubmedType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String typeName = request.getParameter("typeName");
		PubmedType pubmedType = new PubmedType();
		pubmedType.setTypeName(typeName);
		pubmedType = pubmedTypeBiz.add(pubmedType);
		return mapping.findForward("adminAddPubmedTypeOk");
	}
}
