<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--<link href="${pageContext.request.contextPath}/statics/css/customStyle.css" rel="stylesheet">--%>
<title>app 后台</title>
    <%@include file="../../head.jsp"%>
    <%@include file="../../jquery.jsp"%>
    <%
        request.setAttribute("nav", "draw");
        request.setAttribute("tab", "set");
        String host = "";
        host = request.getHeader("Host");
        if (host.indexOf(':') > 0) {
            host = host.substring(0, host.indexOf(':'));
        }
    %>
</head>
<body style="background: #f6f1eb none repeat scroll 0 0;">
<%@include file="../top.jsp"%>
<div class="nr">
    <%@include file="../navigation.jsp"%>
    <div class="pagemain">
        <input id="strMenuId" type="hidden" value="1"/>
        <input id="strSubMenuId" type="hidden" value="2"/>
        <%--查询 start--%>
        <div>
            <br/>
            <form class="layui-form" action="${pageContext.request.contextPath}/rateStat/supervisorRateStat.do" METHOD="post">
                &nbsp;&nbsp;&nbsp;
                <div class="layui-inline">
                    <label class="">学年</label>&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline">
                        <input type="hidden" id="schoolyear_str" value="${schoolyear}" />
                        <select name="schoolyear" id="schoolyear_query">
                            <option value=""></option>
                        </select>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;
                <div class="layui-inline">
                    <label class="">学期</label>&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline">
                        <select name="semester">
                            <option value=""></option>
                            <option value="1" <c:if test="${semester == 1}">selected</c:if>>第一学期</option>
                            <option value="2" <c:if test="${semester == 2}">selected</c:if>>第二学期</option>
                        </select>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;<input type="submit" class="layui-btn layui-btn-radius layui-btn-small" value="查询">
            </form>
        </div>
        <%--查询 end--%>
        <br/>
        <%--<p align="center">2015-2016-2学期（或者学年）各系听课评价最值统计</p>--%>
        <h3 align="center">${schoolyear}<c:if test="${semester != null and semester != ''}">-${semester}</c:if>学期（或者学年）督导评价分最值统计</h3>
        <%--<hr/>--%>
        <table class="sui-table table-bordered" style="margin-top:20px;">
            <thead>
            <tr>
                <th class="center left-con" width="8%">编号</th>
                <th class="center left-con" width="18%">系别</th>
                <th class="center left-con" width="18%">督导</th>
                <th class="center left-con" width="14%">听课次数</th>
                <th class="center left-con" width="14%">评价最高分</th>
                <th class="center left-con" width="14%">评价最低分</th>
                <th class="center left-con" width="14%">评价平均分</th>
            </tr>
            </thead>
            <tbody id="all_task0">
            <c:if test="${fn:length(list)==0}">
                <tr ><td colspan="6" class="center left-con" >亲，暂时没有活动哦！</td></tr>
            </c:if>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td class="center left-con">${item.id}</td>
                    <td class="center left-con">${item.xiName_}</td>
                    <td class="center left-con">${item.name}</td>
                    <td class="center left-con">${item.rateTimes}</td>
                    <td class="center left-con">${item.maxRate}</td>
                    <td class="center left-con">${item.minRate}</td>
                    <td class="center left-con">
                        <fmt:formatNumber type="number" value="${item.avgRate}" pattern="#0.0" maxFractionDigits="1" />
                    </td>
                </tr>
            </c:forEach>
            </tbody>
    </table>
   </div>
</div>

<%--分页 start--%>
<%--<div align="center" class="page_num_style">
    第${pageNo}页&nbsp;&nbsp;
    <c:choose>
        <c:when test="${query_flag == true}">
            <c:choose>
                <c:when test="${pageNo > 1}">
                    <a href="${pageContext.request.contextPath}/doctorBillStat/query.do?pageNo=${pageNo - 1}&doctorName=${doctorName}&timeStart=${timeStart}&timeEnd=${timeEnd}">上一页</a>&nbsp;&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="#">上一页</a>&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${pageNo < totalPage}">
                    <a href="${pageContext.request.contextPath}/doctorBillStat/query.do?pageNo=${pageNo + 1}&doctorName=${doctorName}&timeStart=${timeStart}&timeEnd=${timeEnd}">下一页</a>&nbsp;&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="#">下一页</a>&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${pageNo > 1}">
                    <a href="${pageContext.request.contextPath}/doctorBillStat/list.do?pageNo=${pageNo - 1}">上一页</a>&nbsp;&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="#">上一页</a>&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${pageNo < totalPage}">
                    <a href="${pageContext.request.contextPath}/doctorBillStat/list.do?pageNo=${pageNo + 1}">下一页</a>&nbsp;&nbsp;
                </c:when>
                <c:otherwise>
                    <a href="#">下一页</a>&nbsp;&nbsp;
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>
    共${totalPage}页
</div>--%>
<%--分页 end--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rateStat/supervisorRateStat.js"></script>
</body>
</html>
