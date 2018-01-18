/*var photos=new Array()
var preloadedimages=new Array()
for (i=0;i<photos.length;i++){
 preloadedimages[i]=new Image()
 preloadedimages[i].src=photos[i]
}
function applyeffect(){
 if (document.all && document.images.photoslider.filters){
  document.images.photoslider.filters.revealTrans.Transition=Math.floor(Math.random()*23)
  document.images.photoslider.filters.revealTrans.stop()
  document.images.photoslider.filters.revealTrans.apply()
 }
}
function playeffect(){
 if (document.all && document.images.photoslider.filters)
  document.images.photoslider.filters.revealTrans.play()
}
function keeptrack(){
 window.status="Image "+(which+1)+" of "+photos.length
}
function doSlideShow(){
 if (which==photos.length-1) which=-1
 which++
 applyeffect()
 document.images.photoslider.src=photos[which]
 playeffect()
 keeptrack()
}
function transport(){
 //window.location=photoslink[which]
 popupCoop();
}*/

/**/
window.onscroll = function() {myFunction()};

function myFunction() {
    if (document.body.scrollTop > 1400 || document.documentElement.scrollTop > 1400) {
        document.getElementById("parallax-left").className = "test";
    } else {
        document.getElementById("parallax-left").className = "";
    }
}

/*menu left*/
/* Set the width of the side navigation to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}


/*go to top*/
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 10 || document.documentElement.scrollTop > 10) {
        document.getElementById("myBtn").style.display = "block";
    } else {
        document.getElementById("myBtn").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0; // For Chrome, Safari and Opera 
    document.documentElement.scrollTop = 0; // For IE and Firefox
}