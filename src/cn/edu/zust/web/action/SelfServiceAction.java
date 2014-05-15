package cn.edu.zust.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import cn.edu.zust.biz.AccreditationBiz;
import cn.edu.zust.biz.CertificateExamBiz;
import cn.edu.zust.biz.EnglishStudyBiz;
import cn.edu.zust.biz.ExamAppreciateBiz;
import cn.edu.zust.biz.FrontierBiz;
import cn.edu.zust.biz.OnlineListeningBiz;
import cn.edu.zust.biz.PubmedTribeBiz;
import cn.edu.zust.biz.ShareBiz;
import cn.edu.zust.biz.SutraBookBiz;
import cn.edu.zust.biz.TestBiz;
import cn.edu.zust.biz.WinBiz;
import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.entity.Frontier;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.entity.Test;
import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;
import cn.edu.zust.util.PreviousNext;

public class SelfServiceAction extends MappingDispatchAction {
	private FrontierBiz frontierBiz;
	private WinBiz winBiz;
	private SutraBookBiz sutraBookBiz;
	private PubmedTribeBiz pubmedTribeBiz;
	private AccreditationBiz accreditationBiz;
	private CertificateExamBiz certificateExamBiz;
	private TestBiz testBiz;
	private EnglishStudyBiz englishStudyBiz;
	private OnlineListeningBiz onlineListeningBiz;
	private ExamAppreciateBiz examAppreciateBiz;
	private ShareBiz shareBiz;
	private PreviousNext previousNext;

	public PreviousNext getPreviousNext() {
		return previousNext;
	}

	public void setPreviousNext(PreviousNext previousNext) {
		this.previousNext = previousNext;
	}

	public ShareBiz getShareBiz() {
		return shareBiz;
	}

	public void setShareBiz(ShareBiz shareBiz) {
		this.shareBiz = shareBiz;
	}

	public ExamAppreciateBiz getExamAppreciateBiz() {
		return examAppreciateBiz;
	}

	public void setExamAppreciateBiz(ExamAppreciateBiz examAppreciateBiz) {
		this.examAppreciateBiz = examAppreciateBiz;
	}

	public OnlineListeningBiz getOnlineListeningBiz() {
		return onlineListeningBiz;
	}

	public void setOnlineListeningBiz(OnlineListeningBiz onlineListeningBiz) {
		this.onlineListeningBiz = onlineListeningBiz;
	}

	public EnglishStudyBiz getEnglishStudyBiz() {
		return englishStudyBiz;
	}

	public void setEnglishStudyBiz(EnglishStudyBiz englishStudyBiz) {
		this.englishStudyBiz = englishStudyBiz;
	}

	public TestBiz getTestBiz() {
		return testBiz;
	}

	public void setTestBiz(TestBiz testBiz) {
		this.testBiz = testBiz;
	}

	public CertificateExamBiz getCertificateExamBiz() {
		return certificateExamBiz;
	}

	public void setCertificateExamBiz(CertificateExamBiz certificateExamBiz) {
		this.certificateExamBiz = certificateExamBiz;
	}

	public AccreditationBiz getAccreditationBiz() {
		return accreditationBiz;
	}

	public void setAccreditationBiz(AccreditationBiz accreditationBiz) {
		this.accreditationBiz = accreditationBiz;
	}

	public FrontierBiz getFrontierBiz() {
		return frontierBiz;
	}

	public void setFrontierBiz(FrontierBiz frontierBiz) {
		this.frontierBiz = frontierBiz;
	}

	public WinBiz getWinBiz() {
		return winBiz;
	}

	public SutraBookBiz getSutraBookBiz() {
		return sutraBookBiz;
	}

	public void setSutraBookBiz(SutraBookBiz sutraBookBiz) {
		this.sutraBookBiz = sutraBookBiz;
	}

	public void setWinBiz(WinBiz winBiz) {
		this.winBiz = winBiz;
	}

	public PubmedTribeBiz getPubmedTribeBiz() {
		return pubmedTribeBiz;
	}

	public void setPubmedTribeBiz(PubmedTribeBiz pubmedTribeBiz) {
		this.pubmedTribeBiz = pubmedTribeBiz;
	}

	public ActionForward querySubjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Page fpage = new Page();
		fpage.setPageIndex(1);
		fpage.setPageSize(40);
		List<Frontier> frontieres = frontierBiz.query(fpage);
		HttpSession session = request.getSession();
		session.setAttribute("frontieres", frontieres);
		session.setAttribute("fpage", fpage);

		Page wpage = new Page();
		wpage.setPageIndex(1);
		wpage.setPageSize(40);
		List<Win> wins = winBiz.query(wpage);
		session.setAttribute("wins", wins);
		session.setAttribute("wpage", wpage);

		Page sbpage = new Page();
		sbpage.setPageIndex(1);
		sbpage.setPageSize(40);
		List<SutraBook> sutraBooks = sutraBookBiz.query(sbpage);
		session.setAttribute("sutraBooks", sutraBooks);
		session.setAttribute("spage", sbpage);
		return mapping.findForward("success");
	}

	public ActionForward queryFrontiers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String fpageIndex = request.getParameter("fpageIndex");
		Page fpage = new Page();
		fpage.setPageIndex(Integer.parseInt(fpageIndex));
		fpage.setPageSize(40);
		List<Frontier> frontieres = frontierBiz.query(fpage);
		HttpSession session = request.getSession();
		session.setAttribute("frontieres", frontieres);
		session.setAttribute("fpage", fpage);
		return mapping.findForward("success");
	}

	public ActionForward queryWins(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String wpageIndex = request.getParameter("wpageIndex");
		Page wpage = new Page();
		wpage.setPageIndex(Integer.parseInt(wpageIndex));
		wpage.setPageSize(40);
		List<Win> wins = winBiz.query(wpage);
		HttpSession session = request.getSession();
		session.setAttribute("wins", wins);
		session.setAttribute("wpage", wpage);
		return mapping.findForward("success");
	}

	public ActionForward querySubtraBooks(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sbpageIndex = request.getParameter("sbpageIndex");
		Page sbpage = new Page();
		sbpage.setPageIndex(Integer.parseInt(sbpageIndex));
		sbpage.setPageSize(40);
		HttpSession session = request.getSession();
		List<SutraBook> sutraBooks = sutraBookBiz.query(sbpage);
		session.setAttribute("sutraBooks", sutraBooks);
		session.setAttribute("sbpage", sbpage);
		return mapping.findForward("success");
	}

	public ActionForward queryPubmedTribes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page ptpage = new Page();
		String ptpageIndex = request.getParameter("ptpageIndex");
		if (ptpageIndex == null || ptpageIndex == "") {
			ptpage.setPageIndex(1);
		} else {
			ptpage.setPageIndex(Integer.valueOf(ptpageIndex));
		}
		ptpage.setPageSize(40);
		List<PubmedTribe> pubmedTribes = pubmedTribeBiz.query(ptpage);
		HttpSession session = request.getSession();
		session.setAttribute("pubmedTribes", pubmedTribes);
		session.setAttribute("ptpage", ptpage);
		return mapping.findForward("success");
	}

	public ActionForward queryQualifications(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		Page apage = new Page();
		apage.setPageIndex(1);
		apage.setPageSize(40);
		List<Accreditation> accreditations = accreditationBiz.query(apage);
		session.setAttribute("accreditations", accreditations);
		session.setAttribute("apage", apage);

		Page cepage = new Page();
		cepage.setPageIndex(1);
		cepage.setPageSize(40);
		List<CertificateExam> certificateExams = certificateExamBiz
				.query(cepage);
		session.setAttribute("certificateExams", certificateExams);
		session.setAttribute("cepage", cepage);

		Page tpage = new Page();
		tpage.setPageIndex(1);
		tpage.setPageSize(40);
		List<Test> tests = testBiz.query(tpage);
		session.setAttribute("tests", tests);
		session.setAttribute("tpage", tpage);

		return mapping.findForward("success");
	}

	public ActionForward queryAccreditations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String apageIndex = request.getParameter("apageIndex");
		HttpSession session = request.getSession();
		Page apage = new Page();
		apage.setPageIndex(Integer.parseInt(apageIndex));
		apage.setPageSize(40);
		List<Accreditation> accreditations = accreditationBiz.query(apage);
		session.setAttribute("accreditations", accreditations);
		session.setAttribute("apage", apage);
		return mapping.findForward("success");
	}

	public ActionForward queryCertificateExams(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String cepageIndex = request.getParameter("cepageIndex");
		HttpSession session = request.getSession();
		Page cepage = new Page();
		cepage.setPageIndex(Integer.parseInt(cepageIndex));
		cepage.setPageSize(40);
		List<CertificateExam> certificateExams = certificateExamBiz
				.query(cepage);
		session.setAttribute("certificateExams", certificateExams);
		session.setAttribute("cepage", cepage);
		return mapping.findForward("success");
	}

	public ActionForward queryTests(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tpageIndex = request.getParameter("tpageIndex");
		HttpSession session = request.getSession();
		Page tpage = new Page();
		tpage.setPageIndex(Integer.parseInt(tpageIndex));
		tpage.setPageSize(40);
		List<Test> tests = testBiz.query(tpage);
		session.setAttribute("tests", tests);
		session.setAttribute("tpage", tpage);
		return mapping.findForward("success");
	}

	public ActionForward queryEnglishes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Page espage = new Page();
		espage.setPageIndex(1);
		espage.setPageSize(40);
		List<EnglishStudy> englishStudies = englishStudyBiz.query(espage);
		session.setAttribute("englishStudies", englishStudies);
		session.setAttribute("espage", espage);

		Page eapage = new Page();
		eapage.setPageIndex(1);
		eapage.setPageSize(40);
		List<ExamAppreciate> examAppreciates = examAppreciateBiz.query(eapage);
		session.setAttribute("examAppreciates", examAppreciates);
		session.setAttribute("eapage", eapage);

		Page olpage = new Page();
		olpage.setPageIndex(1);
		olpage.setPageSize(40);
		List<OnlineListening> onlineListenings = onlineListeningBiz
				.query(olpage);
		session.setAttribute("onlineListenings", onlineListenings);
		session.setAttribute("olpage", olpage);

		return mapping.findForward("success");
	}

	public ActionForward queryEnglishStudies(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Page espage = new Page();
		espage.setPageIndex(Integer.parseInt(request
				.getParameter("espageIndex")));
		espage.setPageSize(40);
		List<EnglishStudy> englishStudies = englishStudyBiz.query(espage);
		session.setAttribute("englishStudies", englishStudies);
		session.setAttribute("espage", espage);
		return mapping.findForward("success");
	}

	public ActionForward queryOnlineListenings(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Page olpage = new Page();
		olpage.setPageIndex(1);
		olpage.setPageSize(40);
		List<OnlineListening> onlineListenings = onlineListeningBiz
				.query(olpage);
		session.setAttribute("onlineListenings", onlineListenings);
		session.setAttribute("olpage", olpage);
		return mapping.findForward("success");
	}

	public ActionForward queryExamAppreciates(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Page eapage = new Page();
		eapage.setPageIndex(1);
		eapage.setPageSize(40);
		List<ExamAppreciate> examAppreciates = examAppreciateBiz.query(eapage);
		session.setAttribute("examAppreciates", examAppreciates);
		session.setAttribute("eapage", eapage);
		return mapping.findForward("success");
	}

	public ActionForward queryShares(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Page spage = new Page();
		String spageIndex = request.getParameter("spageIndex");
		if (spageIndex == null || spageIndex == "") {
			spage.setPageIndex(1);
		} else {
			spage.setPageIndex(Integer.parseInt(spageIndex));
		}
		spage.setPageSize(40);
		List<Share> shares = shareBiz.query(spage);
		session.setAttribute("shares", shares);
		session.setAttribute("spage", spage);
		return mapping.findForward("success");
	}

	public ActionForward queryFrontier(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		Frontier frontier = frontierBiz.query(Integer.valueOf(id));
		session.setAttribute("frontier", frontier);
		// 查该数据前一条数据
		Integer previousId = previousNext.queryPreviousData("Frontier", Integer
				.valueOf(id));
		if (previousId != null) {
			Frontier previousFrontier = frontierBiz.query(previousId);
			session.setAttribute("previousFrontier", previousFrontier);
		} else {
			session.setAttribute("previousFrontier", null);
		}
		// 查该数据后一条数据
		Integer nextId = previousNext.queryNextData("Frontier", Integer
				.valueOf(id));
		if (nextId != null) {
			Frontier nextFrontier = frontierBiz.query(nextId);
			session.setAttribute("nextFrontier", nextFrontier);
		} else {
			session.setAttribute("nextFrontier", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward queryWin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		Win win = winBiz.query(id);
		session.setAttribute("win", win);
		// 查询前一条数据
		Integer previousId = previousNext.queryPreviousData("Win", id);
		if (previousId != null) {
			Win previousWin = winBiz.query(previousId);
			session.setAttribute("previousWin", previousWin);
		} else {
			session.setAttribute("previousWin", null);
		}
		// 查询后一条数据
		Integer nextId = previousNext.queryNextData("Win", id);
		if (nextId != null) {
			session.setAttribute("nextWin", winBiz.query(nextId));
		} else {
			session.setAttribute("nextWin", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward querySutraBook(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		SutraBook sutraBook = sutraBookBiz.query(id);
		session.setAttribute("sutraBook", sutraBook);
		// 查询前一条数据
		Integer previousId = previousNext.queryPreviousData("SutraBook", id);
		if (previousId != null) {
			session.setAttribute("previousSutraBook", sutraBookBiz
					.query(previousId));
		} else {
			session.setAttribute("previousSutraBook", null);
		}
		// 查询后一条数据
		Integer nextId = previousNext.queryNextData("SutraBook", id);
		if (nextId != null) {
			session.setAttribute("nextSutraBook", sutraBookBiz.query(nextId));
		} else {
			session.setAttribute("nextSutraBook", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward queryPubmedTribe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		PubmedTribe pubmedTribe = pubmedTribeBiz.query(id);
		HttpSession session = request.getSession();
		session.setAttribute("pubmedTribe", pubmedTribe);
		Integer previousId = previousNext.queryPreviousData("PubmedTribe", id);
		if (previousId != null) {
			session.setAttribute("previousPubmedTribe", pubmedTribeBiz
					.query(previousId));
		} else {
			session.setAttribute("previousPubmedTribe", null);
		}
		Integer nextId = previousNext.queryNextData("PubmedTribe", id);
		if (nextId != null) {
			session.setAttribute("nextPubmedTribe", pubmedTribeBiz
					.query(nextId));
		} else {
			session.setAttribute("nextPubmedTribe", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward queryAccreditation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		session.setAttribute("accreditation", accreditationBiz.query(id));
		Integer previousId = previousNext
				.queryPreviousData("Accreditation", id);
		if (previousId != null) {
			session.setAttribute("previousAccreditation", accreditationBiz
					.query(previousId));
		} else {
			session.setAttribute("previousAccreditation", null);
		}
		Integer nextId = previousNext.queryNextData("Accreditation", id);
		if (nextId != null) {
			session.setAttribute("nextAccreditation", accreditationBiz
					.query(nextId));
		} else {
			session.setAttribute("nextAccreditation", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward queryCertificateExam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("certificateExam", certificateExamBiz.query(id));
		Integer previousId = previousNext.queryPreviousData("CertificateExam",
				id);
		if (previousId != null) {
			session.setAttribute("previousCertificateExam", certificateExamBiz
					.query(previousId));
		} else {
			session.setAttribute("previousCertificateExam", null);
		}
		Integer nextId = previousNext.queryNextData("CertificateExam", id);
		if (nextId != null) {
			session.setAttribute("nextCertificateExam", certificateExamBiz
					.query(nextId));
		} else {
			session.setAttribute("nextCertificateExam", null);
		}
		return mapping.findForward("success");
	}

	public ActionForward queryTest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("test", testBiz.query(id));
		Integer previousId = previousNext.queryPreviousData("Test", id);
		session.setAttribute("previousTest", previousId == null ? null
				: testBiz.query(previousId));
		Integer nextId = previousNext.queryNextData("Test", id);
		session.setAttribute("nextTest", nextId == null ? null : testBiz
				.query(nextId));
		return mapping.findForward("success");
	}

	public ActionForward queryEnglishStudy(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("englishStudy", englishStudyBiz.query(id));
		Integer previousId = previousNext.queryPreviousData("EnglishStudy", id);
		session.setAttribute("previousEnglishStudy", previousId == null ? null
				: englishStudyBiz.query(previousId));
		Integer nextId = previousNext.queryNextData("EnglishStudy", id);
		session.setAttribute("nextEnglishStudy", nextId == null ? null
				: englishStudyBiz.query(nextId));
		return mapping.findForward("success");
	}

	public ActionForward queryOnlineListening(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("onlineListening", onlineListeningBiz.query(id));
		Integer previousId = previousNext.queryPreviousData("OnlineListening",
				id);
		session.setAttribute("previousOnlineListening",
				previousId == null ? null : onlineListeningBiz
						.query(previousId));
		Integer nextId = previousNext.queryNextData("OnlineListening", id);
		session.setAttribute("nextOnlineListening", nextId == null ? null
				: onlineListeningBiz.query(nextId));
		return mapping.findForward("success");
	}

	public ActionForward queryExamAppreciate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		session.setAttribute("examAppreciate", examAppreciateBiz.query(id));
		Integer previousId = previousNext.queryPreviousData("ExamAppreciate",
				id);
		session
				.setAttribute("previousExamAppreciate",
						previousId == null ? null : examAppreciateBiz
								.query(previousId));
		Integer nextId = previousNext.queryNextData("ExamAppreciate", id);
		session.setAttribute("nextExamAppreciate", nextId == null ? null
				: examAppreciateBiz.query(nextId));
		return mapping.findForward("success");
	}

	/**
	 * 查看资料共享
	 */
	public ActionForward queryShare(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		HttpSession session = request.getSession();
		Share share = shareBiz.query(id);
		String shareurl =share.getShareUrl();
		System.out.println(shareurl);
		//doc docx xls xlsx ppt pptx pdf
		if(shareurl.indexOf(".doc")>0||shareurl.indexOf(".docx")>0||shareurl.indexOf(".xls")>0||shareurl.indexOf(".xlsx")>0||shareurl.indexOf(".ppt")>0||shareurl.indexOf(".pptx")>0||shareurl.indexOf(".pdf")>0){
			boolean boo = convert(request,share);
			session.setAttribute("flex", boo);
		}
		session.setAttribute("share", share);
		Integer previousId = previousNext.queryPreviousData("Share", id);
		session.setAttribute("previousShare", previousId == null ? null
				: shareBiz.query(previousId));
		Integer nextId = previousNext.queryNextData("Share", id);
		session.setAttribute("nextShare", nextId == null ? null : shareBiz
				.query(nextId));
		return mapping.findForward("success");
	}
	
	private boolean convert(HttpServletRequest request,Share share) throws IOException{
		String sh = share.getShareUrl();
		String basepath = request.getSession().getServletContext().getRealPath(File.separator);
		String sharepath = basepath+"share";
		String swfpath = basepath+"swf";
		
		File shareFile = new File(sharepath+File.separator+share.getShareUrl());
		final File pdfFile = new File(swfpath+File.separator+share.getShareUrl()+".pdf");
		final File swfFile = new File(swfpath+File.separator+share.getShareUrl()+".swf");
		
		//转换成pdf文件
		if(shareFile.exists()) {
			if(!pdfFile.exists()) {
				OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
				try {
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(connection);   
					converter.convert(shareFile, pdfFile);
					pdfFile.createNewFile();
					connection.disconnect();  
					System.out.println("转换为PDF--路径" + pdfFile.getPath());
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					System.out.println("OpenOffice服务未启动");
					throw e;
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("读取文件失败");
					throw e;
				} catch (Exception e){
					e.printStackTrace();
					try {
						throw e;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			} else {
				System.out.println("已转换为PDF，无需再次转换");
			}
		} else {
			System.out.println("要转换的文件不存在"+shareFile.getPath());
			return false;
		} 
		
		
		//转换成swf文件
		final Runtime r = Runtime.getRuntime();

		new Thread(){ 

			@Override
			public void run() {
				if(!swfFile.exists()){
					
					if(pdfFile.exists()) {
						try {
							System.out.println("C:/Programs/SWFTools/pdf2swf.exe " + pdfFile.getPath() +
									" -o " + swfFile.getPath() + " -T 9");
							Process p=null;
								p = r.exec("C:/Programs/SWFTools/pdf2swf.exe " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
								p.waitFor();					
							swfFile.createNewFile();
							System.out.println("转换为SWF格式：" + swfFile.getPath()+swfFile.getName());

						} catch (Exception e) {
							e.printStackTrace();
							try {
								throw e;
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} else {
						System.out.println("PDF文件不存在，无法转换");
					}
				} else {
					System.out.println("已经转为SWF文件，无需再次转换");
				}
			}
			
		   }.start();
		
		return true;
	}
	
}
