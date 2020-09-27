var http = require("http");
    fs = require("fs");
var html = fs.readFileSync("./web/index.html");
http.createServer(function(request, response){
    response.write(html);
    response.end();
}).listen(5194);