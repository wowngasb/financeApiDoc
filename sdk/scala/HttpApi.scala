import net.sf.json.JSONObject;
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import java.io._

package com {

    package test {

        object  HttpApi {

            private val api_host: String = "http://my.app"    // 修改为API域名  http://58jinrongyun.com
            private val api_key: String = "3bddc47e7cc05e1d8f488f2562969a33"  // 修改为你的API key

            def post(module: String, api: String, params: JSONObject) : JSONObject = {
                val auth_str: String = "dyyadmin:" + api_key
                val query_url: String = api_host + "/api/" + module + "/" + api
                val method: String = "POST"

                // create an HttpPost object
                val post = new HttpPost(query_url)
                val content = new String(params.toString().getBytes("UTF-8"))
                // set the Content-type
                post.setHeader("Accept", "application/json")
                post.setHeader("Content-type", "application/json; charset=UTF-8")
                post.setHeader("Authorization", auth_str)

                // add the JSON as a StringEntity
                post.setEntity( new StringEntity(content) )

                // send the post request
                val httpClient = new DefaultHttpClient
                val response = httpClient.execute(post)

                val entity = response.getEntity()
                var body = ""
                if (entity != null) {
                  val inputStream = entity.getContent()
                  body = io.Source.fromInputStream(inputStream).getLines.mkString
                  inputStream.close
                }
                httpClient.getConnectionManager().shutdown()
                
                val ret: JSONObject = new JSONObject(body)
                return ret
            }

        }
    
    }
    
}
