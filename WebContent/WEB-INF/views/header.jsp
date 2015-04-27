<%@page import="com.easybuy.user.domain.*"%>
<div class='navigate'>
<ul>
<% 
	User user = (User) session.getAttribute("user");
	if(user == null){
%>
	<li><a href='/Easybuy/login'>Sign in</a></li>
	<li><a href='/Easybuy/registration/buyerregistration'>Register as Buyer</a></li>
	<li><a href='/Easybuy/registration/seller'>Register as Seller</a></li>
	<li class="right"><a href='/Easybuy/order/'>Order</a></li>
	<li class="right"><a href='/Easybuy/shopcart'>Shopcart</a></li>
	<li class="right"><a href='/Easybuy/wishlist'>Wishlist</a></li>
	<li class="right"><a href='/Easybuy/'>Easybuy</a></li>
<%
	}
	else if(user instanceof Buyer){
		String user_name = ((Buyer)user).getUser_name();
%>
		<li><a href='/Easybuy/user/buyer/profile'>hello, <%= user_name %></a></li>
		<li><a href='/Easybuy/logout'>Sign out</a></li>
		<li><a href='/Easybuy/message/'>Message</a></li>
		<li class="right"><a href='/Easybuy/order/'>Order</a></li>
		<li class="right"><a href='/Easybuy/shopcart'>Shopcart</a></li>
		<li class="right"><a href='/Easybuy/wishlist'>Wishlist</a></li>
		<li class="right"><a href='/Easybuy/'>Easybuy</a></li>
<%	
	}
	else if(user instanceof Seller){
		String user_name = ((Seller)user).getUser_name();
%>
		<li><a href='/Easybuy/user/seller/profile'>hello, <%= user_name %></a></li>
		<li><a href='/Easybuy/logout'>Sign out</a></li>
		<li><a href='/Easybuy/product/sellerProducts'>My products</a></li>
		<li><a href='/Easybuy/message/'>Message</a></li>
		<li class="right"><a href='/Easybuy/order/'>Order</a></li>
		<li class="right"><a href='/Easybuy/'>Easybuy</a></li>
<%
	}
	else {
		String user_name = ((Admin)user).getUser_name();
%>
		<li><a href='/Easybuy/user/admin/profile'>hello, <%= user_name %></a></li>
		<li><a href='/Easybuy/logout'>Sign out</a></li>
		<li><a href='/Easybuy/message/'>Message</a></li>
		<li class="right"><a href='/Easybuy/user/'>User</a></li>
		<li class="right"><a href='/Easybuy/order/'>Order</a></li>
		<li class="right"><a href='/Easybuy/'>Easybuy</a></li>
<%		
	}
%>
	
</ul>
</div>