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
        <input id="strSubMenuId" type="hidden" value="4"/>
        <%--查询 start--%>
        <div>
            <br/>
            <form class="layui-form" action="${pageContext.request.contextPath}/rateStat/xiRateStat.do" METHOD="post">
                &nbsp;&nbsp;&nbsp;
                <div class="layui-inline">
                    <label class="">年份</label>&nbsp;&nbsp;&nbsp;
                    <div class="layui-input-inline">
                        <input class="layui-input" id="year_str" value="${year}" name="year" />
                    </div>
                </div>
                &nbsp;&nbsp;&nbsp;<input type="submit" class="layui-btn layui-btn-radius layui-btn-small" value="查询">
            </form>
        </div>
        <%--查询 end--%>
        <br/>
        <%--<p align="center">2015-2016-2学期（或者学年）各系听课评价最值统计</p>--%>
        <h3 align="center">${year}年各系部学期督导听课评价统计</h3>
        <%--<hr/>--%>
        <table class="sui-table table-bordered" style="margin-top:20px;" id="schoolStat">
            <thead>
                <tr>
                    <th class="center left-con" width="15%" style="vertical-align: middle">学期</th>
                    <th class="center left-con" width="15%" style="vertical-align: middle">系别</th>
                    <th class="center left-con" width="14%">90分以上<br>(优秀,人数)</th>
                    <th class="center left-con" width="14%">80-89分<br>(良好，人数)</th>
                    <th class="center left-con" width="14%">70-79分<br>(中等，人数)</th>
                    <th class="center left-con" width="14%">60-69分<br>(合格，人数)</th>
                    <th class="center left-con" width="14%" style="vertical-align: middle">总评价人数</th>
                </tr>
            </thead>
            <tbody id="all_task0">
            <c:if test="${fn:length(firstSemesterList)==0}">
                <tr ><td colspan="6" class="center left-con" >亲，暂时没有活动哦！</td></tr>
            </c:if>
            <%--上半年--%>
                <c:set var="totalExcellentNumber" value="${0}"></c:set>
                <c:set var="totalGoodNumber" value="${0}"></c:set>
                <c:set var="totalMedium" value="${0}"></c:set>
                <c:set var="totalQualifiedNumber" value="${0}"></c:set>
                <c:forEach items="${firstSemesterList}" var="item" varStatus="count">
                <input type="hidden" id="firstSemester" value="${firstSemester}" >
                <input type="hidden" id="secondSemester" value="${secondSemester}" >
                <tr>
                    <c:if test="${count.count == 1}"><td class="center left-con" rowspan="${fn:length(firstSemesterList) + 2}">${firstSemester}学期</td></c:if>
                    <td class="center left-con">${item.xiName}</td>
                    <c:set var="totalExcellentNumber" value="${totalExcellentNumber + item.excellentNumber}"></c:set>
                    <td class="center left-con">${item.excellentNumber}</td>
                    <c:set var="totalGoodNumber" value="${totalGoodNumber + item.goodNumber}"></c:set>
                    <td class="center left-con">${item.goodNumber}</td>
                    <c:set var="totalMedium" value="${totalMedium + item.medium}"></c:set>
                    <td class="center left-con">${item.medium}</td>
                    <c:set var="totalQualifiedNumber" value="${totalQualifiedNumber + item.qualifiedNumber}"></c:set>
                    <td class="center left-con">${item.qualifiedNumber}</td>
                    <td class="center left-con">
                        ${item.excellentNumber + item.goodNumber +
                        item.medium + item.qualifiedNumber}
                    </td>
                </tr>
                </c:forEach>
                <tr>
                    <td class="center left-con">小计</td>
                    <td class="center left-con">${totalExcellentNumber}</td>
                    <td class="center left-con">${totalGoodNumber}</td>
                    <td class="center left-con">${totalMedium}</td>
                    <td class="center left-con">${totalQualifiedNumber}</td>
                    <td class="center left-con">
                        ${totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber}
                    </td>
                </tr>
                <tr>
                    <input type="hidden" value="${totalExcellentNumber}" id="totalExcellentNumber">
                    <input type="hidden" value="${totalGoodNumber}" id="totalGoodNumber">
                    <input type="hidden" value="${totalMedium}" id="totalMedium">
                    <input type="hidden" value="${totalQualifiedNumber}" id="totalQualifiedNumber">
                    <c:if test="${(totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber) != 0}">
                    <td class="center left-con">小计占比</td>
                    <td class="center left-con">
                        <fmt:formatNumber type="number" value="${(totalExcellentNumber / (totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                    </td>
                    <td class="center left-con">
                        <fmt:formatNumber type="number" value="${(totalGoodNumber / (totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                    </td>
                    <td class="center left-con">
                        <fmt:formatNumber type="number" value="${(totalMedium / (totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                    </td>
                    <td class="center left-con">
                        <fmt:formatNumber type="number" value="${(totalQualifiedNumber / (totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                    </td>
                    <td class="center left-con">
                        100%
                    </td>
                    </c:if>
                    <c:if test="${(totalExcellentNumber + totalGoodNumber + totalMedium + totalQualifiedNumber) == 0}">
                        <td class="center left-con">小计占比</td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            100%
                        </td>
                    </c:if>
                </tr>
                <%--下半年--%>
                <c:set var="totalExcellentNumber2" value="${0}"></c:set>
                <c:set var="totalGoodNumber2" value="${0}"></c:set>
                <c:set var="totalMedium2" value="${0}"></c:set>
                <c:set var="totalQualifiedNumber2" value="${0}"></c:set>
                <c:forEach items="${secondSemesterList}" var="item" varStatus="count">
                    <tr>
                        <c:if test="${count.count == 1}"><td class="center left-con" rowspan="${fn:length(secondSemesterList) + 2}">${firstSemester}学期</td></c:if>
                        <td class="center left-con">${item.xiName}</td>
                        <c:set var="totalExcellentNumber2" value="${totalExcellentNumber2 + item.excellentNumber}"></c:set>
                        <td class="center left-con">${item.excellentNumber}</td>
                        <c:set var="totalGoodNumber2" value="${totalGoodNumber2 + item.goodNumber}"></c:set>
                        <td class="center left-con">${item.goodNumber}</td>
                        <c:set var="totalMedium2" value="${totalMedium2 + item.medium}"></c:set>
                        <td class="center left-con">${item.medium}</td>
                        <c:set var="totalQualifiedNumber2" value="${totalQualifiedNumber2 + item.qualifiedNumber}"></c:set>
                        <td class="center left-con">${item.qualifiedNumber}</td>
                        <td class="center left-con">
                                ${item.excellentNumber + item.goodNumber +
                                        item.medium + item.qualifiedNumber}
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td class="center left-con">小计</td>
                    <td class="center left-con">${totalExcellentNumber2}</td>
                    <td class="center left-con">${totalGoodNumber2}</td>
                    <td class="center left-con">${totalMedium2}</td>
                    <td class="center left-con">${totalQualifiedNumber2}</td>
                    <td class="center left-con">
                        ${totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2}
                    </td>
                </tr>
                <tr>
                    <input type="hidden" value="${totalExcellentNumber2}" id="totalExcellentNumber2">
                    <input type="hidden" value="${totalGoodNumber2}" id="totalGoodNumber2">
                    <input type="hidden" value="${totalMedium2}" id="totalMedium2">
                    <input type="hidden" value="${totalQualifiedNumber2}" id="totalQualifiedNumber2">
                    <c:if test="${(totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2) != 0}">
                        <td class="center left-con">小计占比</td>
                        <td class="center left-con">
                            <fmt:formatNumber type="number" value="${(totalExcellentNumber2 / (totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                        </td>
                        <td class="center left-con">
                            <fmt:formatNumber type="number" value="${(totalGoodNumber2 / (totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                        </td>
                        <td class="center left-con">
                            <fmt:formatNumber type="number" value="${(totalMedium2 / (totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                        </td>
                        <td class="center left-con">
                            <fmt:formatNumber type="number" value="${(totalQualifiedNumber2 / (totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2)) * 100}" pattern="#0.00" maxFractionDigits="2"></fmt:formatNumber>%
                        </td>
                        <td class="center left-con">
                            100%
                        </td>
                    </c:if>
                    <c:if test="${(totalExcellentNumber2 + totalGoodNumber2 + totalMedium2 + totalQualifiedNumber2) == 0}">
                        <td class="center left-con">小计占比</td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            0.00%
                        </td>
                        <td class="center left-con">
                            100%
                        </td>
                    </c:if>
                </tr>
                </tbody>
        </table>
        <br>
        <div id="piePicture1" style="width: 1000px; height: 350px;"></div>
        <div style="width: 1000px; height: 50px"></div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rateStat/xiRateStat.js"></script>
</body>
</html>
