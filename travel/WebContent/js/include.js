$(function () {
    $.get("header1.jsp",function (data) {
        $("#header").html(data);
    });
    $.get("footer.jsp",function (data) {
        $("#footer").html(data);
    });
});