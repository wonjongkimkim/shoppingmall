<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
  <jsp:include page="header.jsp" flush="false" />

            <jsp:include page="side.jsp" flush="false" />

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">회원 가입</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                       
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                <!-- action은 데이터가 전송될 목적지를 가르킴-->
                                    <form role="form" action =" doAdd" method = "post">
 									<div class="form-group">
                                            <label>아이디</label>
                                            <input name = "id" class="form-control" placeholder="아이디 입력">
                                        </div>
                                         <div class="form-group">
                                            <label>비밀번호</label>
                                            <input name = "password" class="form-control" type = "password" placeholder="비밀번호 입력">
                                        </div>
                                         <div class="form-group">
                                            <label>이름</label>
                                            <input name = "username" class="form-control" placeholder="이름 입력">
                                        </div>
                                         <div class="form-group">
                                            <label>핸드폰 번호</label>
                                            <input name = "phone" class="form-control" placeholder="번호 입력">
                                        </div>
                                         <div class="form-group">
                                            <label>주소</label>
                                            <input name = "address" class="form-control" placeholder="주소 입력">
                                        </div>
                                         <div class="form-group">
                                            <label>이메일</label>
                                            <input name = "email" class="form-control" placeholder="이메일 입력">
                                        </div>
                                         <button type="submit" class="btn btn-default">회원 가입</button>
                                        <a href="list" class="btn btn-default">목록</a>
                                        </div>
                                       
                                    </form>
                                </div>
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
