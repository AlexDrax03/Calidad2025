document.addEventListener("DOMContentLoaded", function() {
    var flipCard = false;
    
    document.querySelector('.flip-card').addEventListener('click', function() {
      flipCard = !flipCard;
      var envelope = document.querySelector('.envelope');
      if (flipCard) {
        envelope.classList.add('active');
      } else {
        envelope.classList.remove('active');
      }
    });
  });
  
  var ractive = new Ractive({
    el: '#container',
    template: '#template',
    data: {}
  });
  
  