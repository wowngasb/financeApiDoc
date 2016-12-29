# 房间录制 拉流 点播 RoomVideo

房间录制 拉流 点播 相关操作

## 获取视频列表(getRoomDvrList)

请求方式 GET POST 需要认证

获取房间 Dvr 视频列表

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/getRoomDvrList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/getRoomDvrList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  管理员id                     |
| room_id                | `int`  房间id    |
| uptime                | `array`  获取时间         |
| num               | `int`  每页列表数量        |
| page            | `int`  页数       |
| type                | `string`  视频类型   7DayDvrList 临时存储   DvrList永久存储   UploadVodList上传视频      |

```
{
    "Flag": 100,
    "rows": [
        {
            "url": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",  //视频地址
            "filemtime": 1482981338,                                            
            "app": "dyy_280_902",                                //直播间app号
            "stream": "992b822fa7276761418c1509e78e26a2",        //周播间stream流
            "start": 1482981338,                                 //录制开始时间
            "end": 1482981557,                                   //录制结束时间
            "m3u8": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "duration": 219,
            "thumbnail": "http://cdn.dvr.aodianyun.com/pic/hz-vod/images/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/0/0",
            "size": 22018424,                                 //视频大小
            "width": 540,                                     //宽度
            "height": 360,                                    //高度
            "begin": 0,                   
            "uptime": 1482981727,                             //上传时间
            "id": "58647ff18894efebbb756937",                 
            "vod_file": "dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "room_info": [],
            "room_id": 0,
            "dms_url": "http://127.0.0.1/aae/wis/vod_dms_js.php?room_id=0",
            "desc": "未定义",
            "from_room": {  // 视频录制来源  录制视频才有此字段
            },
            "title": "直播间-录制于20161229",
            "caseName": "未定义",
            "len_str": "3分39秒",
            "create_date": "2016-12-29 11:22:07",
            "stream_url": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "is_living": 0,
            "from_admin": []
        },
        ...
    ]
}

```


## 删除视频(delRoomDvrByUrl)

请求方式 GET POST 需要认证

根据url删除视频

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/delRoomDvrByUrl" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/delRoomDvrByUrl',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  管理员id                     |
| url               | `array`  视频url地址        |
| page            | `int`  页数       |
| type                | `string`  视频类型   7DayDvrList 临时存储   DvrList永久存储   UploadVodList上传视频      |

```
{
    "Flag": 100,
    "FlagString": "删除处理成功"
}

```


## 同步到永久存储(sync7DayDvrListToStable)

请求方式 GET POST 需要认证

同步7日临时存储视屏到永久存储
```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/sync7DayDvrListToStable" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/sync7DayDvrListToStable',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  管理员id                     |
| url               | `array`  视频url地址        |

```
{
	Flag: 100, 
	FlagString: "本次总共1个,同步成功1个"
}

```


## 切断房间当前录制流(replayRoomVodByRoomId)

请求方式 GET POST 需要认证

指定房间的切断当前流 重新进行录制

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/replayRoomVodByRoomId" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/replayRoomVodByRoomId',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |

```
{
    "Flag": 100,
    "FlagString": "录制成功",
    "Info": {
        "file": "dyy_280_902.992b822fa7276761418c1509e78e26a2.1482988700.m3u8"
    }
}

```


## 获取Lss app流量信息(getAppBandWidthInfo)

请求方式 GET POST 需要认证

获取Lss app流量相关信息  需要自身或所属总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/getAppBandWidthInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/getAppBandWidthInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  管理员id                     |
| days             | `int`  天数                     |

```
{
    "Flag": 100,
    "FlagString": "search success",
    "List": {   
        "type": [         //流量类型
            "sum",            
            "play",       
            "publish",    
            "mobile"
        ],
        "data": {
            "4943056": {
                "uptime": 1482916800,      //时间戳
                "sum": 0.000537109375,     //总值
                "play": 0.000263671875,    //接收量
                "publish": 0.0002734375,   //发送量
                "mobile": 0
            },
            ...
        },
        "step": 300,
        "time_period": [     数据周期
            1482916800,
            1482991546
        ]
    },
    "TimeRange": [
        1482905146,
        1482991546
    ]
}
```


## 显示子公司拉流列表(listSubAdminLssPullStream)

请求方式 GET POST 需要认证

显示子公司拉流列表  对应流媒体app

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/listSubAdminLssPullStream" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/listSubAdminLssPullStream',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  管理员id                     |
| page             | `int`  页数                     |
| num             | `int`  每页数量                    |

```
{
    "Flag": 100,
    "FlagString": "获取成功",
    "List": [
        {
            "appid": "dyy_281_438",
            "stream": "yygRb",
            "user": "13830",
            "fromList": [
                "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4"
            ],
            "from": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4",
            "status": "pause",
            "concat": "0",
            "createTime": 1482992490,
            "uptime": 1482992518,
            "room": {       //输出到的直播间 基本信息
                "room_id": 74,
            },
            "fromListEx": [       //拉流信息
                {
                    "url": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "title": "盗墓笔记TC1280高清中字",
                    "ucode": "5a92a1423052fb70d10801f74b6bc76a",
                    "duration": 7265.708333,
                    "thumbnail": "http://cdn.dvr.aodianyun.com/pic/long-vod/u/13830/images/4bb920d180af9f7f1813c10a7d5c398a/0/0",  // 缩略图
                    "size": 1299583067,
                    "width": 800,
                    "height": 480,
                }
            ]
        }
    ]
}
```

## 添加视频到房间的拉流列表(addRoomPullStreamList)

请求方式 GET POST 需要认证

添加多个视频到指定房间的拉流列表 需要所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/addRoomPullStreamList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/addRoomPullStreamList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |
| from             | `array`  视频播放地址，用于添加到拉流列表 为空时删除当前拉流并清空缓存列表                     |
| autoPlay             | `int`  是否自动播放(1是 0否)                     |
| runCount             | `int`  循环次数(0无限循环)                     |
| concat             | `int`  是否无缝播放(1是 0否)                     |
|try                  | `string`   出错是否重试 (默认 on_error)         |


```
{
	Flag: 100, 
	FlagString: "设置拉流成功", 
	Info: 
	{
	    Flag: 100, 
	    FlagString: "拉流列表设置成功"
    }

}

```


## 删除房间的拉流列表(delRoomPullStream)

请求方式 GET POST 需要认证

删除指定房间的拉流列表 需要所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/delRoomPullStream" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/delRoomPullStream',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |
```
{
	Flag: 100, 
	FlagString: "删除拉流成功"
}

```


## 暂停房间的拉流列表(pauseRoomPullStream)

请求方式 GET POST 需要认证

暂停指定房间的拉流列表 需要所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/pauseRoomPullStream" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/pauseRoomPullStream',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |
```
{
	Flag: 100, 
	FlagString: "设置拉流成功"
}

```

## 播放房间的拉流列表(playRoomPullStream)

请求方式 GET POST 需要认证

播放指定房间的拉流列表 需要所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/playRoomPullStream" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/playRoomPullStream',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |
```
{
	Flag: 100, 
	FlagString: "设置拉流成功"
}

```


## 停止房间视频发布(cutReplayOpMic)

请求方式 GET POST 需要认证

停止指定房间的视频发布 需要所属子公司权限
```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/cutReplayOpMic" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/cutReplayOpMic',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间id                     |
```
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```