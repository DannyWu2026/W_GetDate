# W_GetDate

Android 10（API 29）及以上的日期复制工具。点击桌面图标后，应用按设备当前本地日期生成 `yyyy/M/d` 格式，月、日不补零（例如 `2026/1/9`），复制到系统剪贴板并退出，不显示业务界面。系统启动画面或剪贴板提示仍可能出现；复制失败时会显示提示。应用不需要联网权限。

## 更换图标

替换 `app/src/main/res/drawable-nodpi/ic_date_launcher.png`，推荐使用 432 × 432 像素的正方形 PNG，主体留出边距以适应不同桌面的裁切，修改后重新构建 APK。

## 用 GitHub Actions 构建

1. 将整个项目放到 GitHub 仓库根目录，包括隐藏的 `.github` 目录、`gradlew`、`gradlew.bat` 和 `gradle/wrapper/gradle-wrapper.jar`。
2. 推送后，在仓库 **Actions → Android debug build** 查看构建；也可以手动选择 **Run workflow**。
3. 构建成功后，在该次运行的 **Artifacts** 下载 `W_GetDate-debug`，解压并安装 `app-debug.apk`。产物保留 14 天。

本地无需安装 JDK 或 Android SDK。APK 使用调试签名；不同构建的签名可能不同，如无法覆盖安装，请先卸载旧版 W_GetDate。安装时可能需要允许从所使用的来源安装应用。
