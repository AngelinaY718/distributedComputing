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
                                        <li><a class="popup-btn-login" href="javascript:;">Login</a></li>
                                    </ul><!-- .list-info end -->
                                </div><!-- .position-right end -->
                            </div><!-- .hb-content end -->

                        </div><!-- .col-md-12 end -->
                    </div><!-- .row end -->
                </div><!-- .container end -->

            </div><!-- .header-bar-wrap -->

        </div><!-- #header-bar-1 end -->
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
                            <h1>欢迎使用Tickets航班订票网站！</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- .banner-parallax end -->

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
<a class="scroll-top-icon scroll-top" href="javascript:;"><i class="fa fa-angle-up"></i></a>

<div class="popup-preview popup-preview-2 popup-preview-login">
    <div class="popup-bg"></div>

    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="popup-content">
                    <div class="block-content">
                        <div class="content">
                            <div class="left">
                                <form id="form-login" class="rounded" action="homepage.html">
                                    <div class="form-content">
                                        <div class="form-group">
                                            <%--@declare id="loginusername"--%><label for="loginUserName">Username</label>
                                            <input type="text" name="UserName" id="loginUserEmail" class="form-control"
                                                   placeholder="">
                                        </div><!-- .form-group end -->
                                        <div class="form-group">
                                            <label for="loginPassword">Password</label>
                                            <input type="password" name="Password" id="loginPassword"
                                                   class="form-control" placeholder="">
                                        </div><!-- .form-group end -->
                                        <div class="form-group">
                                            <input type="submit" class="form-control rounded" value="Login">
                                        </div><!-- .form-group end -->
                                    </div><!-- .form-content end -->
                                </form><!-- #form-login end -->
                            </div><!-- .left end -->
                            <div class="right">
                                <img src="images/files/logo-header.PNG" />
                                <br>
                                <h3><b>欢迎使用Tickets航班订票网站！</b></h3>
                            </div>
                        </div><!-- .content end -->
                    </div><!-- .block-content end -->
                </div><!-- .popup-content end -->

            </div><!-- .col-md-8 end -->
        </div><!-- .row end -->
    </div><!-- .container end -->
</div><!-- .popup-preview -->

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