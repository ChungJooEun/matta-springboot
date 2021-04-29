// datePicker init method
var initDatePicker = function(){
    $("#visitedDate").datepicker({
        nextText: '다음 달',
        prevText: '이전 달',
        showButtonPanel: true,
        closeText: ' x ',
        dateFormat: "yy.mm.dd",
        dayNames: ['월요일','화요일','수요일','목요일','금요일','토요일','일요일'],
        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
        monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        maxDate: 0,
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
};

var setDate = function() {
    const str_visitedDate = $('#visitedDate').val().split('-');
    console.log(str_visitedDate);
    var date = new Date(str_visitedDate[0], parseInt(str_visitedDate[1]) - 1 , str_visitedDate[2], 0, 0, 0, 0);

    console.log(date);

    $("#visitedDate").datepicker("setDate", date);
}

var parseToLocalDate = function(){
    return $('#visitedDate').val().replace(/\./gi, "-");
};

var main = {
    init : function () {
        initDatePicker();
        setDate();

        var _this = this;
        $('#btn-update').on('click', function() {
            _this.update();
        });
    },
    update : function() {
        var requestData = {
            visitedDate: parseToLocalDate(),
            content: $('#content').val(),
            comment: $('#comment').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/post/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(requestData)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

main.init();

// $(document).ready(function() {
//
// });