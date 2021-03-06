package spring.mvc.study.vo;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class UserVO {
	
	public UserVO(){
		this.user_id = "1";
		this.user_nm = "강지영";
		this.grp_gubun = "01";
		this.store_id = "SA0000000203";
	}
	
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String user_pw;
	private String user_nm;
	private String grp_gubun;
	private String store_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getGrp_gubun() {
		return grp_gubun;
	}
	public void setGrp_gubun(String grp_gubun) {
		this.grp_gubun = grp_gubun;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
}
