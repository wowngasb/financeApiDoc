# 房间管理 RoomMgr

房间管理相关操作，子公司可以操作其下属的房间，总公司可以操作旗下所有子公司的房间

## 新建房间（newCaiJingRoom）

新建房间 请求方式 POST 需要认证

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomMgr/newCaiJingRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomMgr/newCaiJingRoom',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| -------------------- | ------------------------------------------------ |
| room_title          | `string`  房间标题 可选  默认为 房间 + room_id              |
| cover_pic           | `string`  视频封面图片  可选  默认为空             |
| mcs_name          | `string`  直播工具mcs登录帐号  可选  默认为随机的 dyy + rand(10000, 199999999)              |
| mcs_pwd           | `string`  直播工具mcs登录密码  可选  默认为123456               |
| mps_id             |  `int`  MPS播放器样式id lss_player_type为mps时有效  可选  默认为基本样式id     |
| lss_player_type       | `string` 播放器类型（aodianplayer、mps） 可选 默认为aodianplayer        |
| admin_id           | `int`  保留参数一般不需要设置 可选 默认为 0        |
| stream             | `string`  房间流地址 可选 默认为空表示使用随机值 全局唯一不可重复                     |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "新建房间成功",
    "Info": {
        "room_id": 100236,  // 房间ID
        // 其他数据
    }
}
```

## 修改MCS直播账号（bindRoomWithMcsAccount）

请求方式 POST 需要认证

修改指定房间[MCS直播发布工具](http://www.aodianyun.com/aodianyun_doc/298)的帐号密码，帐号是全局唯一的。

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomMgr/bindRoomWithMcsAccount" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomMgr/bindRoomWithMcsAccount',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| mcs_name           | `string`  登录帐号  6-18位数字字母组合，"/^[0-9a-zA-Z]{6,18}$/i"     |
| mcs_pwd            | `string`   登录密码  6-18位数字字母组合，"/^[0-9a-zA-Z]{6,18}$/i"          |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "设置MCS成功"
}
```

## 获取当前房间人数（getRoomDmsUserCount）

请求方式 GET POST 不需要认证

获取房间 实时在线人数

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomMgr/getRoomDmsUserCount" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomMgr/getRoomDmsUserCount',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |

> 返回结果如下:


```json
{
    "Flag": 100,
    "FlagString": "获取数据成功",
    "Total": 2
}
```

## 获取房间流媒体信息（getRoomLssInfo）

请求方式 GET POST 不需要认证

获取房间 流媒体 相关信息

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomMgr/getRoomLssInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomMgr/getRoomLssInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取数据成功",
    "Info": {
        "admin_id": 7,
        "aodian_id": 13830,
        "cover_pic": "http://static.douyalive.com/images/my_147141392965877.png",
        "dms_app": "dyy_7_221",
        "dms_pub_key": "pub_df6f4a4ef6fcb81edfe45cae48aa577f",
        "dms_sub_key": "sub_43718b49407c2c49385fb224862f91ae",
        "dms_total": 0,
        "hls_url": "http://13830.hlsplay.aodianyun.com/dyy_7_221/aajie.m3u8",
        "live_state": 0,
        "lssPublishAddr": "rtmp://13830.lsspublish.aodianyun.com/dyy_7_221/aajie",
        "lss_app": "dyy_7_221",
        "lss_player_stretching": 2,
        "lss_player_type": "mps",
        "mcs_id": 518,
        "mps_id": 438,
        "mps_instance_id": "f1BHzbBBH16UWXiS",
        "room_id": 1000,
        "rtmp_url": "rtmp://13830.lssplay.aodianyun.com/dyy_7_221/aajie",
        "state": 9,
        "stream": "aajie",
        "topic": "chat_1000",
        "video_type": 1,
        "vod_case": "",
        "vod_file": "",
        "vod_room_id": 0,
        "vod_url": "",
        "wis_id": ""
    }
}
```

