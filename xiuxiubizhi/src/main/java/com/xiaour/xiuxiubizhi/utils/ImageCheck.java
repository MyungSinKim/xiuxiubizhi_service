package com.xiaour.xiuxiubizhi.utils;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class ImageCheck {
	
	 private static  MimetypesFileTypeMap mtftp = new MimetypesFileTypeMap(); 

    public static MimetypesFileTypeMap getInstance() {  
        mtftp.addMimeTypes("image png tif jpg jpeg bmp");
        return mtftp;  
    }  

    public static boolean isImage(File file){
        String mimetype= ImageCheck.getInstance().getContentType(file);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }


}
