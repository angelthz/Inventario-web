/**
 * 
 */
const registrarBtn = document.getElementById("new-product-btn");
const formsContainer = document.querySelector(".forms-container");
const saveProductForm = document.querySelector(".save-producto-form");
const deleteForm = document.querySelector(".delete-product-form");
const productName = document.querySelector("#product-name");
const cancelDelete = document.querySelector("#cancel-delete-btn");

document.addEventListener("click", e => {
	if(e.target === registrarBtn ){
		saveProductForm.id.value = "";
		saveProductForm.nombre.value = "";
		saveProductForm.precio.value = "";
		saveProductForm.cantidad.value = "";
		saveProductForm.categoria.value = "";
		saveProductForm.accion.value = "GuardarProducto";
		console.log(saveProductForm.getAttribute("action"));
		saveProductForm.classList.remove("hidden");
		formsContainer.classList.remove("hidden");
	}
	
	if(e.target.matches("#edit-btn")){
		saveProductForm.id.value = e.target.dataset.id;
		saveProductForm.nombre.value = e.target.dataset.nombre;
		saveProductForm.precio.value = e.target.dataset.precio;
		saveProductForm.cantidad.value = e.target.dataset.cantidad;
		saveProductForm.accion.value = "ActualizarProducto";
		console.log(saveProductForm.getAttribute("action"));
		saveProductForm.classList.remove("hidden");
		formsContainer.classList.remove("hidden"); 
	}
	
	if(e.target.matches("#delete-btn")){
		productName.textContent = e.target.dataset.nombre;
		deleteForm.id.value = e.target.dataset.id;
		deleteForm.classList.remove("hidden");
		formsContainer.classList.remove("hidden"); 
	}
	
	if(e.target === formsContainer || e.target === cancelDelete){
		productName.textContent = "";
		deleteForm.id.value = "";
		saveProductForm.classList.add("hidden");
		deleteForm.classList.add("hidden");
		formsContainer.classList.add("hidden");
	}
	
	
	
});

console.log("Hellozzzzzzzzzz")