<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="frg">
    <div class="jyuiq" id="menudiv">
         <ul>
         <li class="active">
              	<a id="menu0" class="adbj0 ad">首页</a>
                <ul class="sub-menu">
                <li style="display:none;"><a href="#" id="sub51" style="color: rgb(255, 255, 255); background: rgb(78, 152, 229) none repeat scroll 0% 0%;">&nbsp;</a></li>
                </ul>
         </li>
              <li class="active">
              	<a id="menu1" href="#" class="adbj1 ad"  data-spm-anchor-id="0.0.0.0">评分统计</a>
                <ul id="divmenu1" class="sub-menu">
                  <li><a id="sub1" href="/rateStat/extremeStat.do">各系评价统计</a></li>
                  <li><a id="sub2" href="/rateStat/supervisorRateStat.do">督导评价统计</a></li>
                  <li><a id="sub3" href="/rateStat/schoolRateStat.do">学院评价统计</a></li>
                  <li><a id="sub4" href="/rateStat/xiRateStat.do">各系评价统计</a></li>
                  <li><a id="sub5" href="/rateStat/excellentStat.do">各系优秀评价统计</a></li>
                  <li><a id="sub6" href="/rateStat/goodStat.do">各系良好评价统计</a></li>
                  <li><a id="sub7" href="/rateStat/mediumStat.do">各系中等评价统计</a></li>
                  <li><a id="sub8" href="/rateStat/qualifiedStat.do">各系合格评价统计</a></li>
                  <%--<li><a id="sub3" href="#">采集手册</a></li>--%>
                </ul>
              </li>
         </ul>
	</div>
</div>