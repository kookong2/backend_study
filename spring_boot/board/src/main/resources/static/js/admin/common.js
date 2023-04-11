window.addEventListener("DOMContentLoaded", function (){
    /** checkbox 전체 선택 처리 S*/
    const selectAlls = document.getElementsByClassName("select_all");
    for (const el of selectAlls){
        el.addEventListener("click", function (){
            const targetName = this.dataset.targetName;
            if(!targetName) return;

            const chks = document.getElementsByName(targetName);
            for (const chk of chks){
                chk.checked = this.checked;
            }
        });
    }
    /** checkbox 전체 선택 처리 E*/
});