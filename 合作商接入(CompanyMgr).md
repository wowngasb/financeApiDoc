# 合作商接入 CompanyMgr

合作商接入相关文档，需要特殊的合作商帐号和`API_KEY`，一般客户无法使用

## 开通新的客户（newSubCompany）

请求方式 POST 需要认证

合作伙伴开通新的客户 返回开通客户的id 帐号 密码

对于设置为流量计费的用户，各项服务将按照使用量和单价进行扣费

对于设置为并发计费的客户，不会产生直播流量费用，在每月月底会算出本月直播观看最高并发值，按照并发价格计算金额

计费方式设置为并发计费（bingfa）的客户，直播视频将使用预设码率并不允许修改，直播工具MCS发布配置也会被禁用

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/newSubCompany" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/newSubCompany',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_type        | `string`   房间模版类型 caijing：财经模版  jiaoyu：教育模版             |
| billing_type        | `string`   客户计费方式 bingfa：并发计费  liuliang：流量计费              |
| name              | `string`   客户后台登录名  可选  默认随机生成             |
| title                | `string`   客户名称  可选  默认随机生成            |
| pasw               | `string`   客户登录密码  可选  默认为 123456              |
| sublimit            | `int`   客户创建房间数量限制  可选  默认为 10000        |
| view_auth_url      | `string`   用户自定义认证url  防盗链  进入房间之前验证  可选  默认为空   （[参见：房间认证接口规范](#房间认证接口规范)）            |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "创建客户成功",
    "Info": {
        "admin_id": 1145,  //客户id
        "pasw": "123456",  //后台管理页面 登录密码
        "name": "sub_24889_9884",  //后台管理页面 登陆账号
        "access_id": "121576745758",  //奥点云access_id  用于调用奥点云API
        "access_key": "17k0Id422f8eKJUg51al3hreyI75mdzJ",  //奥点云access_key  用于调用奥点云API
    }
}
```

## 获取客户信息（getSubInfo）

请求方式 GET POST 需要认证

获取客户信息

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id            | `int`  客户ID 指定的客户                        |

> 返回结果如下:

````
{
    "Flag": 100,
    "FlagString": "获取客户信息成功",
    "Info": {
        "admin_id": 1147,  //客户ID 指定的客户
        "name": "sub_24894_42124",  //客户后台登录名
        "title": "合作测试_24894",  //客户标题
        "admin_type": "jiaoyu",  //房间模版类型 caijing：财经模版  jiaoyu：教育模版
        "billing_type": "bingfa",  //客户计费方式 bingfa：并发计费  liuliang：流量计费
        "state": 1,  //客户状态 1正常  2冻结
        "create_time": "2016-10-24 15:12:54",  //客户创建时间
        "access_id": "121576745758",  //奥点云access_id  用于调用奥点云API
        "access_key": "17k0Id422f8eKJUg51al3hreyI75mdzJ",  //奥点云access_key  用于调用奥点云API
        "aodian_id": 10000,  //奥点云uin 用于奥点云相关接口
        "view_auth_url": ""  //用户自定义认证url  防盗链  进入房间之前验证  
    }
}
```

## 设置客户状态（stateSubCompany）

请求方式 POST 需要认证

设置客户状态    因为涉及冻结服务等操作 同一个帐号 每分钟只能操作一次

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/stateSubCompany" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/stateSubCompany',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id            | `int`  客户ID 指定的客户                        |
| state                | `int`  客户状态 1正常  2冻结            |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "设置状态成功"
}
```

## 修改客户信息（setSubCompany）

请求方式 POST 需要认证

修改指定客户的基本信息 下列设置的字段为可选参数 不设置表示 保持原有不变

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/setSubCompany" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/setSubCompany',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                        |
| title                | `string`   客户名称  可选  不设置表示保持不变       |
| name              | `string`   客户后台登录名  可选  不设置表示保持不变   |
| sublimit            | `int`    客户创建房间数量限制  可选  不设置表示保持不变     |
| pasw               | `string`    客户登录密码  可选  不设置表示保持不变     |
| view_auth_url       | `string`   用户自定义认证url  防盗链  进入房间之前验证  可选  不设置表示保持不变  （[参见：房间认证接口规范](#房间认证接口规范)）       |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改客户成功"
}
```

## 开通新房间（newRoomByAdminId）

请求方式 POST 需要认证

为客户开通直播间

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/newRoomByAdminId" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/newRoomByAdminId',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`  客户ID 指定的客户                 |
| room_title          | `string`   房间标题 可选  默认为 房间 + room_id      |
| cover_pic           | `string`   视频封面图片  可选  默认为空    |
| mcs_name          | `string`    直播工具mcs登录帐号  可选  默认为随机的 dyy + rand(10000, 199999999)     |
| mcs_pwd           | `string`    直播工具mcs登录密码  可选  默认为123456    |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "新建房间成功",
    "Info": {
        "room_id": 100270,  //房间id
        "admin_id": 1147,  //客户id
        "state": 1,  //房间状态 1正常  2冻结  9删除
        "viewer_count": 0,  //房间累计点击数
        "viewer_max": 0,  //房间最高同时在线数
        "room_title": "房间100270",  //房间标题
        "live_state": 0,  //是否正在直播 0 未直播  1 正在直播
        "cover_pic": "",  //视频封面图片
        "background_pic": "",  //房间背景图片
        "mcs_name": "dyy198870906",  //房间直播账号
        "mcs_pwd": "123456",  //房间直播密码
        "ctrl_chat": 0,  //房间聊天控制 0 开启聊天  9关闭聊天
        "chat_filter_keys": "",  //聊天关键词过滤 使用 | 分隔
        "create_time": "2016-10-24 15:12:54",  //房间创建时间
        "lssPublishAddr": "rtmp://1436.lsspublish.aodianyun.com/dyy_280_902/xxx",   //rtmp 发布地址
        "rtmp_url": "rtmp://1436.lssplay.aodianyun.com/dyy_280_902/xxx",   //rtmp 观看地址
        "hls_url": "http://1436.hlsplay.aodianyun.com/dyy_280_902/xxx.m3u8"   //hls 观看地址
    }
}
```

## 修改MCS直播账号（setRoomAccount）

请求方式 POST 需要认证

修改指定房间的主播帐号和密码 用于登录[MCS直播发布工具](http://www.aodianyun.com/aodianyun_doc/298)  帐号全局唯一

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/setRoomAccount" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/setRoomAccount',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`    房间ID 指定的房间            |
| mcs_name          | `string`   登录帐号  6-18位数字字母组合     |
| mcs_pwd           | `string`    登录密码  6-18位数字字母组合   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "设置MCS成功"
}
```

## 修改房间状态（setRoomState）

请求方式 POST 需要认证

设置房间状态

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/setRoomState" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/setRoomState',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`    房间ID 指定的房间            |
| state                | `int`   房间状态 1正常  2冻结  9删除   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "设置状态成功"
}
```

## 获取房间信息（getRoomInfo）

请求方式 GET POST 需要认证

获取房间基本信息

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getRoomInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getRoomInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`    房间ID 指定的房间            |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "获取房间信息成功",
    "Info": {
        "room_id": 100270,  //房间id
        "admin_id": 1147,  //客户id
        "state": 1,  //房间状态 1正常  2冻结  9删除
        "viewer_count": 0,  //房间累计点击数
        "viewer_max": 0,  //房间最高同时在线数
        "room_title": "房间100270",  //房间标题
        "live_state": 0,  //是否正在直播 0 未直播  1 正在直播
        "cover_pic": "",  //视频封面图片
        "background_pic": "",  //房间背景图片
        "mcs_name": "dyy198870906",  //房间直播账号
        "mcs_pwd": "123456",  //房间直播密码
        "ctrl_chat": 0,  //房间聊天控制 0 开启聊天  9关闭聊天
        "chat_filter_keys": "",  //聊天关键词过滤 使用 | 分隔
        "create_time": "2016-10-24 15:12:54",  //房间创建时间
        "lssPublishAddr": "rtmp://1436.lsspublish.aodianyun.com/dyy_280_902/xxx",   //rtmp 发布地址
        "rtmp_url": "rtmp://1436.lssplay.aodianyun.com/dyy_280_902/xxx",   //rtmp 观看地址
        "hls_url": "http://1436.hlsplay.aodianyun.com/dyy_280_902/xxx.m3u8"   //hls 观看地址
    }
}
```

## 获取房间流媒体信息（getRoomLssInfo）

请求方式 GET POST 需要认证

获取房间 流媒体 相关信息

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getRoomLssInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getRoomLssInfo',
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
        "aodian_id": 13830,  //奥点uin
        "cover_pic": "http://static.douyalive.com/images/my_147141392965877.png",  //播放器封面图片
        "dms_app": "dyy_7_221",
        "dms_pub_key": "pub_df6f4a4ef6fcb81edfe45cae48aa577f",
        "dms_sub_key": "sub_43718b49407c2c49385fb224862f91ae",
        "dms_total": 0,
        "hls_url": "http://13830.hlsplay.aodianyun.com/dyy_7_221/aajie.m3u8",   // HLS 播放 视频地址
        "live_state": 0,
        "lssPublishAddr": "rtmp://13830.lsspublish.aodianyun.com/dyy_7_221/aajie",   // RTMP 发布 视频地址
        "lss_app": "dyy_7_221",   // 视频 流媒体  app
        "lss_player_stretching": 2,
        "lss_player_type": "mps",
        "mcs_id": 518,
        "mps_id": 438,
        "mps_instance_id": "f1BHzbBBH16UWXiS",
        "room_id": 1000,
        "rtmp_url": "rtmp://13830.lssplay.aodianyun.com/dyy_7_221/aajie",  // RTMP 播放 视频地址
        "state": 9,
        "stream": "aajie",   // 视频 流媒体  stream
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

## 教育房间录制列表（getRoomWisReplay）

请求方式 GET POST 需要认证

获取教育模版房间 录制节目列表

获取白板录制列表之后  可以这样创建 [录制回放页面](#录制回放页面)

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getRoomWisReplay" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getRoomWisReplay',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id            | `int`    房间ID 指定的房间            |
| page               | `int`    页数    默认为 1                  |
| num                | `int`    每页数量    默认为 20               |
| expire              | `int`   嵌入链接 有效期 单位秒  默认 86400 24小时       |

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
          "wis_live_url": "http://web.wis.aodianyun.com/replay.php?wisId=lc_a9d7afff8f53ec7cc954c9f726d70195&expire=1582015223&rand=&dmn=&power=1&sign=3ts6UIwlcqH2yAegJ%2BI6fusFt%2BY%3D&style=010&pad=0&space=0&recordId=ecda1086a8a94fd2f3b6c1f8a0787f3a"
          "startTime": 1478854301820,  //录制开始时间 单位毫秒
          "endTime": 1478854513075  //录制结束时间 单位毫秒
      },
      ......
    ]
}
```

## 查询各项服务报价（getBillPrice）

请求方式 GET POST 需要认证

查询合作商 各项服务报价

计费服务类别：直播流量(LSS)，消息服务(DMS)，点播流量(VOD)，媒体存储(MSS)，并发计费(PCU)。

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getBillPrice" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getBillPrice',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

> 返回结果如下:

```json
{
  "Flag": 100,
  "FlagString": "获取报价成功",
  "Info": {
    "LSS_PER_FLOW": "0.68",  //直播流量价格(GB)每小时一条流水
    "VOD_PER_FLOW": "0.65",  //点播流量价格(GB)每小时一条流水
    "LSS_PER_NUM": "10.9",  //直播并发价格(1人1月)每月一条流水
    "DMS_PER_COUNT": "0.02",  //DMS消息价格(万条)每日一条流水
    "MSS_PER_SPACE": "0.02"  //MSS存储价格(GB每天)每日一条流水
  }
}
```

## 查询每日消费明细（getBillRunning）

请求方式 GET POST 需要认证

查询指定客户或全站 某日 消费明细

对于设置为流量计费的用户，各项服务将按照使用量和单价进行扣费

对于设置为并发计费的客户，不会产生直播流量费用，而是在月底根据每月最高同时在线用户数计费，**并发计费在月底产生的计费条目不会出现在本接口中，请使用每月费用查询接口**

计费服务类别：直播流量(LSS)，消息服务(DMS)，点播流量(VOD)，媒体存储(MSS)。

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getBillRunning" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getBillRunning',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户  可选  默认为0表示获取旗下所有客户的消费明细   |
| date_day            | `string`   标识日期的字符串 格式为 2016-10-10  可选 默认为 今天    |

> 返回结果如下:

```json
{
    "Flag": 100,
    "date_day": "2016-10-10",  //日期
    "Total": {
        "all": 0.21,  //扣费总金额汇总
        "DMS": 0,  //扣费各项服务 金额汇总
        "LSS": 0,
        "VOD": 0,
        "MSS": 0.21,
        "DMS_VAL": 0,//扣费各项服务 使用量汇总
        "LSS_VAL": 0,
        "VOD_VAL": 0,
        "MSS_VAL": 10.537
    },
    "Info": [
        {
            "id": "711641",  //扣费记录id
            "uin": "1436",  //奥点云uin
            "order_type": "1",
            "product_id": "1",
            "uptime": "1476115203",  //扣费时间戳
            "status": "1",
            "bill_desc": "计费时段：2016-10-10 00:00:00 - 2016-10-10 23:59:59",  //扣费描述
            "bill_val": "1.3090",  //服务使用量
            "product_name": "MSS",  //服务名称
            "child_name": "计费值",  //扣费类别
            "uptime_str": "2016-10-11 00:00:03",  //扣费时间 字符串
            "admin_name": "fsefsefsef",  //客户名称
            "admin_id": 1151,  //客户id
            "bill_price": "0.02",  //服务价格
            "bill_total": 0.03,  //服务扣费金额
            "bill_val_str": "1.3090GB",  //服务使用量 加单位
            "bill_price_str": "0.02/GB"  //服务价格 加单位
        },
        ......
    ]
}
```

## 查询每月消费明细（getMonthBillRunning）

请求方式 GET POST 需要认证

查询指定客户或全站 某月 消费明细 

对于设置为流量计费的用户，各项服务将按照使用量和单价进行扣费

对于设置为并发计费的客户，不会产生直播流量费用，在每月月底会算出本月直播观看最高并发值，按照并发价格计算金额

计费服务类别：直播流量(LSS)，消息服务(DMS)，点播流量(VOD)，媒体存储(MSS), 并发计费(PCU)。

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getMonthBillRunning" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getMonthBillRunning',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户  可选  默认为0表示获取旗下所有客户的消费明细   |
| date_month        | `string`   标识日期的字符串 格式为 2016-10  可选 默认为 当前月   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "date_month": "2016-10",  //日期
    "Total": {
        "all": 25.73,  //全月扣费总金额汇总
        "DMS": 1.76,  //全月扣费各项服务 金额汇总
        "LSS": 18.34,
        "VOD": 1.38,
        "MSS": 4.25,
        "PCU": 49,
        "DMS_VAL": 89.206,  //全月扣费各项服务 使用量汇总
        "LSS_VAL": 26.984,
        "VOD_VAL": 2.079,
        "MSS_VAL": 210.217,
        "PCU_VAL": 5
    },
    "Info": [
        {
        "admin_name": "fsefsefsef",  //客户名称
        "admin_id": 1151,  //客户id
        "all": 0.21,  //每日 扣费总金额汇总
        "DMS": 0,  //每日 扣费各项服务 金额汇总
        "LSS": 0,
        "VOD": 0,
        "MSS": 0.21,
        "PCU": 49,  //并发计费 只会出现在每月的最后一天里
        "DMS_VAL": 0,  //每日扣费各项服务 使用量汇总
        "LSS_VAL": 0,
        "VOD_VAL": 0,
        "PCU_VAL": 5,
        "MSS_VAL": 10.537,
        "date_day": "2016-10-01"  //月份的每一天
        },
        ......
    ],
    "Running": [
        {
            "id": "711641",  //扣费记录id
            "uin": "1436",  //奥点云uin
            "order_type": "1",
            "product_id": "1",
            "uptime": "1476115203",  //扣费时间戳
            "status": "1",
            "bill_desc": "计费时段：2016-10-10 00:00:00 - 2016-10-10 23:59:59",  //扣费描述
            "bill_val": "1.3090",  //服务使用量
            "product_name": "MSS",  //服务名称
            "child_name": "计费值",  //扣费类别
            "uptime_str": "2016-10-11 00:00:03",  //扣费时间 字符串
            "admin_name": "fsefsefsef",  //客户名称
            "admin_id": 1151,  //客户id
            "bill_price": "0.02",  //服务价格
            "bill_total": 0.03,  //服务扣费金额
            "bill_val_str": "1.3090GB",  //服务使用量 加单位
            "bill_price_str": "0.02/GB"  //服务价格 加单位
        },
        ......
    ]
}

```

## 实时直播并发人数（getSubLssNum）

请求方式 GET POST 需要认证

查询指定客户 实时直播并发人数

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubLssNum" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubLssNum',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": {
        "onlinenumber": 0,  //客户当前 直播在线人数
        "time": 1477650905,  //本次请求服务器时间戳
        "uptime": 1477650905,   //本条记录的生成时间
        "limit_normal": 0,
        "limit_special": 0,
        "limit": 0
    }
}
```

## 实时点播并发人数（getSubVodNum）

请求方式 GET POST 需要认证

查询指定客户 实时点播并发人数

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubVodNum" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubVodNum',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": {
        "onlinenumber": 0,  //客户当前 点播在线人数
        "time": 1477650905,  //本次请求服务器时间戳
        "uptime": 1477650905,   //本条记录的生成时间
        "limit_normal": 0,
        "limit_special": 0,
        "limit": 0
    }
}
```

## 直播流量使用情况（getSubLssFlow）

请求方式 GET POST 需要认证

查询指定客户 直播流量 使用情况

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubLssFlow" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubLssFlow',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |
| stime               | `int`    开始时间戳  |
| etime               | `int`    结束时间戳   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "search success",
    "List": {
        "type": [  // 数据分类 tag
            "sum",
            "play",
            "publish",
            "mobile"
        ],
        "data": {
            "0": {  // 数据样例
                "uptime": 0,
                "sum": 0,
                "play": 0,
                "publish": 0,
                "mobile": 0
            },
            "1477648200": {  
                "uptime": 1477648200,
                "sum": 1271040,  //总和流量
                "play": 573696,  //pc播放流量
                "publish": 697344,  //发布流量
                "mobile": 0  //手机观看流量
            },
            ......
        },
        "step": 300,  //时间 步长
        "time_period": [
            1477648200,  //开始时间
            1477650339  //结束时间
        ]
    }
}
```

## 直播带宽使用情况（getSubLssBandWidth）

请求方式 GET POST 需要认证

查询指定客户 直播带宽 使用情况

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubLssBandWidth" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubLssBandWidth',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |
| stime               | `int`    开始时间戳  |
| etime               | `int`    结束时间戳   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "search success",
    "List": {
        "type": [  // 数据分类 tag
            "sum",
            "play",
            "publish",
            "mobile"
        ],
        "data": {
            "0": {  // 数据样例
                "uptime": 0,
                "sum": 0,
                "play": 0,
                "publish": 0,
                "mobile": 0
            },
            "1477648200": {  
                "uptime": 1477648200,
                "sum": 1271040,  //总和带宽
                "play": 573696,  //pc播放带宽
                "publish": 697344,  //发布带宽
                "mobile": 0  //手机观看带宽
            },
            ......
        },
        "step": 300,  //时间 步长
        "time_period": [
            1477648200,  //开始时间
            1477650339  //结束时间
        ]
    }
}
```

## 点播流量使用情况（getSubVodFlow）

请求方式 GET POST 需要认证

查询指定客户 点播流量 使用情况

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubVodFlow" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubVodFlow',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |
| stime               | `int`    开始时间戳  |
| etime               | `int`    结束时间戳   |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "search success",
    "List": {
        "type": [  // 数据分类 tag
            "direct",
            "upload"
        ],
        "data": {
            "1477648800": {
                "uptime": 1477648800,  //更新时间
                "direct": 22548,         //直播生成的视频 点播流量
                "upload": 2254848     //上传的视频 点播流量
            },
            ......
        },
        "step": 3600,   //时间 步长
        "time_period": [ 
            1477206000,   //开始时间
            1477650339   //结束时间
        ]
    }
}
```

## 直播流量每月使用情况（getSubLssMonthPeak）

请求方式 GET POST 需要认证

查询指定客户 直播流量  每月使用情况

```shell
curl -X "POST" "http://58jinrongyun.com/api/CompanyMgr/getSubLssMonthPeak" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/CompanyMgr/getSubLssMonthPeak',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                  | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id           | `int`    客户ID 指定的客户   |
| month              | `int`    月份表示 例如 201609  可选 默认为空 表示查询当月  |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "ok",
    "user": "24894",  //奥点uin
    "sum": 51620736  //月度流量使用
}
```

## 其他

### 房间认证接口规范

如果客户设置了 认证链接 则每当用户进入房间都会进行认证

后台把进入房间所带的参数原样转发到认证链接接口，请求方式为GET 

例如

后台设置认证链接为：http://58jinrongyun.com/cache/test_auth.php

用户打开观看连接：http://58jinrongyun.com/glive/35?token=abc&nick=test&uid=10001

后台将会请求 http://58jinrongyun.com/cache/test_auth.php?room_id=35&token=abc&nick=test&uid=10001 进行认证


> 认证接口需要返回json标识认证是否通过 格式如下：

```json
//认证成功
{
  "errno": 0,
  "message": "success"
}

//认证失败
{
  "errno": 403,  //你可以换成你的错误码 非0表示错误  0标识成功
  "message": "auth failed",  //你可以换成你的错误信息
  "redirect": "http://baidu.com/404.html"  //你可以换成你的错误页面
}
```
