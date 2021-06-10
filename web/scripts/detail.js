const productListOnSession = JSON.parse(sessionStorage.getItem('productsList'));
const cartOnSession = JSON.parse(sessionStorage.getItem('cart'));
const parameter = location.search.substring(1);
console.log(parameter);

function getProductById(id) {
  for (const prod of productListOnSession.products) {
    if (prod.itemCode == id) {
      return prod;
    }
  }
}

const found = getProductById(parameter);
console.log(found);

function render(product) {
  const renderHook = document.getElementById('product-detail');
  renderHook.innerHTML = `
    <div class="col-12 col-md-6">
        <img src="${product.imageUrl}" alt="${product.name}" class="w-100 img-fluid">
      </div>
      <div class="col-12 col-md-6">
        <legend>${product.name}</legend>
        <p class="mb-3">
          ${product.description}
        </p>
        <div class="mb-3">
          <strong>Item code:</strong> &nbsp;
          <p class="d-inline item-code">${product.itemCode}</p>
        </div>
        <div class="mb-3">
          <strong>Manufacturer:</strong> &nbsp;
          <p class="d-inline">${product.manufacturer}</p>
        </div>
        <div class="mb-3">
          <strong>Category:</strong> &nbsp;
          <p class="d-inline"><a href="#">${product.category}</a></p>
        </div>
        <div class="mb-3">
          <strong>Available in stock:</strong> &nbsp;
          <p class="d-inline">${product.available}</p>
        </div>
        <div class="mb-3">
          <p class="d-inline">${product.unitPrice} USD</p>
        </div>
        <div class="mb-3">
          <a href="products-list.html" class="btn btn-main text-decoration-none text-white">
            <i class="fa fa-backward"></i>&nbsp;Back
          </a>
          <a href="cart.html?${product.itemCode}|1" class="btn btn-sub text-decoration-none text-white">
            <i class="fa fa-shopping-cart"></i>&nbsp;Order Now
          </a>
        </div>
      </div>
  `;
}

render(found);

// console.log(cartOnSession);