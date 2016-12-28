# 子公司管理 AdminMgr

管理子公司相关操作，总公司可以操作旗下代理的子公司

## 新建子公司（addCaijingSubAdmin）

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

