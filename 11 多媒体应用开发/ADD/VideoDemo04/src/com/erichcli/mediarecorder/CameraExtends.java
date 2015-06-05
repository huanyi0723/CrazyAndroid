package com.erichcli.mediarecorder;

import android.hardware.Camera;

import java.util.List;

/**
 * Created by erichcli on 9/3/14.
 */
public class CameraExtends {

    public static Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int width,int height){

        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) width/height;

        if (sizes == null){
            return null;
        }

        Camera.Size optimalSize = null;

        double minDiff = Double.MAX_VALUE;

        int targetHeight = height;

        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE)
                continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find preview size that matches the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;

    }


}
