# 客户辅助管理 AdminAssist

设置总公司对应uin相关全局配置

## 获取DVR上传自动转码配置（getUpDvrTransConfig）

请求方式 POST 需要认证

获取 DVR 视频上传自动转码 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getUpDvrTransConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getUpDvrTransConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取成功",
    "Config": {
        "autoTranscoding": 1,  //是否自动转码  0否  1是
        "videoRate": {
            "0": "0x0",
            "2": "1280x720",  //转码 码率列表
            "3": "854x480",
            "4": "640x360",
            "5": "426x240"
        },
        "drmURI": "http://wx.inxedu.com/api/ajax/drmkey"  //DRM API 地址
    }
}
```

## 设置DVR上传自动转码配置（setUpDvrTransConfig）

请求方式 POST 需要认证

设置 DVR 视频上传自动转码 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setUpDvrTransConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setUpDvrTransConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| --------------------- | -------------------------------------------------- |
| admin_id          | `int`  客户ID 指定的客户                           |
| autoTranscoding   | `int`   是否自动转码  0否  1是                     |
| videoRate          | `array`   码率数组                              |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```


## 获取DVR上传自动同步配置（getVodUpVodConfig）

请求方式 POST 需要认证

获取 DVR 视频上传自动同步 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getVodUpVodConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getVodUpVodConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Data": {
        "_id": "582e93448894efebbb4bd638",
        "user": "25586",
        "autoFiling": 1  //自动同步 0不同步  1全部同步  2制定条件同步
    }
}
```

## 设置DVR上传自动同步配置（setVodUpVodConfig）

请求方式 POST 需要认证

设置 DVR 视频上传自动同步 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setVodUpVodConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setVodUpVodConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |
| autoFiling             | `int`  自动同步 0不同步  1全部同步  2制定条件同步                    |
| stime             | `string`  可选 autoFiling为2时的具体条件 指定时间段 开始                |
| etime             | `string`  可选 autoFiling为2时的具体条件 指定时间段 结束          |
| duration             | `string`  可选 autoFiling为2时的具体条件 指定视频长度 大于秒数                 |
| width             | `string`  可选 autoFiling为2时的具体条件 指定分辨率：宽度            |
| height             | `string`  可选 autoFiling为2时的具体条件 指定分辨率：高度          |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 获取DRM加密配置（getDvrDrmConfig）

请求方式 POST 需要认证

获取 DVR 视频上传DRM加密 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getDvrDrmConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getDvrDrmConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Data": {
        "_id": "582e93458894efebbb4bd64d",
        "user": "25586",
        "autoTranscoding": 1,  //转码设置
        "videoRate": {
            "0": "0x0",
            "2": "1280x720",
            "3": "854x480",
            "4": "640x360",
            "5": "426x240"
        },
        "drmURI": "http://wx.inxedu.com/api/ajax/drmkey"  //DRM API 地址
    }
}
```

## 设置DRM加密配置（setDvrDrmConfig）

请求方式 POST 需要认证

设置 DVR 视频上传DRM加密 配置  对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setDvrDrmConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setDvrDrmConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| drmURI             | `string`  加密API http地址                  |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 获取VOD域名黑白名单（getVodDomainRef）

请求方式 POST 需要认证

获取 VOD点播域名配置 黑白名单 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |
| domain             | `string`  cdn域名  直播存储 {{uin}}.live-vod.cdn.aodianyun.com  上传存储{{uin}}.long-vod.cdn.aodianyun.com             |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "数据查询成功",
    "Info": {
        "whitedomains": [],  //白名单列表
        "blackdomains": [],  //黑名单列表
        "domains-status": "disabled",  //当前模式 关闭disabled  黑名单blacklist  白名单whitelist  同时只能有一个生效
        "ips": [],
        "ips-status": "disabled",
        "useragent": [],
        "useragent-status": "disabled",
        "allow-empty-referer": true  //Refer允许为空  是true   否false
    }
}
```

## 设置VOD域名黑白名单（setVodDomainRef）

请求方式 POST 需要认证

设置 VOD点播域名配置 黑白名单 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |
| domain             | `string`  cdn域名  直播存储 {{uin}}.live-vod.cdn.aodianyun.com  上传存储{{uin}}.long-vod.cdn.aodianyun.com             |
| status           | `string`    黑名单 blacklist  白名单whitelist  同时只能有一个生效                  |
| host           | `string`  Refer域名列表(一行一个)               |
| allownullrefer           | `string`  Refer允许为空  是true   否false                 |

> 返回结果如下:

     
```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 获取VOD域名列表（listVodDomainRef）

请求方式 POST 需要认证

获取 VOD点播域名列表 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/listVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/listVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "域名列表",
    "List": [
        {
            "id": "11966",
            "domain": "XXXX.live-vod.cdn.aodianyun.com",
            "level": "1",
            "type": "1",
            "status": "1",
            "uptime": "1475047743"
        }
    ]
}
```

## 增加VOD域名（addVodDomainRef）

请求方式 POST 需要认证

增加 VOD点播域名 对应奥点（uin）

需要准备自己的域名 并CNAME 指向 直播存储 XXXX.live-vod.cdn.aodianyun.com  上传存储XXXX.long-vod.cdn.aodianyun.com 

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/addVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/addVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |
| domain             | `string`  CNAME 域名 指向 直播存储 XXXX.live-vod.cdn.aodianyun.com  上传存储XXXX.long-vod.cdn.aodianyun.com       |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 启用VOD点播域名（checkVodDomainRef）

请求方式 POST 需要认证

检查并启用 VOD点播域名 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/checkVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/checkVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |
| domain             | `string`  CNAME 域名 指向 直播存储 XXXX.live-vod.cdn.aodianyun.com  上传存储XXXX.long-vod.cdn.aodianyun.com       |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 停用VOD点播域名（removeVodDomainRef）

请求方式 POST 需要认证

停用并移除 VOD点播域名 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/removeVodDomainRef" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/removeVodDomainRef',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ------------------ | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| type                | `int`  客户ID cdn域名类型  1直播存储域名  2上传存储域名              |
| domain             | `string`  CNAME 域名 指向 直播存储 XXXX.live-vod.cdn.aodianyun.com  上传存储XXXX.long-vod.cdn.aodianyun.com       |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 设置直播域名白名单（setSubAdminDns）

请求方式 POST 需要认证

设置 LSS直播APP 域名白名单  最多5个 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setSubAdminDns" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setSubAdminDns',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |
| type                  | `array`  域名白名单列表  可以使用通配符  最多5个     |
| forbideEmptyReferer  | `int`  `forbideEmptyReferer`  是否禁止空的Refer  是1   否0     |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```

## 获取直播域名白名单（getSubAdminDns）

请求方式 POST 需要认证

获取 LSS直播APP 域名白名单  最多5个 对应奥点（uin）

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getSubAdminDns" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getSubAdminDns',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取域名白名单成功",
    "User": "13830",
    "Appid": "dyy_1557_231",
    "List": [
        "baidu.com",
        "www.baidu.com",
        "image.baidu.com"
    ],
    "forbideEmptyReferer": 0
}
```

## 获取webhook配置（getWebHookConfig）

请求方式 POST 需要认证

获取 webhook 异步通知 配置信息  对应总公司

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getWebHookConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getWebHookConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": {
        "url": "http://finance.aodianyun.com/cache/webhook.php",
        "content_type": "application/x-www-form-urlencoded",
        "secret": "adeawda",
        "event": {
            "sys/notify/lss": "1",
            "sys/notify/lss_fluency": "1",
            "sys/notify/live_dvr": "1",
            "sys/notify/upload_dvr": "1",
            "sys/notify/live_dvr_preview_image": "1"
        }
    }
}
```

## 设置webhook配置（setWebHookConfig）

请求方式 POST 需要认证

设置 webhook 异步通知 配置信息  对应总公司

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/setWebHookConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/setWebHookConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  客户ID 指定的客户                        |
| url                    | `string`    回调接口地址                  |
| content_type          | `string`    请求数据类型                      |
| secret                | `string`    密钥用于检查其请求有效性                 |
| event             | `array`    需要关注的事件列表 值为1表示关注                   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```


## 房间直播状态（getRoomPublishInfo）

请求方式 POST 需要认证

获取 房间 发布流畅度相关信息  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getRoomPublishInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getRoomPublishInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                           |
| rangeMinute        | `int`   获取的时间范围 单位分钟 大于0小于等于60           |

> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": [
        {
            "room_id": 1042,
            "admin_id": 1140,
            "state": 1,
            "viewer_count": 54,
            "viewer_max": 1,
            "room_title": "晚间直播",  //房间基本信息 参见getRoomInfo接口
            ......
            "bandwidth_info": {   //房间当前带宽信息
                "bandwidth": 0,
                "bandwidth_last": 0,
                "time": 1483687106,
                "uptime": 1483687106,
                "bandwidth_str": "0",
                "uptime_str": "2017-01-06 15:18:26"
            },
            "fluencyHistoryData": [  // 房间流畅度信息
                {
                    "name": "上行流畅度",
                    "index": 0,
                    "legendIndex": 0,
                    "_colorIndex": 0,
                    "_symbolIndex": 0,
                    "data": []
                },
                {
                    "name": "转发流畅度",
                    "index": 1,
                    "legendIndex": 1,
                    "_colorIndex": 1,
                    "_symbolIndex": 1,
                    "data": []
                },
                {
                    "name": "下行流畅度",
                    "index": 2,
                    "legendIndex": 2,
                    "_colorIndex": 2,
                    "_symbolIndex": 2,
                    "data": []
                }
            ],
            "fluencyHistoryData_uptime": null,
            "PreviewImage": [],   //房间直播截图信息
            "7DayDvr": []  //房间直播自动录制下来的 临时存储的视频信息
        }
    ]
}
```


## 所有直播状态（getAdminPublishRoom）

请求方式 POST 需要认证

获取 Lss app 发布流畅度相关信息 只获取正在直播的房间  需要总公司权限 或者 所属子公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getAdminPublishRoom" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getAdminPublishRoom',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司ID 指定的子公司    默认为0表示获取自身旗下房间       |
| rangeMinute        | `int`   获取的时间范围 单位分钟 大于0小于等于60           |

> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": [  //旗下所有正在直播的房间 直播状态信息 参见 getRoomPublishInfo 接口
        {
            "room_id": 1042,
            "admin_id": 1140,
            "state": 1,
            ......
        }
    ]
}
```

## 获取管理员限制信息（getLimitInfo）

请求方式 GET POST 需要认证

获取 管理员限制相关信息 需要 自身 或所属 总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminAssist/getLimitInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminAssist/getLimitInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                   | 描述                                          |
| ------------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司ID 指定的子公司    默认为0表示获取自身旗下房间       |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取成功",
    "limit_msg": "流量限制：1TB, 已使用：5.57GB(未超出), 流量有效期：2016-08-28 到 2017-08-28 (12个月, 未过期)",
    "Info": {
        "bandwidth": {
            //带宽信息
            "bandwidth": 0,
            "bandwidth_last": 0,
            "time": 1484544948,
            "uptime": 1484544948,
            "limit_normal": 0,
            "limit_special": 0,
            "limit": 0
        },
        "onlinenumber": {
            //在线并发数量
            "onlinenumber": 0,
            "time": 1484544947,
            "uptime": 1484544948,
            "limit_normal": 0,
            "limit_special": 0,
            "limit": 0
        },
        "yearflow": {
            //年流量
            "yearflow": 5700.11,
            "time": 1484544948,
            "start_time": "2016-08-28 00:00:00",
            "month_count": 12,
            "month_start": "201608",
            "end_time": "2017-08-28 00:00:00",
            "in_time_range": true,
            "limit": 1048576
        },
        "_uptime_": "2017-01-16 13:35:48"
    },
    "view_state": true,
    "admin_id": 281
}
```




