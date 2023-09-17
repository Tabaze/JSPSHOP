<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
  <c:when test="${empty param.direct}">
    <c:redirect url="/JSPSHOP/login"></c:redirect>
  </c:when>
  <c:when test="${param.direct eq 'dashboard'}">
    <c:redirect url="/JSPSHOP/dashboard" />
  </c:when>
  <c:when test="${param.direct eq 'produitCard'}">
    <c:redirect url="/JSPSHOP/productCard" />
  </c:when>
  <c:when test="${param.direct eq 'produitList'}">
    <c:redirect url="/JSPSHOP/produitList" />
  </c:when>
  <c:when test="${param.direct eq 'AddProduct'}">
    <c:redirect url="/JSPSHOP/AddProduct" />
  </c:when>
  <c:when test="${param.direct eq 'cateList'}">
    <c:redirect url="/JSPSHOP/cateList" />
  </c:when>
  <c:otherwise>
    <c:redirect url="/JSPSHOP/pages/error.html" />
  </c:otherwise>
</c:choose>
