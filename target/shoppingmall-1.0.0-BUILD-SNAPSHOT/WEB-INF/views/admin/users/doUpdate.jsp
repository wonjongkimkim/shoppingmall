<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
${user.id}
<a href = "/admin/users/list"> 
                    	<button type="button" class="btn btn-primary">목록</button></a>
                    	
<script type = "text/javascript">
location.href = "/admin/users/info?id=${userVO.id }"
</script>