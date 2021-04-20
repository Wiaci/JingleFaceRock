let x = "0";
let y = "0";
let r = "1";
let svg;
let emptySVG;
let incorrect = document.getElementById("incorrect")

document.addEventListener("DOMContentLoaded", () => {
	svg = document.querySelector("svg")
	emptySVG = svg.innerHTML
	document.getElementById("submit").onclick = e => {
		e.preventDefault()
		if (/-?\d+(\.\d+)?/.test(y) && y >= -3 && y <= 3) {
			incorrect.innerHTML = ""
			draw(x, y, r);
			console.log("Here")
			load();
		} else {
			incorrect.innerHTML = "(-3.0, 3.0)!"
		}
	}
	document.getElementById("clear").onclick = e => {
		e.preventDefault()
		clear()
		clearTable()
	}
	svg.onclick = e => {
		let coords = svg.getBoundingClientRect()
		let xp = r/100*(e.clientX - 150 - coords.left)
		let yp = r/100*(150 + coords.top - e.clientY)
		draw(xp, yp, r)
		load([{name:"x", value:xp}, {name:"y", value:yp}, {name:"r", value:r}])
	}
	redraw()
})

function draw(x, y, r) {
	let color;
	if (inArea(x, y)) {
		color = "orange"
	} else color = "magenta"
	svg.innerHTML +=
		`<circle cx=\"${150+x/r*100}\" cy=\"${150-y/r*100}\" r=\"4\" 
                             fill=\"${color}\" ></circle>`;
}

function redraw() {
	svg.innerHTML = emptySVG;
	let xList = []
	let yList = []
	document.querySelectorAll(".x-val").forEach(el => {
		xList.push(el.innerHTML)
	})
	document.querySelectorAll(".y-val").forEach(el => {
		yList.push(el.innerHTML)
	})
	for (let i = 0; i < xList.length; i++) {
		draw(xList[i], yList[i], r)
	}
}

function clear() {
	console.log("clear")
	svg.innerHTML = emptySVG
}


function setX(_x) {
	if (/-?\d+((\.|,)\d+)?/.test(_x)) {
		if (_x > 5) x = 5;
		else if (_x < -5) x = -5
		else x = Math.trunc(_x);
	}
	console.log(x)
}
function setY(_y) {
	y = _y;
	console.log(y)
}
function setR(_r) {
	r = _r;
	console.log(r)
	redraw();
}

function validate() {
	console.log(document.querySelector("#ytext").value) ;
}

function inArea(x, y) {
	return (x <= 0 && y >= 0 && x*x + y*y <= r*r) || (x >= 0 && y >= 0 && x <= r && y <= r) ||
		(x <= 0 && y <= 0 && y >= -2*x - r)
}