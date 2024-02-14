function sidebar(){
    let sideBar = document.getElementById("side-bar");
    sideBar.style.opacity = "1"; 
    sideBar.style.transition = "1s";
    sideBar.style.display="block";
    let sidemenu=document.getElementById("side-menu");
    sidemenu.style.transform='translateX(-100%)';
    sidemenu.style.transition="800ms";
    sidemenu.addEventListener("mouseleave",()=>{
        sideBar.style.display="none";
    })
}
