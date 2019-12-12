'use strict';
    {
        //add
        const openAdd = document.getElementById('open-add');
        const closeAdd = document.getElementById('close-add');
        const modalAdd = document.getElementById('modal-add');
        const maskAdd = document.getElementById('mask-add');

        openAdd.addEventListener('click', function () {
            modalAdd.classList.remove('hidden');
            maskAdd.classList.remove('hidden');
        });

        closeAdd.addEventListener('click', function() {
            modalAdd.classList.add('hidden');
            maskAdd.classList.add('hidden');
        });

        maskAdd.addEventListener('click', function() {
            modalAdd.classList.add('hidden');
            maskAdd.classList.add('hidden');
        });

        //show
        const showOpen = document.getElementById('show-open'); //id=show-openにidを付与
        const showClose = document.getElementById('show-close');
        const showModal = document.getElementById('show-modal');
        const showMask = document.getElementById('show-mask');
    
        showOpen.addEventListener('click', function() {
            // for(var i = 0; i < showOpen.length; i++) {
            //     return showOpen = document.getElementById('show-open' + [i]).val([i]);
            // }
            showModal.classList.remove('hidden');
            showMask.classList.remove('hidden');
        });
        
        showClose.addEventListener('click', function() {
            showModal.classList.add('hidden');
            showMask.classList.add('hidden');
        });

        showMask.addEventListener('click', function() {
            showModal.classList.add('hidden');
            showMask.classList.add('hidden');
        });
    }