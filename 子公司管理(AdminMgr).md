# 子公司管理 AdminMgr

管理子公司相关操作，总公司可以操作旗下代理的子公司

## 新建子公司（addCaijingSubAdmin）

请求方式  POST 需要认证

添加新的 子公司 需要总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/addCaijingSubAdmin" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/addCaijingSubAdmin',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| title                | `string`     子公司标题         |
| name              | `string`    登陆用户名         |
| sublimit            | `int`    旗下子公司数量限制         |
| is_lssflowinfo       | `int`    是否拥有查看流量权限  1是，0否         |
| is_mcsconfig           | `int`    是否拥有修改发布配置权限  1是，0否         |
| limit_onlinenumber     | `int`      子公司 在线并发限制  上级limit_type为2时有效   -1为无限制         |
| limit_bandwidth        | `int`     子公司 带宽限制  上级limit_type为1时有效  -1为无限制         |
| limit_yearflow          | `int`     子公司 年流量限制  上级limit_type为3时有效   -1为无限制         |
| limit_bandwidth_ex     | `int`   子公司 带宽限制 特殊限额         |
| limit_onlinenumber_ex  | `int`   子公司 在线并发限制 特殊限额         |
| limit_weekdays_use_ex   | `string`   使用特殊限额 的 特殊星期几 使用_分隔         |
| pasw                    | `string`    登录密码         |
| expiration_date          | `string`   房间有效期 到达有效期后会被冻结         |
| is_roomvod              | `int`   是否开启点播功能  1 开启 2 关闭         |
| limit_onlinenumber_vod  | `int`   点播并发人数 限制         |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "新建子账号成功",
    "Info": {
        "admin_id": 10036,  // 子公司id
    }
}
```

## 修改子公司（setCaijingSubAdmin）

请求方式  POST 需要认证

修改指定的 子公司 需要总公司权限


```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/setCaijingSubAdmin" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/setCaijingSubAdmin',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| admin_id                | `int`  需要设置的子公司admin_id      |
| title                | `string`     子公司标题         |
| name              | `string`    登陆用户名         |
| sublimit            | `int`    旗下子公司数量限制         |
| is_lssflowinfo       | `int`    是否拥有查看流量权限  1是，0否         |
| is_mcsconfig           | `int`    是否拥有修改发布配置权限  1是，0否         |
| limit_onlinenumber     | `int`      子公司 在线并发限制  上级limit_type为2时有效   -1为无限制         |
| limit_bandwidth        | `int`     子公司 带宽限制  上级limit_type为1时有效  -1为无限制         |
| limit_yearflow          | `int`     子公司 年流量限制  上级limit_type为3时有效   -1为无限制         |
| limit_bandwidth_ex     | `int`   子公司 带宽限制 特殊限额         |
| limit_onlinenumber_ex  | `int`   子公司 在线并发限制 特殊限额         |
| limit_weekdays_use_ex   | `string`   使用特殊限额 的 特殊星期几 使用_分隔         |
| pasw                    | `string`    登录密码         |
| expiration_date          | `string`   房间有效期 到达有效期后会被冻结         |
| is_roomvod              | `int`   是否开启点播功能  1 开启 2 关闭         |
| limit_onlinenumber_vod  | `int`   点播并发人数 限制         |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改子账号"
}
```

## 冻结解冻子公司（stateSubAdmin）

请求方式  POST 需要认证

设置子公司状态 正常1，冻结2  需要总公司权限


```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/stateSubAdmin" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/stateSubAdmin',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| admin_id                | `int`  需要设置的子公司admin_id      |
| state                | `int`  状态 正常1，冻结2 关闭9        |

> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "操作成功"
}
```


## 查找子公司（getSubAdminList）

请求方式 GET POST 需要认证

查找旗下的子公司 需要总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/getSubAdminList" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/getSubAdminList',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| start               | `int`  起始位置 用于分页     |
| limit               | `int`  每页数量 用于分页      |
| sort_option        | `array`  排序依据 ['field' => 'admin_id', 'direction' => 'asc']    |
| admin_id          | `int`  需要设置的子公司admin_id      |
| create_time_s      | `string`  创建时间范围 起始 为空表示不限制    |
| create_time_e      | `string`  创建时间范围 结束 为空表示不限制    |
| state              | `array`  状态  正常1，冻结2 关闭9 为空表示不限      |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "admin_id": 280,  //子公司相关信息
            "state": 1,
            "name": "sdk_test",
            ......
        },
        ......
    ],
    "results": 1
}
```

## 设置子公司密码（setAdminPwd）

请求方式 POST 需要认证

设置子公司密码  需要总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/setAdminPwd" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/setAdminPwd',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ 
| admin_id          | `int`  需要设置的子公司admin_id      |
| pasw      | `string`  登录密码    |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": "修改密码成功"
}
```

## 获取用户信息（getAdminInfo）

请求方式 GET POST 需要认证

获取指定admin_id 信息 需要自身或 所属总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/getAdminInfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/getAdminInfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ 
| admin_id          | `int`  需要设置的子公司admin_id      |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "Info": {
        "admin_id": 281,
        "state": 1,          //管理员状态，1正常，2冻结，9删除
        "name": "subAdmin",
        "pasw_time": "2017-01-11 09:37:59",
        "telephone": null,
        "realname": null,
        "title": "子公司一号",
        ...
    }
}
```


## 流量查看权限（setAdminIsLssflowinfo）

请求方式 POST 需要认证

设置指定admin_id子公司 是否可以直播流量带宽信息  需要所属总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/setAdminIsLssflowinfo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/setAdminIsLssflowinfo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ 
| admin_id          | `int`  需要设置的子公司admin_id      |
| is_lssflowinfo    | `int`  1开启权限   0关闭权限             |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改流量查看权限成功"
}
```

## 发布配置权限（setAdminIsMcsConfig）

请求方式 POST 需要认证

设置指定admin_id子公司 是否可以修改直播间的发布配置  需要所属总公司权限


```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/setAdminIsMcsConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/setAdminIsMcsConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ 
| admin_id          | `int`  需要设置的子公司admin_id      |
| is_mcsconfig    | `int`  1开启权限  0关闭权限              |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改MCS权限成功"
}
```

## 点播功能权限（setAdminIsRoomvod）

请求方式 POST 需要认证

设置指定admin_id子公司 是否可以使用点播功能  需要所属总公司权限

```shell
curl -X "POST" "http://finance.aodianyun.com/api/AdminMgr/setAdminIsRoomvod" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://finance.aodianyun.com/api/AdminMgr/setAdminIsRoomvod',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```


| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ 
| admin_id          | `int`  需要设置的子公司admin_id      |
| is_roomvod    | `int`  1开启权限  0关闭权限              |
     
> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改点播功能成功"
}

```

