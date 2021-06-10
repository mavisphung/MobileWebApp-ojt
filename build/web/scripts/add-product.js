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
for(const parameter of parameters) {
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