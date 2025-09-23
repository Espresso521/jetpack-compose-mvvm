package com.kotaku.mvvm.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kotaku.mvvm.db.AppDatabase
import com.kotaku.mvvm.db.WordDao
import com.kotaku.mvvm.model.Word
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton
import kotlinx.coroutines.launch

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: android.content.Context,
        @IoDispatcher io: kotlinx.coroutines.CoroutineDispatcher
    ): AppDatabase {
        val seed = listOf(
            Word(1, "abandon", "見捨てる；放棄する", "He abandoned his plan."),
            Word(2, "benevolent", "慈悲深い；善意のある", "A benevolent smile."),
            Word(3, "concise", "簡潔な；要領の良い", "A concise summary."),
            Word(4, "diligent", "勤勉な；一生懸命な", "A diligent student."),
            Word(5, "elaborate", "手の込んだ；精巧な", "An elaborate design."),
            Word(6, "achieve", "達成する；成し遂げる", "She achieved her goal."),
            Word(7, "brilliant", "素晴らしい；輝かしい", "A brilliant idea."),
            Word(8, "consider", "よく考える；配慮する", "Please consider my request."),
            Word(9, "develop", "発展させる；開発する", "They developed a new app."),
            Word(10, "efficient", "効率的な；能率の良い", "An efficient system."),
            Word(11, "focus", "集中する；焦点を合わせる", "Focus on your studies."),
            Word(12, "genuine", "本物の；誠実な", "A genuine smile."),
            Word(13, "habit", "習慣；癖", "He has a bad habit."),
            Word(14, "improve", "改善する；向上させる", "We need to improve our service."),
            Word(15, "journey", "旅；道のり", "The journey took three hours."),
            Word(16, "knowledge", "知識；認識", "Knowledge is power."),
            Word(17, "listen", "聞く；耳を傾ける", "Listen to the teacher."),
            Word(18, "motivate", "動機を与える；やる気にさせる", "She motivated the team."),
            Word(19, "necessary", "必要な；不可欠な", "Water is necessary for life."),
            Word(20, "optimistic", "楽観的な；前向きな", "He is optimistic about the future.")
        )

        return Room.databaseBuilder(context, AppDatabase::class.java, "words.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    // DB 首次创建时预置
                    kotlinx.coroutines.CoroutineScope(io).launch {
                        val dao = Room.databaseBuilder(context, AppDatabase::class.java, "words.db")
                            .build()
                            .wordDao()
                        // 双重保险：防止重复写
                        if (dao.count() == 0) dao.insertAll(seed)
                    }
                }
            })
            .build()
    }

    @Provides
    fun provideWordDao(db: AppDatabase): WordDao = db.wordDao()
}