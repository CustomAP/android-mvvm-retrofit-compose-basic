package com.example.redemption

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.redemption.model.Photo
import com.example.redemption.ui.theme.RedemptionTheme
import com.example.redemption.view.PhotoListViewModel
import com.example.redemption.view.ui.PhotoItem

class MainActivity : ComponentActivity() {
    private val photoListViewModel by viewModels<PhotoListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedemptionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    photoListViewModel.errorMessage.let {
                        if (it.isNotEmpty()) {
                            Text(it)
                        }
                    }
                    MovieList(photoList = photoListViewModel.photoListResponse)
                    photoListViewModel.getPhotos()
                }
            }
        }
    }
}

@Composable
fun MovieList(photoList: List<Photo>) {
    LazyColumn {
        itemsIndexed(items = photoList) {
            index, item -> PhotoItem(photo = item)
        }
    }
}