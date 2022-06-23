// open modal
$("#login").click(function() {
    document.getElementById('modal-form').classList.add("show");
    document.getElementById('login-form').classList.add("display");
});
$("#register").click(function() {
    document.getElementById('modal-form').classList.add("show");
    document.getElementById('register-form').classList.add("display");
});
// close modal
$("#modal__overlay").click(function() {
    document.getElementById('modal-form').classList.remove("show");
    document.getElementById('register-form').classList.remove("display");
    document.getElementById('login-form').classList.remove("display");
});
$("#btn-back-1").click(function() {
    document.getElementById('modal-form').classList.remove("show");
    document.getElementById('register-form').classList.remove("display");
    document.getElementById('login-form').classList.remove("display");
});
$("#btn-back-2").click(function() {
    document.getElementById('modal-form').classList.remove("show");
    document.getElementById('register-form').classList.remove("display");
    document.getElementById('login-form').classList.remove("display");
});
// switch login <-> register
$("#switch-btn-register").click(function() {
    document.getElementById('register-form').classList.add("display");
    document.getElementById('login-form').classList.remove("display");
    console.log("hello")
});
$("#switch-btn-login").click(function() {
    document.getElementById('login-form').classList.add("display");
    document.getElementById('register-form').classList.remove("display");
    console.log("hello")
});