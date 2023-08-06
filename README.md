# Myapp2687386
Este  proyecto es una intruduccion breve a lo que es el desarrollo de android en este caso  se utilizo el framework de desarrollo Jetpack Compose  cuyo lenguaje es Kotlin 
se trataron temas de interfaz de usuario   explicando la estructura y respectivas partes de la codificacion de una vista , colores y animaciones 


Para empezar con el desarrolo de el documento se Describira el funcionamiento de Jetpack Compose.  

*   Este framework Trabaja con anaotaciones y tiene su propia sintaxis  para sus distintas funciones y/o elementos 
'@Composable '


*   Este  Freamework trabaja con unas nuevas formas de desarrollo de experiencia de usuario 
la cual es [Compose.material.3](https://m3.material.io/develop/android/jetpack-compose) 

*   Este framework se destaca por la poca sintaxis que lleva para el desarrollo y su optimo funcionamiento respecto a otros lenguajes de programacion mas sin embargo no significa que sea mas facil

## Partes de la vista Con Jectpack Compose  en nuestro proyecto 

* Esta es la clase para crear la vista android (La primera vista)
como podemos   ver en la codificacion es una clase llavama  MainActivity  es es herada de ComponentActivity() nativa de jetpack Compose 

''' 


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


'''
*  En esta parte de nuestro archivo llamado MainActivity.kt  se creo una funcion  de tipo Jetpack Compose  en la cual se basa el proyecto ,  en esta funcion  destacan los objetos Row y colum en los cuales se organiza el contenido a mostrar 
tambien unos de los objetos o "elementos" Compose mas relevantes son el surface ya que  traduciendolo significa superficie 
lo que indica que es la base  para los otros elementos entro de este   en este elememento van los argumentos "Firmas" claves para el desarrollo de nuestra vista  


Tambien resalta  la sintaxis Material.theme.. esta es la forma de invocar que parte de la libreria  MaterialTheme  (que se menciono anterior mente) deseamos utilizar y de que manera

'''kotlin 

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
''' 
* Los previews , estos se generan haciento una anotacion de tipo composable que espesifique  que es un preview ademas de otra anotacion que afirme que es una funcion composable ,   esta funcion sirve para previsualizar el funcionamiento de la la funcion que se esta desarrollando sin la nececidad de hacer la depuracion de todo el proyecto 

''' kotlin 

@Preview
@Composable
fun ConversationPreview(){
        MyApp2687386Theme {

            Conversation(SampleData.conversationSample)
        }
}
'''


### describiendo mas nuestro proyecto 

en nuestro proyecto trabajamos una funcion  especifica de jetpack compose 
la cual es lazycolum    la cual especificamente en el caso propio de nuestro proyecto por ser lazycolumn  muestra solo lo que el usuario puede ver  es decir esta funcion solo muestra los elementos entro de la columna solo si el usuario puede verlos en la pantalla  y se se van mostrando los demas elementos a medida que el usuario se vaya desplazando 
'''kotlin
@Composable
fun Conversation(messages:List<Message>){
    
    LazyColumn{
        items(messages){
            message -> MessageCard(message)
        }

    }

''  
## Entorno 
* sdk oreo 8.1
* molude Empty Activity 
* lenguaje Kotlin
###
* [el archivo principal se encuentra en esta direccion](app/src/main/java/co/sena/edu/myapp2687386/MainActivity.kt) 

