      const sum = document.querySelector('#sum');
      const own = document.querySelector('#own');
      const noOwn = document.querySelector('#noOwn');
      const type = document.querySelector('.type');
      const person = document.querySelector('#person');
      const company = document.querySelector('#company');
      const tax = document.querySelector('#tax');
      const letBill = document.querySelector('#getBill');
      const fio = document.querySelector('.fio');
      const adres = document.querySelector('.adres');
      const posts = document.querySelector('.posts');

      let minWage = 6700.00;

      sum.addEventListener('input', calcResult);
      noOwn.addEventListener('change', showBlock);
      person.addEventListener('change', function(){
        tax.innerHTML = `<b>${minWage}</b>`
      });
      company.addEventListener('change', function(){
        tax.innerHTML = `<b>${minWage*2}</b>`
      })

      own.addEventListener('change', showBlock);

      function calcResult(){
        if(own.checked == true){

        	if (isNaN(sum.value)) {
            sum.value = "";
            alert("Неверный тип данных");
        	}

            if((sum.value*0.02) <= (10*minWage)){
                tax.innerHTML = (0.02*sum.value).toFixed(2);
            }
            else if((sum.value*0.02) > (10*minWage)){
                 tax.innerHTML = 10*minWage;
            }
        }
      }

      function showBlock(){
        type.classList.toggle('hidden');
        sum.parentElement.classList.toggle('hidden');
        tax.innerHTML = "";
        sum.value = "";
      }

      letBill.addEventListener('click', getLocalStorage);

      function getLocalStorage(){
       localStorage.sum = sum.value;
       localStorage.tax = tax.innerHTML;
       localStorage.fio = fio.value;
       localStorage.adres = adres.value;
       localStorage.posts = posts.value;
      }
