package spring.mvc.study.menu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.study.menu.dao.MenuDao;
import spring.mvc.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Service("menuService")
public class MenuService {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);
	
	@Autowired MenuDao menuDAO;
	
	public List<UserVO> dataList(){
		return menuDAO.dataList();
	}
	
	/*@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)*/
	public int dataInsert(){
		menuDAO.dataInsert();
		throw new RuntimeException("트랜잭션 테스트 : 강제로 오류를 발생시켜봄!!");
		//return menuDAO.dataInsert(); 
	}
}
