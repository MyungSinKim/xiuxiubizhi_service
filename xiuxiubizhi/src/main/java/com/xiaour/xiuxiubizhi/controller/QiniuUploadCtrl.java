package com.xiaour.xiuxiubizhi.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.xiaour.xiuxiubizhi.entity.Image;
import com.xiaour.xiuxiubizhi.service.ImageService;
import com.xiaour.xiuxiubizhi.utils.DateUtil;
import com.xiaour.xiuxiubizhi.utils.ImageCheck;
import com.xiaour.xiuxiubizhi.utils.JsonResult;

@RestController
@RequestMapping("/qiniu")
public class QiniuUploadCtrl {
	
    @Autowired
    private ImageService imageService;
	
	private static final String url="http://oxmyk0wbf.bkt.clouddn.com/";

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = "20Oko5NC9owPWXF0m3uejft3-V8OiTEXGfr1xeU_"; // 这两个登录七牛 账号里面可以找到
	String SECRET_KEY = "0QkTvipXbWxn46vxWz84vsaAGuGiyhiZWP6v6K-z";

	// 要上传的空间
	String bucketname = "xiuxiubizhi"; // 填写新建的那个存储空间对象的名称
	// 上传到七牛后保存的文件名
	String key = "QINIU_TEST.jpg";
	// 上传文件的路径
	String FilePath = "d:\\QINIU_TEST.jpg"; // 本地要上传文件路径
	
	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	
	Configuration cfg = new Configuration(Zone.zone1());

	// 创建上传对象
	UploadManager uploadManager = new UploadManager(cfg);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}
	
	@RequestMapping(value="/uploadImg")
	public String uploadImg() {
		List<Image> list= new ArrayList<>();

		String date= DateUtil.dateToString(new Date(),"yyyyMMdd");
		String path="D:\\QINIU_IMG\\"+date;
		File dir = new File(path);
		Map<String,String> data= new HashMap<>();

		if(dir.exists()&&dir.isDirectory()) {
			File fileList[] = dir.listFiles();
			for(File file:fileList) {
				if(ImageCheck.isImage(file)) {
				data.put(file.getName(), file.getPath());
				}
			}
			try {
				Set<String> set=upload(data);
				Image img;
				
				//添加到数据库
				for(String url:set) {
					img= new Image();
					img.setCreateTime(new Date());
					img.setUrl(url);
					img.setViewCount(1);
					list.add(img);
				}
				imageService.insertBatch(list);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			return JsonResult.failureWithTips("今天的文件夹还不存在呢");
		}
		return JsonResult.successWithData(data+":上传了共"+list.size());
	}

	// 普通上传
	public Set<String> upload(Map<String,String> data) throws IOException {
		Set<String> set= new HashSet<>();
		try {
			for (Map.Entry<String, String> entry : data.entrySet()) {  
				// 调用put方法上传
				Response res = uploadManager.put(entry.getValue(), entry.getKey(), getUpToken());
				// 打印返回的信息
				if(res.isOK()) {
					set.add(url+entry.getKey());
				}
			}  
			
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return set;
	}

	public static void main(String args[]) throws IOException {
		new QiniuUploadCtrl().uploadImg();
	}

}
