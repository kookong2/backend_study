
window.addEventListener("DOMContentLoaded", function(){
    const menuEl = document.getElementById("menus");
    const menu1El = document.getElementById("li");
    //menu1El.setAttribute("class", "menu");
    //menu1El.setAttribute("id", "menu1");
    //menu1El.setAttribute("data-price", 10000);
    menu1El.dataset.price = 10000; // data-price
    menu1El.className = "menu";
    menu1El.id = "menu1";

    const menu1Text = document.createTextNode("메뉴1");
    menu1El.appendChild(menu1Text);
    //menu1El.appendChild(menu1El);

    const menu2El = document.getElementById("menu2");
    menu1El.insertBefore(menu1El, menu2El);


    console.log(menu1El);
});