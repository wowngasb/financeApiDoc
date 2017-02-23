# 场景组操作 AdminHsms

直播场景组设置

## 创建场景组（newHsmsGroup）

请求方式 GET POST 需要认证

创建场景组

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/newHsmsGroup" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/newHsmsGroup',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| group_name            | `String`  场景名                     |
| group_content                | `String`  场景描述    |
| admin_id                | `int`  用户id         |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "创建成功",
    "Info": {
        "group_id": 9    //场景组编号
    }
}
```


## 修改场景组状态（stateHsmsGroup）

请求方式 GET POST 需要认证

修改场景组状态

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/stateHsmsGroup" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/stateHsmsGroup',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| group_id            | `Int`  场景名                     |
| state                | `Int`  状态 1 正常 2隐藏 9删除    |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```

## 更新场景组（updateHsmsGroup）

请求方式 GET POST 需要认证

修改场景组状态

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/updateHsmsGroup" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/updateHsmsGroup',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| group_id            | `Int`  场景名                     |
| group_name                | `String`  场景组名    |
| group_content                | `String`  场景组描述    |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```


## 获取场景列表（listHsmsGroup）

请求方式 GET POST 需要认证

获取场景列表

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/listHsmsGroup" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/listHsmsGroup',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| start            | `Int`  开始位置                     |
| limit                | `Int`  每页最大数量    |
| sort_option                | `Array`  排序规则   ['field' => 'create_time', 'direction' => 'desc'] |
| admin_id                | `Int`  用户id    |
| state                | `Int`  状态 1 正常 2隐藏 9删除     |


> 返回结果如下:
```json
{
    "Flag": 100,
    "rows": [
        {
            "scene_id": 1,
            "admin_id": 1,
            "group_id": 1,         
            "scene_name": "name1",       //场景名
            "scene_config": "config1",   //场景配置
            "scene_type": "hsms-logo",   //场景logo
            "scene_sort": 100,      //排序值
            "state": 1,         //状态
            "create_time": "2017-01-10 09:18:43",
            "uptime": "2017-01-22 10:38:50",
            "config": null,
            "group": {
              //所属场景组信息
                "group_id": 1,
                "admin_id": 281,
                "group_name": "name",
                "group_content": "qqqqq",
                "group_config": null,
                "state": 1,
                "create_time": "2017-01-09 15:53:29",
                "uptime": "2017-01-11 16:32:57",
                "config": []
            }
        },
      ...
    "results": 2
}
```


## 设置更新场景组配置（updateHsmsGroupConfig）

请求方式 GET POST 需要认证

设置更新场景组配置

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/updateHsmsGroupConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/updateHsmsGroupConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| group_id            | `Int`  场景组id                     |
| group_config                | `Array`  场景组配置    |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```

## 改变场景状态（stateHsmsScene）

请求方式 GET POST 需要认证

改变场景状态

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/stateHsmsScene" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/stateHsmsScene',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| scene_id            | `Int`  场景组id                     |
| state                | `Int`  状态值   1整除 9删除 |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```

## 设置更新场景配置（updateHsmsSceneConfig）

请求方式 GET POST 需要认证

设置更新场景配置

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/updateHsmsSceneConfig" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/updateHsmsSceneConfig',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 |描述                                          |
| ---------------------- | ------------------------------------------------ |
| scene_id            | `Int`  场景组id                     |
| scene_config                | `Array`  场景配置 |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```

## 更新场景（updateHsmsScene）

请求方式 GET POST 需要认证

更新场景

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/updateHsmsScene" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/updateHsmsScene',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 |描述                                          |
| ---------------------- | ------------------------------------------------ |
| scene_id            | `Int`  场景组id         |
| scene_name                | `String`  场景配置 |
| scene_sort                | `Int`  场景排序 |
| position                | `Int`  图层位置 |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "修改成功",
}
```

## 新建场景（newHsmsScene）

请求方式 GET POST 需要认证

新建场景

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/newHsmsScene" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/newHsmsScene',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 |描述                                          |
| ---------------------- | ------------------------------------------------ |
| group_id            | `Int`  场景组id         |
| admin_id                | `Int`  用户id |
| scene_name                | `String`  场景名 |
| scene_sort                | `Int`  场景排序 |
| scene_type                | `Int`  场景类型 ['弹幕', '预告', '封面', '投票', '片尾', '记分牌', '弹幕', 'LOGO', '字幕', '通用场景', '足球场景'] |
| position                | `Int`  图层位置 |


> 返回结果如下:

```json
{
    "Flag": 100,
    "FlagString": "创建成功",
    "Info": {
        "scene_id": 9    //场景组编号
    }
}
```


## 获取场景列表（listHsmsScene）

请求方式 GET POST 需要认证

获取场景列表

```shell
curl -X "POST" "http://58jinrongyun.com/api/AdminHsms/listHsmsScene" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/AdminHsms/listHsmsScene',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```

| 字段                 |描述                                          |
| ---------------------- | ------------------------------------------------ |
| start            | `Int`  开始位置         |
| limit                | `Int`  每页条数 |
| sort_option                | `Array`  排序规则 |
| group_id                | `Int`  场景组id |
| state                | `Array`  状态 1正常 2隐藏 [1,2]|


> 返回结果如下:

```json
{
    "Flag": 100,
    "rows": [
        {
            "scene_id": 1,
            "admin_id": 1,
            "group_id": 1,
            "scene_name": "name1",   //场景名
            "scene_config": "config1",   //场景配置
            "scene_type": "hsms-logo",   //场景类型
            "scene_sort": 100,     //排序规则
            "state": 1,
            "create_time": "2017-01-10 09:18:43",
            "uptime": "2017-01-22 10:38:50",
            "config": null,
            "group": {
                //场景组信息
                "group_id": 1,
                "admin_id": 281,
                "group_name": "name",
                "group_content": "qqqqq",
                "group_config": null,
                "state": 1,
                "create_time": "2017-01-09 15:53:29",
                "uptime": "2017-01-11 16:32:57",
                "config": []
            }
        },
        ...
    ],
    "results": 2
}
```