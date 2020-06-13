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

		<!-- Content
		============================================= -->
		<section id="content">

			<div id="content-wrap">

				<!-- === Section Flat =========== -->
				<div class="section-flat">

					<div class="section-content">

						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="page-single-content sidebar-left">
										<div class="row">
											<div class="content-main">
												<div class="block-content-2">
													<div class="block-title">
														<h3><span class="colored">01</span> USer Info</h3>
													</div><!-- .block-title end -->
													<form id="form-hotel-booking" action="payment.jsp">
														<div class="form-content">
															<div class="form-group">
																<div class="fields-row fields-2">
																	<div class="box-field">
																		<label for="hbName"> Name</label>
																		<input type="text" name="hbName" id="hbName" class="form-control" placeholder="">
																	</div><!-- .box-field end -->
																</div><!-- .fields-row end -->
															</div><!-- .form-group end -->
															<div class="form-group">
																<div class="fields-row fields-2">
																	<div class="box-field">
																		<label for="hbPhone">Phone</label>
																		<input type="text" name="hbPhone" id="hbPhone" class="form-control" placeholder="">
																	</div><!-- .box-field end -->
																</div><!-- .fields-row end -->
															</div><!-- .form-group end -->
															<div class="form-group">
																<input type="submit" class="form-control" value="Proceed to Next Step">
															</div><!-- .form-group end -->
														</div><!-- .form-content end -->
													</form><!-- #form-hotel-booking end -->
												</div><!-- .block-content-2 end -->
											</div><!-- .content-main end -->
										</div><!-- .row end -->
									</div><!-- .page-single-content end -->
								</div><!-- .col-md-12 end -->
							</div><!-- .row end -->
						</div><!-- .container end -->
					</div><!-- .section-content end -->
				</div><!-- .section-flat end -->
			</div><!-- #content-wrap -->
		</section><!-- #content end -->
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
