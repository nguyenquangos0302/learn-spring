async function getDataFromApi() {
	let response = await fetch("http://localhost:8080/client/api/v1/book");
	let data = await response.json();
	console.log(data);
}

getDataFromApi();

alert("1");