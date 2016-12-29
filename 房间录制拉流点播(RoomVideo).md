# 房间录制 拉流 点播 RoomVideo

房间录制 拉流 点播 相关操作

##获取房间 Dvr 视频列表(getRoomDvrList)

请求方式 GET POST 需要认证

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
| type                | `string`  视屏类型   7DayDvrList 临时存储   DvrList永久存储   UploadVodList上传视频      |

```
{
    "Flag": 100,
    "rows": [
        {
            "url": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",  //视屏地址
            "filemtime": 1482981338,                                            
            "app": "dyy_280_902",                                //直播间app号
            "stream": "992b822fa7276761418c1509e78e26a2",        //周播间stream流
            "start": 1482981338,                                 //录制开始时间
            "end": 1482981557,                                   //录制结束时间
            "m3u8": "http://hz-vod.cdn.aodianyun.com/m3u8/0x0/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338.m3u8",
            "duration": 219,
            "thumbnail": "http://cdn.dvr.aodianyun.com/pic/hz-vod/images/dyy_280_902.992b822fa7276761418c1509e78e26a2.1482981338/0/0",
            "size": 22018424,                                 //视屏大小
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
            "from_room": {
                "room_id": 93,
                "admin_id": 280,
                "state": 1,
                "viewer_count": 6,
                "viewer_max": 4,
                "room_title": "直播间",
                "stream": "992b822fa7276761418c1509e78e26a2",
                "create_time": "2016-12-14 10:37:26",
                "live_state": 1,
                "owner_id": 0,
                "ctrl_enter": 0,
                "ctrl_enter_pwd": "",
                "ctrl_enter_p_u": 0,
                "wis_guest_pwd": null,
                "wis_ctrl_pwd": null,
                "wis_id": "lc_e6969aae2c635b5d64cffb4a48dfdd4d",
                "wis_record_id": null,
                "wis_record_start": null,
                "wis_record_end": null,
                "wis_key": "2c0c42c42057eab44ea805c55d66a7bd",
                "is_pullstream": 0,
                "is_replay": 0,
                "is_lcps": 0,
                "is_checkchat": 0,
                "video_type": 1,
                "vod_url": null,
                "vod_file": null,
                "vod_room_id": 0,
                "chat_filter_keys": null,
                "view_filter_ips": null,
                "cover_pic": "http://test25.aodianyun.com/aae/dyy/assets/img/play_bj.png",
                "background_pic": null,
                "hall_pic": null,
                "notice": null,
                "roomtype": 0,
                "viewlimit": 0,
                "expireDay": 0,
                "viewlimit_vip": 0,
                "ctrl_view_pwd": null,
                "ctrl_view": 0,
                "ctrl_qas": 0,
                "ctrl_sysmsg": 1,
                "ctrl_share": 0,
                "ctrl_chat": 0,
                "mcs_name": "dyy55787644",
                "mcs_id": 15136,
                "mcs_pwd": "123456",
                "lss_player_maxbufferlength": 2,
                "lss_player_bufferlength": 1,
                "lss_player_stretching": 2,
                "lss_player_type": "mps",
                "mps_id": 36,
                "mps_instance_id": "fm6N3H3BNu1PQWii",
                "uptime": "2016-12-29 11:19:19",
                "admin_title": "测试专用",
                "admin_email": null,
                "admin_name": "sdk_test",
                "dms_app": "dyy_280_902",
                "vod_case": "583e7b83f1393ae65aa3cfb4",
                "dms_id": 11298,
                "dms_pub_key": "pub_88eaeb2b53ba96a733a4f59c2380b891",
                "dms_sub_key": "sub_0158d96013930339991b6f55dfc61e2b",
                "dms_s_key": "s_72e14fc19ea45db1ebdb7fd65750a6b7",
                "access_id": "418318687069",
                "access_key": "17k0Id421f8eKJUg51al3hreyI75mdzJ",
                "lss_app": "dyy_280_902",
                "aodian_id": 1436,
                "topic": "chat_93",
                "rtmp_url": "rtmp://1436.lssplay.aodianyun.com/dyy_280_902/992b822fa7276761418c1509e78e26a2",
                "lssPublishAddr": "rtmp://1436.lsspublish.aodianyun.com/dyy_280_902/992b822fa7276761418c1509e78e26a2",
                "hls_url": "http://1436.hlsplay.aodianyun.com/dyy_280_902/992b822fa7276761418c1509e78e26a2.m3u8",
                "userlist_api": "/api/RoomMgr/getDmsUserList?room_id=93",
                "dms_url": "/helper/dms_user.js?id=93&chat=1",
                "room_player": "/helper/room_player.js?r=93",
                "publish_tool": "http://download.kkyoo.com/aodianyun/mcs_setup1.4.16.1.exe",
                "mps_list": [
                    {
                        "mps_id": "36",
                        "name": "默认播放器"
                    },
                    {
                        "mps_id": 1587,
                        "name": "测试"
                    },
                    {
                        "mps_id": 1593,
                        "name": "ghjkhk"
                    }
                ],
                "view_url": "http://test25.aodianyun.com/glive/93",
                "dms_total": 1,
                "_uptime_": 1482982004
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


##根据url删除视频(delRoomDvrByUrl)

请求方式 GET POST 需要认证

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


##同步7日临时存储视屏到永久存储(sync7DayDvrListToStable)

请求方式 GET POST 需要认证

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
| url               | `array`  视屏url地址        |

```
{
	Flag: 100, 
	FlagString: "本次总共1个,同步成功1个"
}

```


##指定房间的切断当前流 重新进行录制(replayRoomVodByRoomId)

请求方式 GET POST 需要认证

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


##获取Lss app流量相关信息需要自身或所属总公司权限(getAppBandWidthInfo)

请求方式 GET POST 需要认证

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


##显示子公司拉流列表  对应流媒体app(listSubAdminLssPullStream)

请求方式 GET POST 需要认证

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
            "room": {       //直播间信息
                "room_id": 74,
                "admin_id": 281,
                "state": 1,
                "viewer_count": 52,
                "viewer_max": 2,
                "room_title": "财经一号",
                "stream": "yygRb",
                "create_time": "2016-11-30 16:23:16",
                "live_state": 1,
                "owner_id": 0,
                "ctrl_enter": 0,
                "ctrl_enter_pwd": "",
                "ctrl_enter_p_u": 0,
                "wis_guest_pwd": null,
                "wis_ctrl_pwd": null,
                "wis_id": "",
                "wis_record_id": null,
                "wis_record_start": null,
                "wis_record_end": null,
                "wis_key": "",
                "is_pullstream": 0,
                "is_replay": 0,
                "is_lcps": 0,
                "is_checkchat": 0,
                "video_type": 1,
                "vod_url": null,
                "vod_file": null,
                "vod_room_id": 0,
                "chat_filter_keys": null,
                "view_filter_ips": null,
                "cover_pic": "http://my.app/aae/dyy/assets/img/play_bj.png",
                "background_pic": "",
                "hall_pic": null,
                "notice": "",
                "roomtype": 0,
                "viewlimit": 0,
                "expireDay": 0,
                "viewlimit_vip": 0,
                "ctrl_view_pwd": null,
                "ctrl_view": 0,
                "ctrl_qas": 0,
                "ctrl_sysmsg": 1,
                "ctrl_share": 0,
                "ctrl_chat": 9,
                "mcs_name": "dyy105174419",
                "mcs_id": 3895,
                "mcs_pwd": "123456",
                "lss_player_maxbufferlength": 2,
                "lss_player_bufferlength": 1,
                "lss_player_stretching": 2,
                "lss_player_type": "mps",
                "mps_id": 438,
                "mps_instance_id": "fN1Humm1116UPixX",
                "uptime": "2016-12-29 14:21:58",
                "admin_title": "子公司一号",
                "admin_email": null,
                "admin_name": "subAdmin",
                "dms_app": "dyy_281_438",
                "vod_case": "583e8194f1393a057ba3cfb4",
                "dms_id": 11300,
                "dms_pub_key": "pub_5bfb7a0ced7adb2ce454575747762679",
                "dms_sub_key": "sub_eae37e48dab5f305516d07788eaaea60",
                "dms_s_key": "s_ceb80d29276f78653df081e5a9f0ac76",
                "access_id": "111576745758",
                "access_key": "fVYGq1S0gnrvoxZv77msq577jx7MQq3n",
                "lss_app": "dyy_281_438",
                "aodian_id": 13830,
                "topic": "chat_74",
                "rtmp_url": "rtmp://13830.lssplay.aodianyun.com/dyy_281_438/yygRb",
                "lssPublishAddr": "rtmp://13830.lsspublish.aodianyun.com/dyy_281_438/yygRb",
                "hls_url": "http://13830.hlsplay.aodianyun.com/dyy_281_438/yygRb.m3u8",
                "userlist_api": "/api/RoomMgr/getDmsUserList?room_id=74",
                "dms_url": "/helper/dms_user.js?id=74&chat=1",
                "room_player": "/helper/room_player.js?r=74",
                "publish_tool": "http://download.kkyoo.com/aodianyun/mcs_setup1.4.16.1.exe",
                "mps_list": [
                    {
                        "mps_id": "438",
                        "name": "默认播放器"
                    }
                ],
                "view_url": "http://127.0.0.1/slive/74",
                "dms_total": 1,
                "_uptime_": 1482992519
            },
            "fromListEx": [       //拉流信息
                {
                    "url": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "title": "盗墓笔记TC1280高清中字",
                    "ucode": "5a92a1423052fb70d10801f74b6bc76a",
                    "duration": 7265.708333,
                    "thumbnail": "http://cdn.dvr.aodianyun.com/pic/long-vod/u/13830/images/4bb920d180af9f7f1813c10a7d5c398a/0/0",
                    "size": 1299583067,
                    "width": 800,
                    "height": 480,
                    "uptime": 1482725658,
                    "case": "583e8194f1393a057ba3cfb4",
                    "mp4_240": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/426x240/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "mp4Size_240": 395943434,
                    "m3u8_240": "http://13830.long-vod.cdn.aodianyun.com/u/13830/m3u8/426x240/4bb920d180af9f7f1813c10a7d5c398a/4bb920d180af9f7f1813c10a7d5c398a.m3u8",
                    "m3u8Size_240": 456198899,
                    "adaptive": "http://13830.long-vod.cdn.aodianyun.com/u/13830/m3u8/adaptive/4bb920d180af9f7f1813c10a7d5c398a.m3u8",
                    "mp4_360": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/640x360/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "mp4Size_360": 669145983,
                    "mp4_480": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/854x480/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "mp4Size_480": 850781555,
                    "m3u8_480": "http://13830.long-vod.cdn.aodianyun.com/u/13830/m3u8/854x480/4bb920d180af9f7f1813c10a7d5c398a/4bb920d180af9f7f1813c10a7d5c398a.m3u8",
                    "m3u8Size_480": 947382927,
                    "m3u8_360": "http://13830.long-vod.cdn.aodianyun.com/u/13830/m3u8/640x360/4bb920d180af9f7f1813c10a7d5c398a/4bb920d180af9f7f1813c10a7d5c398a.m3u8",
                    "m3u8Size_360": 751295543,
                    "id": "5860991a8894efebbb4bae76",
                    "desc": "未定义",
                    "caseName": "dyy_281",
                    "drm": 0,
                    "drm_1080": 0,
                    "drm_720": 0,
                    "drm_480": 0,
                    "drm_360": 0,
                    "drm_240": 0,
                    "vod_file": "4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "room_info": {   //房间信息
                        "room_id": 107,
                        "admin_id": 281,
                        "state": 1,
                        "viewer_count": 2,
                        "viewer_max": 0,
                        "room_title": "盗墓笔记TC1280高清中字",
                        "stream": null,
                        "create_time": "2016-12-26 14:55:41",
                        "live_state": 0,
                        "owner_id": 0,
                        "ctrl_enter": 0,
                        "ctrl_enter_pwd": "",
                        "ctrl_enter_p_u": 0,
                        "wis_guest_pwd": null,
                        "wis_ctrl_pwd": null,
                        "wis_id": null,
                        "wis_record_id": null,
                        "wis_record_start": null,
                        "wis_record_end": null,
                        "wis_key": null,
                        "is_pullstream": 0,
                        "is_replay": 0,
                        "is_lcps": 0,
                        "is_checkchat": 1,
                        "video_type": 2,
                        "vod_url": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                        "vod_file": "http://13830.long-vod.cdn.aodianyun.com/u/13830/m3u8/854x480/4bb920d180af9f7f1813c10a7d5c398a/4bb920d180af9f7f1813c10a7d5c398a.m3u8",
                        "vod_room_id": 0,
                        "chat_filter_keys": null,
                        "view_filter_ips": null,
                        "cover_pic": "http://cdn.dvr.aodianyun.com/pic/long-vod/u/13830/images/4bb920d180af9f7f1813c10a7d5c398a/0/0",
                        "background_pic": null,
                        "hall_pic": null,
                        "notice": null,
                        "roomtype": 0,
                        "viewlimit": 0,
                        "expireDay": 0,
                        "viewlimit_vip": 0,
                        "ctrl_view_pwd": null,
                        "ctrl_view": 0,
                        "ctrl_qas": 0,
                        "ctrl_sysmsg": 1,
                        "ctrl_share": 0,
                        "ctrl_chat": 0,
                        "mcs_name": null,
                        "mcs_id": 0,
                        "mcs_pwd": null,
                        "lss_player_maxbufferlength": 2,
                        "lss_player_bufferlength": 1,
                        "lss_player_stretching": 2,
                        "lss_player_type": "mps",
                        "mps_id": null,
                        "mps_instance_id": null,
                        "uptime": "2016-12-29 10:15:34",
                        "admin_title": "子公司一号",
                        "admin_email": null,
                        "admin_name": "subAdmin",
                        "dms_app": "dyy_281_438",
                        "vod_case": "583e8194f1393a057ba3cfb4",
                        "dms_id": 11300,
                        "dms_pub_key": "pub_5bfb7a0ced7adb2ce454575747762679",
                        "dms_sub_key": "sub_eae37e48dab5f305516d07788eaaea60",
                        "dms_s_key": "s_ceb80d29276f78653df081e5a9f0ac76",
                        "access_id": "111576745758",
                        "access_key": "fVYGq1S0gnrvoxZv77msq577jx7MQq3n",
                        "lss_app": "dyy_281_438",
                        "aodian_id": 13830,
                        "topic": "chat_107",
                        "rtmp_url": "rtmp://13830.lssplay.aodianyun.com/dyy_281_438/",
                        "lssPublishAddr": "rtmp://13830.lsspublish.aodianyun.com/dyy_281_438/",
                        "hls_url": "http://13830.hlsplay.aodianyun.com/dyy_281_438/.m3u8",
                        "userlist_api": "/api/RoomMgr/getDmsUserList?room_id=107",
                        "dms_url": "/helper/dms_user.js?id=107&chat=1",
                        "room_player": "/helper/room_player.js?r=107",
                        "publish_tool": "http://download.kkyoo.com/aodianyun/mcs_setup1.4.16.1.exe",
                        "mps_list": [
                            {
                                "mps_id": "438",
                                "name": "默认播放器"
                            }
                        ],
                        "view_url": "http://127.0.0.1/slive/107",
                        "dms_total": 0,
                        "_uptime_": 1482992469
                    },
                    "room_id": 0,
                    "dms_url": "http://127.0.0.1/aae/wis/vod_dms_js.php?room_id=0",
                    "from_room": [],
                    "len_str": "2小时1分5秒",
                    "create_date": "2016-12-26 12:14:18",
                    "stream_url": "http://13830.long-vod.cdn.aodianyun.com/u/13830/mp4/0x0/4bb920d180af9f7f1813c10a7d5c398a.mp4",
                    "is_living": 0,
                    "from_admin": {   //直播间管理员信息
                        "admin_id": 281,
                        "state": 1,
                        "name": "subAdmin",
                        "pasw_time": "2016-11-30 15:36:20",
                        "telephone": null,
                        "realname": null,
                        "title": "子公司一号",
                        "email": null,
                        "login_ip": "180.153.81.203",
                        "login_count": 13,
                        "login_time": "2016-12-28 16:45:40",
                        "access_id": null,
                        "access_key": null,
                        "lss_app": "dyy_281_438",
                        "dms_app": "dyy_281_438",
                        "dms_sub_key": "sub_eae37e48dab5f305516d07788eaaea60",
                        "dms_pub_key": "pub_5bfb7a0ced7adb2ce454575747762679",
                        "dms_s_key": "s_ceb80d29276f78653df081e5a9f0ac76",
                        "aodian_id": null,
                        "dms_id": 11300,
                        "vod_case": "583e8194f1393a057ba3cfb4",
                        "env_config": null,
                        "api_key": "5c52244a3ec8557d72a1eb6fb04da3ca",
                        "parent_id": 180,
                        "autohook_id": 0,
                        "admin_type": "caijing",
                        "limit_type": 0,
                        "limit_bandwidth": 0,
                        "limit_onlinenumber": 0,
                        "limit_bandwidth_ex": 0,
                        "limit_onlinenumber_ex": 0,
                        "limit_weekdays_use_ex": "",
                        "limit_yearflow": 1048576,
                        "limit_yearflow_months": 0,
                        "limit_yearflow_time": "2016-11-30 15:36:20",
                        "limit_onlinenumber_vod": -1,
                        "is_roomlcps": 1,
                        "is_roomvod": 1,
                        "is_lssflowinfo": 1,
                        "is_lsspublish": 0,
                        "is_mcsconfig": 1,
                        "sublimit": 10,
                        "create_time": "2016-11-30 15:36:20",
                        "expiration_date": "0000-00-00 00:00:00",
                        "register_from": null,
                        "mps_item_list": "[{\"mps_id\":\"438\",\"name\":\"\\u9ed8\\u8ba4\\u64ad\\u653e\\u5668\"}]",
                        "isv_order_id": null,
                        "isv_expired_time": null,
                        "isv_expired_date": null,
                        "uptime": "2016-12-28 16:45:40",
                        "slug": "",
                        "billing_type": null,
                        "mcs_type": null,
                        "view_auth_url": null,
                        "webhook_config": null,
                        "account_balance": "0.00",
                        "limit_onlinenumber_over_price": null,
                        "limit_bandwidth_over_price": null
                    }
                }
            ]
        }
    ]
}
```

##添加多个视频到指定房间的拉流列表 需要所属子公司权限(addRoomPullStreamList)

请求方式 GET POST 需要认证

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


##删除指定房间的拉流列表 需要所属子公司权限(delRoomPullStream)

请求方式 GET POST 需要认证

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


##暂停指定房间的拉流列表 需要所属子公司权限(pauseRoomPullStream)

请求方式 GET POST 需要认证

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

##播放指定房间的拉流列表 需要所属子公司权限(playRoomPullStream)

请求方式 GET POST 需要认证

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


##停止指定房间的视频发布 需要所属子公司权限(cutReplayOpMic)

请求方式 GET POST 需要认证

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