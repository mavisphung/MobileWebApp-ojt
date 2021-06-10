const productsListOnSession = JSON.parse(sessionStorage.getItem('productsList'));
const cartOnSession = JSON.parse(sessionStorage.getItem('cart'));
const queryString = location.search.substring(1);

const parameters = queryString.split('|');

function getProductById(id) {
  for (const prod of productsListOnSession.products) {
    if (prod.itemCode == id) {
      return prod;
    }
  }
}

// console.log(parameters);

const foundProduct = getProductById(parameters[0]);
if (!foundProduct) {
  window.location.replace('products-list.html');
  alert('Not found!');
}



// const quantityInDetail = cartOnSession.get(foundProduct.itemCode);
// if (quantityInDetail) {
//   let quantity = cartOnSession.get(foundProduct.itemCode);
//   cartOnSession.set(foundProduct.itemCode, quantity + 1);
// }
// else {
//   cartOnSession.set(foundProduct.itemCode, 1);
// }

// sessionStorage.setItem('cart', cartOnSession);
// console.log(cartOnSession);