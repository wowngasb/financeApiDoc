# 教育模板操作 JiaoYuUserInfo

教育模板相关操作

## 获取消息列表(listMsgReview)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listMsgReview',
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
| sort_option            | `array`  排序字段 ['field' => 'id', 'direction' => 'decs']       |
```
{
    "Flag": 100,
    "rows": [
        {
            "cmd": "question",     //消息类型
            "uid": "YK-11804",     //用户uid
            "nick": "游客",        
            "ava": "/dist/dyy/view/jiaoyu/mobile/images/male.png",
            "content": "地瓜干",   //发送内容
            "room_id": 73,         //房间id
            "time": 1480576896,    
            "state": 1,           //状态 0未定义 1存入 2已发布 8清空  9删除 
            "msg_id": 75,          //消息id
            "msg_from": null
        },
        ...
    ],
    "results": 2
}

```

## 后台审核 发布 dms 消息(dmsMsgReview)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/dmsMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/dmsMsgReview',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| msg_id               | `int`  消息唯一标识     |
| state               | `int`  2 发布  9 删除    |

```
{
    "Flag": 100,
    "FlagString": "退出成功"
}

```


## 获取教育模版 文档列表(listWisDoc)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listWisDoc" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listWisDoc',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| page               | `int`  页数     |
| num               | `int`  每页数量    |

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": {
        "list": [
            {
                "fileName": "qq.pptx",           //文档文件名
                "url": "http://1436.long-vod.cdn.aodianyun.com/mfs/1436/wis/0x0/0ae67e448f46beba410bd478712782c9.pptx", //文档地址
                "pdfUrl": "http://1436.long-vod.cdn.aodianyun.com/mfs/1436/wis/0x0/170fc0ca0d6645192f315ab2856c73f7.pdf",
                //文档pdf地址
                "page": 3,
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

## 后台审核 发布 dms 消息(delMsgReview)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/delMsgReview" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/delMsgReview',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |


```
{
    "Flag": 100,
    "FlagString": "删除成功"
}

```


## 获取单条白板录制信息(getWisRecordInfo)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/getWisRecordInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/getWisRecordInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| recordId             | `string`  录制id                     |

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


## 删除教育模版(delWisDoc)

请求方式 GET POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/delWisDoc" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/delWisDoc',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| token             | `string`  认证token                     |
| doc_id             | `int`  文档id                    |

```
{
    "Flag": 100,
    "FlagString": "success",
    "Info": null
}
```
