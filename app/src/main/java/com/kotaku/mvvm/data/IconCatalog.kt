package com.kotaku.mvvm.ui.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.DirectionsTransit
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EventNote
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.FamilyRestroom
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.Opacity
import androidx.compose.material.icons.filled.Park
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector
import com.kotaku.mvvm.R
import com.kotaku.mvvm.model.Word
import com.kotaku.mvvm.ui.screen.DetailMedia

object IconCatalog {

    data class WordMedia(
        val listIcon: ImageVector,
        val detail: DetailMedia
    )

    val wordMediaMap: Map<String, WordMedia> = mapOf(
        // A
        "airplane" to WordMedia(Icons.Default.Flight, DetailMedia.Rive(R.raw.airplane)),

        // B
        "bag" to WordMedia(Icons.Default.Work, DetailMedia.Image(R.drawable.bag)),
        "book" to WordMedia(Icons.Default.MenuBook, DetailMedia.Rive(R.raw.book)),
        "bus" to WordMedia(Icons.Default.DirectionsBus, DetailMedia.Rive(R.raw.bus)),

        // C
        "cake" to WordMedia(Icons.Default.Cake, DetailMedia.Rive(R.raw.cute_cake)),
        "car" to WordMedia(Icons.Default.DirectionsCar, DetailMedia.Rive(R.raw.car)),
        "chair" to WordMedia(Icons.Default.EventSeat, DetailMedia.Image(R.drawable.chair)),
        "child" to WordMedia(Icons.Default.ChildCare, DetailMedia.Image(R.drawable.child)),
        "coffee" to WordMedia(Icons.Default.LocalCafe, DetailMedia.Rive(R.raw.coffee)),
        "computer" to WordMedia(Icons.Default.Computer, DetailMedia.Image(R.drawable.computer)),

        // D
        "day" to WordMedia(Icons.Default.Today, DetailMedia.Rive(R.raw.day)),
        "doctor" to WordMedia(Icons.Default.MedicalServices, DetailMedia.Rive(R.raw.doctor)),
        "dog" to WordMedia(Icons.Default.Pets, DetailMedia.Rive(R.raw.dog)),
        "drink" to WordMedia(Icons.Default.LocalDrink, DetailMedia.Rive(R.raw.drink)),

        // F
        "family" to WordMedia(Icons.Default.FamilyRestroom, DetailMedia.Image(R.drawable.family)),
        "food" to WordMedia(Icons.Default.RestaurantMenu, DetailMedia.Image(R.drawable.food)),
        "friend" to WordMedia(Icons.Default.Group, DetailMedia.Image(R.drawable.friend)),

        // G
        "game" to WordMedia(Icons.Default.SportsEsports, DetailMedia.Rive(R.raw.game)),

        // H
        "hospital" to WordMedia(Icons.Default.LocalHospital, DetailMedia.Rive(R.raw.hospital)),
        "house" to WordMedia(Icons.Default.Home, DetailMedia.Image(R.drawable.house)),
        "hotel" to WordMedia(Icons.Default.Hotel, DetailMedia.Rive(R.raw.hotel)),

        // I
        "ice cream" to WordMedia(Icons.Default.Icecream, DetailMedia.Image(R.drawable.icecream)),
        "idea" to WordMedia(Icons.Default.Lightbulb, DetailMedia.Image(R.drawable.idea)),

        // L
        "language" to WordMedia(Icons.Default.Language, DetailMedia.Image(R.drawable.language)),

        // M
        "manager" to WordMedia(
            Icons.Default.SupervisorAccount,
            DetailMedia.Image(R.drawable.manager)
        ),
        "market" to WordMedia(Icons.Default.Storefront, DetailMedia.Image(R.drawable.market)),
        "meeting" to WordMedia(Icons.Default.EventNote, DetailMedia.Image(R.drawable.meeting)),
        "movie" to WordMedia(Icons.Default.Movie, DetailMedia.Image(R.drawable.movie)),
        "music" to WordMedia(Icons.Default.MusicNote, DetailMedia.Rive(R.raw.music)),

        // N
        "news" to WordMedia(Icons.Default.Article, DetailMedia.Image(R.drawable.news)),
        "night" to WordMedia(Icons.Default.NightsStay, DetailMedia.Image(R.drawable.night)),
        "nurse" to WordMedia(Icons.Default.HealthAndSafety, DetailMedia.Image(R.drawable.nurse)),

        // O
        "office" to WordMedia(Icons.Default.Business, DetailMedia.Image(R.drawable.office)),

        // P
        "paper" to WordMedia(Icons.Default.Description, DetailMedia.Image(R.drawable.paper)),
        "park" to WordMedia(Icons.Default.Park, DetailMedia.Image(R.drawable.park)),
        "pen" to WordMedia(Icons.Default.Edit, DetailMedia.Rive(R.raw.pen)),
        "phone" to WordMedia(Icons.Default.Phone, DetailMedia.Image(R.drawable.phone)),
        "plan" to WordMedia(Icons.Default.Assignment, DetailMedia.Image(R.drawable.plan)),
        "problem" to WordMedia(Icons.Default.ReportProblem, DetailMedia.Image(R.drawable.problem)),

        // R
        "restaurant" to WordMedia(
            Icons.Default.Restaurant,
            DetailMedia.Image(R.drawable.restaurant)
        ),

        // S
        "school" to WordMedia(Icons.Default.School, DetailMedia.Image(R.drawable.school)),
        "station" to WordMedia(Icons.Default.Train, DetailMedia.Rive(R.raw.station)),
        "student" to WordMedia(Icons.Default.School, DetailMedia.Image(R.drawable.students)),

        // T
        "team" to WordMedia(Icons.Default.Groups, DetailMedia.Image(R.drawable.team)),
        "ticket" to WordMedia(
            Icons.Default.ConfirmationNumber,
            DetailMedia.Image(R.drawable.ticket)
        ),
        "time" to WordMedia(Icons.Default.AccessTime, DetailMedia.Rive(R.raw.time)),
        "train" to WordMedia(Icons.Default.DirectionsTransit, DetailMedia.Image(R.drawable.train)),

        // W
        "water" to WordMedia(Icons.Default.Opacity, DetailMedia.Rive(R.raw.water)),
        "weather" to WordMedia(Icons.Default.WbSunny, DetailMedia.Rive(R.raw.weather))
    )
    val SEED = listOf(
        // A
        Word(1, "airplane", "飛行機", "The airplane takes off.", "飛行機が離陸します。"),

        // B
        Word(4, "bag", "かばん", "She forgot her bag.", "彼女はかばんを忘れました。"),
        Word(5, "book", "本", "This book is interesting.", "この本は面白いです。"),
        Word(6, "bus", "バス", "The bus is crowded.", "バスは混んでいます。"),

        // C
        Word(7, "cake", "ケーキ", "The cake is sweet.", "そのケーキは甘いです。"),
        Word(8, "car", "車", "He bought a new car.", "彼は新しい車を買いました。"),
        Word(9, "chair", "椅子", "Please sit on the chair.", "椅子に座ってください。"),
        Word(10, "child", "子供", "The child is sleeping.", "子供が寝ています。"),
        Word(11, "coffee", "コーヒー", "I like hot coffee.", "私はホットコーヒーが好きです。"),
        Word(
            12,
            "computer",
            "コンピュータ",
            "I use a computer every day.",
            "私は毎日コンピュータを使います。"
        ),

        // D
        Word(13, "day", "日", "Today is a good day.", "今日は良い日です。"),
        Word(14, "doctor", "医者", "The doctor helped me.", "医者は私を助けてくれました。"),
        Word(15, "dog", "犬", "The dog is barking.", "犬が吠えています。"),
        Word(16, "drink", "飲み物", "This drink is cold.", "この飲み物は冷たいです。"),

        // F
        Word(17, "family", "家族", "My family is important to me.", "私にとって家族は大切です。"),
        Word(18, "food", "食べ物", "The food is delicious.", "その食べ物は美味しいです。"),
        Word(19, "friend", "友達", "He is my best friend.", "彼は私の親友です。"),

        // G
        Word(20, "game", "ゲーム", "This game is fun.", "このゲームは楽しいです。"),

        // H
        Word(21, "hospital", "病院", "He went to the hospital.", "彼は病院へ行きました。"),
        Word(22, "house", "家", "They built a big house.", "彼らは大きな家を建てました。"),
        Word(23, "hotel", "ホテル", "The hotel is clean.", "そのホテルはきれいです。"),

        // I
        Word(
            24,
            "ice cream",
            "アイスクリーム",
            "He ate ice cream.",
            "彼はアイスクリームを食べました。"
        ),
        Word(25, "idea", "アイデア", "She has a good idea.", "彼女は良いアイデアを持っています。"),

        // L
        Word(26, "language", "言語", "English is a global language.", "英語は国際的な言語です。"),

        // M
        Word(27, "manager", "部長", "The manager is strict.", "部長は厳しいです。"),
        Word(28, "market", "市場", "The market is busy.", "市場はにぎやかです。"),
        Word(29, "meeting", "会議", "We have a meeting today.", "今日は会議があります。"),
        Word(30, "movie", "映画", "We watched a movie.", "私たちは映画を見ました。"),
        Word(31, "music", "音楽", "I enjoy listening to music.", "私は音楽を聴くのが好きです。"),

        // N
        Word(
            32,
            "news",
            "ニュース",
            "I read the news online.",
            "私はネットでニュースを読みました。"
        ),
        Word(33, "night", "夜", "Good night.", "おやすみなさい。"),
        Word(34, "nurse", "看護師", "The nurse is busy.", "看護師は忙しいです。"),

        // O
        Word(
            35,
            "office",
            "オフィス",
            "My office is on the 5th floor.",
            "私のオフィスは5階にあります。"
        ),

        // P
        Word(36, "paper", "紙", "This paper is white.", "この紙は白いです。"),
        Word(37, "park", "公園", "The park is clean.", "その公園はきれいです。"),
        Word(38, "pen", "ペン", "I need a pen to write.", "書くためにペンが必要です。"),
        Word(39, "phone", "電話", "My phone is charging.", "私の電話は充電中です。"),
        Word(40, "plan", "計画", "The plan is perfect.", "その計画は完璧です。"),
        Word(41, "problem", "問題", "This is a big problem.", "これは大きな問題です。"),

        // R
        Word(
            43,
            "restaurant",
            "レストラン",
            "This restaurant is famous.",
            "このレストランは有名です。"
        ),

        // S
        Word(44, "school", "学校", "The school opens at 8 a.m.", "学校は午前8時に始まります。"),
        Word(46, "station", "駅", "The station is near.", "駅は近いです。"),
        Word(47, "student", "学生", "The student studies hard.", "その学生はよく勉強します。"),

        // T
        Word(48, "team", "チーム", "Our team won the game.", "私たちのチームが試合に勝ちました。"),
        Word(49, "ticket", "切符", "I lost my ticket.", "私は切符をなくしました。"),
        Word(50, "time", "時間", "Time is money.", "時間はお金です。"),
        Word(51, "train", "電車", "The train is late.", "電車が遅れています。"),

        // W
        Word(52, "water", "水", "Drink more water.", "もっと水を飲みなさい。"),
        Word(53, "weather", "天気", "The weather is nice today.", "今日は天気が良いです。")
    )

}