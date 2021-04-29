var moveUpdatePage = function() {

    var postId = $('#id').val();
    var url = '/post/update/' + postId;

    location.href = url;
};

var main = {

    init: function() {

        var _this = this;

        // 삭제
        $('#btn-delete').on('click', function() {
            _this.delete();
        });
    },
    delete : function() {
        var postId = $('#id').val();

        $.ajax({
            type:'PUT',
            url: '/api/v1/post/delete/' + postId,
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();