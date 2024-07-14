package com.example.landmark_detection_application.presentation

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.landmark_detection_application.domain.Classification
import com.example.landmark_detection_application.domain.LandmarkClassifier

class LandmarkImageAnalyzer(
    private val classifier: LandmarkClassifier,
    private val onResults:(List<Classification>)->Unit
):ImageAnalysis.Analyzer {
    private var frameskipCounter=0
    override fun analyze(image: ImageProxy) {
        if (frameskipCounter%60==0){
            val rotationDegree=image.imageInfo.rotationDegrees
            val bitMap=image.toBitmap().ceterCrop(321,321)
            val result=classifier.classify(bitMap,rotationDegree)
            onResults(result)
        }
        frameskipCounter++

        image.close()
    }
}