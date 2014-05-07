package cn.edu.zust.web.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.springframework.context.ApplicationContext;

import cn.edu.zust.biz.InterestGroupBiz;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.User;

public class ChatOnlineAction extends MappingDispatchAction {
	private InterestGroupBiz interestGroupBiz;

	public InterestGroupBiz getInterestGroupBiz() {
		return interestGroupBiz;
	}

	public void setInterestGroupBiz(InterestGroupBiz interestGroupBiz) {
		this.interestGroupBiz = interestGroupBiz;
	}

	@SuppressWarnings("unchecked")
	public ActionForward checkUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从session中得到当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		if (user == null) {
			out.print("loginError");
			return null;
		}
		// 从参数中得到该用户要进入的兴趣小组
		String interestGroupId = request.getParameter("interestGroupId");
		//判断该用户是否为该兴趣小组成员
		ApplicationContext ac = (ApplicationContext) request
		.getSession()
		.getServletContext()
		.getAttribute(
				"org.springframework.web.context.WebApplicationContext.ROOT");
		InterestGroupBiz igBiz=(InterestGroupBiz)ac.getBean("interestGroupBiz");
		InterestGroup ig=igBiz.query(Integer.valueOf(interestGroupId));
		System.out.println(ig.getUsers().size());
		
		Set<User> us=ig.getUsers();
		boolean b=false;
		for(User u:us){
			System.out.println(u.getId()+u.getLoginName());
			if(u.getId().equals(user.getId())){
				b=true;
				break;
			}
		}
		if (b == false) {
			out.print("notJiaRuError");
			return null;
		} 
		
		String loginName = user.getLoginName();
		// System.out.print("检查用户输入的是:"+name);

		// 得到application
		ServletContext application = request.getSession().getServletContext();
		// 从application中取出所有已登录者的信息
		Map<String, ArrayList<String>> users = (HashMap<String, ArrayList<String>>) application
				.getAttribute("users");
		// 如果信息是空，则创建
		if (users == null) {
			users = new HashMap<String, ArrayList<String>>();
		}
		
		// 得到该小组的信息，小组信息为空时创建
		List<String> list = users.get(interestGroupId);
		if (list == null) {
			list = new ArrayList<String>();
		}
		b = false;
		// 如果不为空就得判断该用户是否存在
		if (list != null) {
			for (String string : list) {
				if (string.equals(loginName)) {
					b = true;
					break;
				}
			}
		}
		if (b == true) {
			out.print("loginedError");
			return null;
		} else {
			request.setAttribute("interestGroupId", interestGroupId);
			return this.doLogin(mapping, form, request, response);
		}
	}

	// 登陆
	@SuppressWarnings("unchecked")
	public ActionForward doLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取进去的小组
		String interestGroupId = (String) request
				.getAttribute("interestGroupId");
		// 获取姓名
		String name = ((User) request.getSession().getAttribute("user"))
				.getLoginName();

		// 存放在 application中
		ServletContext application = request.getSession().getServletContext();
		Map<String, ArrayList<String>> users = (HashMap<String, ArrayList<String>>) application
				.getAttribute("users");
		// 如果为空，则创建
		if (users == null) {
			users = new HashMap<String, ArrayList<String>>();
		}
		ArrayList<String> list = users.get(interestGroupId);
		// 判断是否为空
		if (list == null) { // 该聊天室的第一个用户
			list = new ArrayList<String>();
		}
		// System.out.println("即将添加的是:"+name);
		// 将该用户放在数组中
		list.add(name);
		// 将该数组存放在Map集合中，并放在application应用中
		users.put(interestGroupId, list);
		application.setAttribute("users", users);
		// 查询聊天信息
		Map<String, ArrayList<String>> messages = (HashMap<String, ArrayList<String>>) application
				.getAttribute("messages");
		if (messages == null) {
			messages = new HashMap<String, ArrayList<String>>();
		}
		// 得到当前小组的message
		ArrayList<String> messageList = messages.get(interestGroupId);
		// 如果为空则创建
		if (messageList == null) {
			messageList = new ArrayList<String>();
		}
		// 如果超过199条数据就删除50条
		if (messageList.size() > 199) {
			List<String> ms = messageList.subList(0, 50);
			messageList.removeAll(ms);
		}
		messageList.add("\n欢迎，欢迎，大家热列欢迎！" + name + " , 进入兴趣小组了.....\n");
		messages.put(interestGroupId, messageList);
		application.setAttribute("messages", messages);
		// response.sendRedirect("chat/main.jsp");
		return null;
	}

	@SuppressWarnings("unchecked")
	public ActionForward doInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从参数中得到该用户要进入的兴趣小组
		String interestGroupId = request.getParameter("interestGroupId");
		// 获取当前用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			return null;
		}
		String loginName = user.getLoginName();
		// 获取该用户发送的信息
		String message = request.getParameter("message");
		// message=new String(message.getBytes("GB2312"),"UTF-8");
		System.out.println(message);
		// 获得所有用户发送的信息
		ServletContext application = request.getSession().getServletContext();
		Map<String, ArrayList<String>> messages = (HashMap<String, ArrayList<String>>) application
				.getAttribute("messages");
		// 如果为空则创建
		if (messages == null) {
			messages = new HashMap<String, ArrayList<String>>();
		}
		// 得到当前小组的message
		ArrayList<String> messageList = messages.get(interestGroupId);
		// 如果为空则创建
		if (messageList == null) {
			messageList = new ArrayList<String>();
		}
		// 如果超过199条数据就删除50条
		if (messageList.size() > 199) {
			List<String> ms = messageList.subList(0, 50);
			messageList.removeAll(ms);
		}
		// 如果传过来的消息不是空的，就加入消息
		if (message != null && !"".equals(message.trim())) {
			// message = URLDecoder.decode(message, "GB2312");
			message = loginName
					+ "  ("
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date()) + ")  说:\n" + message + "\n";

			// 添加到集合中
			messageList.add(message);
			// 添加到application对象中
			messages.put(interestGroupId, messageList);
			application.setAttribute("messages", messages);
		}
		StringBuffer buffer = new StringBuffer("Welcome to Chatting Room\n");
		if (messageList != null && messageList.size() != 0) {
			for (String string : messageList) {
				buffer.append(string);
			}
		}
		// 输出
		PrintWriter out = response.getWriter();
		out.print(buffer.toString());
		out.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	public ActionForward doLayout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 传进小组id
		String interestGroupId = request.getParameter("interestGroupId");
		HttpSession session = request.getSession();
		// 得到当前用户
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		String loginName = user.getLoginName();
		// 查找兴趣小组的用户
		ServletContext application = request.getSession().getServletContext();
		Map<String, ArrayList<String>> users = (HashMap<String, ArrayList<String>>) application
				.getAttribute("users");

		if (users != null) {
			ArrayList<String> list = users.get(interestGroupId);
			System.out.println("小组成员人数：" + list.size());
			// 将该用户删除
			list.remove(loginName);
			users.put(interestGroupId, list);
			application.setAttribute("users", users);
			System.out.println("小组成员人数：" + list.size());
		}

		// 查询出该小组的信息
		Map<String, ArrayList<String>> messages = (HashMap<String, ArrayList<String>>) application
				.getAttribute("messages");
		if (messages == null) {
			messages = new HashMap<String, ArrayList<String>>();
		}
		ArrayList<String> messageList = messages.get(interestGroupId);
		if (messageList == null) {
			messageList = new ArrayList<String>();
		}
		messageList.add("\n" + loginName + " , 离开聊天室了.....\n");
		messages.put(interestGroupId, messageList);
		application.setAttribute("messages", messages);
		// response.sendRedirect("/achat/chat/index.jsp");
		return null;
	}

	@SuppressWarnings("unchecked")
	public ActionForward getUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从application中取出所有已登录者的信息
		// 存放在 application中
		ServletContext application = request.getSession().getServletContext();
		Map<String, ArrayList<String>> users = (Map<String, ArrayList<String>>) application
				.getAttribute("users");
		// 获得小组编号
		String interestGroupId = request.getParameter("interestGroupId");
		ArrayList<String> list = users.get(interestGroupId);
		int size = 0;
		if (list != null)
			size = list.size();
		// 获得小组的人数
		int total = 0;
		InterestGroup ig = interestGroupBiz.query(Integer
				.valueOf(interestGroupId));
		if (ig != null && ig.getUsers() != null) {
			total = ig.getUsers().size();
		}
		StringBuffer buffer = new StringBuffer("小组成员(" + size + "/" + total
				+ ")\n");
		if (list != null) {
			for (String string : list) {
				buffer.append("<font color='red'>" + string + "</font>" + "\n");
			}
		}
		Set<User> us = ig.getUsers();
		List<String> listUs = new ArrayList<String>();
		for (User u : us) {
			listUs.add(u.getLoginName());
		}
		listUs.removeAll(list);
		for (String lu : listUs) {
			buffer.append(lu + "\n");
		}
		// 设置输出信息的格式及字符集
		response.setContentType("text/xml; charset=GB2312");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.print("<response>");
		out.print("<userinfo>");
		out.print(buffer.toString());
		out.print("</userinfo>");
		out.print("</response>");
		return null;
	}

	@SuppressWarnings("unchecked")
	public ActionForward chat(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String interestGroupId = request.getParameter("interestGroupId");
		InterestGroup ig = interestGroupBiz.query(Integer
				.valueOf(interestGroupId));
		request.setAttribute("chatIg", ig);
		request.setAttribute("interestGroupId", interestGroupId);

		// 获得所有用户发送的信息
		ServletContext application = request.getSession().getServletContext();
		Map<String, ArrayList<String>> messages = (HashMap<String, ArrayList<String>>) application
				.getAttribute("messages");
		// 如果为空则创建
		if (messages == null) {
			messages = new HashMap<String, ArrayList<String>>();
		}
		// 得到当前小组的message
		ArrayList<String> messageList = messages.get(interestGroupId);
		// 如果为空则创建
		if (messageList == null) {
			messageList = new ArrayList<String>();
		}
		// 如果超过199条数据就删除50条
		if (messageList.size() > 199) {
			List<String> ms = messageList.subList(0, 50);
			messageList.removeAll(ms);
		}
		StringBuffer buffer = new StringBuffer("Welcome to Chatting Room\n");
		if (messageList != null && messageList.size() != 0) {
			for (String string : messageList) {
				buffer.append(string);
			}
		}
		request.setAttribute("messageList", buffer.toString());
		return mapping.findForward("success");
	}
}
