// Mensaje de bienvenida en el menú principal
document.addEventListener("DOMContentLoaded", () => {
    const username = document.querySelector("#username");
    if (username) {
        console.log(`Welcome, ${username.textContent}!`);
    }
});
