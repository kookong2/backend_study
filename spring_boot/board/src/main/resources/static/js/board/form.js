/** 게시글 쓰기, 수정 */
window.addEventListener("DOMContentLoaded", function (){
    CKEDITOR.replace("content",{
        heights : 300
    });

    /** 파일 업로드 버튼 클릭 처리 S */
    const fileUploads = document.getElementsByClassName("fileUpload");
    for(const el of fileUploads){
        el.addEventListener("click",function (){
            const type = el.dataset.type;
            const fileEl = document.getElementById("file");
            if(!fileEl) return;

            fileEl.dataset.attachFileType=type;
            fileEl.click();
        });
    }

    const fileEl = document.getElementById("file");
    if(fileEl){
        fileEl.addEventListener("change",function (e){
            const files = e.target.files;
            const type = fileEl.dataset.attachFileType || "file";
            koreait.fileManager.upload(files, type);
        });
    }
    /** 파일 업로드 버튼 클릭 처리 E */
});