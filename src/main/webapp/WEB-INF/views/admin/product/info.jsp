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
                    	<a href = "/admin/product/list"> 
                    	<button type="button" class="btn btn-primary">상품 목록</button></a>
                  
                    	
                    	<a href="/admin/product/delete?id=${productVO.id}">
                    	<button type="button" class="btn btn-primary">상품 삭제</button></a>
                    	
                    	<a href="/admin/wishlist/add?id=${sessionId}&productId=${productVO.id}">
                    	<button type="button" class="btn btn-primary">카트에 담기</button></a>
                    </h1>
                </div> 
                
                
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
            
             <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	상품 번호
                        </div>
                        <div class="panel-body">   
                       ${productVO.id}
                        </div>
                     
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	상품 이름
                        </div>
                        <div class="panel-body">   
                       ${productVO.name}
                        </div>
                     
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            	가격
                        </div>
                        <div class="panel-body">
                            <p> ${productVO.price}</p>
                        </div>
                    
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                
                <!-- /.col-lg-4 -->
                
                  <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	남은 수량
                        </div>
                        <div class="panel-body">
                         ${productVO.amount}
                        </div>
                   
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                
                  <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	상품 카테고리
                        </div>
                        <div class="panel-body">
                         ${productVO.category}
                        </div>
                   
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	브랜드
                        </div>
                        <div class="panel-body">
                         ${productVO.brandName}
                        </div>
                   
                    </div>
                    
                </div>
                 <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                           	이미지
                        </div>
                        <div class="panel-body">
                         <img width = 100 src= "/img/${productVO.image}"  >

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
