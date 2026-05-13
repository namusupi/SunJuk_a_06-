<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="sungjuck.*" %>

<%
    성적관리컨트롤러 controller =
        new 성적관리컨트롤러();

    controller.성적입력(
        "inha",
        "20250001",
        95,
        88,
        90
    );
%>