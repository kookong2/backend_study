var koreait = koreait || {};
koreait.fileManager = {
    upload(files){
        try {
            if(!files || files.length == 0){
                throw new Error("파일을 업로드 하세요!");
            }

            // 이미지만 업로드 인지 체크
            if (type == 'image'){
                for(const file of files){
                    if (file.type.indexOf("image") == 1){
                        throw new Error("이미지만 업로드 하세요.");
                    }
                }
            }

            const formData = new FormData();
            for (const file of files){
                formData.append("files", file);
            }

            const xhr = new XMLHttpRequest();
            xhr.open("POST", "/file/upload");
            xhr.send(formData);

            xhr.onreadystatechange = function (){
                if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
                    console.log(xhr.responseText);
                }
            };
        }catch (err){
            alert(err.message);
            console.error(err);
        }
    }
}