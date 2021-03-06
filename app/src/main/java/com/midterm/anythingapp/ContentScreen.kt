package com.midterm.anythingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.floor

@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.colorPrimaryDark))
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = "Home View",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}
@Composable
fun MusicScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.colorPrimaryDark))
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = "Music View",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}
@Composable
fun MovieScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.colorPrimaryDark))
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = "Movie View",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}
@Composable
fun BooksScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.colorPrimaryDark))
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = "Books View",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}
@Composable
fun TapScreen() {
    val counter = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${counter.value}", style = TextStyle(color = Color.Green),
            fontSize = 35.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(150.dp))
        CreateCircle(counter = counter.value) {
                newValue -> counter.value = newValue
        }
    }
}

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(R.color.colorPrimaryDark))
        .wrapContentSize(Alignment.Center)) {
        Text(
            text = "Profile View",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp)
    }
}

@Composable
fun PortfolioScreen() {
    val state = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp,12.dp,12.dp,65.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 4.dp) {
        Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            CreateImageProfile(R.drawable.loli)
            CreateInfo()
            Button(onClick = { state.value = !state.value }) {
                Text(text = "Portfolio")
            }
            Divider(modifier = Modifier.padding(15.dp))
            if (state.value)
                Portfolio(
                    data = listOf(
                    listItem("Bitcoin","38,781 USD",R.drawable.loli01),
                    listItem("Ethereum","2,862 USD",R.drawable.loli02),
                    listItem("Tether","1 USD",R.drawable.loli03),
                    listItem("BNB","392 USD",R.drawable.loli04),
                    listItem("Dogecoin","0.14 USD",R.drawable.loli05),
                    listItem("Shiba Inu","0.000024 USD",R.drawable.loli06)))
        }
    }
}

@Composable
fun TipScreen() {
    val totalPerPerson = remember {
        mutableStateOf(0f)
    }
    val total = remember {
        mutableStateOf(0f)
    }
    val sliderValue = remember {
        mutableStateOf(0f)
    }
    val numPerson = remember {
        mutableStateOf(0)
    }
    val tipAmount = remember {
        mutableStateOf(0f)
    }
    tipAmount.value = floor(total.value * sliderValue.value / 100)
    totalPerPerson.value = if (numPerson.value > 0) (tipAmount.value + total.value) / numPerson.value else 0f
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TopHeader(totalPerPerson.value)
        MainContent(sliderValue,
            numPerson,
            total,
            tipAmount)
    }
}

@Composable
fun TopHeader(total: Float) {
    Card(modifier = Modifier
        .padding(start = 25.dp, top = 30.dp, end = 25.dp, bottom = 10.dp)
        .fillMaxWidth()
        .height(150.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        backgroundColor = Color(0xffdfc2f2)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Total Per Person",
                    style = MaterialTheme.typography.h5,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Black
                )
                Text(text = "$%.2f".format(total),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Black
                )
            }
        }
    }
}

@Composable
fun MainContent(sliderValue: MutableState<Float>,
                numPerson: MutableState<Int>,
                initCost: MutableState<Float>,
                tipAmount: MutableState<Float>,) {
    var isTyping = remember {
        mutableStateOf(false)
    }
    var text = remember {
        mutableStateOf("")
    }
    Card(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            OutlinedTextField(value = text.value,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                label = { Text(text = "Enter Bill",
                    color = Color(0xff575557),
                    fontWeight = FontWeight.Black)},
                onValueChange = {
                    text.value = it
                    initCost.value = if (text.value != "") text.value.toFloat() else 0f
                    isTyping.value = text.value != "" },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.AttachMoney, contentDescription = "enter bill")
                    }
                })
            if (isTyping.value) {
                CreateSplit(numPerson)
                CreateTip(tipAmount)
                CreateSlider(sliderValue)
            }
        }
    }
}

@Composable
fun CreateSplit(numPerson: MutableState<Int>) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Split", modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 90.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier
                .size(35.dp),
                shape = CircleShape,
                elevation = 4.dp) {
                Icon(imageVector = Icons.Filled.Remove,
                    contentDescription = "remove",
                    modifier = Modifier.clickable {
                        if (numPerson.value > 0) {
                            numPerson.value -= 1
                        }
                    })
            }
            Text(text = "${numPerson.value}",
                modifier = Modifier.padding(6.dp))
            Card(modifier = Modifier
                .size(35.dp),
                shape = CircleShape,
                elevation = 4.dp) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "add",
                    modifier = Modifier.clickable {
                        numPerson.value += 1
                    })
            }
        }
    }
}

@Composable
fun CreateTip(tipAmount: MutableState<Float>) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Tip", modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 90.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = "$%.1f".format(tipAmount.value), modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun CreateSlider(sliderValue: MutableState<Float>) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "${sliderValue.value.toInt()} %")
    }
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Slider(value = sliderValue.value.toFloat(),
            onValueChange = { sliderValue.value = it },
            valueRange = 0f..100f,
            steps = 5,
            modifier = Modifier.padding(20.dp, 10.dp,20.dp))
    }
}

@Composable
fun CreateInfo(){
    Column(modifier = Modifier.padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Hu???nh Ph?? Qu??",
            style = MaterialTheme.typography.h3,
            color= MaterialTheme.colors.primaryVariant)

        Text(text = "Blockchain programmer",
            modifier = Modifier.padding(3.dp))

        Text(text = "@ThemeCrypto",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp))
    }
}

@Composable
fun CreateImageProfile(id: Int) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = .5f)
    ) {
        Image(painter = painterResource(id = id),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Portfolio(data: List<listItem>) {
    LazyColumn {
        items(data) {
                item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)) {
                    CreateImageProfile(item.icon)
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item.name, fontWeight = FontWeight.Bold)
                        Text(text = item.desc, style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}
@Composable
fun CreateCircle(counter: Int=0, countUp: (Int) -> Unit) {
    Button(onClick = { countUp(counter + 1) },
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp),
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(4.dp,0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap")
        }
    }
}
class listItem(val name: String, val desc: String, val icon: Int)
