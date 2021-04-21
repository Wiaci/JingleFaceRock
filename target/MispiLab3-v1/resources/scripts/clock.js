function setClock() {
	let date = new Date();
	let h = date.getHours() / 10 >= 1 ? "" : "0";
	let m = date.getMinutes() / 10 >= 1 ? "" : "0";
	let s = date.getSeconds() / 10 >= 1 ? "" : "0";
	document.getElementById("hours").innerHTML = h + date.getHours();
	document.getElementById("minutes").innerHTML = m + date.getMinutes();
	document.getElementById("seconds").innerHTML = s + date.getSeconds();
}

setInterval(setClock, 6000)
setClock()