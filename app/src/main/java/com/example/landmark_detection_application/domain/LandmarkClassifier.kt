package com.example.landmark_detection_application.domain

import android.graphics.Bitmap

interface LandmarkClassifier {
    fun classify(bitmap: Bitmap,rotation:Int):List<Classification>
}