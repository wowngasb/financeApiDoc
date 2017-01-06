using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Newtonsoft.Json;
using System.Net;
using System.IO;

namespace HttpApi
{
    class HttpApi
    {
        private static string api_host = "http://my.app";    // 修改为API域名  http://finance.aodianyun.com
        private static string API_KEY = "3bddc47e7cc05e1d8f488f2562969a33";  // 修改为你的API key

        public static dynamic post(string module, string api, dynamic param)
        {
            var query_url = api_host + "/api/" + module + "/" + api;
            var auth_str = "dyyadmin:" + API_KEY;
            var content = JsonConvert.SerializeObject(param);
            byte[] byteArray = Encoding.UTF8.GetBytes(content);

            HttpWebRequest objWebRequest = (HttpWebRequest)WebRequest.Create(query_url);
            objWebRequest.Method = "POST";
            objWebRequest.ContentType = "application/application/json; charset=UTF-8";
            objWebRequest.Accept = "application/json";
            objWebRequest.Headers.Add(HttpRequestHeader.Authorization, auth_str);
            objWebRequest.ContentLength = byteArray.Length;
            Stream newStream = objWebRequest.GetRequestStream();  // Send the data. 
            newStream.Write(byteArray, 0, byteArray.Length);  //写入参数 
            newStream.Close();

            HttpWebResponse response = (HttpWebResponse)objWebRequest.GetResponse();
            StreamReader sr = new StreamReader(response.GetResponseStream(), Encoding.Default);
            string textResponse = sr.ReadToEnd(); // 返回的数据

            return JsonConvert.DeserializeObject<dynamic>(textResponse);
        }

    }


}
