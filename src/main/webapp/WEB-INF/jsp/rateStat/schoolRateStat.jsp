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
        <input id="strSubMenuId" type="hidden" value="3"/>
        <%--查询 start--%>
        <div>
            <br/>
            <form class="layui-form" action="${pageContext.request.contextPath}/rateStat/schoolRateStat.do" METHOD="post">
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
        <h3 align="center">${schoolyear}<c:if test="${semester != null and semester != ''}">-${semester}</c:if>学期（或者学年）学院督导听课评价统计</h3>
        <%--<hr/>--%>
        <table class="sui-table table-bordered" style="margin-top:20px;" id="schoolStat">
            <thead>
            <tr>
                <th class="center left-con" rowspan="2" width="20%">分类</th>
                <th class="center left-con" colspan="4" width="60%">等级评价</th>
                <th class="center left-con" rowspan="2" width="20%">合计</th>
            </tr>
            <tr>
                <th class="center left-con" width="15%">优秀</th>
                <th class="center left-con" width="15%">良好</th>
                <th class="center left-con" width="15%">中等</th>
                <th class="center left-con" width="15%">合格</th>
            </tr>
            </thead>
            <tbody id="all_task0">
            <tr>
                <td class="center left-con">被评价人数</td>
                <td class="center left-con">${schoolRateStatModel.excellentNumber}</td>
                <td class="center left-con">${schoolRateStatModel.goodNumber}</td>
                <td class="center left-con">${schoolRateStatModel.medium}</td>
                <td class="center left-con">${schoolRateStatModel.qualifiedNumber}</td>
                <td class="center left-con">
                    ${schoolRateStatModel.excellentNumber + schoolRateStatModel.goodNumber +
                    schoolRateStatModel.medium + schoolRateStatModel.qualifiedNumber}
                </td>
            </tr>
            <tr>
                <td class="center left-con">占比</td>
                    <input type="hidden" id="excellentPerCent" value="${schoolRateStatModel.excellentPerCent}">
                <td class="center left-con">
                    <fmt:formatNumber type="number" value="${schoolRateStatModel.excellentPerCent * 100}" pattern="#0.00" maxFractionDigits="2" />%
                </td>
                    <input type="hidden" id="goodPerCent" value="${schoolRateStatModel.goodPerCent}">
                <td class="center left-con">
                    <fmt:formatNumber type="number" value="${schoolRateStatModel.goodPerCent * 100}" pattern="#0.00" maxFractionDigits="2" />%
                </td>
                    <input type="hidden" id="mediumPerCent" value="${schoolRateStatModel.mediumPerCent}">
                <td class="center left-con">
                    <fmt:formatNumber type="number" value="${schoolRateStatModel.mediumPerCent * 100}" pattern="#0.00" maxFractionDigits="2" />%
                </td>
                    <input type="hidden" id="qualifiedPerCent" value="${schoolRateStatModel.qualifiedPerCent}">
                <td class="center left-con">
                    <fmt:formatNumber type="number" value="${schoolRateStatModel.qualifiedPerCent * 100}" pattern="#0.00" maxFractionDigits="2" />%
                </td>
                <td class="center left-con">
                    <fmt:formatNumber type="number" value="${(schoolRateStatModel.excellentPerCent + schoolRateStatModel.goodPerCent + schoolRateStatModel.mediumPerCent + schoolRateStatModel.qualifiedPerCent ) * 100}" maxFractionDigits="2" />%
                </td>
            </tr>
            </tbody>
    </table>
   <div id="piePicture" style="width: 1000px;height:350px;"></div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rateStat/schoolRateStat.js"></script>
</body>
</html>
