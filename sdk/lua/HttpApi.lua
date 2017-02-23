
-----------------------------------------------------------------------------
-- Imports and dependencies
-----------------------------------------------------------------------------
local json = require("json")
local http=require("socket.http")

-----------------------------------------------------------------------------
-- Module declaration
-----------------------------------------------------------------------------
local HttpApi = {}             -- Public namespace
local __HttpApi = {}     -- Private namespace

__HttpApi.api_host = "http://my.app"    -- 修改为API域名  http://58jinrongyun.com
__HttpApi.api_key = "3bddc47e7cc05e1d8f488f2562969a33"   -- 修改为你的API key
  
function HttpApi.post(module, api, params)
    local auth_str = "dyyadmin:" .. __HttpApi.api_key
    local query_url = __HttpApi.api_host .. "/api/" .. module .. "/" .. api
    local method = "POST"
    local content = json.encode(params)
    local response_body = {}

    local res, code, response_headers = http.request{
        url = query_url,
        method = method,
        headers = {
            ["Accept"] = "application/json",
            ["Authorization"] = auth_str,
            ["Content-Type"] = "application/application/json; charset=UTF-8",
            ["content-length"] = string.len(content)
        },
        source = ltn12.source.string(content),
        sink = ltn12.sink.table(response_body)
    }

    if code == "200" or code == "201" or code == "204" then
        return {
                Flag = '500',
                FlagString = 'http请求失败',
                Error = {
                    response_code = code,
                    response = response_body,
                }
        }
    else
        return json.decode(table.concat(response_body))
    end
    
end

return HttpApi