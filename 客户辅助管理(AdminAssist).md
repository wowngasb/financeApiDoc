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
