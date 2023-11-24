package eu.krzdabrowski.currencyadder.addcurrency.ui.tests

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import eu.krzdabrowski.currencyadder.addcurrency.ui.CurrencyAdderRoute
import eu.krzdabrowski.currencyadder.core.utils.test.android.TestActivity
import eu.krzdabrowski.currencyadder.core.utils.test.android.getHiltTestViewModel
import eu.krzdabrowski.currencyadder.usersavings.api.data.dummy.generateTestUserSavingsFromDomain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CurrencyAdderRouteTest {

    @get:Rule(order = 0)
    val hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    private val testUserSavings = generateTestUserSavingsFromDomain()

    @Before
    fun setUp() {
        hiltTestRule.inject()
        composeTestRule.activity.setContent {
            CurrencyAdderRoute(
                userSavingsViewModel = composeTestRule.getHiltTestViewModel(),
                totalSavingsViewModel = composeTestRule.getHiltTestViewModel(),
            )
        }
    }

    @Test
    fun currencyAdderRoute_whenHappyPath_shouldShowAllUserSavings() {
        testUserSavings.forEach { userSaving ->
            composeTestRule
                .onNodeWithText(userSaving.place)
                .assertExists()
        }
    }
}