<!DOCTYPE HTML>
<html>
<head>
    <title>Servers' Information</title>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, user-scalable=no"/>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-style: normal;
            font-family: 굴림, Gulim, 돋움, Dotum, AppleGothic, Sans-serif;
        }

        img, fieldset {
            border: none;
        }

        hr, legend {
            display：none;
        }

        li {
            list-style: none;
        }

        a {
        }

        a:visited {
        }

        a:hover, a:active, a:focus {
        }

        html:first-child select {
            padding-right: 6px;
            height: 20px;
        }

        /* Opera Fix */
        option, x:-moz-any-link {
            padding-right: 4px;
        }

        /* Firefox Fix */
        option, x:-moz-any-link, x:default {
            padding-right: 0;
        }

        /* Firefox Fix */


        /* Layout Selector */
        html, body {
            height: 100%;
        }

        #wrap {
            height: 100%;
            width: auto;
        }

        #header {
            background-image: url('');
            background-size: cover;
            width: 80px;
            height: 200px;
            z-index: -1;
            width: auto;
        }

        #container {
            min-height: 100%;
            margin: -100px 0 -50px;
            width: auto;
        }

        /* IE Hack */
        * html #container {
            height: 100%;
        }

        #footer {
            background-image: url('');
            background-size: cover;
            width:80px;
            height:70px;
            z-index: -1;
        }

        .contents-box {
            padding: 100px 0 50px 0;
            align-items: center;
        }

        .snb {
            border: 1px solid black;
            float: left;
            padding: 10px;
            margin: 10px;
            width: 240px;
            height: 500px;
        }

        .contents {
            margin-left: 200px;
            background: #00ffee;
            height: 500px;
        }

        .clear {
            clear: both;
            display: block;
            float: none;
            font-size: 0 !important;
            height: 0;
            line-height: 0 !important;
            margin: 0 !important;
            overflow: hidden;
            padding: 0 !important;
            width: 100%;
        }
    </style>
</head>
<body>
<div id="wrap">

    <!-- Head Start-->
    <div id="header">header</div>
    <!-- Head End-->

    <!-- Body Start-->
    <div id="container">
        <div class="contents-box">
            <div style="float: left; width: 20%; height: 100%; padding:5px;">
                <div class="snb">Simulator</div>
            </div>
            <div style="border: 1px solid gold; float: left; width: 57%; height: 100%; padding:5px;">
                <div class="snb">Rest Server</div>
                <div class="snb">Kafka</div>
                <div class="snb">Service Server</div>
            </div>
            <div style="float: left; width: 20%; height: 100%; padding:5px;">
            <div class="snb">Database</div>
            </div>
        </div>
    </div>
    <!-- Body End-->


    <!-- Footer Start-->
    <div id="footer">Footer</div>
    <!-- Footer End-->
</div>
</body>


<%--<body class="is-preload">--%>
<%--<div>--%>
<%--    <div class="main">--%>
<%--        <div class="main_1 main_common">test1</div>--%>
<%--        <div class="main_2 main_common">test2</div>--%>
<%--        <div class="main_3 main_common">test3</div>--%>
<%--    </div>--%>
<%--    <!-- Wrapper -->--%>
<%--    <div>--%>

<%--        <!-- Banner -->--%>
<%--        <div style="border: 1px solid black; float: left; width: 17%; height: 100%; padding:10px;">--%>
<%--            첫번째 영역--%>
<%--        </div>--%>
<%--        <div style="border: 1px solid gold; float: left; width: 60%; height: 100%; padding:10px;">--%>
<%--            <div style="border: 1px solid gold; float: right; width: 30%; padding:10px;">--%>
<%--                1번째 영역--%>
<%--            </div>--%>
<%--            <div style="border: 1px solid gold; float: right; width: 30%; padding:10px;">--%>
<%--                2번째 영역--%>
<%--            </div>--%>
<%--            <div style="border: 1px solid gold; float: right; width: 30%; padding:10px;">--%>
<%--                3번째 영역--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div style="border: 1px solid black; float: right; width: 17%; padding:10px;">--%>
<%--            3번째 영역--%>
<%--        </div>--%>

<%--    </div>--%>

<%--</div>--%>

<%--</body>--%>
</html>