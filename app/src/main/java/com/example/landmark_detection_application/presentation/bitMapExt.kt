package com.example.landmark_detection_application.presentation

import android.graphics.Bitmap

fun Bitmap.ceterCrop(desiredWidth:Int,desiredHeight:Int):Bitmap{
    val xStart=(width-desiredWidth)/2
    val yStart=(height-desiredHeight)/2

    if(xStart<0 || yStart<0 || desiredWidth>width || desiredHeight>height){
        throw IllegalStateException("Invalid arguments for center croping")
    }
    return Bitmap.createBitmap(this,xStart,yStart,desiredWidth,desiredHeight)
}