insert into Categorie
select a.* from JSON_TABLE('[
    {"id":1,"name":"smartphones"},
    {"id":2,"name":"laptops"},
    {"id":3,"name":"fragrances"},
    {"id":4,"name":"skincare"},
    {"id":5,"name":"groceries"},
    {"id":6,"name":"home-decoration"},
    {"id":7,"name":"furniture"},
    {"id":8,"name":"sunglasses"},
    {"id":9,"name":"automotive"},
    {"id":10,"name":"motorcycle"},
    {"id":11,"name":"lighting"}
    ]', 

    '$[*]' COLUMNS(
		idCategorie int path '$.id',
		name varchar(254) path '$.name'
    )) a;