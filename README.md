# 🚀 Compose with Rive & MVVM

**Jetpack Compose + Material 3** を用いて実装した Android デモアプリです。  
本プロジェクトでは **Rive アニメーション** を統合しており、インタラクティブなアニメーションを体験できます。  
一部のコードは [RiveAnimation](https://github.com/thekaailashsharma/RiveAnimation) を参考にしています。  

---

## 🎬 デモ

![Demo](./readme/output1.gif)

---

## 📦 技術スタック

| 区分 | ライブラリ名 | Maven/座標 | バージョン | 用途 |
|---|---|---|---|---|
| ビルド | Kotlin | `org.jetbrains.kotlin.android` | **2.2.20** | 言語／Compose等の基盤 |
| ビルド | Android Gradle Plugin | `com.android.application` | **8.13.0** | Android ビルド |
| UI | Compose BOM | `androidx.compose:compose-bom` | **2025.01.00** | Compose の依存を整合 |
| UI | Material 3 | `androidx.compose.material3:material3` | **1.3.2** | 最新UIコンポーネント |
| UI | Compose UI | `androidx.compose.ui:ui` | **1.9.1** | Compose 基本UI |
| UI | Activity Compose | `androidx.activity:activity-compose` | **1.9.2** | Activity×Compose 連携 |
| ナビゲーション | Navigation Compose | `androidx.navigation:navigation-compose` | **2.8.0** | 画面遷移 |
| ライフサイクル | ViewModel Compose | `androidx.lifecycle:lifecycle-viewmodel-compose` | **2.8.5** | VM と Compose 連携 |
| 永続化 | Room Runtime / KTX | `androidx.room:room-runtime / room-ktx` | **2.8.0** | DB アクセス |
| DI | Hilt (Android) | `com.google.dagger:hilt-android` | **2.57.1** | 依存性注入 |
| DI | Hilt Navigation Compose | `androidx.hilt:hilt-navigation-compose` | **1.3.0** | Hilt×Nav 統合 |
| アニメ | Rive Android | `app.rive:rive-android` | **10.4.4** | Rive アニメ再生 |
| ユーティリティ | Timber | `com.jakewharton.timber:timber` | **5.0.1** | ログ出力 |
| システムUI | Accompanist System UI Controller | `com.google.accompanist:accompanist-systemuicontroller` | **0.30.1** | ステータスバー等の色制御 |
| 起動時初期化 | App Startup | `androidx.startup:startup-runtime` | **1.1.1** | 初期化ランナー |
| アイコン | Material Icons Extended | `androidx.compose.material:material-icons-extended` | **1.7.8** | 追加アイコン |

---

## 📖 参考

- [Rive 公式ドキュメント](https://rive.app/)
- [thekaailashsharma / RiveAnimation](https://github.com/thekaailashsharma/RiveAnimation)

---

## 🚀 クイックスタート

```bash
git clone https://github.com/Espresso521/jetpack-compose-mvvm.git
