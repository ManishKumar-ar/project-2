package com.example.pdfreader

import android.content.pm.PackageManager
import android.icu.number.Precision.increment
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.pdfreader.ui.theme.PDFReaderTheme

class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Home(appViewModel = appViewModel)
        }
    }
}


@Composable
fun Home(modifier: Modifier = Modifier, appViewModel: AppViewModel) {
    val count by appViewModel._count.observeAsState(0)
    Column (
        modifier = Modifier.fillMaxSize().padding(top=16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text("hello")
        Spacer(modifier = Modifier.height(16.dp))

        Text("value is incremented to $count")
        Button(onClick = { appViewModel.increment() }) {
            Text(text = "Increment ${count}")
        }

        FloatingActionButton(onClick = { appViewModel.increment() }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "add button"
            )
        }
    }
}
