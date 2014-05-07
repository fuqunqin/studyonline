package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.ShareTypeBiz;
import cn.edu.zust.entity.ShareType;

public class ShareTypeAction extends MappingDispatchAction {
	private ShareTypeBiz shareTypeBiz;

	public ShareTypeBiz getShareTypeBiz() {
		return shareTypeBiz;
	}

	public void setShareTypeBiz(ShareTypeBiz shareTypeBiz) {
		this.shareTypeBiz = shareTypeBiz;
	}

	public ActionForward adminQueryShareTypes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<ShareType> shareTypes = shareTypeBiz.query();
		request.setAttribute("shareTypes", shareTypes);
		return mapping.findForward("adminQueryShareTypesOk");
	}

	public ActionForward adminAddShareType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String typeName = request.getParameter("typeName");
		ShareType shareType = new ShareType();
		shareType.setTypeName(typeName);
		shareType = shareTypeBiz.add(shareType);
		return mapping.findForward("adminAddShareTypeOk");
	}
}
