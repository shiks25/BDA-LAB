show dbs

//create db
use student

//insert values
db.student.insertMany([
{Rollno:1,name:"Shikha N",age:19,Phno:8884380480,email:"nshikha@gmail.com"},
{Rollno:2,name:"Halsey",age:20,Phno:9990735672,email:"h@gmail.com"},
{Rollno:3,name:"Tom",age:20,Phno:6899804810,email:"me@gmail.com"},
{Rollno:10,name:"Mary",age:19,Phno:8887680480,email:"mary@gmail.com"},
{Rollno:11,name:"ABC",age:23,Phno:9937636760,email:"hehe@gmail.com"}
]);
db.student.find();



//update
db.student.updateOne(
{Rollno:10},
{$set:{"email":"hello@gmail.com"}}
);

//update
db.student.updateOne(
{Rollno:11},
{$set:{"name":"FEM"}}
);

db.student.find();


//export(in terminal)
//mongoexport --db=student --collection=student --out=E:\student.csv --type=csv --fields=Rollno,name,age,Phno,email

//drop drop
db.student.drop();
show collections

//import(in terminal)
//mongoimport -d student -c student --type csv --file E:\student.csv --headerline

db.student.find();














