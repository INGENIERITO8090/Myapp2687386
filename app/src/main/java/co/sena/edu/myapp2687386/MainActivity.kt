package co.sena.edu.myapp2687386
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.sena.edu.myapp2687386.ui.SampleData
import co.sena.edu.myapp2687386.ui.theme.MyApp2687386Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         MyApp2687386Theme() {
            Surface(modifier = Modifier.fillMaxSize() ) {

         Converesation(SampleData.conversationSample)

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
            .border(1.5.dp, MaterialTheme.colorScheme.scrim, CircleShape)
        )
        Spacer(modifier = Modifier.height(50.dp))
      // state verification
        var isExpanded by remember { mutableStateOf(false) }
        Column(modifier = Modifier.clickable { isExpanded =!isExpanded } )     {
            Text(text = msg.author, color= MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape=MaterialTheme.shapes.medium,shadowElevation = 4.dp) {

                Text(text = msg.body,modifier=Modifier.padding(all=4.dp) , style = MaterialTheme.typography.bodyLarge ,maxLines = if( isExpanded)Int.MAX_VALUE else 1)

            }


        }
    }

}

@Preview(showBackground = true )
@Composable
fun MessageCardPreview(){
    MyApp2687386Theme() {
        Surface() {
            MessageCard(msg = Message("Nacho","la vida es muy corta como para morir virgen "))
         }

    }
}

@Composable

fun Converesation(messages:List<Message>){
    LazyColumn(){
        items(messages){
            message -> MessageCard(message)
        }

    }
}

@Preview
@Composable
fun ConversationPreview(){
        MyApp2687386Theme() {
            Converesation(SampleData.conversationSample)

        }



}



