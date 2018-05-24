# PlayerDemo

本工程主要是通过移植B站的ijkPlayer实现直播和视频播放的功能。

1、ijkPlayer需要自己手动编译代码得到so库，由于本地是windows环境没有配置好，所以在github
上找到了别人已经编译好的aar文件（ijkplayer-java-debug.aar），将三个so库都已经打包好的放在libs目录下，对于aar文件打包项目编译，需要注意build.gradle
中的配置：
    repositories {
        flatDir {
            dirs 'libs'
        }
    }
    
compile(name: 'ijkplayer-java-debug', ext: 'aar')


2、由于外部使用主要在ijkVideoView这个类，所以主要移植其所在的media目录代码即可，主要工作：
修改包名，可以先从入口类着手进行，然后逐个引入包名修改；
R类的替换；
string layout color 等资源文件的增加；


3、功能调试时注意https的支持需要使用编译了openssl的库文件，切记使用正常网络，否则由于网络不稳定的问题导致视频资源数据无法获取也会报如下错误：
05-23 14:41:39.165 20845 20845 E tv.danmaku.ijk.media.player.IjkMediaPlayer: Error (-10000,0)
本人就因为公司网络问题在上面纠结了半天。。。


偶尔也会有超时信息：
05-24 08:27:51.735 25388 25585 I System.out: [socket][:37628] exception
05-24 08:27:51.736 25388 25585 W System.err: java.net.SocketTimeoutException: failed to connect to /192.168.10.100 (port 5222) after 3000ms


4、对于播放器界面改造：
ijkplayer播放器中的播放控制面板时安卓原生自带的MediaController帧布局实现的，如果需要自定义，需要替换掉重写，替换布局文件R.layout.media_controller；
menu菜单的操作选项需要去除， 视频播放比例需要默认调整为fill_parent；
浮窗显示需要初始化时屏蔽；
