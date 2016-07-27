package spring.mvc.study.menu.dao;

import java.util.List;

import javax.annotation.Resource;

import spring.mvc.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Resource
public interface MenuDao {
	public List<UserVO> dataList();
	public int dataInsert();
}
