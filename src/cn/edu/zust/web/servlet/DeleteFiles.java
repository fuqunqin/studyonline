package cn.edu.zust.web.servlet;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;

import cn.edu.zust.biz.OnlineListeningBiz;
import cn.edu.zust.biz.ShareBiz;
import cn.edu.zust.biz.TestBiz;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.Test;

public class DeleteFiles implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(final ServletContextEvent sce) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				ApplicationContext ac = (ApplicationContext) sce
						.getServletContext()
						.getAttribute(
								"org.springframework.web.context.WebApplicationContext.ROOT");
				String sharePath = sce.getServletContext()
						.getRealPath("/share");
				File sf = new File(sharePath);
				if (!sf.exists()) {
					sf.mkdirs();
				}
				File[] shareFiles = sf.listFiles();
				for (File file : shareFiles) {
					ShareBiz shareBiz = (ShareBiz) ac.getBean("shareBiz");
					Share share = shareBiz.query(file.getAbsolutePath());
					if (share == null) {
						file.delete();
					}
				}
				String olPath = sce.getServletContext().getRealPath(
						"/onlinelistening");
				File olf = new File(olPath);
				if (!olf.exists()) {
					olf.mkdirs();
				}
				File[] olFiles = olf.listFiles();
				for (File file : olFiles) {
					OnlineListeningBiz onlineListeningBiz = (OnlineListeningBiz) ac
							.getBean("onlineListeningBiz");
					OnlineListening onlineListening = onlineListeningBiz
							.query(file.getAbsolutePath());
					if (onlineListening == null) {
						file.delete();
					}
				}
				String testPath = sce.getServletContext().getRealPath(
						"/test");
				File tf = new File(testPath);
				if (!tf.exists()) {
					tf.mkdirs();
				}
				File[] testFiles = olf.listFiles();
				for (File file :testFiles) {
					TestBiz testBiz = (TestBiz) ac
							.getBean("testBiz");
					Test test = testBiz
							.query(file.getAbsolutePath());
					if (test == null) {
						file.delete();
					}
				}
			}
		}, 0, 1000 * 60 * 60 * 24);
	}

}
