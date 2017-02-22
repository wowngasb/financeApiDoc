# 视频上传demo

demo 使用 `plupload` 插件，也可以换成其他插件

## 视频上传及认证


```javascript
    var uploaderObj = new plupload.Uploader({ //实例化一个plupload上传对象
        browse_button: 'selectFiles',//触发文件选择对话框的按钮，为那个元素id
        runtimes: 'html5,flash,silverlight,html4',
        url: 'http://upload.dvr.aodianyun.com/v2/DVR.FormUpload',  //视频上传接口地址
        chunk_size: '5000kb',   //分片大小  可以定义
        max_retries: 3,   //分片上传  最大重试次数
        filters: {
            // Maximum file size
            max_file_size: '4096mb',   //最大文件大小限制
            // Select the duplicate files are not allowed
            prevent_duplicates: true   //是否允许 多选文件
        },
        multipart_params: MULTIPART_PARAMS,  //视频上传认证参数  通过 RoomVideo.getUploadAuthParams 接口获取
        // Flash settings
        flash_swf_url: './plupload/Moxie.swf',
        // Silverlight settings
        silverlight_xap_url: './plupload/Moxie.xap',
        init: {
            FileFiltered: function (uploader, file) {
                var ext = ['.avi', '.f4v', '.mpg', '.mp4', '.flv', '.wmv', '.mov', '.3gp', '.rmvb', '.rm', '.mkv', '.asf', '.ts', '.mts', '.dat', '.vob', '.mp3', '.wav', '.m4v', '.webm'];
                var type = file['name'].substr(file['name'].lastIndexOf('.')).toLowerCase();
                if (ext.indexOf(type) == -1) {  //判断文件扩展名是否有效  
                }
                //更新ui 添加选择的文件 略
            },
            UploadProgress: function (uploader, file) {  //文件上传百分比
            },
            QueueChanged: function (uploader, file) {
                changeTotal();
            },
            FileUploaded: function (uploader, file, responseObject) {  //文件上传完成
                $('#status_' + file['id']).html('<span class="text-success">上传完成</span>');
                var rst = $.parseJSON(responseObject.response);
                if ( rst && rst.Flag == 100 && rst.location) {
                    //视频上传完成  你可以调用异步接口 保存信息  
                    //需要在此处调用 设置视频分类接口 把该视频分配给指定的子公司  参见 RoomVideo.addVodCaseTask  接口  
                    //视频url：rst.locatio   视频文件名 file.name
                    console.log("upload done", {res_url: rst.location, file_name: file.name});
                }
            },
            ChunkUploaded: function (uploader, file, responseObject) {
                if (responseObject.status != 200) {  //检查分片上传是否成功
                }
                var rst = $.parseJSON(responseObject.response);
                if ( rst && rst.Flag != 100) {
                }
            },
            FilesRemoved: function (uploader, file) {  //移除文件
            }
        }
    });
    uploaderObj.init(); //初始化

```

# 视频上传相关接口


## 获取视频上传授权(getUploadAuthParams)

请求方式 GET POST 需要认证

获取视频上传认证参数 需要总公司或子公司权限

获取到的认证参数用于视频上传接口 [demo GitHub](https://github.com/aodianyunGroup/financeApiDoc/demo/upload)

视频上传完成之后需要调用 RoomVideo.addVodCaseTask 接口把视频分配给指定的子公司

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomVideo/cutReplayOpMic" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomVideo/cutReplayOpMic',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户id              |
| expires             | `int`  授权信息有效期 单位为秒 上传期间需要一直有效 默认24小时   |


> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "获取成功",
    "Info": {
        "access_id": "xxxx",
        "expires": xxxx,
        "signature": "xxxx",
        "signature_nonce": "706"
    }
}
```

## 分配上传视频(addVodCaseTask)

请求方式 GET POST 需要认证

分配上传完成的视频给指定的子公司 需要子公司或总公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomVideo/cutReplayOpMic" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomVideo/cutReplayOpMic',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户id              |
| res_url             | `string`  视频url 上传完成之口可以获取到   |
| file_name           | `string`  视频文件名  |


> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "设置成功"
}
```
