
window.addEventListener("DOMContentLoaded", function(){
    const registerE1 = document.getElementById("register");
    registerE1.addEventListener("click",function(){
        try{
            const toDoEl = document.getElementById("todo");
            const toDo = toDoEl.value;
            if(!toDo || toDo.trim() == ""){
                throw new Error("할 일을 입력하세요.");
            }
    
            const liEl = document.createElement("li");
            const textNode = document.createTextNode(toDo);
            liEl.appendChild(textNode);
    
            const ulEl = document.getElementById("todoList");
            ulEl.appendChild(liEl);
            
            toDo.value = "";

            liEl.addEventListener("dblclick", function(){
                //ulEl.removeChild(liEl);
                if(confirm("정말 삭제 하시겠습니까?")){
                    liEl.parentElement.removeChild(liEl);
                }
            });

        } catch (err){
            alert(err.message);
        }
    })
});