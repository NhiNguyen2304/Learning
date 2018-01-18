var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1} 
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none"; 
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block"; 
  dots[slideIndex-1].className += "active";
}




function openTab(evt, ad) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace("active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(ad).style.display = "block";
    evt.currentTarget.className += " active";
}



// FAVORITE

function init(){
	var c=window.localStorage.getItem("count");
	if(c==null)
	window.localStorage.setItem("count",0);
}

function findout(name){
	var c=window.localStorage.getItem("count");	
	if(c!=null){
		for(var i = 1;i <= c;i++){
			var v = window.localStorage.getItem(i);
			if(v != null){
				if(v.indexOf(name) == 0)
				return i;	
				
			}
		}
		
	}
	return -1;
	
}
function add(name,type,img,more){
	
	var pos=findout(name);
	if(pos==-1){
		var c=window.localStorage.getItem("count");
		c++;
		window.localStorage.setItem("count",c);
		
		window.localStorage.setItem(c, name+","+type+","+img+","+more+",1");
		alert("Your favorite is added succesfully");
	}
	else{
		alert("This product was add");	
		
	}
	
}

function show(){
	
	var sum=0;
	var s ="<table>";
	s +="<tr>";
	s +="<th> NAME </th>";	
	s +="<th> TYPE </th>";
	s +="<th> IMAGE </th>";
	s +="<th> MORE </th>";
	s +="<th> DELETE </th>";
	s +="</tr>";
	
	var c=window.localStorage.getItem("count");
	if(c != null){
		
		for(var i = 1; i <= c; i++){
			var v=window.localStorage.getItem(i);
			if(v != null){
				var arr=v.split(",");
				
				s +="<tr>";
				s +="<td>" + arr[0] +"</td>"; //Ten
				s +="<td>" + arr[1] +"</td>"; //loai
				s +="<td><img src='" +arr[2] +"'></td>";//hinh
				s +="<td><a href='" + arr[3] +"'>More detail</a></td>"; //detail
			
				s +="<td><input type='button' value='delete' onclick='xoa(\"" + arr[0] +"\")'></td>";
				s +="</tr>";
				
				
				
			}
		}
		var the=document.getElementById("bang");
		the.innerHTML=s;
	}
	
}
function xoa(name){
	if(window.confirm("Do you want to delete this product?")==true){
		var pos=findout(name);
		
		if(pos!=-1){
			
			window.localStorage.removeItem(pos);
			show();
			
		}
	}

}

/*Left Menu*/
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}