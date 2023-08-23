package co.sena.edu.jetpackcomose_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.sena.edu.jetpackcomose_6.ui.theme.MyApp2687386Theme

class jectpackcompose_6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp2687386Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon={
                    Icon(imageVector = Icons.Default.Search, contentDescription =null)

        },
        colors =TextFieldDefaults.textFieldColors() ,
        placeholder = {Text(stringResource(R.string.placeholder_search))} ,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)

    )
}


@Composable
fun AlingyourbBodyElement(modifier: Modifier){
    Column(modifier = Modifier ) {
     Image(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)    
     
     Text(text = s)
        
    }



    






}
