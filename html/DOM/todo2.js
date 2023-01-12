
window.addEventListener("DOMContentLoaded", function(){
    const registerEl = document.getElementById("register");
    registerEl.addEventListener("click", function(){
        const toDOEl = document.getElementById("todo");
        const toDo = toDOEl.value;
        let tpl = document.getElementById("tpl").innerHTML;

        tpl = tpl.replace(/\[#todo\]/g, toDo);

        const domParser = new DOMParser();
        const dom = domParser.parseFromString(tpl, "text/html");
        const liEl = dom.querySelector("li");

        const ulEl = document.getElementById("todoList");
        ulEl.appendChild(liEl);
    });
});