//js.js
document.addEventListener("DOMContentLoaded", function() {
  document.getElementById('dateButton').addEventListener('click', function() {
    document.getElementById('demo').innerHTML = new Date();
  });
});