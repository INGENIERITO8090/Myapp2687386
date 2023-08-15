  package co.sena.edu.myapp2687386

  import android.os.Bundle
  import androidx.activity.ComponentActivity
  import androidx.activity.compose.setContent
  import androidx.compose.foundation.layout.fillMaxSize
  import androidx.compose.material3.Button
  import androidx.compose.material3.Surface
  import androidx.compose.material3.Text
  import androidx.compose.runtime.Composable
  import androidx.compose.ui.Modifier
  import co.sena.edu.myapp2687386.ui.theme.MyApp2687386Theme

  class MainActivity : ComponentActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContent {
              MyApp2687386Theme() {
                  Surface(modifier = Modifier.fillMaxSize()) {
                      Greeting(name = "Luis")
                      ContadorDeClicks(0) {

                      }

                  }
              }
          }
      }


      // Funcion de componibilidad simple
      // emite un wiget tipo text con los datos quemados
      @Composable
      fun Greeting(name: String) {
          Text("Hello $name")
      }
      // contenido dinamico

// Recomposicion
      //Se vuelve a llamar la funcion de componibilidad con datos nuevos (Solo se llaman  los objetos que cambiaron )
     // Esta funcion cuenta la cantidad de clicks que se hacen en el boton

    @Composable
    fun ContadorDeClicks(clicks:Int,onClick:() -> Unit) {
        Button(onClick = onClick) {
            Text("I've been clicked $clicks times")
        }
    }


}










