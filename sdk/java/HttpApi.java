package com.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

public class HttpApi {

    private static String api_host = "http://my.app";    // 修改为API域名  http://finance.aodianyun.com
    private static String API_KEY = "3bddc47e7cc05e1d8f488f2562969a33";  // 修改为你的API key

    public static JSONObject post(String module, String api, JSONObject params){
        String auth_str = "dyyadmin:" . HttpApi.API_KEY;
        String query_url = HttpApi.api_host . "/api/{$module}/{$api}";
        String method = 'POST';
        String content = params.toString().getBytes("UTF-8");

        try{
            URL url = new URL(query_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Authorization", auth_str);
            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(content);
            out.flush();
            out.close();
            
            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer response = new StringBuffer("");
            
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response.append(lines);
            }
            reader.close();
            connection.disconnect();
            return new JSONObject(response);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JSONObject test1_args = new JSONObject();
        test1_args.put("room_id", 73);
        test1_args.put("expire", 1000);
        test1_args.put("uid", "234234");
        test1_args.put("nick", "ttt");
        test1_args.put("ava", "");
        JSONObject test_1 = HttpApi.post("RoomMgr", "getAuthToken", test1_args);
        System.out.println("test_1", test_1.toString());

        JSONObject test2_args = new JSONObject();
        test2_args.put("token", test_1.get("Info"));
        test2_args.put("page", 1);
        test2_args.put("num", 20);
        
        JSONObject test_2 = HttpApi::post("JiaoYuUserInfo", "listWisDoc", test2_args);
echo 'test_2 ', json_encode($test_2);
        System.out.println("test_2", test_2.toString());
    }

}