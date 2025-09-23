package com.kotaku.mvvm.data

import com.kotaku.mvvm.db.WordDao
import com.kotaku.mvvm.di.IoDispatcher
import com.kotaku.mvvm.model.Word
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeedRepository @Inject constructor(
    private val dao: WordDao,
    @IoDispatcher private val io: CoroutineDispatcher,
    private val scope: CoroutineScope
) {
    private val SEED = listOf(
        Word(1, "apple", "リンゴ", "I ate an apple.", "私はリンゴを食べました。"),
        Word(2, "book", "本", "This book is interesting.", "この本は面白いです。"),
        Word(3, "car", "車", "He bought a new car.", "彼は新しい車を買いました。"),
        Word(4, "dog", "犬", "The dog is barking.", "犬が吠えています。"),
        Word(5, "house", "家", "They built a big house.", "彼らは大きな家を建てました。"),
        Word(6, "school", "学校", "The school opens at 8 a.m.", "学校は午前8時に始まります。"),
        Word(
            7,
            "computer",
            "コンピュータ",
            "I use a computer every day.",
            "私は毎日コンピュータを使います。"
        ),
        Word(8, "phone", "電話", "My phone is charging.", "私の電話は充電中です。"),
        Word(
            9,
            "table",
            "テーブル",
            "The table is made of wood.",
            "そのテーブルは木で作られています。"
        ),
        Word(10, "chair", "椅子", "Please sit on the chair.", "椅子に座ってください。"),
        Word(11, "bag", "かばん", "She forgot her bag.", "彼女はかばんを忘れました。"),
        Word(12, "pen", "ペン", "I need a pen to write.", "書くためにペンが必要です。"),
        Word(13, "paper", "紙", "This paper is white.", "この紙は白いです。"),
        Word(14, "water", "水", "Drink more water.", "もっと水を飲みなさい。"),
        Word(15, "food", "食べ物", "The food is delicious.", "その食べ物は美味しいです。"),
        Word(16, "coffee", "コーヒー", "I like hot coffee.", "私はホットコーヒーが好きです。"),
        Word(17, "city", "都市", "Tokyo is a big city.", "東京は大都市です。"),
        Word(18, "country", "国", "Japan is a beautiful country.", "日本は美しい国です。"),
        Word(19, "music", "音楽", "I enjoy listening to music.", "私は音楽を聴くのが好きです。"),
        Word(20, "movie", "映画", "We watched a movie.", "私たちは映画を見ました。"),
        Word(21, "game", "ゲーム", "This game is fun.", "このゲームは楽しいです。"),
        Word(22, "friend", "友達", "He is my best friend.", "彼は私の親友です。"),
        Word(
            23,
            "family",
            "家族",
            "My family is important to me.",
            "私にとって家族は大切です。"
        ),
        Word(24, "child", "子供", "The child is sleeping.", "子供が寝ています。"),
        Word(25, "teacher", "先生", "The teacher is kind.", "先生は親切です。"),
        Word(26, "student", "学生", "The student studies hard.", "その学生はよく勉強します。"),
        Word(27, "doctor", "医者", "The doctor helped me.", "医者は私を助けてくれました。"),
        Word(28, "nurse", "看護師", "The nurse is busy.", "看護師は忙しいです。"),
        Word(29, "hospital", "病院", "He went to the hospital.", "彼は病院へ行きました。"),
        Word(
            30,
            "bookstore",
            "本屋",
            "I bought it at the bookstore.",
            "私はそれを本屋で買いました。"
        ),
        Word(31, "station", "駅", "The station is near.", "駅は近いです。"),
        Word(32, "train", "電車", "The train is late.", "電車が遅れています。"),
        Word(33, "bus", "バス", "The bus is crowded.", "バスは混んでいます。"),
        Word(34, "airplane", "飛行機", "The airplane takes off.", "飛行機が離陸します。"),
        Word(
            35,
            "airport",
            "空港",
            "We arrived at the airport.",
            "私たちは空港に到着しました。"
        ),
        Word(36, "ticket", "切符", "I lost my ticket.", "私は切符をなくしました。"),
        Word(37, "hotel", "ホテル", "The hotel is clean.", "そのホテルはきれいです。"),
        Word(
            38,
            "restaurant",
            "レストラン",
            "This restaurant is famous.",
            "このレストランは有名です。"
        ),
        Word(39, "shop", "店", "The shop is closed.", "店は閉まっています。"),
        Word(40, "market", "市場", "The market is busy.", "市場はにぎやかです。"),
        Word(41, "money", "お金", "I need some money.", "私はお金が少し必要です。"),
        Word(42, "job", "仕事", "He has a new job.", "彼には新しい仕事があります。"),
        Word(43, "company", "会社", "This is a big company.", "これは大きな会社です。"),
        Word(
            44,
            "office",
            "オフィス",
            "My office is on the 5th floor.",
            "私のオフィスは5階にあります。"
        ),
        Word(45, "manager", "部長；マネージャー", "The manager is strict.", "部長は厳しいです。"),
        Word(46, "meeting", "会議", "We have a meeting today.", "今日は会議があります。"),
        Word(
            47,
            "team",
            "チーム",
            "Our team won the game.",
            "私たちのチームが試合に勝ちました。"
        ),
        Word(
            48,
            "idea",
            "アイデア",
            "She has a good idea.",
            "彼女は良いアイデアを持っています。"
        ),
        Word(49, "plan", "計画", "The plan is perfect.", "その計画は完璧です。"),
        Word(50, "problem", "問題", "This is a big problem.", "これは大きな問題です。"),
        Word(51, "answer", "答え", "The answer is correct.", "答えは正しいです。"),
        Word(52, "question", "質問", "I have a question.", "質問があります。"),
        Word(
            53,
            "language",
            "言語",
            "English is a global language.",
            "英語は国際的な言語です。"
        ),
        Word(54, "word", "単語", "This word is difficult.", "この単語は難しいです。"),
        Word(55, "sentence", "文", "Write a short sentence.", "短い文を書きなさい。"),
        Word(56, "story", "物語", "The story is touching.", "その物語は感動的です。"),
        Word(
            57,
            "news",
            "ニュース",
            "I read the news online.",
            "私はネットでニュースを読みました。"
        ),
        Word(58, "weather", "天気", "The weather is nice today.", "今日は天気が良いです。"),
        Word(59, "season", "季節", "Spring is my favorite season.", "春は私の好きな季節です。"),
        Word(60, "time", "時間", "Time is money.", "時間はお金です。"),
        Word(61, "day", "日", "Today is a good day.", "今日は良い日です。"),
        Word(62, "year", "年", "This year is special.", "今年は特別な年です。"),
        Word(63, "month", "月", "Next month is April.", "来月は4月です。"),
        Word(64, "week", "週", "I work five days a week.", "私は週5日働きます。"),
        Word(65, "hour", "時間", "It takes one hour.", "それは1時間かかります。"),
        Word(66, "minute", "分", "Wait a few minutes.", "数分待ってください。"),
        Word(67, "morning", "朝", "Good morning!", "おはようございます！"),
        Word(68, "afternoon", "午後", "Good afternoon.", "こんにちは。"),
        Word(69, "evening", "夕方", "Good evening.", "こんばんは。"),
        Word(70, "night", "夜", "Good night.", "おやすみなさい。"),
        Word(
            71,
            "breakfast",
            "朝食",
            "I had bread for breakfast.",
            "私は朝食にパンを食べました。"
        ),
        Word(72, "lunch", "昼食", "Lunch is ready.", "昼食の準備ができました。"),
        Word(
            73,
            "dinner",
            "夕食",
            "We had dinner together.",
            "私たちは一緒に夕食を食べました。"
        ),
        Word(74, "beach", "海辺", "The beach is beautiful.", "その海辺は美しいです。"),
        Word(75, "mountain", "山", "We climbed the mountain.", "私たちは山に登りました。"),
        Word(76, "river", "川", "The river is wide.", "その川は広いです。"),
        Word(77, "forest", "森", "The forest is dark.", "その森は暗いです。"),
        Word(78, "park", "公園", "The park is clean.", "その公園はきれいです。"),
        Word(79, "garden", "庭", "There are flowers in the garden.", "庭には花があります。"),
        Word(80, "flower", "花", "This flower is red.", "この花は赤いです。"),
        Word(81, "tree", "木", "The tree is tall.", "その木は高いです。"),
        Word(82, "bird", "鳥", "The bird is singing.", "鳥が歌っています。"),
        Word(83, "fish", "魚", "The fish is swimming.", "魚が泳いでいます。"),
        Word(84, "cat", "猫", "The cat is cute.", "猫は可愛いです。"),
        Word(85, "cow", "牛", "The cow is big.", "牛は大きいです。"),
        Word(86, "horse", "馬", "The horse runs fast.", "馬は速く走ります。"),
        Word(87, "sheep", "羊", "The sheep are eating grass.", "羊が草を食べています。"),
        Word(88, "pig", "豚", "The pig is dirty.", "豚は汚れています。"),
        Word(89, "chicken", "鶏", "The chicken laid an egg.", "鶏が卵を産みました。"),
        Word(90, "egg", "卵", "I eat eggs for breakfast.", "私は朝食に卵を食べます。"),
        Word(91, "milk", "牛乳", "I drink milk every morning.", "私は毎朝牛乳を飲みます。"),
        Word(92, "bread", "パン", "This bread is soft.", "このパンは柔らかいです。"),
        Word(93, "cake", "ケーキ", "The cake is sweet.", "そのケーキは甘いです。"),
        Word(
            94,
            "chocolate",
            "チョコレート",
            "I like chocolate.",
            "私はチョコレートが好きです。"
        ),
        Word(
            95,
            "ice cream",
            "アイスクリーム",
            "He ate ice cream.",
            "彼はアイスクリームを食べました。"
        ),
        Word(
            96,
            "sandwich",
            "サンドイッチ",
            "This sandwich is tasty.",
            "このサンドイッチは美味しいです。"
        ),
        Word(97, "soup", "スープ", "The soup is hot.", "そのスープは熱いです。"),
        Word(98, "meat", "肉", "I don't eat much meat.", "私はあまり肉を食べません。"),
        Word(99, "rice", "ご飯；米", "Rice is a staple food in Japan.", "米は日本の主食です。"),
        Word(100, "vegetable", "野菜", "Eat more vegetables.", "もっと野菜を食べなさい。")
    )

    fun seedIfEmpty() = scope.launch(io) {
        if (dao.count() == 0) dao.insertAll(SEED)
    }
}