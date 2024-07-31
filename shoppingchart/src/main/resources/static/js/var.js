// datetime

function updateDateTime() {
  const now = new Date();
  const year = String(now.getFullYear());
  const month = String(now.getMonth() + 1).padStart(2, '0');
  const day = String(now.getDate()).padStart(2, '0');
  const hours = String(now.getHours()).padStart(2, '0');
  const minutes = String(now.getMinutes()).padStart(2, '0');
  const seconds = String(now.getSeconds()).padStart(2, '0');
  const formattedDateTime = `${year}/${month}/${day} ${hours}:${minutes}:${seconds}`;
  document.getElementById('datetime').textContent = formattedDateTime;
}

// Update the date and time every second
setInterval(updateDateTime, 1000);

// Initial call to display the current date and time immediately
window.onload = updateDateTime;

document.addEventListener('DOMContentLoaded', () => {
  const homeDiv = document.getElementById('home');
  homeDiv.style.cursor = 'pointer'; // Change cursor to pointer

  homeDiv.addEventListener('click', () => {
    fetch('/')
      .then(response => {
        if (!response.ok) throw new Error('Network response was not ok');
        return response.text();
      })
      .then(html => {
        document.body.innerHTML = html; // Replace body content with fetched HTML
        history.pushState(null, '', '/');
      })
      .catch(error => console.error('There has been a problem with your fetch operation:', error));
  });
});