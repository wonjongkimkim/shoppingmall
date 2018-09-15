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
                    <h1 class="page-header">상품 추가</h1>
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
                                    <form role="form" action="doAdd" method="post" enctype="multipart/form-data">
 									<div class="form-group">
                                            <label>상품 이름</label>
                                            <input name = "name" class="form-control" placeholder="상품 이름">
                                        </div>
                                         
                                         <div class="form-group">
                                            <label>가격</label>
                                            <input name = "price" class="form-control" placeholder="가격">
                                        </div>
                                         <div class="form-group">
                                            <label>수량</label>
                                            <input name = "amount" class="form-control" placeholder="수량">
                                        </div>
                                         <div class="form-group">
                                            <label>카테고리</label>
                                            <input name = "category" class="form-control" placeholder="카테고리">
                                        </div>
                                       
                                         <div class="form-group">
                                            <label>브랜드</label>
                                            <select class = "form-control" name = "brandName">
                                             <c:forEach items = "${brandList} " var = "brandVO">
                                             <option value = "${brandVO.name }"></option>
                                             </c:forEach>
                                             </select>
                                        </div>
                                       
                                           <div class="form-group">
                                            <label>사이즈</label>
                                            <input name = "size" class="form-control" placeholder="사이즈">
                                        </div>
                                        
                                           <div class="form-group">
                                            <label>색상</label>
                                            <input name = "color" class="form-control" placeholder="색상">
                                        </div>
                                        
                                        
                                        
                                        
                                        <div class="form-group">
                                            <label>상품 이미지</label>
                                            <input name="file" type="file">
                                        </div>
                                         <button type="submit" class="btn btn-default">상품 추가</button>
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
