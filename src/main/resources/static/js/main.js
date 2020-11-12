var singleFileUploadForm = document.querySelector("#singleFileUploadForm");
var singleFileUploadInput = document.querySelector("#singleFileUploadInput");
var singleFileUploadSuccess = document.querySelector("#singleFileUploadSuccess");
var singleFileUploadError = document.querySelector("#singleFileUploadError");

var multipleFileUploadForm = document.querySelector("#multipleFileUploadForm");
var multipleFileUploadInput = document.querySelector("#multipleFileUploadInput");
var multipleFileUploadSuccess = document.querySelector("#multipleFileUploadSuccess");
var multipleFileUploadError = document.querySelector("#multipleFileUploadError");


multipleFileUploadForm.addEventListener('submit', function (event) {
    var files = multipleFileUploadInput.files;
    if (files.length === 0) {
        multipleFileUploadError.innerHTML = "Please select at least one file!";
    }
    uploadMultipleFiles(files);
    event.preventDefault();
}, true);


singleFileUploadForm.addEventListener('submit', function (event) {
    var files = singleFileUploadInput.files;
    if (files.length === 0) {
        singleFileUploadError.innerHTML = "Please select 1 file!";
    }
    uploadSingleFiles(files[0]);
    event.preventDefault();
}, true);


function uploadSingleFiles(file) {
    var data = new FormData();
    data.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function () {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if (xhr.status === 200) {
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p>File uploaded successfully.</p>" + "<p>Download uri : <a href='"
                + response.downloadUrl
                + "' target='_blank'>"
                + response.downloadUrl
                + "</a></p>";
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message)
                || "Some error occured";
        }
    };

    xhr.send(data);
}


function uploadMultipleFiles(files) {
    var data = new FormData();
    for (var i = 0; i < files.length; i++) {
        data.append("files", files[i]);
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadMultipleFiles");

    xhr.onload = function () {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        if (xhr.status === 200) {
            multipleFileUploadError.style.display = "none";
            var content = "<p>All files uploaded successfully.</p>";
            for (var i = 0; i < response.length; i++) {
                content += "<p>Download uri : <a href='"
                    + response[i].downloadUrl
                    + "' target='_blank'>"
                    + response[i].downloadUrl
                    + "</a></p>";
            }
            multipleFileUploadSuccess.innerHTML = content;
        } else {
            multipleFileUploadSuccess.style.display = "none";
            multipleFileUploadError.innerHTML = (response && response.message)
                || "Some error occured";
        }
    };

    xhr.send(data);
}