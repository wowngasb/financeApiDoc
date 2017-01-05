# -*- coding: utf-8 -*-
import requests
import json

class HttpApi(object):
    api_host = "http://my.app"    # 修改为API域名  http://finance.aodianyun.com
    API_KEY = "3bddc47e7cc05e1d8f488f2562969a33"  # 修改为你的API key

    @classmethod
    def post(cls, module, api, params):
        auth_header = {
            'Authorization': 'dyyadmin:' + HttpApi.API_KEY,
            "Content-type": "application/json; charset=UTF-8",
            'Accept': 'application/json',
        }
        res = requests.post(HttpApi.api_host + '/api/%s/%s' % (module, api), data=json.dumps(params), headers=auth_header)
        if res.ok:
            return res.json()
        else:
            return {
                'Flag': 500,
                'FlagString': 'http请求失败',
                'Error': {
                    'response_code': res.status_code,
                    'response': res.content,
                    'curl_error': res.reason
                }
            }
