window.addEventListener('load',function(){
            const sum = document.querySelector('#sum');
            const tax = document.querySelector('#tax');
            const payer3 = document.querySelector('#payer3');
            const payer4 = document.querySelector('#payer4');
            const payer5 = document.querySelector('#payer5');
            sum.innerHTML = localStorage.sum;
           	tax.innerHTML = localStorage.tax;
            payer1.innerHTML = localStorage.fio;
            payer2.innerHTML = localStorage.adres;
            payer3.innerHTML = localStorage.posts;
        })
