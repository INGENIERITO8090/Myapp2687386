package co.sena.edu.myapp2687386
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.sena.edu.myapp2687386.ui.theme.MyApp2687386Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         MyApp2687386Theme( darkTheme = isSystemInDarkTheme()) {
            Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.scrim) {
                 Conversation(SampleData.conversationSample)
            }
         }
        }
    }
}
data class Message(val author: String , val  body : String)

@Composable
fun MessageCard( msg: Message){

        Row (
            modifier=Modifier.padding(all=8.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Contact profile picture",
                modifier= Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, color = Color.Green, CircleShape)
            )
            Spacer(modifier = Modifier.height(50.dp))
            // state verification
            var isExpanded by remember { mutableStateOf(false) }
            Column(modifier = Modifier.clickable { isExpanded =!isExpanded } )     {

                Text(text = msg.author, color= MaterialTheme.colorScheme.scrim, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape=MaterialTheme.shapes.medium,shadowElevation = 4.dp, color = MaterialTheme.colorScheme.scrim, border = BorderStroke(2.dp, color = Color.Green)) {

                    Text(text = msg.body,modifier=Modifier.padding(all=4.dp) , style = MaterialTheme.typography.bodyLarge ,maxLines = if( isExpanded)Int.MAX_VALUE else 1, color = Color.White)

                }

            }
        }



}



@Preview(showBackground = true )
@Composable
fun MessageCardPreview(){
    MyApp2687386Theme {
        Surface(color = MaterialTheme.colorScheme.scrim  , shadowElevation = 4.dp ) {
            MessageCard (msg = Message("Nacho","la vida es muy corta como para morir virgen "))
         }

    }
}

@Composable
fun Conversation(messages:List<Message>){
    LazyColumn{
        items(messages){
            message -> MessageCard(message)
        }

    }
}



@Preview
@Composable
fun ConversationPreview() {
    MyApp2687386Theme {

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.scrim) {
            Conversation(SampleData.conversationSample)
        }
    }
}


