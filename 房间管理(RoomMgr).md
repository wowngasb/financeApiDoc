# 房间管理 RoomMgr

房间管理相关操作，子公司可以操作其下属的房间，总公司可以操作旗下所有子公司的房间

## 新建房间（newCaiJingRoom）

新建房间 请求方式 POST 需要认证

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/newCaiJingRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/newCaiJingRoom',
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
    "Info": {   //房间详细信息  参见  getRoomInfo 接口
        "room_id": 74,  // 房间 id
        "admin_id": 281,  // 子公司 id
        "state": 1,  // 状态 正常1，冻结2 关闭9
        "viewer_count": 49,  // 累计观看人数
        // 其他数据
    }
}
```

## 修改房间（setCaijingRoom）

设置房间 请求方式 POST 需要认证

以下参数字段可以只使用部分 表示只修改部分设置  不需要修改的字段可以不设置或设置为null 表示保持原设置不变

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/setCaijingRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/setCaijingRoom',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| -------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| state             | `int`  房间状态 1正常，2冻结 可选          |
| room_title          | `string`  房间标题 可选               |
| cover_pic           | `string`  视频封面图片 可选             |
| notice             | `string`  预览界面 房间公告 可选             |
| mcs_name          | `string`  直播工具mcs登录帐号  可选            |
| mcs_pwd           | `string`  直播工具mcs登录密码  可选          |
| background_pic   | `string`  预览界面 房间背景图片地址  可选          |
| mps_id             |  `int`  MPS播放器样式id lss_player_type为mps时有效  可选     |
| lss_player_stretching  |  `int`  视频全屏模式,1代表按比例撑满至全屏,2代表铺满全屏,3代表视频原始大小 默认为2 可选     |
| chat_filter_keys       | `string` 聊天屏蔽关键词 使用 英文竖线 隔开  可选        |
| lss_player_bufferlength  |  `int`   播放器缓冲区长度 默认为1 可选     |
| lss_player_maxbufferlength  |  `int`  播放器最大缓冲时间 默认为2  可选     |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改房间成功"
}
```

## 修改MCS直播账号（bindRoomWithMcsAccount）

请求方式 POST 需要认证

修改指定房间[MCS直播发布工具](http://www.aodianyun.com/aodianyun_doc/298)的帐号密码，帐号是全局唯一的。

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/bindRoomWithMcsAccount" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/bindRoomWithMcsAccount',
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

## 修改MPS播放器（bindRoomWithMpsPlayer）

请求方式 POST 需要认证

为直播间设置MPS播放器  需要总公司权限 或者 所属子公司权限

只有当房间播放器类型设置为 mps 才有效

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/bindRoomWithMpsPlayer" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/bindRoomWithMpsPlayer',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| mps_id           | `int`  MPS播放器id 默认为0 表示使用默认的MPS播放器    |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改播放器成功"
}
```

## 修改播放器类型（setRoomLssPlayerType）

请求方式 POST 需要认证

修改直播间播放器类型  需要总公司权限 或者 所属子公司权限


```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/setRoomLssPlayerType" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/setRoomLssPlayerType',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| lss_player_type           | `string`  播放器类型  mps表示MPS播放器  aodianplayer表示基本播放器  |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "设置播放器成功"
}
```

## 获取当前房间人数（getRoomDmsUserCount）

请求方式 GET POST 不需要认证

获取房间 实时在线人数

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/getRoomDmsUserCount" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/getRoomDmsUserCount',
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

## 生成房间Token（getAuthToken）

请求方式 GET POST  需要认证

生成房间Token  需要房间管理权限

Token 可用于聊天审核 教育模版操作文档、回答问题等操作

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/getAuthToken" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/getAuthToken',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`  房间ID 指定的房间                        |
| expire              | `int`  token有效期 单位为秒 为0 表示永久有效            |
| uid                 | `string` 用户唯一标识 用于标识token使用者  可为空      |
| nick                | `string`  用户昵称 用于标识token使用者  可为空     |
| ava                 | `string`  用户头像  用于标识token使用者  可为空      |
| ext                 | `string`  用户扩展信息  可为空      |

> 返回结果如下:


```json
{
    "Flag": 100,
    "FlagString": "生成token成功",
    "Info": "fc661zGWNHIlGywU4BQcDtM2Fujt-Cn4zx0RxHNMvC0jq8MsPm7vPfd_8WhlvdqlRjw2RduO4EFErwOljp031WTRA8lbn1Q"
}
```


## 设置房间状态（stateSubRoom）

请求方式 GET POST 需要房间管理权限

设置房间状态  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/stateSubRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/stateSubRoom',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`  房间ID 指定的房间                        |
| state               | `int`  状态 正常1，冻结2 关闭9          |

> 返回结果如下:


```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```


## 立即删除房间（removeSubRoom）

请求方式 GET POST 需要房间管理权限

立即删除房间 不可找回  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/removeSubRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/removeSubRoom',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`  房间ID 指定的房间                        |

> 返回结果如下:


```json
{
    "Flag": 100,
    "FlagString": "永久删除房间成功"
}
```

## 修改直播配置（setRoomMcsConfig）

设置指定房间的MCS配置信息  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/setRoomMcsConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/setRoomMcsConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`  房间ID 指定的房间                        |
| config               | `array`  直播配置信息数组          |
| mcs_id              | `int`  mcs实例id 默认为0 表示使用原id         |
| chat_url             | `string`  MCS 内嵌网页 设置为 null 表示使用默认连接   |

config 参数为 

| 字段                | 描述                                    |
| ---------------------- | ------------------------------------------------ |
| MaxOutResolution  |  `string` 直播流最大输出分辨率 例如 "1280*720" |
| ADBitRate         | `string`   音频码率kbps  "48"                  |
| VDIntervalSecond  | `string`   关键帧间隔： "3"                      |
| VD_method       | `string`   桌面捕获视频 编码方式 可选 "vbr" "cbr" |
| VDFPS            | `string`   桌面捕获视频 参数 帧数 "15"        |
| VDBitRate         | `string`   桌面捕获视频 参数 码率(cbr)  "200" |
| VBRQuality        |  `string`  桌面捕获视频 参数 质量(vbr)  "10"  |
| VC_method        | `string`   摄像头视频  编码方式 可选 "vbr" "cbr" |
| VCFPS             | `string`   摄像头视频  参数 帧数 "15"         |
| VCBitRate          | `string`   摄像头视频  参数 码率(cbr)  "200" |
| CQuality           |  `string`   摄像头视频  参数 质量(vbr)  "10"  |
| VF_method         | `string`   本地文件视频  编码方式 可选 "vbr" "cbr" |
| VFFPS              | `string`   本地文件视频  参数 帧数 "15"         |
| VFBitRate          | `string`   本地文件视频  参数 码率(cbr)  "200" |
| VBRFQuality        | `string`   本地文件视频  参数 质量(vbr)  "10"| 
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```


## 获取直播配置（getRoomMcsConfig）

获取指定房间的MCS配置信息  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/getRoomMcsConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/getRoomMcsConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`  房间ID 指定的房间                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取成功",
    "Info": {
        "id": "1593",
        "uin": "13830",
        "user": "dyy42446555",  //直播账号 登录名
        "name": "测试MPS",
        "password": "e10adc3949ba59abbe56e057f20f883e",
        "app": "dyy_1736_133",
        "stream": "a0c3d2dd3b4688f31da13991477980d9",
        "appType": "1",
        "PubUrlPub": "",
        "config": {  // 参见setRoomMcsConfig 接口
            "MaxOutResolution": "1280*720",
            "ADSampleRate": "44100",
            "ADChannels": "2",
            "ADBitperSample": "16",
            "ADBitRate": "48",
            "VDIntervalSecond": "3",
            "BFrameCount": "1",
            "VD_method": "cbr",
            "VDFPS": "15",
            "VDBitRate": "200",
            "VCFPS": "15",
            "VC_method": "cbr",
            "VCBitRate": "200",
            "VF_method": "cbr",
            "VFFPS": "15",
            "VFBitRate": "200",
            "StrKey": "",
            "PubWay": "rtmp",
            "strUserID": "1478",
            "PubUrlPub": "13830.lsspublish",
            "PublishRoomInfo": "dyy_1736_133",
            "ChatUrl": "http://58jinrongyun.com/admin/mcsblock/wispublish?token=a07dVZvHzZPe8GZEAePcC3loHl8Tn5cBXyPpy3qrcdyLqCFhBCbaBJXQdbox",
            "stream": "a0c3d2dd3b4688f31da13991477980d9"
        },
        "addTime": "1478053169",
        "upTime": "1481186822",
        "status": "1"
    }
}
```

## 获取房间列表（getAdminRoomList）

获取房间列表  需要总公司权限 或者 所属子公司权限

所有参数均为查询条件  可以不添加这个参数表示不使用这个查询

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/getAdminRoomList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/getAdminRoomList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ----------------------- | --------------------------------------------------------- |
| start               | `int`  起始位置 用于分页                            |
| limit               | `int`  每页数量 用于分页                            |
| sort_option        | `array`  排序依据 默认 ['field' => 'room_id', 'direction' => 'asc']    |
| room_id           | `int array`  房间room_id 为0时获取所有下属房间              |
| room_title         | `string`  房间标题 支持模糊查询                       |
| admin_id          | `int`  每管理员 admin_id 默认为0 表示查找自身下属房间    |
| create_time_s      | `string`  创建时间范围 起始 为空表示不限制    |
| create_time_e      | `string`  创建时间范围 结束 为空表示不限制    |
| state               | `int array`  状态  正常1，冻结2 关闭9 为0表示不限      |
| live_state           | `int`  直播状态  直播1 未直播0 为-1表示不限      |
| stream             | `string`  房间 stream 为空表示不限            |
| vod_room_id       | `int`  录制来源房间 默认为0表示不限      |
| roomtype          | `int`  房间类型 默认为0表示不限制    |
| video_type          | `int`  房间视频来源  1直播stream，2上传点播，3直播存储  默认为1 |
| mcs_name          | `string`  直播账号 支持模糊查询 为空表示不限制    |

> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [  //房间详细信息 参见getRoomInfo 接口
        {
            "room_id": 74,  // 房间 id
            "admin_id": 281,  // 子公司 id
            "state": 1,  // 状态 正常1，冻结2 关闭9
            "viewer_count": 49,  // 累计观看人数
            ......
        },
        ......
    ],
    "results": 4  //条目总数 等于rows字段数组的长度
}
```

## 获取房间信息（getRoomInfo）

请求方式 GET POST 需要认证

获取指定房间信息  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/getRoomInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/getRoomInfo',
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
    "Info": {  // 房间详细信息
        "room_id": 74,  // 房间 id
        "admin_id": 281,  // 子公司 id
        "state": 1,  // 状态 正常1，冻结2 关闭9
        "viewer_count": 49,  // 累计观看人数
        "viewer_max": 2,  // 最高同时在线人数
        "room_title": "财经一号",  // 房间标题
        "create_time": "2016-11-30 16:23:16",  // 
        "live_state": 0,  // 直播状态  直播1 未直播0
        "video_type": 1,  // 房间视频来源  1直播stream，2上传点播，3直播存储
        "vod_url": null,  // 点播视频来源 url
        "vod_file": null,  // 点播视频 视频连接
        "vod_room_id": 0,  // 点播视频 房间录制来源
        "chat_filter_keys": null,  // 聊天关键词过滤
        "cover_pic": "",  // 视频封面图片
        "background_pic": "",  // 直播间 背景图片
        "ctrl_qas": 0,  // 问答控制，0开启，7审核 9禁止所有人
        "ctrl_sysmsg": 1,  // 是否显示 系统消息 0不显示  1显示 默认为 1
        "ctrl_share": 0,  // 设置房间是否显示 分享按钮  0不显示   1显示
        "ctrl_chat": 9,  // 聊天控制，0开启，7审核 9禁止
        "mcs_name": "dyy105174419",  // mcs 直播账号 登录名
        "mcs_id": 3895,  // mcs app id 每个主播账号对应一个id
        "mcs_pwd": "123456",  // mcs 直播账号 密码
        "lss_player_maxbufferlength": 2,  // 最大视频缓冲时间，默认2秒 hls不支持
        "lss_player_bufferlength": 1,  // 设置视频缓冲时间，默认1秒 hls不支持
        "lss_player_stretching": 2,  // 设置全屏模式 1按比例撑满 2铺满全屏 3原始大小
        "lss_player_type": "mps",  // 流媒体视频播放器类型 默认mps:mps播放器,aodianplayer:默认播放器
        "mps_id": 438,  // 所选 MPS 播放器 id
        "mps_instance_id": "fN1Humm1116UPixX",  // 根据所选 MPS 播放器 id 流媒体app stream 生成的实例id
        "uptime": "2016-12-26 14:41:19",  // 记录更新时间
        "lss_app": "dyy_281_438",  // 房间流媒体 app
        "stream": "dadad",  // 房间流媒体 stream
        "admin_type": "caijing",  //模版类型  caijing财经  jiaoyu教育
        "mps_list": [  //MPS 播放器相关
            {
                "mps_id": "438",
                "name": "默认播放器"
            }
        ],
    },
    "FlagString": "获取数据成功"
}
```


## 增加直播账号（addRoomMcs）

请求方式 GET POST 需要认证

为指定房间 增加直播账号 需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/addRoomMcs" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/addRoomMcs',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| account             | `string`  直播账号 数字，字母长度(长度6~18)                        |
| name             | `string`  账号用户名 主播名称(不超过10个字)                        |
| password             | `string`  账号密码 数字，字母长度(长度6~18)                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "添加MCS成功"
}
```

## 获取直播账号列表（listRoomMcs）

请求方式 GET POST 需要认证

获取指定房间 直播账号列表  需要总公司权限 或者 所属子公司权限


```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/listRoomMcs" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/listRoomMcs',
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
    "Info": {
        "12": {
            "id": 12,
            "room_id": 74,
            "mcs_id": 18317,  //直播账号id 用于删除修改密码等
            "name": "555555555",  // 直播账号 登录名
            "account": "6576666666",
            "password": "ffffffffffffff",  // 直播账号 登录密码
            "create_time": "2016-12-23 11:31:57",
            "uptime": "2016-12-23 15:19:56"
        },
        ......
    }
}
```

## 修改直播账号密码（paswRoomMcs）

请求方式 GET POST 需要认证

修改指定直播账号 登录密码  需要总公司权限 或者 所属子公司权限


```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/paswRoomMcs" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/paswRoomMcs',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| mcs_id             | `int`  直播帐号唯一标识                        |
| password           | `string`  新的密码 数字，字母长度{6~18}                        |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功"
}
```

## 删除直播账号（delRoomMcs）

请求方式 GET POST 需要认证

删除指定的 直播账号  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/delRoomMcs" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/delRoomMcs',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                        |
| mcs_id             | `int`  直播帐号唯一标识                        |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "删除成功"
}

```

## 历时消息查询（listRoomHistoryMsg）

请求方式 GET POST 需要认证

历时消息查询  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomMgr/listRoomHistoryMsg" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomMgr/listRoomHistoryMsg',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

room_id 为必选字段，其他为检索参数  可以不设置 表示不使用这个条件

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| start               | `int`  起始位置 用于分页  默认为 0                       |
| limit               | `int`  每页数量 用于分页  默认为 20     最大100           |
| sort_option        | `array`  排序依据 默认 ['field' => 'create_time', 'direction' => 'decs']    |
| room_id             | `int`  房间ID 指定的房间                        |
| uid             | `string`  用户标识  默认为空                 |
| msg_id             | `int`  消息id 可以指定查询某一条消息  默认0                 |
| msg_cmd             | `string or array`  消息类型  chat 聊天  question 提问  answer 回答    默认为空        |
| state             | `int or array`  消息状态  1 待审核  2 审核发布  3 未开启审核直接发布  7 已回答  8 批量清除  9 手动删除  默认为空     |
| create_time_s             | `string`  消息创建时间 起始   格式 2017-01-01 12:00:00   默认为空      |
| create_time_e             | `string`  消息创建时间 结束   格式 2017-01-01 12:00:00   默认为空      |
| uptime_s             | `string`  消息更新时间 起始   格式 2017-01-01 12:00:00     默认为空    |
| uptime_e             | `string`  消息更新时间 结束   格式 2017-01-01 12:00:00   默认为空      |

     

> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "uid": "9035",   // 发送者 用户标识
            "nick": "ihpyH",  // 发送者 昵称
            "ava": "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png",  // 发送者 头像
            "ext": "student",  // 发送者 角色
            "content": "法规法规",   //发送内容
            "time": 1491461108,  //发送时间
            "cmd": "chat",  // 消息类型  chat 聊天  question 提问  answer 回答
            "state": 1,  // 消息状态  1 待审核  2 审核发布  3 未开启审核直接发布  7 已回答  8 批量清除  9 手动删除
            "msg_id": 590,  // 消息唯一id
            "msg_from": null   // cmd 为 answer 的回答消息有此字段 对应问题的 msg_id
        },
        // ......
    ],
    "results": 35  //符合条件的消息总数
}
```


