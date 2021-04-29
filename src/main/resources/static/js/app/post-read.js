var moveUpdatePage = function() {

    var postId = $('#id').val();

    console.log(postId);

    var url = '/post/update/' + postId;

    console.log(url);

    location.href = url;
};