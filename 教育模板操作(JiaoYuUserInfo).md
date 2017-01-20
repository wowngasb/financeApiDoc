# 教育模板操作 JiaoYuUserInfo

教育模板相关操作 相关操作需要使用 `RoomMgr`模块`getAuthToken`接口 获取token

## 待审核消息列表(listMsgReview)

请求方式 GET POST 需要认证

待审核消息列表  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/listMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/listMsgReview',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| uid                | `int`  发送者uid    |
| msg_id                | `int`  消息唯一标识         |
| msg_cmd               | `string`  消息命令类型        |
| state            | `int`  2 发布，9 删除       |
| create_time_s                | `string`  获取某时间段内评论的开始时间点         |
| create_time_e               | `string`   获取某时间段内评论的结束时间点        |
| update_s            | `string`        记录更新开始时间 |
| update_e               | `string`  记录更新结束时间        |
| start            | `int`  查询开始位置      |
| limit               | `string`  每页数据条数        |
| sort_option            | `array`  排序字段  默认 'field' => 'id', 'direction' => 'decs'       |
> 返回结果如下:

```
{
    "Flag": 100,
    "rows": [
        {
            "cmd": "question",     //消息类型
            "uid": "YK-11804",     //用户uid
            "nick": "游客",        
            "ava": "/dist/dyy/view/jiaoyu/mobile/images/male.png",  //用户头像
            "content": "地瓜干",   //发送内容
            "room_id": 73,         //房间id
            "time": 1480576896,    
            "state": 1,           //状态 1待审核 2已发布 8清空  9删除 
            "msg_id": 75,          //消息id
            "msg_from": null
        },
        ...
    ],
    "results": 2  //消息总数
}

```

## 后台审核消息(dmsMsgReview)

请求方式 GET POST 需要认证

后台审核发布聊天消息  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/dmsMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/dmsMsgReview',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| msg_id               | `int`  消息唯一标识     |
| state               | `int`  2 发布  9 删除    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "审核成功"
}

```

## 清空待审核消息(delMsgReview)

请求方式 GET POST 需要认证

清空待审核聊天消息  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/delMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/delMsgReview',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "删除成功"
}
```


## 获取文档列表(listWisDoc)

请求方式 GET POST 需要认证

获取教育模版 文档列表  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/listWisDoc" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/listWisDoc',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| page               | `int`  页数     |
| num               | `int`  每页数量    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": {
        "list": [
            {
                "fileName": "qq.pptx",           //文档文件名
                "url": "http://1436.long-vod.cdn.aodianyun.com/mfs/1436/wis/0x0/0ae67e448f46beba410bd478712782c9.pptx", //文档地址
                "pdfUrl": "http://1436.long-vod.cdn.aodianyun.com/mfs/1436/wis/0x0/170fc0ca0d6645192f315ab2856c73f7.pdf",  //文档pdf地址
                "page": 3,  //文档总页数
                "time": 1480576051,          //文档创建时间
                "width": 720,                //文档宽度
                "height": 540,               //文档高度
                "id": "65da1fde9a84617e2c33671d795347d0"   //文档id
            },
            ...
        ]
    }
}

```

## 删除文档(delWisDoc)

请求方式 GET POST 需要认证

删除文档  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/delWisDoc" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/delWisDoc',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| doc_id             | `int`  文档id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": null
}
```



## 上传文档(uploadWisDoc)

请求方式 GET POST 需要认证

上传文档  需要token认证

目前支持文档格式 'png', 'jpg', 'pdf', 'ppt', 'pptx', 'doc', 'docx', 'xls', 'xlsx', 文档大小需要小于20M

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/uploadWisDoc" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/uploadWisDoc',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| file_name         | `string`  文档文件名 支持格式 'pdf', 'ppt', 'pptx', 'doc', 'docx', 'xls', 'xlsx',    |
| file_contents      | `string`  文档文件base64编码后的内容       |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": null
}
```


## 白板录制列表（listWisReplay）

请求方式 GET POST 需要认证

获取教育房间 白板录制节目列表  需要token认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/listWisReplay" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/listWisReplay',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| page               | `int`    页数                      |
| num                | `int`    每页数量                   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "success",
    "Info": [
      {
          "id": "70fa43d93802056a34b45e30cb4bc3f3",  //录制id
          "wisId": "lc_51b33821af8688197b328bc18ea0d6f4",  
          "title": "2016-11-11 04:51:41",  //录制文件标题
          "videoUrl": "http://13830.live-vod.cdn.aodianyun.com/m3u8/0x0/dyy_168_850.0d2b7152b0a2bf430a8c66fd6363070f.1478854302/dyy_168_850.0d2b7152b0a2bf430a8c66fd6363070f.1478854302.m3u8",  //录制生成视频文件 m3u8
          "recUrl": "http://4640.long-vod.cdn.aodianyun.com/wis/13830/70fa43d93802056a34b45e30cb4bc3f3/record.meta",  //录制生成白板数据文件
          "startTime": 1478854301820,  //录制开始时间 单位毫秒
          "endTime": 1478854513075  //录制结束时间 单位毫秒
      },
      ......
    ]
}
```


## 获取录制信息(getWisRecordInfo)

请求方式 GET POST 需要认证

获取单条白板录制节目信息

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/getWisRecordInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/getWisRecordInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| recordId             | `string`  录制id                     |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": {
        "endTime": 1480576636112,                //录制结束时间
        "id": "02041b3dc93ae654094d7817d737f06c",   //录制id
        "recUrl": "http://4640.long-vod.cdn.aodianyun.com/wis/1436/02041b3dc93ae654094d7817d737f06c/record.meta",   
        "startTime": 1480576257062,  //录制开始时间
        "title": "2016-12-01 03:10:57",
        "videoUrl": "http://1436.live-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.ff04257eb2edfb28f52efeb738d6ca17.1480576257/dyy_280_902.ff04257eb2edfb28f52efeb738d6ca17.1480576257.m3u8",   //录制视频地址
        "wisId": "lc_a9d7afff8f53ec7cc954c9f726d70195"
    }
}
```

## 获取启动命令行(getWisPublishShell)

请求方式 GET POST 需要认证

获取网页启动发布工具命令行 需安装白板发布工具 跳过MCS帐号登陆

```shell
curl -X "POST" "http://finance.aodianyun.com/api/JiaoYuUserInfo/getWisPublishShell" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/JiaoYuUserInfo/getWisPublishShell',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| token              | `string`  认证token                     |
| ChatUrl              | `string`  软件内嵌网页地址 为空表示使用默认页面       |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "room_id": 73,
        "auth": {  // 用户相关信息
            "room_id": 73,
            "uid": "10156412",
            "nick": "李老师",
            "ava": "http://test25.aodianyun.com/dist/dyy/assets/img/male.png",
            "ext": "",
            "_cache_": 1483414931,
            "_uptime_": 1483414939
        },
        "wis_shell": "wis://wis.aodianyun.com?params=eyJNYXhPdwMH0=",   //启动链接 放入网页a标签中 点击即可启动软件
        "mcs_config": {  //MCS 视频发布相关参数  参见 getRoomMcsConfig 接口
        }
    }
}
```
