# 房间视频管理 RoomVideo

房间上传视频、自动录制、点播视频、直播拉流 相关操作

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
| --------------------- | ------------------------------------------------ |
| admin_id          | `int`  子公司id                     |
| room_id           | `int`  房间id    |
| uptime            | `array`  获取时间   时间戳 格式为[开始时间，结束时间]      |
| num              | `int`  每页列表数量        |
| page             | `int`  页数       |
| type              | `string`  视频类型   7DayDvrList 临时存储   DvrList永久存储   UploadVodList上传视频      |

```
{
    "Flag": 100,
    "rows": [
        {
            "url": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",  //视频地址url  全局唯一
            "filemtime": 1482981338,   //文件修改时间
            "app": "dyy_280_902",    //流媒体 app
            "stream": "992b822fa7276761418c1509e78e26a2",   //流媒体stream流
            "start": 1482981338,  //录制开始时间
            "end": 1482981557,  //录制结束时间
            "m3u8": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_981338.m3u8",  //视频m3u8地址
            "duration": 219,
            "thumbnail": "http://cdn.dvr.aodianyun.com/pic/hz-vod/images/dyy_2981338/0/0",   //视频封面图
            "size": 22018424,//视频大小
            "width": 540,    //宽度
            "height": 360,   //高度
            "begin": 0,
            "uptime": 1482981727,   //更新时间
            "id": "58647ff18894efebbb756937",
            "vod_file": "dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "room_info": [],   // 点播房间相关信息  如未创建点播房间 不存在
            "room_id": 0,
            "desc": "未定义",
            "from_room": {},    // 视频录制来源  直播录制视频才有此字段
            "title": "直播间-录制于20161229",
            "caseName": "未定义",
            "len_str": "3分39秒",
            "create_date": "2016-12-29 11:22:07",
            "stream_url": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "is_living": 0,
            "from_admin": []  // 来源 子公司
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
| admin_id          | `int`  子公司id     为空表示使用当前admin_id         |
| url               | `array`  视频url地址  可以同时删除多个      |
| type             | `string`  视频类型   7DayDvrList 临时存储   DvrList永久存储   UploadVodList上传视频      |

```
{
    "Flag": 100,
    "FlagString": "删除处理成功"
}
```

## 同步到永久存储(sync7DayDvrListToStable)

请求方式 GET POST 需要认证

同步7日临时存储视频到永久存储

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
| admin_id           | `int`  子公司id                     |
| url               | `array`  视频url地址        |

```
{
	Flag: 100, 
	FlagString: "本次总共1个,同步成功1个"
}

```


## 切断房间当前录制流(replayRoomVodByRoomId)

请求方式 GET POST 需要认证

针对正在直播的房间 结束当前录制文件  重新生成录制文件

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
        "file": "dyy_280_902.992b822fa7276761418c1509e78e26a2.1482988700.m3u8"  // 上一个录制的文件名
    }
}

```


## 查询直播带宽(listAppBandWidthInfo)

请求方式 GET POST 需要认证

获取Lss 流媒体 app带宽历史信息   支持查询90天内的数据  需要子公司自身或所属总公司权限 

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/listAppBandWidthInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/listAppBandWidthInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司id                     |
| stime             | `int`  开始时间戳              |
| etime             | `int`  结束时间戳                 |

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
            "4943056": {   // 每个 key * step 为记录的时间戳  数据单位为 Mbps
                "uptime": 1482916800,      //时间戳
                "sum": 0.000537109375,     //总值
                "play": 0.000263671875,    //pc端观看量
                "publish": 0.0002734375,   //发布占用量
                "mobile": 0    //手机端观看量
            },
            ...
        },
        "step": 300,  // 时间间隔
        "time_period": [     //数据范围
            1482916800,
            1482991546
        ]
    },
    "TimeRange": [   // 查询输入的时间戳范围
        1482905146,
        1482991546
    ]
}
```

## 查询直播流量(listAppFlowInfo)

请求方式 GET POST 需要认证

获取Lss 流媒体 app流量历史信息   支持查询90天内的数据  需要子公司自身或所属总公司权限 

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomVideo/listAppFlowInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomVideo/listAppFlowInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司id                     |
| stime             | `int`  开始时间戳              |
| etime             | `int`  结束时间戳                 |

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
            "4943056": {   // 每个 key * step 为记录的时间戳  数据单位为 MB
                "uptime": 1482916800,      //时间戳
                "sum": 93.75234,     //总值
                "play": 87.5234,    //pc端观看量
                "publish": 3.75234,   //发布占用量
                "mobile": 3.4687    //手机端观看量
            },
            ...
        },
        "step": 300,  // 时间间隔
        "time_period": [     //数据范围
            1482916800,
            1482991546
        ]
    },
    "TimeRange": [   // 查询输入的时间戳范围
        1482905146,
        1482991546
    ]
}
```


## 获取拉流列表(listSubAdminLssPullStream)

请求方式 GET POST 需要认证

获取拉流列表子公司拉流列表  对应流媒体app  需要子公司自身或所属总公司权限 

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
| admin_id             | `int`  子公司id                     |
| page             | `int`  页数    默认为 1                 |
| num             | `int`  每页数量      默认为 100              |

```
{
    "Flag": 100,
    "FlagString": "获取成功",
    "List": [
        {
            "appid": "dyy_281_438",
            "stream": "yygRb",
            "user": "13830",
            "fromList": [   //拉流地址列表
                "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/d180af9f7f1813c10a7d5c398a.mp4"
            ],
            "from": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/80af9f7f1813c10a7d5c398a.mp4",
            "status": "pause",
            "concat": "0",
            "createTime": 1482992490,
            "uptime": 1482992518,
            "room": {       //输出到的直播间 参见房间基本信息
                "room_id": 74,
            },
            "fromListEx": [   //拉流地址列表 扩展信息
                {
                    "url": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d0af9f7f1813c10a7d5c398a.mp4",
                    "title": "C1280高清中字",
                    "ucode": "5a92a1423052fb70d10801f74b6bc76a",
                    "duration": 7265.708333,
                    "thumbnail": "http://cdn.dvr.aodianyun.com/pic/long-vod/u/13830/images/4bb9200a7f1813c10a7d5c398a/0/0",  // 缩略图
                    "size": 1299583067,
                    "width": 800,
                    "height": 480,
                }
            ]
        }
    ]
}
```

## 设置拉流(addRoomPullStreamList)

请求方式 GET POST 需要认证

添加多个视频到指定房间的拉流列表 对应流媒体app  需要子公司自身或所属总公司权限 

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
| from                | `array`  视频播放地址，用于添加到拉流列表 为空时删除当前拉流并清空缓存列表  每一个都应该是一个视频url        |
| autoPlay            | `int`  是否自动播放(1是 0否)                     |
| runCount           | `int`  循环次数(范围1-100， 0无限循环)                     |
| concat              | `int`  是否无缝播放(1是 0否)                     |


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


## 删除拉流(delRoomPullStream)

请求方式 GET POST 需要认证

删除指定房间的拉流列表 对应流媒体app  需要子公司自身或所属总公司权限 

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


## 暂停拉流(pauseRoomPullStream)

请求方式 GET POST 需要认证

暂停指定房间的拉流列表 需要子公司自身或所属总公司权限 

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

## 播放拉流(playRoomPullStream)

请求方式 GET POST 需要认证

播放指定房间的拉流列表 需要子公司自身或所属总公司权限 

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