package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.StatusBiz;
import cn.edu.zust.entity.Status;

public class StatusAction extends MappingDispatchAction {
	private StatusBiz statusBiz;

	public StatusBiz getStatusBiz() {
		return statusBiz;
	}

	public void setStatusBiz(StatusBiz statusBiz) {
		this.statusBiz = statusBiz;
	}

	public ActionForward adminQueryStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Status> statuses = statusBiz.query();
		request.setAttribute("statuses", statuses);
		return mapping.findForward("adminQueryStatusOk");
	}
}
