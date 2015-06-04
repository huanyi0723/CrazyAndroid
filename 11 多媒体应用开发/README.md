## 11 多媒体应用开发
1 基本概念
音频录制 播放
视频录制 播放

2 播放音频
MediaPlayer的用法
	start() //开始或恢复播放
	stop() //停止播放
	pause() //暂停播放
	//装载音频文件 静态方法
	create(Context context, Uri uri) //从指定Uri来装载音频文件
	create(Context context, int resid) //从资源文件中加载
	//装载音频文件
	setDataSource(Context context, Uri uri)
	setDataSource(String path) //path路径所代表的文件
	setDataSource(FileDescriptor fd) //fd所代表的文件
	setDataSource(FileDescriptor fd, long offset, long length) //
	
	prepare() //准备音频
	
	//接口
	setOnPreparedListener //调用prepare()触发
	setOnCompletionListener //播放完后调用
	setOnSeekCompleteListener //seek() 方法后调用
	setOnErrorListener //播放错误调用
	
	//音效控制
	AudioEffect
		Equalizer //均衡控制器
		Virtualizer //示波奇
		BassBoost  //重低音控制器
		PresetReverb //预设音场控制器
		EnvironmentalReverb 
		
SoundPool播放音效 //密集 短促的声音
	//构造器
	SoundPool(int maxStreams, int streamType, int srcQuality) //支持多少声音 指定声音类型 声音品质
	//加载声音
	load(String path, int priority) 
	load(Context context, int resId, int priority) 
	load(AssetFileDescriptor afd, int priority) 
	load(FileDescriptor fd, long offset, long length, int priority) 
	//播放
	play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)

3 播放视频
VideoView的用法
	setVideoPath(String path)
	setVideoURI(Uri uri)
	start()
	stop()
	pause()
窗口 全屏的问题

MediaPlayer和SurfaceView实现播放








