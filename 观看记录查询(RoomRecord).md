# 观看记录查询 RoomRecord

房间用户观看记录相关数据查询，子公司可以查询其下属的房间，总公司可以查询旗下所有子公司的房间

## 获取房间在线人数记录（listRoomRecord）

请求方式 GET POST 需要认证

获取房间在线人数记录

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listRoomRecord" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listRoomRecord',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                     |
| stime                | `int`  开始时间戳    |
| etime                | `int`  结束时间戳         |
| is_vod               | `int`  是否为点播  0不是，1是  可选  默认为 0        |
| is_sub_ref            | `int`  是来源记录  0不是，1是  可选  默认为 0       |


> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "id": 55278,
            "admin_id": 188,  //管理员id 
            "room_id": 100067,  //房间ID 指定的房间
            "ref_host": "",  //访问来源域名 需要参数 is_sub_ref设置为1
            "is_sub_ref": 0,  //是来源记录
            "num": 1,  //房间在线人数
            "timer_count": 2462063,  //定时器序号 乘以600 为记录的时间戳
            "uptime": "2016-10-23 23:51:02"  //记录更新时间
        },
        ......
    ],
    "results": 2,  //结果条目数量 为 rows数组的长度
    "pointStart": 1477000200000,  //时间起始 单位 毫秒
    "data": {  //自动补全后的数据数组 可用于直接生成图表
        "total": [
            0,  //每个时间点对应的 在线人数 两个数据的时间间隔为 pointInterval
            ......
        ]
    },
    "pointInterval": 600000  //时间间隔 单位 毫秒
}
```
***

## 获取子公司在线人数记录（listAppRecord）

请求方式 GET POST 需要认证

获取子公司在线人数记录

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listAppRecord" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listAppRecord',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司ID 指定的子公司                 |
| stime                | `int`  开始时间戳    |
| etime                | `int`  结束时间戳         |
| is_vod               | `int`  是否为点播  0不是，1是  可选  默认为 0        |
| is_sub_ref            | `int`  是来源记录  0不是，1是  可选  默认为 0       |


> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "id": 55278,
            "admin_id": 188,  //管理员id 
            "room_id": 100067,  //房间ID 指定的房间
            "ref_host": "",  //访问来源域名 需要参数 is_sub_ref设置为1
            "is_sub_ref": 0,  //是来源记录
            "num": 1,  //房间在线人数
            "timer_count": 2462063,  //定时器序号 乘以600 为记录的时间戳
            "uptime": "2016-10-23 23:51:02"  //记录更新时间
        },
        ......
    ],
    "results": 2,  //结果条目数量 为 rows数组的长度
    "pointStart": 1477000200000,  //时间起始 单位 毫秒
    "data": {  //自动补全后的数据数组 可用于直接生成图表
        "total": [
            0,  //每个时间点对应的 在线人数 两个数据的时间间隔为 pointInterval
            ......
        ]
    },
    "pointInterval": 600000  //时间间隔 单位 毫秒
}
```
***

## 获取房间IP访问记录（listRoomIpDistribution）

请求方式 GET POST 需要认证

获取房间IP访问记录

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listRoomIpDistribution" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listRoomIpDistribution',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| room_id             | `int`  房间ID 指定的房间                 |
| stime                | `int`  开始时间戳    |
| etime                | `int`  结束时间戳         |
| is_vod               | `int`  是否为点播  0不是，1是  可选  默认为 0        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "login_ip": "127.0.0.1"  //ip访问记录
        },
    ],
    "results": 2,  //结果条目数量 为 rows数组的长度
    "Province": [
        {
            "name": "北京",  //每个省ip分布数量
            "value": 0
        },
        ......
    ]
}
```

## 获取子公司IP访问分布记录（listAppIpDistribution）

请求方式 GET POST 需要认证

获取子公司IP访问记录

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listAppIpDistribution" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listAppIpDistribution',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司ID 指定的子公司               |
| stime                | `int`  开始时间戳    |
| etime                | `int`  结束时间戳         |
| is_vod               | `int`  是否为点播  0不是，1是  可选  默认为 0        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "login_ip": "127.0.0.1"  //ip访问记录
        },
    ],
    "results": 2,  //结果条目数量 为 rows数组的长度
    "Province": [
        {
            "name": "北京",  //每个省ip分布数量
            "value": 0
        },
        ......
    ]
}
```

## 获取房间观看记录（listRoomViewRecord）

请求方式 GET POST 需要认证

获取房间观看记录

```shell
curl -X "POST" "http://finance.aodianyun.com/api/RoomRecord/listRoomViewRecord" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/RoomRecord/listRoomViewRecord',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| start                | `int`  查询记录跳过数量 用于分页                |
| limit                | `int`  查询记录每页数量 用于分页             |
| room_id            | `int`  房间ID 指定的房间                 |
| stime               | `int`  开始时间戳               |
| etime               | `int`  结束时间戳               |
| user_id              | `string`  用户user_id 查询参数  可选  默认为空            |
| login_ip             | `string`  登录ip  可选  默认为空   |
| agent               | `string`  设备表示 WEB 网页端，WAP 移动端  可选  默认为空        |
| ref_host             | `string`  来源域名  可选  默认为空       |
| is_vod               | `int`  是否为点播  0不是，1是  可选  默认为 0        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "id": 8108,
            "user_id": "YK-844378",
            "room_id": 100067,  //房间ID 指定的房间
            "login_ip": "127.0.0.1",  //ip访问记录
            "m_state": 2,
            "agent": "WEB",  //设备 WEB 网页端，WAP 移动端
            "out_time": "2016-10-24 10:49:33",  //退出房间 时间
            "in_time": "2016-10-24 10:20:00",  //进入房间 时间
            "interval_time": 1773,  //观看时长 单位秒
            "ref_host": "dev.shu.com",  //来源域名
            "ref_url": "http://dev.shu.com/slive/100067",  //来源url
            "uptime": "2016-10-24 00:18:01",  //记录更新时间
            "agent_str": "网页端",  //设备  字符串表示
            "time_str": "29分33秒"  //观看时长  字符串表示
        },
        ......
    ],
    "results": 2  //查询结果总数量数量 用于分页 
}
```
