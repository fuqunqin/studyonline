package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.util.Page;

public interface OnlineListeningBiz {
	// �����������
	public OnlineListening add(OnlineListening onlineListening);

	// �޸���������
	public OnlineListening modify(OnlineListening onlineListening);

	// ɾ����������
	public void remove(List<OnlineListening> onlineListenings);

	// ��ѯ��������
	public List<OnlineListening> query(Page page);

	// ��ѯ������������
	public OnlineListening query(Integer id);

	// ͨ��·����ѯ��������
	public OnlineListening query(String listenUrl);
}
