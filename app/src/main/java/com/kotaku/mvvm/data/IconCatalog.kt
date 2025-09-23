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
import androidx.compose.material.icons.filled.HelpOutline
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
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector
import com.kotaku.mvvm.model.Word

object IconCatalog {
    val wordIconMap: Map<String, ImageVector> = mapOf(
        // A
        "airplane" to Icons.Default.Flight,

        // B
        "bag" to Icons.Default.Work,
        "book" to Icons.Default.MenuBook,
        "bus" to Icons.Default.DirectionsBus,

        // C
        "cake" to Icons.Default.Cake,
        "car" to Icons.Default.DirectionsCar,
        "chair" to Icons.Default.EventSeat,
        "child" to Icons.Default.ChildCare,
        "coffee" to Icons.Default.LocalCafe,
        "computer" to Icons.Default.Computer,

        // D
        "day" to Icons.Default.Today,
        "doctor" to Icons.Default.MedicalServices,
        "dog" to Icons.Default.Pets,
        "drink" to Icons.Default.LocalDrink,

        // F
        "family" to Icons.Default.FamilyRestroom,
        "food" to Icons.Default.RestaurantMenu,
        "friend" to Icons.Default.Group,

        // G
        "game" to Icons.Default.SportsEsports,

        // H
        "hospital" to Icons.Default.LocalHospital,
        "house" to Icons.Default.Home,
        "hotel" to Icons.Default.Hotel,

        // I
        "ice cream" to Icons.Default.Icecream,
        "idea" to Icons.Default.Lightbulb,

        // L
        "language" to Icons.Default.Language,

        // M
        "manager" to Icons.Default.SupervisorAccount,
        "market" to Icons.Default.Storefront,
        "meeting" to Icons.Default.EventNote,
        "movie" to Icons.Default.Movie,
        "music" to Icons.Default.MusicNote,

        // N
        "news" to Icons.Default.Article,
        "night" to Icons.Default.NightsStay,
        "nurse" to Icons.Default.HealthAndSafety,

        // O
        "office" to Icons.Default.Business,

        // P
        "paper" to Icons.Default.Description,
        "park" to Icons.Default.Park,
        "pen" to Icons.Default.Edit,
        "phone" to Icons.Default.Phone,
        "plan" to Icons.Default.Assignment,
        "problem" to Icons.Default.ReportProblem,

        // Q
        "question" to Icons.Default.HelpOutline,

        // R
        "restaurant" to Icons.Default.Restaurant,

        // S
        "school" to Icons.Default.School,
        "shop" to Icons.Default.Store,
        "station" to Icons.Default.Train,
        "student" to Icons.Default.School,

        // T
        "team" to Icons.Default.Groups,
        "ticket" to Icons.Default.ConfirmationNumber,
        "time" to Icons.Default.AccessTime,
        "train" to Icons.Default.DirectionsTransit,

        // W
        "water" to Icons.Default.Opacity,
        "weather" to Icons.Default.WbSunny
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

        // Q
        Word(42, "question", "質問", "I have a question.", "質問があります。"),

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
        Word(45, "shop", "店", "The shop is closed.", "店は閉まっています。"),
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