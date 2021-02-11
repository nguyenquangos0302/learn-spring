const getData = document.getElementById('get');
const h1 = document.getElementById('h1');
const send = document.getElementById('send');
const form = document.getElementById('form');

let dataRe;

async function getDataFromApi() {
	let response = await fetch("http://localhost:8080/client/api/v1/book");
	let data = await response.json();
	dataRe = data;
}

getData.addEventListener('click', async function(event) {
	event.preventDefault();
	await getDataFromApi();
	h1.value = '';
	for (let i = 0; i < dataRe.length; i++) {
		h1.innerHTML += dataRe[i].name;
	}
})

send.addEventListener('click', function(event) {
	event.preventDefault();
	const dataSend = {
		name: form.value
	}
	fetch("http://localhost:8080/client/api/v1/book", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(dataSend),
	})
	.then(response => response.json())
	.then(data => {
		console.log('success', data);
	})
	.catch(error => {
		console.log('error', error);
	})
})