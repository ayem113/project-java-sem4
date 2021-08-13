
<%@include file="/common/taglib.jsp"%>
<%@ page import="com.projectjavasem4.util.SecurityUtils" %>

<header id="header"
	class="header style-03 header-dark header-transparent">
	<div class="header-wrap-stick">
		<div class="header-position">
			<div class="header-middle">
				<div class="furgan-menu-wapper"></div>
				<div class="header-middle-inner">

					<div class="block-menu-bar">
						<a class="menu-bar menu-toggle" href="#"> <span></span> <span></span>
							<span></span>
						</a>
					</div>
				</div>
				<div class="header-logo">
					<a href="index.html"><img alt="Furgan"
						src="<c:url value='/template/web/assets/images/logo.png '/>"
						class="logo"></a>
				</div>
				<div class="header-control">
					<div class="header-control-inner">
						<div class="meta-dreaming">
							<ul class="wpml-menu">
							
							
							
						 
								<security:authorize access = "isAnonymous()">
									<li class="menu-item">
										<div class="wcml-dropdown product wcml_currency_switcher">
											<ul>
												<li class="wcml-cs-active-currency"><a
													class="wcml-cs-item-toggle">USD</a>
													<ul class="wcml-cs-submenu">
														<li><a>EUR</a></li>
													</ul></li>
											</ul>
										</div>
									</li>
								</security:authorize>
								
								<security:authorize access = "isAuthenticated()"> 
								<li class="menu-item furgan-dropdown block-language">
								<a
									href="#" data-furgan="furgan-dropdown"> <img
										src="/template/web/assets/images/en.png" alt="en" width="18"
										height="12"> English
								</a> <span class="toggle-submenu"></span>
									<ul class="sub-menu">
										<li class="menu-item"><a href="#"> <img
												src="assets/images/it.png" alt="it" width="18" height="12">
												Italiano
										</a></li>
									</ul>
								</li>
							</security:authorize>
								
								
								<%-- <security:authorize access = "isAnonymous()">
									<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a></li>
									<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
								</security:authorize>
								<security:authorize access = "isAuthenticated()">
									<li class="nav-item"><a class="nav-link" href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a></li>
									<li class="nav-item"><a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a></li>
								</security:authorize> --%>
								
								
								
								
							</ul>
							<div class="header-search furgan-dropdown">
								<div class="header-search-inner" data-furgan="furgan-dropdown">
									<a href="#" class="link-dropdown block-link"> <span
										class="flaticon-magnifying-glass-1"></span>
									</a>
								</div>
								<div class="block-search">
									<form role="search" method="get"
										class="form-search block-search-form furgan-live-search-form">
										<div class="form-content search-box results-search">
											<div class="inner">
												<input autocomplete="off"
													class="searchfield txt-livesearch input" name="s" value=""
													placeholder="Search here..." type="text">
											</div>
										</div>
										<input name="post_type" value="product" type="hidden">
										<input name="taxonomy" value="product_cat" type="hidden">
										<div class="category">
											<select title="product_cat" name="product_cat"
												class="category-search-option" tabindex="-1">
												<option value="0">All Categories</option>
												<option class="level-0" value="light">Light</option>
												<option class="level-0" value="chair">Chair</option>
												<option class="level-0" value="table">Table</option>
												<option class="level-0" value="bed">Bed</option>
												<option class="level-0" value="new-arrivals">New
													arrivals</option>
												<option class="level-0" value="lamp">Lamp</option>
												<option class="level-0" value="specials">Specials</option>
												<option class="level-0" value="sofas">Sofas</option>
											</select>
										</div>
										<button type="submit" class="btn-submit">
											<span class="flaticon-magnifying-glass-1"></span>
										</button>
									</form>
									<!-- block search -->
								</div>
							</div>
							<div class="furgan-dropdown-close">x</div>
							<div class="menu-item block-user block-dreaming furgan-dropdown">
								<a class="block-link" href="my-account.html"> <span
									class="flaticon-profile"></span>
								</a>
								<ul class="sub-menu">
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--dashboard is-active">
										<a href="#">Dashboard</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--orders">
										<a href="#">Orders</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--downloads">
										<a href="#">Downloads</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-adchair">
										<a href="#">Address</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-account">
										<a href="#">Account details</a>
									</li>
									<li
										class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--customer-logout">
										<a href="#">Logout</a>
									</li>
								</ul>
							</div>
							<div
								class="block-minicart block-dreaming furgan-mini-cart furgan-dropdown">
								<div class="shopcart-dropdown block-cart-link"
									data-furgan="furgan-dropdown">
									<a class="block-link link-dropdown" href="cart.html"> <span
										class="flaticon-cart"></span> <span class="count">3</span>
									</a>
								</div>
								<div class="widget furgan widget_shopping_cart">
									<div class="widget_shopping_cart_content">
										<ul class="furgan-mini-cart cart_list product_list_widget">
											<li class="furgan-mini-cart-item mini_cart_item"><a
												href="#" class="remove remove_from_cart_button">×</a> <a
												href="#"> <img
													src="/template/web/assets/images/apro134-1-600x778.jpg"
													class="attachment-furgan_thumbnail size-furgan_thumbnail"
													alt="img" width="600" height="778">T-shirt with skirt
													– Pink&nbsp;
											</a> <span class="quantity">1 × <span
													class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>150.00</span></span></li>
											<li class="furgan-mini-cart-item mini_cart_item"><a
												href="#" class="remove remove_from_cart_button">×</a> <a
												href="#"> <img src="assets/images/apro1113-600x778.jpg"
													class="/template/web/attachment-furgan_thumbnail size-furgan_thumbnail"
													alt="img" width="600" height="778">Alarm Clock&nbsp;
											</a> <span class="quantity">1 × <span
													class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>129.00</span></span></li>
											<li class="furgan-mini-cart-item mini_cart_item"><a
												href="#" class="remove remove_from_cart_button">×</a> <a
												href="#"> <img
													src="/template/web/assets/images/apro201-1-600x778.jpg"
													class="attachment-furgan_thumbnail size-furgan_thumbnail"
													alt="img" width="600" height="778">Chair AAC&nbsp;
											</a> <span class="quantity">1 × <span
													class="furgan-Price-amount amount"><span
														class="furgan-Price-currencySymbol">$</span>139.00</span></span></li>
										</ul>
										<p class="furgan-mini-cart__total total">
											<strong>Subtotal:</strong> <span
												class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>418.00</span>
										</p>
										<p class="furgan-mini-cart__buttons buttons">
											<a href="cart.html" class="button furgan-forward">Viewcart</a>
											<a href="checkout.html"
												class="button checkout furgan-forward">Checkout</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="header-mobile">
		<div class="header-mobile-left">
			<div class="block-menu-bar">
				<a class="menu-bar menu-toggle" href="#"> <span></span> <span></span>
					<span></span>
				</a>
			</div>
			<div class="header-search furgan-dropdown">
				<div class="header-search-inner" data-furgan="furgan-dropdown">
					<a href="#" class="link-dropdown block-link"> <span
						class="flaticon-magnifying-glass-1"></span>
					</a>
				</div>
				<div class="block-search">
					<form role="search" method="get"
						class="form-search block-search-form furgan-live-search-form">
						<div class="form-content search-box results-search">
							<div class="inner">
								<input autocomplete="off"
									class="searchfield txt-livesearch input" name="s" value=""
									placeholder="Search here..." type="text">
							</div>
						</div>
						<input name="post_type" value="product" type="hidden"> <input
							name="taxonomy" value="product_cat" type="hidden">
						<div class="category">
							<select title="product_cat" name="product_cat" id="112546160"
								class="category-search-option" tabindex="-1"
								style="display: none;">
								<option value="0">All Categories</option>
								<option class="level-0" value="light">Light</option>
								<option class="level-0" value="chair">Chair</option>
								<option class="level-0" value="table">Table</option>
								<option class="level-0" value="bed">Bed</option>
								<option class="level-0" value="new-arrivals">New
									arrivals</option>
								<option class="level-0" value="lamp">Lamp</option>
								<option class="level-0" value="specials">Specials</option>
								<option class="level-0" value="sofas">Sofas</option>
							</select>
						</div>
						<button type="submit" class="btn-submit">
							<span class="flaticon-magnifying-glass-1"></span>
						</button>
					</form>
					<!-- block search -->
				</div>
			</div>
			<ul class="wpml-menu">
				<li class="menu-item furgan-dropdown block-language"><a
					href="#" data-furgan="furgan-dropdown"> <img
						src="assets/images/en.png" alt="en" width="18" height="12">
						English
				</a> <span class="toggle-submenu"></span>
					<ul class="sub-menu">
						<li class="menu-item">
						<a href="#"> <img src="assets/images/it.png" alt="it" width="18" height="12"> Italiano </a>
						</li>
					</ul>
				</li>
				<li class="menu-item">
					<div class="wcml-dropdown product wcml_currency_switcher">
						<ul>
							<li class="wcml-cs-active-currency"><a
								class="wcml-cs-item-toggle">USD</a>
								<ul class="wcml-cs-submenu">
									<li><a>EUR</a></li>
								</ul></li>
						</ul>
					</div>
				</li>
				
				
			</ul>
		</div>
		<div class="header-mobile-mid">
			<div class="header-logo">
				<a href="index.html"><img alt="Furgan"
					src="assets/images/logo.png" class="logo"></a>
			</div>
		</div>
		<div class="header-mobile-right">
			<div class="header-control-inner">
				<div class="meta-dreaming">
					<div class="menu-item block-user block-dreaming furgan-dropdown">
						<a class="block-link" href="my-account.html"> <span
							class="flaticon-profile"></span>
						</a>
						<ul class="sub-menu">
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--dashboard is-active">
								<a href="#">Dashboard</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--orders">
								<a href="#">Orders</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--downloads">
								<a href="#">Downloads</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-adchair">
								<a href="#">Address</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--edit-account">
								<a href="#">Account details</a>
							</li>
							<li
								class="menu-item furgan-MyAccount-navigation-link furgan-MyAccount-navigation-link--customer-logout">
								<a href="#">Logout</a>
							</li>
						</ul>
					</div>
					<div
						class="block-minicart block-dreaming furgan-mini-cart furgan-dropdown">
						<div class="shopcart-dropdown block-cart-link"
							data-furgan="furgan-dropdown">
							<a class="block-link link-dropdown" href="cart.html"> <span
								class="flaticon-cart"></span> <span class="count">3</span>
							</a>
						</div>
						<div class="widget furgan widget_shopping_cart">
							<div class="widget_shopping_cart_content">
								<ul class="furgan-mini-cart cart_list product_list_widget">
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro134-1-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">T-shirt with skirt –
											Pink&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>150.00</span></span></li>
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro1113-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">Alarm Clock&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>129.00</span></span></li>
									<li class="furgan-mini-cart-item mini_cart_item"><a
										href="#" class="remove remove_from_cart_button">×</a> <a
										href="#"> <img src="assets/images/apro201-1-600x778.jpg"
											class="attachment-furgan_thumbnail size-furgan_thumbnail"
											alt="img" width="600" height="778">Chair AAC&nbsp;
									</a> <span class="quantity">1 × <span
											class="furgan-Price-amount amount"><span
												class="furgan-Price-currencySymbol">$</span>139.00</span></span></li>
								</ul>
								<p class="furgan-mini-cart__total total">
									<strong>Subtotal:</strong> <span
										class="furgan-Price-amount amount"><span
										class="furgan-Price-currencySymbol">$</span>418.00</span>
								</p>
								<p class="furgan-mini-cart__buttons buttons">
									<a href="cart.html" class="button furgan-forward">Viewcart</a>
									<a href="checkout.html" class="button checkout furgan-forward">Checkout</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>