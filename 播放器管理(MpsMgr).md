# 播放器管理 MpsMgr

MPS播放器设置功能相关操作

## 新建播放器(newMpsItem)

请求方式 GET POST 需要认证

根据admin_id 创建Mps播放器

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/newMpsItem" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/newMpsItem',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id          | `int`  需要设置的子公司admin_id                     |
| name             | `string`  播放器名称                    |
| style             | `int`  播放器样式 默认1                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "创建成功",
    "MpsId": 234234,  // 本次创建的播放器 mps_id
    "Info": [  // 创建成功之后  当前已存在的播放器列表
        {
            "mps_id": "36",
            "name": "默认播放器"
        },
        ......
    ]
}
```

## 列出播放器(listMpsItem)

请求方式 GET POST 需要认证

获取指定admin_id 已创建的播放器列表

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/listMpsItem" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/listMpsItem',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  指定的子公司admin_id                     |

> 返回结果如下:

```
{
    "Flag": 100,
    "mps_item_list": [
        {
            "mps_id": "36",  // 播放器唯一标识id
            "name": "默认播放器"  // 播放器名称
        },
        ...
    ]
}
```


## 获取播放器信息(getMpsItem)

请求方式 GET POST 需要认证

获取指定mps_id的播放器的详细信息

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/listMpsItem" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/listMpsItem',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  指定的子公司admin_id                     |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "查询成功",
    "Info": {
        "id": "1587",
        "uin": "1436",
        "name": "测试",
        "style": "2",
        "config": {  // 播放器详细配置
            "watermarkPosition": "",    //浮层图片位置1
            "watermarkPosition2": "",   //浮层图片位置2
            "watermark2": "",      //浮层图片2
            "watermark": "",    //浮层图片1
            "supernatantword": "",   //浮层文字
            "displayfrequen": "",   //浮层文字 显示频率
            "scrollposition": "",   //浮动文字 滚动位置
            "logoPosition": "left",  // logo位置  right 右侧 center 中间 left 左侧    
            "adveReAddr": "",  // logo 点击跳转链接
            "logoAddr": "http://pic.aodianyun.com/aodianyun/mps/logo/b4413fa2dcb00868004e3ad85eabbe65/0/0",  //logo图片地址
            "backgroundimage": ""  
        },
        "isDefault": "0",
        "addTime": "1482916581",
        "upTime": "1482977511"
    }
}
```

## 设置logo(editLogo)

请求方式 GET POST 需要认证

设置MPS播放器的logo

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/editLogo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/editLogo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |
| logoPosition       | `string`  logo位置  right 右侧 center 中间 left 左侧                    |
| adveReAddr       | `string`  点击跳转链接(完整链接地址)                   |
| logoAddr_bytes   | `string`   图片文件具体内容 使用base64编码  |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {},   //修改后的mps实例信息 参见接口getMpsItem
    }
}
```


## 清除logo(clearLogo)

请求方式 GET POST 需要认证

清除MPS播放器的logo

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/clearLogo" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/clearLogo',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": {
        "Flag": 100,
        "FlagString": "查询成功",
        "Info": {},  //修改后的mps实例信息 参见接口getMpsItem
        "_uptime_": 1482918963
    }
}
```

## 设定名称(editName)

请求方式 GET POST 需要认证

修改MPS播放器的名称

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/editName" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/editName',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器id                    |
| name             | `string`  播放器名称                   |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
    }
}
```


## 设置水印(editWatermark)

请求方式 GET POST 需要认证

设置MPS水印

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/editWatermark" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/editWatermark',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器唯一id                    |
| watermarkPosition             | `string`  水印位置一                   |
| watermarkPosition2             | `string`  水印位置二                   |
| watermark_bytes             | `string`  图片文件具体内容 使用base64编码                  |
| watermark2_bytes             | `string`  图片文件具体内容 使用base64编码                  |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
}
```

## 清除水印一(clearWatermark)

请求方式 GET POST 需要认证

清除第一块水印

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/clearWatermark" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/clearWatermark',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器唯一id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
}
```

## 清除水印二(clearWatermark2)

请求方式 GET POST 需要认证

清除第一块水印

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/clearWatermark2" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/clearWatermark2',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器唯一id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
}
```


## 设置浮动信息(editSupernatant)

请求方式 GET POST 需要认证

设置浮动信息显示

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/editSupernatant" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/editSupernatant',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  需要设置的子公司admin_id                     |
| mps_id             | `int`  播放器唯一id                    |
| supernatantword             | `string`  文字信息                    |
| displayfrequen             | `int`  显示频率                    |
| scrollposition             | `string`  活动方式                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "FlagString": "操作成功",
    "Info": { },  //修改后的mps实例信息 参见接口getMpsItem
}
```

## 创建动态直播实例(createDynamicLssPlayer)

请求方式 GET POST 需要认证

创建MPS 动态直播实例

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/createDynamicLssPlayer" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/createDynamicLssPlayer',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())

```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司admin_id                     |
| mps_id             | `int`  播放器mps_id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "uin": 1436,   //uin  用于创建播放器
        "appId": "fb16muuzm11XiWXx"   //实例id用于创建播放器
    }
}
```


## 创建动态点播实例(createDynamicVodPlayer)

请求方式 GET POST 需要认证

创建MPS 动态点播实例

```shell
curl -X "POST" "http://58jinrongyun.com/api/MpsMgr/createDynamicVodPlayer" \
     -H "Authorization: dyyadmin:{{API_KEY}} \n Content-type: application/x-www-form-urlencoded; charset=UTF-8" \
     -d "params"
```

```python
import requests

result = requests.post('http://58jinrongyun.com/api/MpsMgr/createDynamicVodPlayer',
  headers={"Authorization": "dyyadmin:{{API_KEY}}", "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},
  data=params)

print(result.json())
```
| 字段                 | 描述                                          |
| ---------------------- | ------------------------------------------------ |
| admin_id             | `int`  子公司admin_id                     |
| mps_id             | `int`  播放器mps_id                    |

> 返回结果如下:

```
{
    "Flag": 100,
    "Info": {
        "uin": 1436,   //uin  用于创建播放器
        "appId": "fb16muuzm11XiWXx"   //实例id用于创建播放器
    }
}
```


> 网页中使用如下播放代码:

``` html
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
</head>
<body>
<div id="MPSplayer"></div>
<script type="text/javascript" src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script><!-- jquery地址也可使用您的地址 -->
<script type="text/javascript" src="http://cdn.aodianyun.com/mps/v1/hlsplayer.js"></script>
<script type="text/javascript">
var objectPlayer=new mpsPlayer({
    container:'MPSplayer',//播放器容器ID，必要参数
    uin: '1436',//用户ID
    appId: 'fm3Bzm3HbHbUWxyS',//播放实例ID
    rtmpUrl: "rtmp://xxx.com/app/stream",  //rtmp地址 直播可以同设置rtmp和hls地址  优先使用rtmp地址
    hlsUrl: "http://xxx.com/app/stream.m3u8",  //hls地址 点播视频只需设置hls地址
    width: '100%',//播放器宽度，可用数字、百分比等
    height: '100%',//播放器高度，可用数字、百分比等
    autostart: false,//是否自动播放，默认为false
    stretching: 1,  //设置全屏模式,1代表按比例撑满至全屏,2代表铺满全屏,3代表视频原始大小,默认值为1。hls初始设置不支持，手机端不支持
    mobilefullscreen: false,  //移动端是否全屏，默认为true
    controlbardisplay: 'enable',//是否显示控制栏，值为：disable、enable默认为disable。
    isclickplay: true,//是否单击播放，默认为false
    isfullscreen: true//是否双击全屏，默认为true
});
/* 以下为 objectPlayer 支持的事件 */
/* objectPlayer.startPlay();//播放 */
/* objectPlayer.pausePlay();//暂停 */
/* objectPlayer.stopPlay();//停止 hls不支持*/
/* objectPlayer.closeConnect();//断开连接 */
/* objectPlayer.setMute(true);//静音或恢复音量，参数为true|false */
/* objectPlayer.setVolume(volume);//设置音量，参数为0-100数字 */
/* objectPlayer.setFullScreenMode(1);//设置全屏模式,1代表按比例撑满至全屏,2代表铺满全屏,3代表视频原始大小,默认值为1。手机不支持 */
</script>
</body>
</html>
```