/**
 * Created by LiuQi on 2017/9/10.
 */
function formRender() {
    layui.use('form', function() {
        var form = layui.form;
        form.render();
    })
}
formRender();

$(document).ready(function() {
    $.ajax({
        url : "/schoolyear/list.do",
        type : "POST",
        success: function(data) {
            var list = data.list;
            var schoolyear_query = document.getElementById("schoolyear_query");
            for(var i = 0; i < list.length; i++) {
                schoolyear_query.options.add(new Option(list[i].name, list[i].name));
            }
            selectConfirm();
            formRender();
        }
    })
});

function selectConfirm() {
    var schoolyear_str = $("#schoolyear_str").val();
    if(schoolyear_str != null && schoolyear_str != '' && schoolyear_str != undefined) {
        var schoolyear_query = document.getElementById("schoolyear_query");
        for(var i=0; i<schoolyear_query.options.length; i++){
            if(schoolyear_query.options[i].text == schoolyear_str){
                schoolyear_query.options[i].selected = true;
                break;
            }
        }
    }
}

var myChart = echarts.init(document.getElementById("piePicture"));
var schoolTable = document.getElementById("schoolStat");
var option = {
    series: [{
        type: 'pie',
        name: '',
        radius: "50%",
        center: ['50%', '35%'],
        data: [
            {name: '优秀\n' + $.trim(schoolTable.rows[3].cells[1].innerHTML), value: parseFloat($("#excellentPerCent").val())},
            {name: '良好\n' + $.trim(schoolTable.rows[3].cells[2].innerHTML), value: parseFloat($("#goodPerCent").val())},
            {name: '中等\n' + $.trim(schoolTable.rows[3].cells[3].innerHTML), value: parseFloat($("#mediumPerCent").val())},
            {name: '合格\n' + $.trim(schoolTable.rows[3].cells[4].innerHTML), value: parseFloat($("#qualifiedPerCent").val())},
        ]
    }]
};
myChart.setOption(option);
/*var option = {
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            data:[
                {value:235, name:'视频广告'},
                {value:274, name:'联盟广告'},
                {value:310, name:'邮件营销'},
                {value:335, name:'直接访问'},
                {value:40, name:'搜索引擎'}
            ]
        }
    ]
}
myChart.setOption(option)*/
