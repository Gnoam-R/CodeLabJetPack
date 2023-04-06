package com.example.bluromatic.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.bluromatic.DELAY_TIME_MILLIS
import com.example.bluromatic.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val TAG = "BlurWorker"

class BlueWorker (ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result {

        // 상태 알림을 표시
        makeStatusNotification(
            applicationContext.resources.getString(R.string.blurring_image),
            applicationContext
        )
        return withContext(Dispatchers.IO){
            return@withContext try {

                // This is a utility function added to emulate slower work.
                delay(DELAY_TIME_MILLIS)

                // picture 변수 생성
                val picture = BitmapFactory.decodeResource(
                    applicationContext.resources,
                    R.drawable.android_cupcake
                )
                // 결과 저장
                val output = blurBitmap(picture, 1)
                val outputUri = writeBitmapToFile(applicationContext, output)

                // 사용자에게 보여주는 알림 메시지 생성
                makeStatusNotification(
                    "Output is $outputUri",
                    applicationContext
                )

                Result.success()
            } catch (throwable: Throwable) {
                Log.e(
                    TAG,
                    applicationContext.resources.getString(R.string.error_applying_blur),
                    throwable
                )
                Result.failure()
            }
        }
    }
}