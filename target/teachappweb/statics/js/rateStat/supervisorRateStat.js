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
        console.log(schoolyear_query.options.length);
        for(var i=0; i<schoolyear_query.options.length; i++){
            if(schoolyear_query.options[i].text == schoolyear_str){
                schoolyear_query.options[i].selected = true;
                break;
            }
        }
    }
}

