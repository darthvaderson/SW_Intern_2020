<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        html,
        body{

            width:100%;
            height:100%;
            padding:0px;
            margin:0px;
            font-family:opensans;

        }

        #container {
            width: 1700px;

        }
        #header {
            height: 80px;
            border: 1px solid #bcbcbc;

        }

        #wrapper{
            width: 1700px;
            height: 450px;
        }
        .content-1 {
            width: 200px;
            height: 390px;
            padding: 20px;
            margin-top : 60px;
            float: left;
        }

        .content-2 {
            width: 300px;
            height: 450px;
            padding: 20px;

            float: left;

        }
        #footer {
            clear: both;
            padding: 20px;
        }
        .distance01{

            width:36px;
            height: 450px;
            float:left;
            vertical-align:middle;
            text-align:center;
        }
        .distance02{
            width:40px;
            height: 450px;
            float:left;
            vertical-align:middle;
            text-align:center;
        }

        #abc{
            float:left;
            border: 3px solid #bcbcbc;
            border-radius: 20px;
            margin-left:0px;
            margin-right:0px;
        }
        #title {
            clear: both;
            padding: 20px;
        }

        .server_num{
            margin-top:0px;
            text-indent:10%;
        }
        .server_title{
            text-indent:10%;
            font-weight: bold;
        }

        .logo{
            display:block;
            max-width: 200px;
            max-height:80px;
            width:auto;
            height:auto;

        }
        .background01{
            height:160px;
            line-height:160px;
            background-image: url("<spring:url value='/resources/img/background00.jpg'/>");
            text-align : center;
            font-size: xx-large;
            color: white;
            text-decoration: underline;
            text-underline-position: under;
            font-weight: bold;
        }
        .img01{
            display:block;
            max-width: 120px;
            max-height:120px;
            width:auto;
            height:auto;
            margin: 0px auto;

        }

        .img02{
            display:block;
            max-width: 200px;
            max-height:200px;
            width:auto;
            height:auto;
            margin: 0px auto;
        }

        .pointer{
            margin-top:183px;
            vertical-align:middle;
            max-width:30px;

        }
        ul.info{
            list-style: none;
            padding-left: 30px;
            font-size : small;
        }

        .detail{
            margin-left: 30px;
            margin-top: 10px;

            font-size: middle;
            text-decoration: underline;
            text-underline-position: under;
        }

        @font-face{
            font-family:"opensans";
            src:url("../../resources/font/OpenSans-Light.ttf")format("truetype");
            font-style:normal;
            font-weight:normal;
        }



    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <img class="logo" src="../../resources/img/logo.png"/>
    </div>

    <div id="wrapper">

        <div class="background01">MLPE 데이터 수집 서버
        </div>

        <div id="title">
        </div>
        <div class="content-1">

            <img class="img01" src="../../resources/img/simulator.png"/>

            <div class="server_num">01</div>
            <div class="server_title">Simulator  </div>


        </div>

        <div class ="distance02">
            <img class="pointer" src="../../resources/img/pointer.png"/>
        </div>

        <div id="abc">
            <div class="content-2">
                <img class="img02" src="../../resources/img/http.png"/>

                <div class="server_num">02</div>
                <div class="server_title">Rest API Server</div>


                <div class="detail">서버 정보</div>
                <ul class="info">
                    <li>데이터 처리량 : <%= request.getAttribute("rest")%></li>
                </ul>


            </div>

            <div class ="distance01">
                <img class="pointer" src="../../resources/img/pointer.png"/>
            </div>

            <div class="content-2">
                <img class="img02" src="../../resources/img/kafka02.png"/>

                <div class="server_num">03</div>
                <div class="server_title">Kafka Server</div>


            </div>

            <div class ="distance01">
                <img class="pointer" src="../../resources/img/pointer.png"/>
            </div>

            <div class="content-2">
                <img class="img02" src="../../resources/img/service.png"/>

                <div class="server_num">04</div>
                <div class="server_title">Service Server</div>


                <div class="detail">서버 정보</div>

                <ul class="info">
                    <div class="info_1">
                        <li id="ip1">IP 주소 : <%= request.getAttribute("ip1")%></li>
                        <li id="cpu1">CPU 사용량 : <%= request.getAttribute("cpu1")%> %</li>
                        <li id="memory1">메모리 사용량 : <%= request.getAttribute("memory1")%> %</li>
                        <li id="number1">데이터 처리량 : <%= request.getAttribute("number1")%></li>
                    </div>
                </ul>

            </div>
        </div>
        <div class ="distance02">
            <img class="pointer" src="../../resources/img/pointer.png"/>
        </div>

        <div class="content-1">
            <img class="img01" src="../../resources/img/postgreSQL.png"/>
            <div class="server_num">05</div>
            <div class="server_title">Database</div>

        </div>

    </div>


    <div id="footer">
    </div>
</div>
</body>
</html>

