package cn.edu.zust.web.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;

import cn.edu.zust.biz.AccreditationBiz;
import cn.edu.zust.biz.CertificateExamBiz;
import cn.edu.zust.biz.EnglishStudyBiz;
import cn.edu.zust.biz.ExamAppreciateBiz;
import cn.edu.zust.biz.FrontierBiz;
import cn.edu.zust.biz.InterestGroupBiz;
import cn.edu.zust.biz.OnlineListeningBiz;
import cn.edu.zust.biz.PubmedTribeBiz;
import cn.edu.zust.biz.ShareBiz;
import cn.edu.zust.biz.SutraBookBiz;
import cn.edu.zust.biz.TestBiz;
import cn.edu.zust.biz.UserBiz;
import cn.edu.zust.biz.WinBiz;
import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.entity.Frontier;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.entity.Test;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;

public class MainQuerySession implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ApplicationContext ac = (ApplicationContext) event
				.getSession()
				.getServletContext()
				.getAttribute(
						"org.springframework.web.context.WebApplicationContext.ROOT");
		Page page = new Page();
		page.setPageIndex(1);
		// 最新用户
		List<User> users = ((UserBiz) ac.getBean("userBiz")).queryNew(8);
		session.setAttribute("mainus", users);
		// 学科动态
		List<Frontier> frontiers = ((FrontierBiz) ac.getBean("frontierBiz"))
				.query(page);
		if (frontiers.size() > 3) {
			frontiers = frontiers.subList(0, 3);
		}
		session.setAttribute("mainfs", frontiers);

		List<Win> wins = ((WinBiz) ac.getBean("winBiz")).query(page);
		if (wins.size() > 2) {
			wins = wins.subList(0, 2);
		}
		session.setAttribute("mainws", wins);

		List<SutraBook> sutraBooks = ((SutraBookBiz) ac.getBean("sutraBookBiz"))
				.query(page);
		if (sutraBooks.size() > 2) {
			sutraBooks = sutraBooks.subList(0, 2);
		}
		session.setAttribute("mainsbs", sutraBooks);
		// 资料共享
		List<Share> shares = ((ShareBiz) ac.getBean("shareBiz")).query(page);
		if (shares.size() > 7) {
			shares = shares.subList(0, 7);
		}
		session.setAttribute("mainss", shares);
		// 考研部落
		List<PubmedTribe> pubmedTribes = ((PubmedTribeBiz) ac
				.getBean("pubmedTribeBiz")).query(page);
		if (pubmedTribes.size() > 7) {
			pubmedTribes = pubmedTribes.subList(0, 7);
		}
		session.setAttribute("mainpts", pubmedTribes);
		// 资格认证
		List<Accreditation> accreditations = ((AccreditationBiz) ac
				.getBean("accreditationBiz")).query(page);
		if (accreditations.size() > 3) {
			accreditations = accreditations.subList(0, 3);
		}
		session.setAttribute("mainas", accreditations);

		List<CertificateExam> certificateExams = ((CertificateExamBiz) ac
				.getBean("certificateExamBiz")).query(page);
		if (certificateExams.size() > 2) {
			certificateExams = certificateExams.subList(0, 2);
		}
		session.setAttribute("mainces", certificateExams);

		List<Test> tests = ((TestBiz) ac.getBean("testBiz")).query(page);
		if (tests.size() > 2) {
			tests = tests.subList(0, 2);
		}
		session.setAttribute("maints", tests);
		// 英语学习
		List<EnglishStudy> englishStudies = ((EnglishStudyBiz) ac
				.getBean("englishStudyBiz")).query(page);
		if (englishStudies.size() > 3) {
			englishStudies = englishStudies.subList(0, 3);
		}
		session.setAttribute("mainess", englishStudies);

		List<OnlineListening> onlineListenings = ((OnlineListeningBiz) ac
				.getBean("onlineListeningBiz")).query(page);
		if (onlineListenings.size() > 2) {
			onlineListenings = onlineListenings.subList(0, 2);
		}
		session.setAttribute("mainols", onlineListenings);

		List<ExamAppreciate> examAppreciates = ((ExamAppreciateBiz) ac
				.getBean("examAppreciateBiz")).query(page);
		if (examAppreciates.size() > 2) {
			examAppreciates = examAppreciates.subList(0, 2);
		}
		session.setAttribute("maineas", examAppreciates);
		// 兴趣小组
		List<InterestGroup> interestGroups = ((InterestGroupBiz) ac
				.getBean("interestGroupBiz")).query(page);
		if (interestGroups.size() > 7) {
			interestGroups = interestGroups.subList(0, 7);
		}
		session.setAttribute("mainigs", interestGroups);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
	}

}
