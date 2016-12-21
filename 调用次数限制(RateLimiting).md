# 调用次数限制 RateLimiting

每个 API_KEY 每分钟调用次数限制为`100`，个别特殊 API 调用次数限制另行设定

不同的API会有不同的调用次数限制, 请检查返回 header 中的如下字段

| header 字段                | 描述                                         |
| ---------------------------- | ------------------------------------------------ |
| X-RateLimit-LimitTag     | 限制规则分类 all 代表总数限制                        |
| X-RateLimit-LimitNum    | 限制调用次数，超过后服务器会返回 403 错误              |
| X-RateLimit-Remaining   | 当时间段中还剩下的调用次数                           |
| X-RateLimit-TimeRange  | 限制时间范围长度 单位 秒                            |
| X-RateLimit-TimeReset   | 限制重置时间 unix time                          |