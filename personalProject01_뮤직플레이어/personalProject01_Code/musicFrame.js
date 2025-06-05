let imgArr = [
   "./img/happy.jpg", "./img/knowaboutme.jpg", "./img/lovewinsall.jpg", 
   "./img/supernatural.jpg", "./img/reset.jpg", "./img/나무.jpg", 
   "./img/너를만나.jpg", "./img/미운오리새끼.jpg", "./img/예뻤어.jpg", 
   "./img/breakthewall.jpg"
];
let singer = [
	"Day6", "NMIXX", "아이유", "NewJeans", "Ive", "카더가든", "폴킴", "최예나", "Day6", "NMIXX"
];
let imgName = [
   "Happy", "Know about me", "Love wins all", "Supernatural", "해야", 
   "나무", "너를 만나", "미운오리새끼", "예뻤어", "Break the wall"
];
let bgColor = [
	"216, 208, 181", "124,121,150", "197,85,74", "255,177,106", "147,169,229",
	"161,174,208", "214,214,214", "170,176,190", "203,204,199", "86,125,168"
];
var musicArry = [
  "./music/DAY6 - HAPPY.mp3",
  "./music/NMIXX-KNOW ABOUT ME.mp3",
  "./music/아이유-Love wins all.mp3",
  "./music/뉴진스-Supernatural.mp3",
  "./music/IVE-해야.mp3",
  "./music/카더가든-나무.mp3",
  "./music/폴킴-너를 만나.mp3",
  "./music/최예나-미운오리새끼.mp3",
  "./music/DAY6-예뻤어.mp3",
  "./music/NMIXX-Break The Wall.mp3"
];
var y = 0;
var sw1 = 0;
let objText = document.getElementById("input_text");
let objText01 = document.getElementById("input_text02");
let currentIndex = 0;
let objImg = document.getElementById("albumImage");
let bgElement = document.getElementById("bg_color");
let btncolor = document.getElementsByClassName("btn");
let myAudio = document.getElementById("ssong");
var swLoop = 0;

	function updateImage() {
		objImg.src = imgArr[currentIndex];
		objText.value = imgName[currentIndex];
		objText01.value = singer[currentIndex];
		document.getElementById("music").value = imgName[currentIndex];

		bgElement.style.backgroundColor = `rgb(${bgColor[currentIndex]})`;
		objText.style.backgroundColor = `rgb(${bgColor[currentIndex]})`;
		objText01.style.backgroundColor = `rgb(${bgColor[currentIndex]})`;
		for (let i = 0; i < btncolor.length; i++) {
			btncolor[i].style.backgroundColor = `rgb(${bgColor[currentIndex]})`;
		}
	}
	
	function addImg(value) {
		for (let i = 0; i < imgName.length; i++) {
			if (imgName[i] === value) {
				currentIndex = i;
				updateImage();
				myAudio.src = musicArry[currentIndex];
				myAudio.load();
				myAudio.play();
				document.getElementById("btn_img").src = "./img/pause.png";
				sw1 = 1;
				y=1;
				break;
			}
		}
	}
	
	function firstImage() {
		currentIndex = 0;
		myAudio.pause();
		updateImage();
		myAudio.src = musicArry[currentIndex];
		myAudio.load();
		myAudio.play();
		document.getElementById("btn_img").src = "./img/pause.png";
		sw1 = 1;
		y=1;
	}
	
	function lastImage() {
		currentIndex = imgArr.length - 1;
		myAudio.pause();
		updateImage();
		myAudio.src = musicArry[currentIndex];
		myAudio.load();
		myAudio.play();
		document.getElementById("btn_img").src = "./img/pause.png";
		sw1 = 1;
		y=1;
	}
	
	function nextImage() {
	if (currentIndex < imgArr.length - 1) {
		myAudio.pause();
		currentIndex++;
		updateImage();
		myAudio.src = musicArry[currentIndex];
		myAudio.load();
		myAudio.play();
		document.getElementById("btn_img").src = "./img/pause.png";
		sw1 = 1;
		y = 1;
	} else {
		alert("마지막 페이지입니다");
		if (myAudio.paused) {
			myAudio.play();
			document.getElementById("btn_img").src = "./img/pause.png";
			sw1 = 1;
		}
	}
}
	
	function prevImage() {
	if (currentIndex > 0) {
		myAudio.pause();
		currentIndex--;
		updateImage();
		myAudio.src = musicArry[currentIndex];
		myAudio.load();
		myAudio.play();
		document.getElementById("btn_img").src = "./img/pause.png";
		sw1 = 1;
		y = 1;
	} else {
		alert("처음 페이지입니다.");
		if (myAudio.paused) {
			myAudio.play();
			document.getElementById("btn_img").src = "./img/pause.png";
			sw1 = 1;
		}
	}
}
	function mPlayPause(){
		if(sw1 == 0){
			document.getElementById("btn_img").src = "./img/pause.png";
			if(y==0){
				myAudio.src = musicArry[currentIndex];
				myAudio.load();
				y = 1;
			}
			myAudio.play();
			sw1 = 1;
		}else {
			document.getElementById("btn_img").src = "./img/play.png";
			myAudio.pause();
			sw1=0;
		}
	}
	function mStop(){
		document.getElementById("btn_img").src = "./img/play.png";
		myAudio.load();
		myAudio.pause();
		sw1=0;
		y=0;
	}
	let rangeBar = document.getElementById("rangeBar");

myAudio.ontimeupdate = function(){
	if(!isSeeking){
		rangeBar.max = Math.floor(myAudio.duration);
        rangeBar.value = Math.floor(myAudio.currentTime);
	}
	var due = Math.floor(myAudio.duration);
	var ctime = Math.floor(myAudio.currentTime);
	let min1 = Math.floor(ctime / 60);
	let sec1 = Math.floor(ctime % 60);
	let min2 = Math.floor(due / 60);
	let sec2 = Math.floor(due % 60);

	min1 = min1 < 10 ? "0" + min1 : min1;
	min2 = min2 < 10 ? "0" + min2 : min2;
	sec1 = sec1 < 10 ? "0" + sec1 : sec1;
	sec2 = sec2 < 10 ? "0" + sec2 : sec2;
	
	document.getElementById("info").innerHTML = `${min1}:${sec1} / ${min2}:${sec2}`;
	if((min1 / min2) == 1 && (sec1 / sec2) == 1){
		let image = document.getElementById("sound");
		if(image.src.split('/').pop() == "once.png"){
			myAudio.loop = true;
		}else{
			myAudio.loop = false;
			nextImage();
		}
	}
}
let isSeeking = false;

rangeBar.addEventListener("input", function () {
    isSeeking = true;
});

rangeBar.addEventListener("change", function () {
    myAudio.currentTime = rangeBar.value;
    isSeeking = false;
});
function toggleImage() {
    let image = document.getElementById("sound");
    let img1 = "./img/repeat.png";
    let img2 = "./img/once.png";

    if (image.src.split('/').pop() == "repeat.png") {
        image.src = img2;
    } else {
        image.src = img1;
    }
}
