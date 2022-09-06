package com.assessment.skedulo.ui.searchuser

import android.widget.Toast
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProviders
import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.domain.searchuser.SearchUserPresenter
import com.assessment.skedulo.domain.searchuser.SearchUserView
import com.assessment.skedulo.structuerandroid.fragment.ViewModelFragment
import com.assessment.skedulo.ui.main.Navigation
import com.assessment.skedulo.ui.main.SharedViewModel

const val SEARCH_USER_SCREEN = "SEARCH_USER_SCREEN"
const val SEARCH_USER_TEXT_FIELD = "SEARCH_USER_TEXT_FIELD"
const val SEARCH_USER_LIST = "SEARCH_USER_LIST"
class SearchUserFragment :
    ViewModelFragment<SearchUserView, SearchUserViewModel, SearchUserPresenter>() {

    private lateinit var navigation: Navigation

    override fun buildViewModel() {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SearchUserViewModel::class.java)
        navigation = ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(SharedViewModel::class.java)
    }

    override fun init() {
        viewModel.errorMessageLiveData.observe(
            this,
            { errorMessage ->
                if(errorMessage.isNullOrEmpty()) return@observe
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                viewModel.clearError()
            }
        )
    }

    @Composable
    fun SearchText() {
        var enabled by remember {
            mutableStateOf(true)
        }
        val loadingState = viewModel.loadingStateLiveData.observeAsState()
        loadingState.value?.let { loading ->
            enabled = !loading
        }

        Row(
            modifier = Modifier
                .padding(4.dp, 4.dp)
                .fillMaxSize()
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textState.value,
                onValueChange = {
                    if (textState.value.text != it.text) {
                        textState.value = it
                        viewModel.onSearchQueryChanged(textState.value.text)
                    }
                },
                enabled = enabled,
                textStyle = TextStyle(fontSize = 17.sp),
                leadingIcon = { Icon(Icons.Filled.Search, null, tint = Color.Gray) },
                modifier = Modifier
                    .testTag(SEARCH_USER_TEXT_FIELD)
                    .padding(10.dp)
                    .background(Color(0xFFE7F1F1), RoundedCornerShape(16.dp)),
                placeholder = { Text(text = "search") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    cursorColor = Color.DarkGray
                )
            )
        }
    }

    @Composable
    fun LoadingAnimation(
        indicatorSize: Dp = 100.dp,
        circleColors: List<Color> = listOf(
            Color(0xFF5851D8),
            Color(0xFF833AB4),
            Color(0xFFC13584),
            Color(0xFFE1306C),
            Color(0xFFFD1D1D),
            Color(0xFFF56040),
            Color(0xFFF77737),
            Color(0xFFFCAF45),
            Color(0xFFFFDC80),
            Color(0xFF5851D8)
        ),
        animationDuration: Int = 360
    ) {

        val infiniteTransition = rememberInfiniteTransition()

        val rotateAnimation by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animationDuration,
                    easing = LinearEasing
                )
            )
        )

        CircularProgressIndicator(
            modifier = Modifier
                .size(size = indicatorSize)
                .rotate(degrees = rotateAnimation)
                .border(
                    width = 4.dp,
                    brush = Brush.sweepGradient(circleColors),
                    shape = CircleShape
                ),
            progress = 1f,
            strokeWidth = 1.dp,
            color = MaterialTheme.colors.background // Set background color
        )
    }

    @Composable
    fun UserItem(githubUser: GithubUserDomainModel) {

        Card(
            modifier = Modifier
                .padding(4.dp, 4.dp)
                .fillMaxWidth()
                .height(90.dp)
        ) {
            Surface {
                Row(
                    modifier = Modifier
                        .padding(4.dp, 4.dp)
                        .fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center, modifier = Modifier
                            .padding(4.dp)
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = githubUser.login,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = githubUser.type,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                        Text(
                            text = githubUser.score.toString(),
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun UserList(items: List<GithubUserDomainModel>) {
        LazyColumn(modifier = Modifier.testTag(SEARCH_USER_LIST)) {
            itemsIndexed(items = items) { _, item ->
                UserItem(item)
            }
        }
    }

    @Preview
    @Composable
    override fun SetLayout() {

        var visibleLoading by remember {
            mutableStateOf(false)
        }
        val loadingState = viewModel.loadingStateLiveData.observeAsState()
        loadingState.value?.let { visible ->
            visibleLoading = visible
        }

        Box(
            modifier = Modifier
                .padding(4.dp, 4.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.LightGray)
                .testTag(SEARCH_USER_SCREEN)
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        SearchText()
                    }
                    Row {
                        val usersListState = viewModel.githubUserListLiveData.observeAsState()
                        usersListState.value?.let { items ->
                            UserList(items)
                        }
                    }
                }

            }
            if (visibleLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    LoadingAnimation()
                }
            }
        }

    }

}