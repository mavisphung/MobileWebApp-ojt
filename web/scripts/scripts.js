const resize = function() {
  if ($(window).width() < 768) {
    $('.text-right').removeClass('text-right');
  } else {
    $('.be-right').addClass('text-right');
  }
}

$(document).ready(function() {
  $(window).resize(resize);
  const productsList = new ProductList();
  sessionStorage.setItem('productList', productsList);
  resize();
});

class CartDetail {
  product;
  quantity;

  constructor(product, quantity) {
    this.product = product;
    this.quantity = quantity;
  }
}


const productListOnSession = JSON.parse(sessionStorage.getItem('productList'));

const queryString = location.search.substring(1);

console.log(queryString);

class Product {
  itemCode;
  name;
  imageUrl;
  manufacturer;
  category;
  available;
  description;
  unitPrice;

  constructor(itemCode, name, imageUrl, manufacturer, category, available, description, unitPrice) {
    this.itemCode = itemCode;
    this.name = name;
    this.imageUrl = imageUrl;
    this.manufacturer = manufacturer;
    this.category = category;
    this.available = available;
    this.description = description;
    this.unitPrice = unitPrice;
  }

}

const parameters = queryString.split('&');
const properties = [];
let i = 0;
for (const parameter of parameters) {
  //0 name
  //1 unitPrice
  //2 available
  //3 description
  //4 manufacturer
  //5 category
  //6 imageUrl
  let tmp = parameter.split('=');
  properties.push(tmp[1]);
}

// console.log(properties);

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

class Product {
  itemCode;
  name;
  imageUrl;
  manufacturer;
  category;
  available;
  description;
  unitPrice;

  constructor(itemCode, name, imageUrl, manufacturer, category, available, description, unitPrice) {
    this.itemCode = itemCode;
    this.name = name;
    this.imageUrl = imageUrl;
    this.manufacturer = manufacturer;
    this.category = category;
    this.available = available;
    this.description = description;
    this.unitPrice = unitPrice;
  }

}

class ProductList {
  products = [
    new Product(
      0,
      'Iphone X',
      '/images/iphonex.jpg',
      'Apple',
      'Apple',
      900,
      `A smartphone is a handheld personal computer with a mobile operating system
          and an integrated mobile boardband cellular network connection for voice,
          SMS, and Internet data communication; most, if not all, smartphones also support Wifi`,
      1099
    ),
    new Product(
      1,
      'Iphone 8 Plus 64GB PRODUCT RED',
      '/images/iphone8plus.jpg',
      'Apple',
      'Apple',
      250,
      `A smartphone is a handheld personal computer with a mobile operating system
          and an integrated mobile boardband cellular network connection for voice,
          SMS, and Internet data communication; most, if not all, smartphones also support Wifi`,
      599
    ),
    new Product(
      2,
      name = 'Huawei P20 Pro DUAL SIM',
      '/images/p20pro.jpg',
      'Huawei',
      'Huawei',
      800,
      `A smartphone is a handheld personal computer with a mobile operating system
          and an integrated mobile boardband cellular network connection for voice,
          SMS, and Internet data communication; most, if not all, smartphones also support Wifi`,
      499
    ),
    new Product(
      3,
      'Galaxy s8',
      '/images/galaxys8.jpg',
      'Samsung',
      'Samsung',
      850,
      `A smartphone is a handheld personal computer with a mobile operating system
          and an integrated mobile boardband cellular network connection for voice,
          SMS, and Internet data communication; most, if not all, smartphones also support Wifi`,
      899
    ),
  ];

  render() {
    const renderHook = document.getElementById('product-list');
    for (const product of this.products) {
      const productEl = document.createElement('div');
      productEl.className = 'col';
      productEl.innerHTML = `
      <div class="card">
          <div class="card-header bg-white">
            <h5>${product.name}</h5>
          </div>
          <img src="${product.imageUrl}" class="card-img-top" alt="${product.name}">
          <div class="card-body">
            <p class="card-text mb-2">
              ${product.description}
            </p>
            <p class="card-text mb-2">
              ${product.unitPrice} USD
            </p>
            <p class="card-text mb-2">
              ${product.available} units in stock
            </p>
            <a href="/product-detail.html?${product.itemCode}" class="btn btn-primary">
              <i class="fa fa-info-circle"></i> Detail
            </a>
            <a href="#" class="btn btn-warning text-white">
              <i class="fa fa-shopping-cart"></i> Order Now
            </a>
          </div>
        </div>
      `;
      renderHook.append(productEl);
    }
  }
}
