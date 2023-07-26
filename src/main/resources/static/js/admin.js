//select btn in navbar
$("#btn-home").click(function() {
    //navbar btn active
    document.getElementById('btn-home').classList.add("active");
    document.getElementById('btn-user').classList.remove("active");
    document.getElementById('btn-product').classList.remove("active");
    document.getElementById('btn-category').classList.remove("active");
    document.getElementById('btn-history').classList.remove("active");

    //area control display
    document.getElementById('home-display').classList.add("display");
    document.getElementById('user-display').classList.remove("display");
    document.getElementById('product-display').classList.remove("display");
    document.getElementById('category-display').classList.remove("display");
    document.getElementById('history-display').classList.remove("display");
});
$("#btn-user").click(function() {
    document.getElementById('btn-home').classList.remove("active");
    document.getElementById('btn-user').classList.add("active");
    document.getElementById('btn-product').classList.remove("active");
    document.getElementById('btn-category').classList.remove("active");
    document.getElementById('btn-history').classList.remove("active");

    document.getElementById('home-display').classList.remove("display");
    document.getElementById('user-display').classList.add("display");
    document.getElementById('product-display').classList.remove("display");
    document.getElementById('category-display').classList.remove("display");
    document.getElementById('history-display').classList.remove("display");
});
$("#btn-product").click(function() {
    document.getElementById('btn-home').classList.remove("active");
    document.getElementById('btn-user').classList.remove("active");
    document.getElementById('btn-product').classList.add("active");
    document.getElementById('btn-category').classList.remove("active");
    document.getElementById('btn-history').classList.remove("active");

    document.getElementById('home-display').classList.remove("display");
    document.getElementById('user-display').classList.remove("display");
    document.getElementById('product-display').classList.add("display");
    document.getElementById('category-display').classList.remove("display");
    document.getElementById('history-display').classList.remove("display");
});
$("#btn-category").click(function() {
    document.getElementById('btn-home').classList.remove("active");
    document.getElementById('btn-user').classList.remove("active");
    document.getElementById('btn-product').classList.remove("active");
    document.getElementById('btn-category').classList.add("active");
    document.getElementById('btn-history').classList.remove("active");

    document.getElementById('home-display').classList.remove("display");
    document.getElementById('user-display').classList.remove("display");
    document.getElementById('product-display').classList.remove("display");
    document.getElementById('category-display').classList.add("display");
    document.getElementById('history-display').classList.remove("display");
});
$("#btn-history").click(function() {
    document.getElementById('btn-home').classList.remove("active");
    document.getElementById('btn-user').classList.remove("active");
    document.getElementById('btn-product').classList.remove("active");
    document.getElementById('btn-category').classList.remove("active");
    document.getElementById('btn-history').classList.add("active");

    document.getElementById('home-display').classList.remove("display");
    document.getElementById('user-display').classList.remove("display");
    document.getElementById('product-display').classList.remove("display");
    document.getElementById('category-display').classList.remove("display");
    document.getElementById('history-display').classList.add("display");
});
//select method in product
$("#add-product").click(function() {
    document.getElementById('add-product').classList.remove("display");
    document.getElementById('list-product').classList.add("display");
    document.getElementById('table-product').classList.add("hidden");
    document.getElementById('form-product').classList.remove("hidden");
});
$("#list-product").click(function() {
    document.getElementById('add-product').classList.add("display");
    document.getElementById('list-product').classList.remove("display");
    document.getElementById('table-product').classList.remove("hidden");
    document.getElementById('form-product').classList.add("hidden");
});
//select method in category
$("#add-category").click(function() {
    document.getElementById('add-category').classList.remove("display");
    document.getElementById('list-category').classList.add("display");
    document.getElementById('table-category').classList.add("hidden");
    document.getElementById('form-category').classList.remove("hidden");
});
$("#list-category").click(function() {
    document.getElementById('add-category').classList.add("display");
    document.getElementById('list-category').classList.remove("display");
    document.getElementById('table-category').classList.remove("hidden");
    document.getElementById('form-category').classList.add("hidden");
});