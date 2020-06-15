<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en-US">

<head>

	<!-- Meta
	============================================= -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="author" content="IT Geeks">
    <!-- description -->
    <meta name="description" content="">
    <!-- keywords -->
    <meta name="keywords" content="">

	<!-- Stylesheets
	============================================= -->
	<link href="css/css-assets.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

	<!-- Favicon
	============================================= -->
	<link rel="shortcut icon" href="images/general-elements/favicon/favicon.png">
	<link rel="apple-touch-icon" href="images/general-elements/favicon/apple-touch-icon.png">
	<link rel="apple-touch-icon" sizes="72x72" href="images/general-elements/favicon/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="images/general-elements/favicon/apple-touch-icon-114x114.png">

	<!-- Title
	============================================= -->
	<title>Ticket</title>

</head>

<body class="page-single bg-grey with-sidebar footer-dark">

	<!-- Document Full Container
	============================================= -->
	<div id="full-container">
		<!-- Header
		============================================= -->
		<header id="header">

			<div id="header-bar-1" class="header-bar">

				<div class="header-bar-wrap">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="hb-content">
									<b>欢迎使用！</b>
									<div class="position-right">
										<ul class="list-info">
											<li><a class="popup-btn-logout" href="index.jsp">Logout</a></li>
										</ul><!-- .list-info end -->
									</div><!-- .position-right end -->
								</div><!-- .hb-content end -->
							</div><!-- .col-md-12 end -->
						</div><!-- .row end -->
					</div><!-- .container end -->

				</div><!-- .header-bar-wrap -->

			</div><!-- #header-bar-1 end -->

			<div id="header-bar-2" class="header-bar sticky">

				<div class="header-bar-wrap">

					<div class="container">
						<div class="row">
							<div class="col-md-12">

								<div class="hb-content">
									<a class="logo logo-header" href="homepage.jsp">
										<img src="images/files/logo-header.png" data-logo-alt="images/files/logo-header-alt.png" alt="">
									</a><!-- .logo end -->
									<ul id="menu-main" class="menu-main">
										<li>
											<a href="javascript:;">更多</a>
											<ul class="sub-menu">
												<li><a href="orderlist.jsp">我的订单</a></li>
											</ul><!-- .sub-menu end -->
										</li>
									</ul><!-- #menu-main end -->
								</div><!-- .hb-content end -->

							</div><!-- .col-md-12 end -->
						</div><!-- .row end -->
					</div><!-- .container end -->

				</div><!-- .header-bar-wrap -->

			</div><!-- #header-bar-2 end -->

		</header><!-- #header end -->

		<!-- Banner
		============================================= -->
		<section id="banner">

			<div class="banner-parallax" data-banner-height="550">
				<img src="images/files/parallax-bg/img-4.jpg" alt="">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="banner-center-box">
									<h1><b>Choose Flight</b></h1>
									<div class="banner-reservation-tabs">
										<ul class="br-tabs-content">
											<li class="active">
												<form class="form-banner-reservation form-inline style-2 form-h-50" action="searchresult.jsp">
													<div class="form-group">
														<input type="text" name="brPlaceStart" class="form-control" placeholder="From" list="fromlist">
														<datalist id="fromlist">
															<option>北京</option>
															<option>上海</option>
														</datalist>
													</div><!-- .form-group end -->
													<div class="form-group">
														<input type="text" name="brPlaceEnd" class="form-control" placeholder="To" list="tolist">
														<datalist id="tolist">
															<option>北京</option>
															<option>上海</option>
														</datalist>
													</div><!-- .form-group end -->
													<div class="form-group">
														<input type="text" name="brTimeStart" class="form-control" placeholder="今日" list="datelist">
														<datalist id="datelist">
															<option>今日</option>
															<option>明日</option>
															<option>后天</option>
														</datalist>
													</div><!-- .form-group end -->
													<div class="form-group">
														<button type="submit" class="form-control icon"><i class="fas fa-search"></i></button>
													</div><!-- .form-group end -->
												</form><!-- .form-banner-reservation end -->
											</li>
										</ul><!-- .br-tabs-content end -->
									</div><!-- .banner-reservation-tabs end -->
								</div><!-- .banner-center-box end -->
							</div><!-- .col-md-12 end -->
						</div><!-- .row end -->
					</div><!-- .container end -->
				</div><!-- .slide-content end -->
		</section><!-- #banner end -->

		<!-- Footer
		============================================= -->
		<footer id="footer">
			<div id="footer-bar-2" class="footer-bar text-white">

				<div class="footer-bar-wrap">

					<div class="container">
						<div class="row">
							<div class="col-md-12">

								<div class="fb-row">
									<div class="copyrights-message">
										<span>All right reserved to the crew of "Can't finish experiment" ©2020</span>
									</div><!-- .copyrights-message end -->

								</div><!-- .fb-row end -->

							</div><!-- .col-md-12 end -->
						</div><!-- .row end -->
					</div><!-- .container end -->

				</div><!-- .footer-bar-wrap -->

			</div><!-- #footer-bar-2 end -->
		</footer><!-- #footer end -->

	</div><!-- #full-container end -->

	<!-- External JavaScripts
	============================================= -->
	<script src="js/jquery.js"></script>
	<script src="js/jRespond.min.js"></script>
	<script src="js/jquery.fitvids.js"></script>
	<script src="js/superfish.js"></script>
	<script src="scss/slick/slick.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/scrollIt.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/countrySelect.min.js"></script>
	<script src='js/functions.js'></script>

</body>
</html>
