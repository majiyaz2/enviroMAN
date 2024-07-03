
# ♻️ Eviro365 Waste Management [![Java CI](https://github.com/majiyaz2/enviroMAN/actions/workflows/main.yml/badge.svg)](https://github.com/majiyaz2/enviroMAN/actions/workflows/main.yml)
The Enviro365 Waste Management Application is built using Spring Boot and provides RESTful APIs for managing waste categories, items within those categories, and tips related to waste management. The application supports CRUD operations (Create, Read, Update, Delete).





## Technologies used

- [Java](https://docs.oracle.com/en/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [H2 Database Engine](https://www.h2database.com/html/main.html)




## Installation

To install the application you have have to above mentioned technologies and then run the following commands

#### *Clone* 
```bash
  git clone https://github.com/majiyaz2/enviro.git
  cd enviro  
```
#### *Run* 
```bash
  mvn clean install
  mvn spring-boot:run
```    
## API Reference

#### Category 

| Endpoint | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `/category` | `GET` | Gets All the categories |
| `/category/{id}` | `GET` | Gets each category based on the ID|
| `/category/addCategory` | `POST` |Creates a new category |
| `/category/{id}` | `PUT` |Updates a category based on the ID |
| `/category/{id}` | `DELETE` |Deletes a category based on the ID |

#### Item 

| Endpoint | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `/item` | `GET` | Gets All the items |
| `/item/{id}` | `GET` | Gets each item based on the ID|
| `/item/addItem/{categoryId}` | `POST` |Creates a new item inside a specified category |
| `/item/{id}` | `PUT` |Updates a item based on the ID |
| `/item/{id}` | `DELETE` |Deletes a item based on the ID |

#### Tip 

| Endpoint | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `/tip` | `GET` | Gets All the tips |
| `/tip/{id}` | `GET` | Gets each tip based on the ID|
| `/tip/addTip/{categoryId}` | `POST` |Creates a new tip inside a specified category |
| `/tip/{id}` | `PUT` |Updates a tip based on the ID |
| `/tip/{id}` | `DELETE` |Deletes a tip based on the ID |

####  Create New Category

- **URL:** `http://localhost:8080/waste-categories`
- **Method:** POST
- **Body (JSON):**
  ```json
  {
    "id": 1,
    "name": "Plastics",
    "description": "Plastic materials and products",
    "isRecyclable": true,
    "items": [
            {
                "id": 1,
                "name": "Plastic Bag",
                "description": "Used plastic shopping bag",
                "weight": 0.01,
                "disposal": "Place in the recycling bin if clean and dry. Otherwise, dispose of in the general waste bin."
            },
            {
                "id": 2,
                "name": "Food Container",
                "description": "Plastic food storage container",
                "weight": 0.2,
                "disposal": "Rinse and place in the recycling bin. If heavily soiled, dispose of in the general waste bin."
            }
        ],
    "tips": [
            {
                "title": "Recycle Properly",
                "content": "Ensure plastics are clean and dry before placing them in the recycling bin.",
                "id": 3
            },
            {
                "title": "Reuse",
                "content": "Find creative ways to reuse plastic items instead of disposing of them.",
                "id": 4
            }
        ]
    }

## License

[MIT](https://choosealicense.com/licenses/mit/)


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://www.datacamp.com/portfolio/majiyaz2)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/andile-mhlongo-a025a5b1/)

