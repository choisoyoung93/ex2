package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeService {
	@Inject
	private NoticeDAO noticeDAO;
	
	/*public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/


	//List
	public List<NoticeDTO> noticeList(int curPage) throws Exception{
		PageMaker pageMaker = new PageMaker(curPage);
		RowMaker rowMaker = pageMaker.getRowMaker(null, null);
		int totalCount = noticeDAO.noticeCount();	
		MakePage makePage = pageMaker.getMakePage(totalCount);
		List<NoticeDTO> noticeArr = noticeDAO.noticeList(rowMaker);
		return noticeArr;
	}
	
	//view
	public NoticeDTO noticeView(int num) throws Exception{
		NoticeDTO noticeDTO = noticeDAO.noticeView(num);		
		return noticeDTO;
	}
	
	//Write
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	//Update
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	//Delete
	public int noticeDelete(int num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}
}
