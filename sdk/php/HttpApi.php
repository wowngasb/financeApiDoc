<?php

/**
 * Class HttpApi
 * http 接口请求类
 */
class HttpApi {

    private static $api_host = "http://my.app";    // 修改为API域名  http://58jinrongyun.com
    private static $api_key = "3bddc47e7cc05e1d8f488f2562969a33";  // 修改为你的API key

    public static function post($module, $api, $params){
        $auth_str = "dyyadmin:" . self::$api_key;
        $timeout = 30;
        $query_url = self::$api_host . "/api/{$module}/{$api}";
        $method = 'POST';
        $content = json_encode($params);

        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $query_url);
        curl_setopt($ch, CURLOPT_HEADER, false);
        curl_setopt($ch, CURLOPT_AUTOREFERER, true);
        curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
        curl_setopt($ch, CURLOPT_FRESH_CONNECT, true);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, $timeout);
        curl_setopt($ch, CURLOPT_TIMEOUT, $timeout);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_BINARYTRANSFER, true);
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $content);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array(
            'Accept: application/json',
            'Content-Type: application/application/json; charset=UTF-8',
            "Authorization: {$auth_str}"
        ));


        $response = curl_exec($ch);
        $response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);  //get response code
        $http_ok = $response_code == 200 || $response_code == 201 || $response_code == 204;
        $curl_error = !$http_ok ? curl_error($ch) : '';
        curl_close($ch);  //close connection

        if ($http_ok) {
            return json_decode(trim($response), true);
        } else {
            return array(
                'Flag' => '500',
                'FlagString' => 'http请求失败',
                'Error' =>[
                    'response_code' => $response_code,
                    'response' => $response,
                    'curl_error' => $curl_error
                ]
            );
        }
    }
}