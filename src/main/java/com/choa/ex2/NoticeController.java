package com.choa.ex2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;
import com.choa.util.MakePage;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Inject	//inject는 data type으로 찾음
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{		
		List<NoticeDTO> noticeList = noticeService.noticeList(curPage);
		model.addAttribute("noticeList", noticeList);
	}
	
	@RequestMapping(value = "noticeView", method = RequestMethod.GET)
	public void noticeView(Model model, Integer num) throws Exception{
		if(num != null){ 
			NoticeDTO noticeDTO = noticeService.noticeView(num);
			model.addAttribute("noticeDTO", noticeDTO);
		}
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public void noticeWrite(){		
		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO, RedirectAttributes reAttributes) throws Exception{		
		System.out.println("Notice Write Process");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeWrite(noticeDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		//reAttributes.addAttribute("message", message);//주소창에 파라미터가 남음
		reAttributes.addFlashAttribute("message", message);//주소창에 남지 않음
		//mv.addObject("message", message);
		mv.setViewName("redirect:noticeList?curPage=1");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public void noticeUpdate(Model model, Integer num) throws Exception{
		if(num != null){ 
			NoticeDTO noticeDTO = noticeService.noticeView(num);
			model.addAttribute("noticeDTO", noticeDTO);
		}
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes reAttributes) throws Exception{		
		System.out.println("Notice Update Process");
		int result = noticeService.noticeUpdate(noticeDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:noticeView?num="+noticeDTO.getNum();
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes reAttributes) throws Exception{
		System.out.println("Notice Delete Process");
		if(num != null){
			int result = noticeService.noticeDelete(num);
			String message = "FAIL";
			if(result > 0){
				message = "SUCCESS";
			}
			reAttributes.addFlashAttribute("message", message);
		}
		return "redirect:noticeList";
	}
}
