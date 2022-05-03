const selectEl = document.getElementById('select');
const registrationImage = document.getElementById('1-v');
const labels = document.querySelectorAll('label');
const button = document.querySelector('.form-submit-button');

selectEl.addEventListener('change', function() {
	switch(true) {
		case this.value === 'variant1' : registrationImage.src = "Assets/1.png";
		break;
		case this.value === 'variant2' : registrationImage.src = "Assets/2.png";
		break;
		case this.value === 'variant3' : registrationImage.src = "Assets/3.png";
		break;
		case this.value === 'variant4' : registrationImage.src = "Assets/4.png";
		break;
		case this.value === 'variant5' : registrationImage.src = "Assets/5.png";
		break;
}
})