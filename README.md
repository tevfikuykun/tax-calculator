Task
Design and build a RESTful APIs to serve as the backend for a tax calculator.
It should support the following features:
● A client can create new product in the service
● A client can modify its own products but cannot modify others’ products
● A client can delete its own products but cannot modify others’ products
● A client can view all products in the service
● A client can calculate the tax of the product
Consider the appropriate HTTP verbs, headers and responses to use. You should also include
tests to assert the correctness of your solution. If you wish to show off your fullstack skills,
you are welcome to include a UI over the API, but this is optional. The complete solution
should include a README that describes how to build and run the solution. Please either share
the code with us in a public source repository or via email in a zip.
Technical Details
Please use Spring Boot to develop your APIs. Ensure the project is easily built with a
common build system for the chose ecosystem. Consider including a Dockerfile if you wish
to demonstrate your knowledge of image building.


Verilen göreve uygun olarak projeyi oluşturdum. Spring Boot kullanarak oluşturduğum projede öncelikle kullanıcı eklenmesi gerekmektedir. 
Burda authorization olarak kullanıcı veya rol oluşturmam gerekmediği için jwt token kullanmadım ve basit bir database kullandım. 
Oluşturulan kullanıcı id sini owner olarak atayarak product oluşturuyoruz. Ayrıca kullanıcı id si silme, düzenleme işlemleri yapılabiliyor.
Vergi oranını dinamik olarak kullanıcıdan alıyoruz ve buna uygun bir vergi sonucunu döndürüyoruz. Ayrıca oluşturduğum postman collection da projenin içindedir.
