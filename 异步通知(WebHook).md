# 异步通知 WebHook

WebHook 可以用于处理异步事件通知等。

如果你设置了webhook通知url，有关注的事件触发时，系统会给你发送一个 POST 请求。如果响应码不为`200`，我们最多会重试`3`次，间隔时间分别为5秒，20秒，60秒。

目前支持的 WebHook 事件有 直播开始和结束、直播流畅度通知、直播生成点播文件、直播截图生成、视频上传与转码。

请求会带有触发事件的对应用户和房间信息

不同的事件会有不同的 `event_type` 和 `event_value`

## Payloads

| 字段                 | 描述                                          |
| --------------------- | ------------------------------------------------ |
| room_id            | 触发事件的房间 无对应房间时为0                       |
| admin_id           | 触发事件的用户                                   |
| retry_times         | 重试次数 第一次为1 后续每次加1                       |
| started_at          | 触发时间, Unix 时间戳 单位秒                        |
| event_type         | 事件类型                                        |
| event_value        | 事件值 数据为json格式                              |



## 直播开始和结束

触发时 `event_type` 为 `sys/notify/lss`

> 开始发布 或 停止发布 会收到

``` json
{
    "cmd": "StartPublish",  // 开始发布 StartPublish;  停止发布 StopPublish
    "app": "",
    "stream": "",
    "time": ""
}
```

## 直播流畅度通知

触发时 `event_type` 为 `sys/notify/lss_fluency`

> 直播流畅度通知 会收到

``` json
{
    "app": "",
    "stream": "",
    "forward_fluency": 100,
    "play_fluency": 100,
    "publish_fluency": 100
}
```

## 直播生成点播文件

触发时 `event_type` 为 `sys/notify/live_dvr`

> 直播生成点播文件时 会收到

``` json
{
    "app":"",
    "stream":"",
    "start":1436406628,
    "end":1436408311,
    "url":"",
    "m3u8":"",
    "uptime":1436408347
}
```

## 直播截图生成

触发时 `event_type` 为 `sys/notify/live_dvr_preview_image`

> 直播生成截图文件时 会收到

``` json
{
    "app":"",
    "stream":"",
    "start":1436406628,
    "end":1436408311,
    "image":"",//图片地址
    "uptime":1436408347
}
```

## 视频上传与转码

触发时 `event_type` 为 `sys/notify/upload_dvr`

> 视频文件上传完成后 会收到

``` json
{
    "user": "13830",
    "filename": "movie",
    "url": "http:\/\/13830.long-vod.cdn.aodianyun.com\/u\/13830\/webm\/0x0\/ad6b883587c20c0e7c338d9729c8f23c.webm",
    "uptime": 1481796467
}
```

> 视频文件对应码率转码完成后 会收到

``` json
{
    "user": "13830",
    "url": "http:\/\/13830.long-vod.cdn.aodianyun.com\/u\/13830\/webm\/0x0\/ad6b883587c20c0e7c338d9729c8f23c.webm",
    "m3u8_240": "http:\/\/13830.long-vod.cdn.aodianyun.com\/u\/13830\/m3u8\/426x240\/ad6b883587c20c0e7c338d9729c8f23c\/ad6b883587c20c0e7c338d9729c8f23c.m3u8",
    "m3u8Size_240": 3266531,
    "adaptive": "http:\/\/13830.long-vod.cdn.aodianyun.com\/u\/13830\/m3u8\/adaptive\/ad6b883587c20c0e7c338d9729c8f23c.m3u8"
}
```
