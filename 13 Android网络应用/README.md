## 13 Android网络应用
1 TCP
客户端 服务端 多线程
项目中很少用

2 访问网络资源
URL的用法 //访问URL对应的资源
	getFile //资源名
	getHost //主机名
	getPath //路径
	getPort //端口号
	getProtocol //协议名
	getQuery //查询字符串
	openStream //读取资源的输入流
	openConnection //URLConnection
	
URLConnection //发送请求 读取资源
	1 URL调用openConnection返回 URLConnection
	2 设置URLConnection的参数和普通请求属性
	3 发送get请求 调用connect
	4 发生POST请求 PrintWriter输出流发送请求参数
	5 远程资源可用 可访问远程资源头字段 或通过输入流读取远程资源数据
	//设置请求头字段的方法
	setAllowUserInteraction 
	setDoInput 
	setDoOutput 
	setIfModifiedSince
	setUseCaches
	
	setRequestProperty
	addRequestProperty
	//访问头字段和内容
	getContent //返回内容
	getHeaderFields //获取响应头字段
	getInputStream //输入流 获取响应内容
	getOutputStream //输入流 发送请求参数
	
	//访问特殊响应头字段的值
	getContentEncoding
	getContentLength 
	getContentType
	getDate
	getExpiration
	getLastModified
	
3 HttpURLConnection 操作HTTP资源
	getResponseCode //获取服务器响应码
	getResponseMessage //获取服务器响应消息
	getRequestMethod //获取发送请求的方法
	setRequestMethod //设置发送请求的方法
	
4 HttpClient //增强版的HttpURLConnection
	1 创建HttpClient对象
	2 发生get请求 创建HttpGet
	3 发生POST请求 创建HttpPost
	4 添加请求参数 setParams() HttpPost可调用setEntity
	5 execute发送请求 返回 HttpResponse
	6 HttpResponse的getAllHeaders getHeaders 获取响应头
	7 HttpResponse的getEntity获取HttpEntity对象

5 WebView显示网页 
有点问题
	goBack() //后退
	goForward //前进
	loadUrl //加载网页
	zoonIn //放大网页
	zoomOut //缩小网页

	显示HTML
	JavaScript //存在问题
	WebService
	

	








