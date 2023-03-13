		const add2 = document.querySelector('.add2');
      	const pas2 = document.querySelector('.pas2');
      	const letBill = document.querySelector('#getBill');

      	letBill.addEventListener('click', getLocalStorage);

      	function getLocalStorage(){
       	localStorage.add2 = add2.value;
       	localStorage.pas2 = pas2.value;
      	}
