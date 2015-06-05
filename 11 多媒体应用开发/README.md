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

4 录制音频
MediaRecorder录制的步骤
	1 创建MediaRecorder对象
	2 调用MediaRecorder对象的setAudioSource()设置声音来源 MediaRecorder.AudioSource.MIC指定麦克风
	3 setOutputFormat //录制的音频文件格式
	4 setAudioEncoder //声音的编码格式
	5 setAudioEncodingBitRate //编码位率
	6 setAudioSamplingRate //采样率
	7 setOutputFile //文件保存
	8 prepare //准备录制
	9 start //开始录制
	10 stop //停止录制
	11 release //释放资源

注意 文件路径总结
	Environment.getExternalStorageDirectory().getCanonicalFile() 
		对应的路径 /storage/emulated/0 //就是SD卡根路径
	Environment 常用方法
		getDataDirectory() //获取 Android 数据目录。
		getDownloadCacheDirectory() //获取 Android 下载/缓存内容目录。
		getExternalStorageDirectory() //获取外部存储目录即 SDCard
		getExternalStoragePublicDirectory(String type) //取一个高端的公用的外部存储器目录来摆放某些类型的文件
		getExternalStorageState() //获取外部存储设备的当前状态
		getRootDirectory() //获取 Android 的根目录

5 拍照片
Camera的用法
	1 Camera.open(0) //打开摄像头
	2 camera.getParameters() //获取拍照参赛
	3 camera.setPreviewDisplay() //设置哪个View显示取景图像
	4 camera.startPreview() //预览取景
	5 camera.takePicture() //拍照
	6 camera.stopPreview() //结束预览取景
	
6 录制视频
MediaRecorder
存在问题






