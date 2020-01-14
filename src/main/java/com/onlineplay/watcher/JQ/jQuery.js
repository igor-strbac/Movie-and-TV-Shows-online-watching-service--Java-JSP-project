$(document).ready(function () {
    // bind form submit event
    $("#file-upload-form").on("submit", function (e) {

        // cancel the default behavior
        e.preventDefault();

        // use $.ajax() to upload file
        $.ajax({
            url: "/file-upload",
            type: "POST",
            data: new FormData(this),
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            success: function (res) {
                console.log(res);
            },
            error: function (err) {
                console.error(err);
            }
        });
    });
});