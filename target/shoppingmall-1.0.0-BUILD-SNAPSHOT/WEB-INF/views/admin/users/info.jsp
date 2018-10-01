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
                    <h1 class="page-header">
                    	<a href = "/admin/users/list"> 
                    	<button type="button" class="btn btn-primary">목록</button></a>
                  
                    	<a href="/admin/users/update?id=${userVO.id}">
                    	<button type="button" class="btn btn-primary">회원 수정</button></a>
                    	
                    	<a href="/admin/users/delete?id=${userVO.id}">
                    	<button type="button" class="btn btn-primary">회원 삭제</button></a>
                    	
                    	<a href="/admin/wishlist/list?id=${userVO.id}">
                    	<button type="button" class="btn btn-primary">카트</button></a>
                    </h1>
                </div>
                
                
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            
             <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	아이디
                        </div>
                        <div class="panel-body">   
                       ${userVO.id}
                        </div>
                     
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	주소
                        </div>
                        <div class="panel-body">   
                       ${userVO.address}
                        </div>
                     
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            	번호
                        </div>
                        <div class="panel-body">
                            <p> ${userVO.phone}</p>
                        </div>
                    
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                
                <!-- /.col-lg-4 -->
                
                  <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	이메일
                        </div>
                        <div class="panel-body">
                         ${userVO.email}
                        </div>
                   
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                
                  <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	회원가입일
                        </div>
                        <div class="panel-body">
                         ${userVO.date}
                        </div>
                   
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	이름
                        </div>
                        <div class="panel-body">
                         ${userVO.username}
                        </div>
                   
                    </div>
                </div>
                <!-- /.col-lg-4 -->
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
