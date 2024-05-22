package com.lee_idle.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lee_idle.rowcoldemo.ui.theme.RowColDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowColDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    /*
    Column {
        Row{
            Column {
                TextCell("1")
                TextCell("2")
                TextCell("3")
            }

            Column {
                TextCell("4")
                TextCell("5")
                TextCell("6")
            }

            Column{
                TextCell("7")
                TextCell("8")
            }
        }
        Row {
            TextCell("9")
            TextCell("10")
            TextCell("11")
        }
    }
     */


    // Alignment(Top, Center, Bottom): Row 컴포넌트의 수직 위치를 조정한다.
    // Arrangement(Start, Center, End): Row 컴포넌트의 수평 위치를 조정한다
    // Arrangement(SpaceEvenely, SpaceBetween, SpaceAround): 배열간 간격을 조절한다.
    // SpaceEvenely: 시작, 끝, 컴포넌트 사이의 공간이 모두 같음
    // SpaceBetween: 시작과 끝의 공간을 두지 않고 컴포넌트 사이의 공간이 같음
    // SpaceAround: 시작과 끝은 컴포넌트 사이의 공간의 절반 만큼만 가진다.
    val modifier = Modifier.size(width = 400.dp, height = 200.dp)
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround) {
        // RowScope는 Row자식들이 사용 가능한 모디파이어를 제공한다.
        // Modifier.align(): 수직 정렬(Top, CenterVertically, Bottom을 이용)
        // Modifier.alignBy(): 자식을 alignBy 모디파이어가 적용된 다른 형제들과 정렬한다.
        // Modifier.alignByBaseLine(): 자식의 베이스라인을 alignBy() 또는 alignByBaseline() 모디파이어가 이미 적용된 형제들과 정렬한다.
        //                              글꼴 크기가 다른 텍스트 콘텐츠들을 정렬할 때 특히 유용하다.
        // Modifier.paddingFrom(): 자식의 정렬 라인에 패딩을 추가한다.
        // Modifier.weight(): 형제에 할당된 가중치에 따라 자식의 폭을 설정한다.
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }

    /*
    Column(horizontalAlignment = Alignment.End,
        modifier = Modifier.width(250.dp).height(400.dp),
        verticalArrangement = Arrangement.Bottom){
        // Modifier.align(): 수직 정렬
        // Modifier.alignBy(): 자식을 alignBy 모디파이어가 적용된 다른 형제들과 정렬한다.
        // Modifier.weight(): 형제에 할당된 가중치에 따라 자식의 폭을 설정한다.
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
     */
}

@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {
    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(text = text,
        modifier = cellModifier,
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
        )
}

@Preview(showBackground = true)
@Composable
fun DemoPreview(){
    RowColDemoTheme {
        MainScreen()
    }
}