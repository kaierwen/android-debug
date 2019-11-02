package github.kaierwen.android.library_beagle_kotlin

import android.app.Application
import android.graphics.Color
import androidx.appcompat.content.res.AppCompatResources
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagleCore.configuration.Appearance
import com.pandulapeter.beagleCore.configuration.Trick

/**
 * Beagle配置入口类
 * @author kaiyuan.zhang
 * @since 2019/11/2
 */
class BeagleEntrance {

    companion object {
        @JvmStatic
        fun init(app: Application) {
            if (BuildConfig.DEBUG) {
                Beagle.imprint(app, Appearance(themeResourceId = R.style.BeagleTheme))

                Beagle.learn(
                    listOf(
                        Trick.Header(
                            title = app.getString(R.string.app_name),
                            subtitle = "v${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})",
                            text = "Built on ${BuildConfig.BUILD_DATE}"
                        ),
                        Trick.AppInfoButton(),
                        Trick.ScreenshotButton(),
                        Trick.ForceCrashButton(),
                        Trick.KeylineOverlayToggle(
                            gridColor = Color.WHITE
                        ),
                        Trick.ViewBoundsOverlayToggle(
                            color = Color.CYAN
                        ),
                        Trick.Toggle(
                            title = "Feature toggle 1",
                            onValueChanged = { isOn -> "Feature 1 is ${if (isOn) "on" else "off"}".showToast() }
                        ),
                        Trick.Toggle(
                            title = "Feature toggle 2",
                            onValueChanged = { isOn -> "Feature 2 is ${if (isOn) "on" else "off"}".showToast() }
                        ),
                        Trick.Padding(),
                        Trick.MultipleSelectionList(
                            title = "Multiple choice",
                            items = mockColors,
                            onItemSelectionChanged = { colors -> Beagle.log(if (colors.isEmpty()) "No colors selected" else "Selected colors: ${colors.joinToString { it.name }}") }
                        ),
                        Trick.NetworkLogList(
                            baseUrl = NetworkingManager.BASE_URL,
                            shouldShowHeaders = true,
                            shouldShowTimestamp = true
                        ),
                        Trick.LogList(shouldShowTimestamp = true),
                        Trick.SingleSelectionList(
                            title = "Environment",
                            items = mockBackendEnvironments,
                            isInitiallyExpanded = true,
                            initialSelectionId = "Develop",
                            onItemSelectionChanged = { backendEnvironment -> backendEnvironment.url.showToast() }
                        ),
                        Trick.Divider(),
                        Trick.Text(
                            text = "This is a TextTrick used for displaying short hints"
                        ),
                        Trick.LongText(
                            title = "Long text",
                            text = "Here is a longer piece of text that occupies more space so it doesn't make sense to always have it fully displayed."
                        ),
                        Trick.Slider(
                            name = { value -> "Slider value: $value" },
                            onValueChanged = { value -> "Slider set to $value".showToast() }
                        ),
                        Trick.Button(
                            text = "Show a toast",
                            onButtonPressed = { "Here is a toast".showToast() }
                        ),
                        Trick.Divider(),
                        Trick.KeyValue(
                            title = "Key - Value",
                            pairs = listOf(
                                "Key1" to "Value1",
                                "Key2" to "Value2",
                                "Key3" to "Value3"
                            )
                        ),
                        Trick.DeviceInformationKeyValue(),
                        Trick.Image(drawable = AppCompatResources.getDrawable(this, R.drawable.img_logo))
                    )
                )
            }
        }
    }

}