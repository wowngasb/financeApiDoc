# 导播台管理 RoomLcps

导播台设置功能相关操作

## 销毁演播厅(removeVlssApp)

请求方式 GET POST 需要认证

销毁 VLSS 虚拟演播厅

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomLcps/removeVlssApp" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomLcps/removeVlssApp',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| appId             | `string`  虚拟演播厅 VLSS app id                     |
| instanceID             | `string`  导播台实例id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "成功"
}

```

## 修改演播厅(editVlssApp)

请求方式 GET POST 需要认证

修改 VLSS 虚拟演播厅

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomLcps/editVlssApp" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomLcps/editVlssApp',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| appId             | `string`  虚拟演播厅 VLSS app id                     |
| instanceID             | `string`  导播台实例id                    |
| name             | `string`  名称                    |
| domain             | `string`  域名前缀                    |
| destroyTime             | `string`  销毁时间                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "成功"
}
```

## 分配导播台(setLcpsOwner)

请求方式 GET POST 需要认证

把导播台分配给指定的子公司

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomLcps/setLcpsOwner" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomLcps/setLcpsOwner',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| instanceID             | `string`    导播台实例 id                  |
| admin_id             | `int`  指定的子公司id                   |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
}

```

## 输出配置(setLcpsOutPut)

请求方式 GET POST 需要认证

导播台输出配置

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomLcps/setLcpsOutPut" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomLcps/setLcpsOutPut',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| url             | `string`                      |
| room_id             | `int`  房间id                   |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "设置成功",
}

```

## 获取列表(getVlssAppList)

请求方式 GET POST 需要认证

获取 VLSS 列表 获取uin的 VLSS 列表 并根据admin_id 进行过滤

```shell
curl -X "POST" "http://58jinrongyun.com/api/RoomLcps/getVlssAppList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/RoomLcps/getVlssAppList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  指定子公司id                   |

> 返回结果如下:

```
{
    "Flag": 100,
    "List": [
        {
            "createTime": 1483694955,
            "destroyTime": 1483718400,
            "instanceID": "",     //导播台实例id
            "name": "ce",
            "progress": 100,
            "status": 1,
            "uptime": 1483694960,
            "url": "http://fgsXXXXX.13830.lcps.aodianyun.com:3000",
            "user": "13830",
            "ip": "120.55.182.230",
            "port": "3000",
            "domain": "fgsXXXXX",
            "maxVideoSize": "720p",
            "isPreOpen": 1,
            "id": 12094,
            "studiosInfo": {
                "id": "90adaaf06e9d16bfad82dff4a79fae3a",
                "user": 13830,
            },
            "admin_id": 0,
            "room_id": 0,
            "mcs_list": {
                //mcs 直播账号列表
                "通道0": {
                    "domain": "fgs",
                    "admin_id": 180,
                    "mcs_id": 18613,
                    "mcs_name": "dyy7509124lcps0",   //直播账号登录名
                    "mcs_pwd": "123456",  //直播账号登录密码
                    "mcs_title": "95_lcps_0",
                    "app_type": 2,
                    "app": "i-23l52mrgr-426",
                    "stream": 0
                },
                ...
            },
            "parent_admin_id": 180
        }
    ]
}

```