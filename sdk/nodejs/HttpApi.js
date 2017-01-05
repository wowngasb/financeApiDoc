var http = require('http');
var querystring = require('querystring');



function HttpApiHelper() {
    this.api_host = "http://my.app";    // 修改为API域名  http://finance.aodianyun.com
    this.API_KEY = "3bddc47e7cc05e1d8f488f2562969a33";  // 修改为你的API key
}


HttpApiHelper.prototype.post = function (module, api, params, callback) {
    var data = JSON.stringify(params);
    var options = {
        host: this.api_host.split('://')[1],
        path: '/api/' + module + '/' + api,
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=UTF-8',
            'Authorization': 'dyyadmin:' + this.API_KEY,
            'Content-Length': Buffer.byteLength(data)
        }
    };
    var body = '';
    var req = http.request(options, function(res) {
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            body += chunk;
        });
        res.on('end',function(){
            callback( JSON.parse(body) );
        })
    });
    req.write(data);
    req.end();
}

exports.HttpApi = new HttpApiHelper();
