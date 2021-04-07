#turkcell-poc

##Installation
Maven clean install yapılır. Tüm kütüphaneler yüklendikten sonra,
POCApplication.class -> main methodu çalıştırılır.
Uygulama ayağa kalkar

##environment
_APPLICATION_PORT: Uygulamanın ayağa kalkacağı port, Default -> 8094;  
_MONGO_DB: Mongo Database Adı, default turkcell_poc; 
_MONGO_UNAME: Mongo kullanıcı adı, default admin; 
_MONGO_UPASS: Mongo kullanıcı şifresi, default root; 
_MONGO_HOST: Mongo host'u, default localhost; 
_MONGO_PORT: Mongo port'u, default 27017; 
_MONGO_AUTH_DB: Mongo authentication database, default admin

##swagger
Swagger url'i aşağıdaki gibidir.
{url}:{port}/swagger-ui/index.html?configUrl=/api-docs/swagger-config#
