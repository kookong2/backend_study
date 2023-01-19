//https://jsonplaceholder.typicode.com/todos

const buttonEl = document.getElementById("button");
buttonEl.addEventListener("click", function(){
    const xhr = new XMLHttpRequest();

    xhr.poen("GET", "https://jsonplaceholder.typicode.com/todos")
    xhr.send(null)
    xhr.addEventListener("readystatechange", function(){
        if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
            const data = xhr.responseText;
            const textEl = document.getElementById("text");
            textEl.value = data;
            
            // JSON.parse // JSON.stringify : javascipt 
            const json = JSON.parse(data);
        }
    });
});