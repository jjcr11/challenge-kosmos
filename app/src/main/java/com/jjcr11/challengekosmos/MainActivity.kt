package com.jjcr11.challengekosmos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.jjcr11.challengekosmos.ui.theme.ChallengeKosmosTheme
import com.jjcr11.challengekosmos.view.ListCharacters
import com.jjcr11.challengekosmos.viewmodel.ListCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ListCharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeKosmosTheme {
                Surface {
                    ListCharacters(viewModel = viewModel, context = this@MainActivity)
                }
            }
        }
    }
}