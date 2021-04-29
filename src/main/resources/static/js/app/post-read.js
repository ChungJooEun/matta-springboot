var main = {

    init: function() {

        var _this = this;

        // 삭제
        $('#btn-delete').on('click', function() {
            _this.delete();
        });

        // 수정
        $('#btn-go-update').on('click', function() {
            _this.update();
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
    },
    update : function() {

        location.href = '/post/update/' + $('#id').val();
    }
};

main.init();