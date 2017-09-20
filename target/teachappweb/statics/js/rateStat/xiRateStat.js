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
var totalNumber1 = parseInt($("#totalExcellentNumber").val()) + parseInt($("#totalGoodNumber").val()) + parseInt($("#totalMedium").val()) + parseInt($("#totalQualifiedNumber").val())
var excellectPerCent1;
var goodPerCent1;
var mediumPerCent1;
var qualifiedPerCent1;
if(totalNumber1 == 0) {
    excellectPerCent1 = 0;
    goodPerCent1 = 0;
    mediumPerCent1 = 0;
    qualifiedPerCent1 = 0;
}else {
    excellectPerCent1 = (parseInt($("#totalExcellentNumber").val()) / totalNumber1).toFixed(4) * 100;
    goodPerCent1 = (parseInt($("#totalGoodNumber").val()) / totalNumber1).toFixed(4) * 100;
    mediumPerCent1 = (parseInt($("#totalMedium").val()) / totalNumber1).toFixed(4) * 100;
    qualifiedPerCent1 = (parseInt($("#totalQualifiedNumber").val()) / totalNumber1).toFixed(4) * 100;
}
//下半年
var totalNumber2 = parseInt($("#totalExcellentNumber2").val()) + parseInt($("#totalGoodNumber2").val()) + parseInt($("#totalMedium2").val()) + parseInt($("#totalQualifiedNumber2").val())
var excellectPerCent2;
var goodPerCent2;
var mediumPerCent2;
var qualifiedPerCent2;
if(totalNumber2 == 0) {
    excellectPerCent2 = 0;
    goodPerCent2 = 0;
    mediumPerCent2 = 0;
    qualifiedPerCent2 = 0;
}else {
    excellectPerCent2 = (parseInt($("#totalExcellentNumber2").val()) / totalNumber2).toFixed(4) * 100;
    goodPerCent2 = (parseInt($("#totalGoodNumber2").val()) / totalNumber2).toFixed(4) * 100;
    mediumPerCent2 = (parseInt($("#totalMedium2").val()) / totalNumber2).toFixed(4) * 100;
    qualifiedPerCent2 = (parseInt($("#totalQualifiedNumber2").val()) / totalNumber2).toFixed(4) * 100;
}
var option = {
    title: [
        {
            text: $("#firstSemester").val() + "学期督导听课评价占比",
            x: '25%',
            textAlign: 'center',
            textStyle: {
                fontSize: 14,
                fontWeight: 'lighter'
            }
        },
        {
            text: $("#secondSemester").val() + "学期督导听课评价占比",
            x: '75%',
            textAlign: 'center',
            textStyle: {
                fontSize: 14,
                fontWeight: 'lighter'
            }
        }
    ],
    series: [{
        type: 'pie',
        name: '',
        radius: "50%",
        center: ['25%', '45%'],
        data: [
            {name: '优秀\n' + excellectPerCent1 + "%", value: parseInt($("#totalExcellentNumber").val())},
            {name: '良好\n' + goodPerCent1 + "%", value: parseInt($("#totalGoodNumber").val())},
            {name: '中等\n' + mediumPerCent1 + "%", value: parseInt($("#totalMedium").val())},
            {name: '合格\n' + qualifiedPerCent1 + "%", value: parseInt($("#totalQualifiedNumber").val())},
        ]
    }, {
        type: 'pie',
        name: '',
        radius: "50%",
        center: ['75%', '45%'],
        data: [
            {name: '优秀\n' + excellectPerCent2 + "%", value: parseFloat($("#totalExcellentNumber2").val())},
            {name: '良好\n' + goodPerCent2 + "%", value: parseFloat($("#totalGoodNumber2").val())},
            {name: '中等\n' + mediumPerCent2 + "%", value: parseFloat($("#totalMedium2").val())},
            {name: '合格\n' + qualifiedPerCent2 + "%", value: parseFloat($("#totalQualifiedNumber2").val())},
        ]
    }]
};

myChart.setOption(option);
