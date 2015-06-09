## 7 图形与图像处理
1 简单图片
	Drawable
	Bitmap的用法
		//创建Bitmap对象
		createBitmap(Bitmap source, int x, int y, int width, int height) 
		//从源位图source中挖取宽width高height指定坐标点(x, y)开始的Bitmap对象
		createBitmap(Bitmap source, int x, int y, int width, int height, Matrix m, boolean filter)
		//Matrix进行变换
	createBitmap(int width, int height, Config config)
	//回收相关
		isRecycled //是否已经回收
		recycle //立即回收
	BitmapFactory //工具类 解析 创建Bitmap
		decodeByteArray(byte[] data, int offset, int length) //从字节数组中解析
		decodeFileDescriptor(FileDescriptor fd) //从FileDescriptor对应的文件中解析
		decodeResource(Resources res, int id) //从资源文件中解析
		decodeStream(InputStream is) //从输入流中解析

2 绘图
	Canvas //有问题 画布
	//画图的方法
		drawArc //画弧
		drawBitmap //画位图
		drawCircle //画圆
		drawLines //画线
	//坐标变换
	
	
	Paint //画笔
	
	