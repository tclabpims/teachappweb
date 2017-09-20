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
        <input id="strSubMenuId" type="hidden" value="7"/>
        <%--查询 start--%>
        <div>
            <br/>
            <form class="layui-form" action="${pageContext.request.contextPath}/rateStat/mediumStat.do" METHOD="post">
                &nbsp;&nbsp;&nbsp;
                <div class="layui-inline">
                    <label class="">年份</label>&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline">
                        <input class="layui-input" id="year_str" value="${year}" name="year" />
                    </div>
                    <label class="">学期</label>&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline">
                        <select name="halfYear">
                            <option value=""></option>
                            <option value="1" <c:if test="${semesterFlag == 1}">selected</c:if>>上半年学期</option>
                            <option value="2" <c:if test="${semesterFlag == 2}">selected</c:if>>下半年学期</option>
                        </select>
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;<input type="submit" class="layui-btn layui-btn-radius layui-btn-small" value="查询">
            </form>
        </div>
        <%--查询 end--%>
        <br/>
        <%--<p align="center">2015-2016-2学期（或者学年）各系听课评价最值统计</p>--%>
        <h3 align="center">
            <c:choose><c:when test="${semester == null}">${year}</c:when><c:otherwise>${semester}</c:otherwise></c:choose>年度（或学期）各系督导评价中等占比表
        </h3>
        <%--<hr/>--%>
        <table class="sui-table table-bordered" style="margin-top:20px;" id="schoolStat">
            <c:if test="${fn:length(list)==0}">
                <tr ><td colspan="6" class="center left-con" >亲，暂时没有活动哦！</td></tr>
            </c:if>
            <script>
                var data = Array();
                var i = 0;
            </script>
            <thead>
                <tr>
                    <th class="center left-con" width="15%" style="vertical-align: middle" rowspan="2">分类</th>
                    <th class="center left-con" width="70%" style="vertical-align: middle" colspan="${fn:length(list)}">70-79分以上 (中等,人数)</th>
                    <th class="center left-con" width="15%" style="vertical-align: middle" rowspan="2">合计</th>
                </tr>
                <tr>
                    <c:forEach var="item" items="${list}">
                        <th class="center left-con" width="${70 / fn:length(list)}%" style="vertical-align: middle">${item.xiName}</th>
                        <script>
                            var o = {};
                            o.name = "${item.xiName}" + "\n" + "${(item.mediumPerCent * 100)}" + '%';
                            o.value = parseInt("${item.medium}");
                            data[i++] = o;
                        </script>
                    </c:forEach>
                </tr>
            </thead>
            <tbody id="all_task0">
            <tr>
                <td class="center left-con">各系所占人数</td>
                <c:set var="totalMediumNumber" value="${0}"></c:set>
                <c:forEach var="item" items="${list}">
                    <c:set var="totalMediumNumber" value="${totalMediumNumber + item.medium}"></c:set>
                    <td class="center left-con">${item.medium}</td>
                </c:forEach>
                <td class="center left-con">${totalMediumNumber}</td>
            </tr>
            <tr>
                <td class="center left-con">各系所占比</td>
                <c:set var="totalPerCent" value="${0}"></c:set>
                <c:forEach var="item" items="${list}">
                    <c:set var="totalPerCent" value="${totalPerCent + item.mediumPerCent}"></c:set>
                    <td class="center left-con"><fmt:formatNumber type="number" value="${item.mediumPerCent * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%</td>
                </c:forEach>
                <td class="center left-con"><fmt:formatNumber type="number" pattern="#0.00" maxFractionDigits="2" value="${totalPerCent * 100}"></fmt:formatNumber>%</td>
            </tr>
            </tbody>
        </table>
        <br>
        <div id="piePicture1" style="width: 1000px; height: 350px;"></div>
    </div>
   <%--饼图--%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rateStat/mediumStat.js"></script>
</body>
</html>
