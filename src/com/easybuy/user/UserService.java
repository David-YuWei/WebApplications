package com.easybuy.user;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.easybuy.common.Pager;
import com.easybuy.user.domain.Admin;
import com.easybuy.user.domain.Buyer;
import com.easybuy.user.domain.Seller;
import com.easybuy.user.domain.User;

@Service("user:userService")
public class UserService {

	private static final String REQUEST_ATTR_USERNAME = "user";
	@Resource(name = "user:userDAO")
	private UserDAO userDAO;
	
	public UserService() {
	}
	
	public HttpSession getSession(HttpServletRequest request) throws Exception {
		return request.getSession();
	}
	
	public Object getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute(REQUEST_ATTR_USERNAME);
	}
	
	public String checkUser(HttpServletRequest request, String username, String password){
		HttpSession session = request.getSession();
		session.invalidate();
		//check user in database
		String result = userDAO.checkExistByUsernameAndPassword(username, password);
		if(result !=null){
			session = request.getSession();
			User user = null;
			if(result.equals("buyer")){
				user = userDAO.getBuyerById(username);
			}
			else if(result.equals("seller")){
				user = userDAO.getSellerById(username);
			}
			else{
				user = userDAO.getAdminById(username);
			}
			session.setAttribute("user", user);
			return "success";
		}
		else{
			return "incorrect username or password";
		}
	}
	
	public List<Buyer> getBuyerList(Pager pager){
		List<Buyer> buyers= userDAO.getBuyerList(pager);
		if(buyers !=null){
			for(Buyer br:buyers){
				//translates value of the attribute to practical meaning
			}
		}
		return buyers;
	}

	public String insertBuyer(HttpServletRequest request,String firstname,String middlename,String lastname,String emailid,String address,String phonenumber,String username,String password) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
	  String result = userDAO.insertBuyer(firstname,middlename,lastname,emailid,address,phonenumber,username,password);
	  if(result != null)
	  {
		  session =request.getSession();
		  User user = null;
		  session.setAttribute("user", user);
		  return "success";
	  }
	  return "success";
		
	}
	
	public String insertSeller(HttpServletRequest request,String firstname,String middlename,String lastname,String emailid,String address,
			String phonenumber,String username,String password,String accountnumber,String routingnumber) throws Exception{
	//	HttpSession session = request.getSession();
  //session.invalidate();
	  String result = userDAO.insertSeller(firstname,middlename,lastname,emailid,address,phonenumber,username,password,accountnumber,routingnumber);
	  if(result != null)
	  {
		  return "success";
	  }
	  return "success";
		
	}
	
	/* public String checkBuyer(HttpServletRequest request,String username) throws Exception
	{
		HttpSession session = request.getSession();
		session.invalidate();
	  String result = userDAO.checkBuyer(username);
	  if(result != null)
	  {
		  session =request.getSession();
		  User user = null;
		  session.setAttribute("user", user);
		  return "success";
	  }
	  return "success"; 
	} */
	public void deleteBuyer(String id) throws Exception{
		
	}
	
	public void updateBuyer(Buyer buyer) throws Exception{
		
	}
	
	public List<Buyer> searchBuyerList(){
		return null;
	}
	
	public Buyer searchBuyerById(String id){
		return null;
	}
	
	
	public void deleteSeller(long id) throws Exception{
		
	}
	
}
