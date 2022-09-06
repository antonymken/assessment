package com.assessment.skedulo.ui.searchuser

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.assessment.skedulo.R
import com.assessment.skedulo.structure.BaseScreenTest
import org.junit.Test


private const val TIMEOUT = 5000L

class SearchUserScreen : BaseScreenTest() {


    @Test
    fun testEventFragment() {
        launchFragmentInContainer<SearchUserFragment>(themeResId = R.style.AppTheme)
        composeTestRule.onNodeWithTag(SEARCH_USER_TEXT_FIELD).assertIsDisplayed()
        composeTestRule.onNodeWithTag(SEARCH_USER_TEXT_FIELD).performTextInput("anto")
        composeTestRule.waitUntil(TIMEOUT) {
            composeTestRule
                .onAllNodesWithTag(SEARCH_USER_LIST)
                .fetchSemanticsNodes().size == 1
        }
    }

}