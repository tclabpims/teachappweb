/**
 * Created by LiuQi on 2017/9/10.
 */
function formRender() {
    layui.use('form', function() {
        var form = layui.form;
        form.render();
    })
}


function yearSelect() {
    //年选择器
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#year_str',
            type: 'year'
        });
    });
}
yearSelect();
formRender();

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
var myChart = echarts.init(document.getElementById("piePicture1"));
console.log(data);
var option = {
    series: [{
        type: 'pie',
        name: '',
        radius: "45%",
        center: ['50%', '45%'],
        data: data
    }]
};

myChart.setOption(option);
