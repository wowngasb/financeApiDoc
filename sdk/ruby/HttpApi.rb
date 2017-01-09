require 'net/http'
require 'uri'
require 'json'

class HttpApi

    @@api_host = "http://my.app"    # 修改为API域名  http://finance.aodianyun.com
    @@api_key = "3bddc47e7cc05e1d8f488f2562969a33"  # 修改为你的API key
        
    def self.post(module_name, api, params)
        auth_str = "dyyadmin:" + @@api_key
        query_url = @@api_host + "/api/" + module_name + "/" + api
        content = params.to_json
                
        url = URI.parse(query_url)
        req = Net::HTTP::Post.new(url.path, {
            'Accept' => 'application/json',
            'Content-Type' => 'application/application/json; charset=UTF-8',
            'Authorization' => auth_str
        })
        req.body = content
        res = Net::HTTP.new(url.host, url.port).start{|http| http.request(req)}
        
        JSON.parse(res.body)
        
    end

end