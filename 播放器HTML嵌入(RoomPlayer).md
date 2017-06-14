# 播放器HTML嵌入

在管理后台新建房间后，可用过以下两种方式在HTML网页中嵌入播放器

## js代码方式（jscode）

引用 dyyplayer.js 然后在js代码中生成 播放器 需要必须参数 房间ID 和 播放器容器ID

[测试页面](http://58jinrongyun.com/helper/room1.php?room_id=1000)

> 嵌入页面代码：

```html
<script type="text/javascript" src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script><!-- jquery地址也可使用您的地址 -->
<script type="text/javascript" src="http://58jinrongyun.com/helper/dyyplayer.js?v=1.02"></script>
<div id="play-container" style="width: 800px;height: 600px;"></div>
<script type="text/javascript">
var playerVar = new dyyPlayer({
    room_id: 1478, //对应房间ID，必要参数
    container: 'play-container', //播放器容器ID，必要参数
    width: '100%', //播放器宽度，可用数字、百分比等
    height: '100%', //播放器高度，可用数字、百分比等
    autostart: true, //是否自动播放，默认为false
    controlbardisplay: 'enable', //是否显示控制栏，值为：disable、enable默认为disable
});
</script>
```
播放器嵌入后，可以使用变量 playerVar.player 对象控制播放器
[在线文档](http://www.aodianyun.com/aodianyun_doc/254)

## 手机布局调整（mobile-mps）

手机端使用MPS播放器使用非全屏播放功能时，因为播放器高度是根据视频高度动态变化的，所以需要增加 playCallback pauseCallback 回调调整页面布局

> 示例代码如下


``` html
<script type="text/javascript" src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script><!-- jquery地址也可使用您的地址 -->
<script type="text/javascript" src="http://58jinrongyun.com/helper/dyyplayer.js?v=1.02"></script>
<div id="play-container" ></div>
<script type="text/javascript">
var playerVar = new dyyPlayer({
    room_id: 1478, //对应房间ID，必要参数
    container: 'play-container', //播放器容器ID，必要参数
    width: '100%',//视频宽度，可用数字、百分比等
    height: '100%',//视频高度，可用数字、百分比等
    autostart: true,//是否自动播放，默认为false
    controlbardisplay: 'enable',//是否显示控制栏，值为：disable、enable默认为disable。
    isclickplay: false,//是否单击播放，默认为false
    isfullscreen: true,//是否双击全屏，默认为true
    playCallback: function(){
        setTimeout(
            function(){
                //可以在这里调整高度
                console.log && console.log("playCallback size:", $('#play-container').width(), $('#play-container').height());
                $('#videoBox').length > 0 && $('#play-container').height( $('#videoBox').height() );
            }
            ,1000);
    },
    pauseCallback: function(){
        setTimeout(
            function(){
                //可以在这里调整高度
                console.log && console.log("pauseCallback size:", $('#play-container').width(), $('#play-container').height());
                $('#videoBox').length > 0 && $('#play-container').height( $('#videoBox').height() );
            }
            ,1000);
    },
    onload: function(){
        //可以在这里增加 播放器事件的 回调函数  不同浏览器支持的事件不同
        console.log && console.log("PlayerReady size:", $('#play-container').width(), $('#play-container').height());
        $('#videoBox').length > 0 && $('#play-container').height( $('#videoBox').height() );
        if(!this.addPlayerCallback){
            return;
        }
        this.addPlayerCallback('start', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback start");
        });
        this.addPlayerCallback('full', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback full");
        });
        this.addPlayerCallback('empty', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback empty");
        });
        this.addPlayerCallback('pause', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback pause");
        });
        this.addPlayerCallback('resume', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback resume");
        });
        this.addPlayerCallback('stop', function(){  // lssplayer 支持 hlsplayer 支持
            console.log && console.log("PlayerCallback stop");
        });

        this.addPlayerCallback('ready', function(){   //  hlsplayer 支持
            console.log && console.log("PlayerCallback ready");
        });
        this.addPlayerCallback('slider.start', function(){  //hlsplayer 支持
            console.log && console.log("PlayerCallback slider.start");
        });
        this.addPlayerCallback('slider.end', function(){   //hlsplayer 支持
            console.log && console.log("PlayerCallback slider.end");
        });
        this.addPlayerCallback('play.stop', function(){   //hlsplayer 支持
            console.log && console.log("PlayerCallback play.stop");
        });
        //html5player  只支持  play.stop
    }
});
</script>
```

## 引用js文件方式（jsfile）

在房间管理页面可获取视频播放器HTML嵌入代码

[测试页面](http://58jinrongyun.com/helper/room2.php?room_id=1000)


### 步骤

1.引用必要的js文件，如页面已引用jQuery则不必重复添加

2.创建放置播放器的DOM容器，并设置播放器容器ID

3.引用生成播放器js，参数r=房间ID，id=播放器容器ID

> 嵌入页面代码：

```html
<div id="play-container" style="width: 800px;height: 600px;"></div>
<script type="text/javascript" src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script><!-- jquery地址也可使用您的地址 -->
<script type="text/javascript" src="http://58jinrongyun.com/helper/room_player.js?r=1000&id=play-container"></script>
```

播放器嵌入后，页面可以使用全局变量 objectPlayer 对象控制播放器
[在线文档](http://www.aodianyun.com/aodianyun_doc/254)


## 学生白板嵌入（wis）

学生端观看 只需获取到 房间id 即可观看

[测试页面](http://58jinrongyun.com/helper/roomwis.php?room_id=1478)

```html
<iframe id="wis-container" style="width: 800px;height: 600px;"></iframe>
<script type="text/javascript" src="http://58jinrongyun.com/helper/room_wis.js?r=1478&id=wis-container"></script>
```

## 教师白板嵌入（twis）

教师端需调用API[接口](#getauthtoken)获取到 认证token之后才可使用 

[测试页面](http://58jinrongyun.com/helper/roomwis.php?room_id=1478&token=a07dVZvHzZPe8GZEAePcC3loHl8Tn5cBXyPpy3qrcdyLqCFhBCbaBJXQdbox)

```html
<iframe id="wis-container" style="width: 800px;height: 600px;"></iframe>
<script type="text/javascript" src="http://58jinrongyun.com/helper/room_wis.js?r=1478&token=a07dVZvHzZPe8GZEAePcC3loHl8Tn5cBXyPpy3qrcdyLqCFhBCbaBJXQdbox&id=wis-container"></script>
```

## 录制回放页面（wisreplay）

通过 [白板录制列表](#listWisReplay) 接口获取的录制列表 可以使用此方式嵌入页面

[测试页面](http://58jinrongyun.com/helper/wisreplaydemo.html)


页面 html
```html
<script src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script>
<script src="http://cdn.aodianyun.com/wis/exchange.js"></script>
<script src="http://cdn.aodianyun.com/lss/aodianplay/player.js"></script>
<div id="player-container" style="width: 400px;height: 300px;"></div>
<iframe id="wis-container" style="width: 800px;height: 600px;"></iframe>
```

页面 javascript
```
var wis_live_url = "http://web.wis.aodianyun.com/replay.php?wisId=lc_5dad72f817f31a2b80feb5511ec13216&expire=1496480152&rand=&dmn=&power=1&sign=6tT6bNIz%2Fj1CIbDnGpVjD9mAoQc%3D&style=010&pad=0&space=0&recordId=031ba7033454db1444e6a96fd8f39c3d";
$(function(){
    $("#wis-container").load(function () {
        WISExchange.Init({
            iframe: "wis-container",
            onSuccess: function (info) {
                console.log("onSuccess", info);
            },
            onDocLoad: function (info) {
                console.log("onDocLoad", info);
            },
            onPageChange: function (info) {
                console.log("onPageChange", info);
            },
            onFailure: function (info) {
                console.log("onFailure", info.error);
            }
        });
        WISExchange.InitPlayer({
            mode: "replay", //replay为录播播放器，live为直播播放器
            container: "player-container",
            width: $("#player-container").width(),
            height: $("#player-container").height()
        });
    });
    $("wis-container").attr("src", wis_live_url);
});
```


## 点播视频播放（vodreplay）

网页播放m3u8视频 你可以选择使用奥点播放器或其他播放器(ckplayer等)

奥点播放器 [测试页面](http://58jinrongyun.com/helper/demo_m3u8.html)

```html
<div id="play" style="width:400px; height:300px;"></div>
<script type="text/javascript" src="http://cdn.aodianyun.com/static/jquery/jquery-1.7.2.min.js"></script><!-- jquery地址也可使用您的地址 -->
<script type="text/javascript" src="http://cdn.aodianyun.com/lss/aodianplay/player.js"></script>
<script type="text/javascript">
var objectPlayer=new aodianPlayer({
    container:'play',//播放器容器ID，必要参数
    hlsUrl: 'http://xxxx.com/xxxx.m3u8',  //视频m3u8地址，必要参数
    /* 以下为可选参数*/
    width: '100%',//播放器宽度，可用数字、百分比等
    height: '100%',//播放器高度，可用数字、百分比等
    autostart: true,//是否自动播放，默认为false
    bufferlength: '1',//视频缓冲时间，默认为3秒。hls不支持！手机端不支持
    maxbufferlength: '2',//最大视频缓冲时间，默认为2秒。hls不支持！手机端不支持
    stretching: '1',//设置全屏模式,1代表按比例撑满至全屏,2代表铺满全屏,3代表视频原始大小,默认值为1。hls初始设置不支持，手机端不支持
    controlbardisplay: 'enable',//是否显示控制栏，值为：disable、enable默认为disable。
    //adveDeAddr: '',//封面图片链接
    //adveWidth: 320,//封面图宽度
    //adveHeight: 240,//封面图高度
    //adveReAddr: '',//封面图点击链接
    //isclickplay: false,//是否单击播放，默认为false
    isfullscreen: true//是否双击全屏，默认为true
});
/* rtmpUrl与hlsUrl同时存在时播放器优先加载rtmp*/
/* 以下为Aodian Player支持的事件 */
/* objectPlayer.startPlay();//播放 */
/* objectPlayer.pausePlay();//暂停 */
/* objectPlayer.stopPlay();//停止 hls不支持*/
/* objectPlayer.closeConnect();//断开连接 */
/* objectPlayer.setMute(true);//静音或恢复音量，参数为true|false */
/* objectPlayer.setVolume(volume);//设置音量，参数为0-100数字 */
/* objectPlayer.setFullScreenMode(1);//设置全屏模式,1代表按比例撑满至全屏,2代表铺满全屏,3代表视频原始大小,默认值为1。手机不支持 */
</script>
```

## 注意事项

1.页面必须有完整的html、head、body标签，同一页面只可嵌入一个播放器

2.视频默认会铺满播放器容器，必要时需设置容器的层叠顺序(z-index)防止视频被其他元素覆盖

3.正确嵌入播放器代码后，管理后台提供的播放器设置、封面设置、人数统计、并发限制、宽带限制等功能才会生效，使用其他播放器将导致上述功能失效

4.嵌入代码使用了[奥点云DMS](http://www.aodianyun.com/aodianyun_doc/23)服务，如观看页面需使用奥点云DMS服务，请联系技术支持协助解决兼容问题
