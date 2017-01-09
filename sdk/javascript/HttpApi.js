function HttpApiHelper() {
    this.api_host = "http://my.app";    // 修改为API域名  http://finance.aodianyun.com
    this.api_key = "3bddc47e7cc05e1d8f488f2562969a33";  // 修改为你的API key
}

HttpApiHelper.prototype.post = function(module, api, params, callback) {
    var auth_str = "dyyadmin:" + this.api_key;
    var query_url = this.api_host + "/api/" + module +  "/" + api;
    $.ajax({
        type: "GET",
        url: query_url,
        data: params,
        cache: false,
        dataType: "jsonp",
        beforeSend: function (xhr) {
            xhr.setRequestHeader ('Authorization', auth_str);
        },
        success: function(rst) {
            typeof callback == 'function' && callback(rst);
        }
    });
}

var HttpApi = new HttpApiHelper();