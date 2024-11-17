package com.example.harrypottercharacters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    val test = listOf(
        Character(
            id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
            name = "Harry Potter",
            alternateNames = listOf("The Boy Who Lived", "The Chosen One", "Undesirable No. 1", "Potty"),
            species = "human",
            gender = "male",
            house = "Gryffindor",
            dateOfBirth = "31-07-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "half-blood",
            eyeColor = "green",
            hairColor = "black",
            Wand(wood= "holly", core = "phoenix tail feather", length = 11.0),
            patronus = "stag",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Daniel Radcliffe",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/harry.jpg",
        ),
        Character(
            id = "4c7e6819-a91a-45b2-a454-f931e4a7cce3",
            name = "Hermione Granger",
            alternateNames = listOf("Hermy", "Know-it-all", "Miss Grant", "Herm-own-ninny"),
            species = "human",
            gender = "female",
            house = "Gryffindor",
            dateOfBirth = "19-09-1979",
            yearOfBirth = 1979,
            wizard = true,
            ancestry = "muggleborn",
            eyeColor = "brown",
            hairColor = "brown",
            wand = Wand(wood = "vine", core = "dragon heartstring", length = 10.0),
            patronus = "otter",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Emma Watson",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/hermione.jpeg",
        ),
        Character(
            id = "c3b1f9a5-b87b-48bf-b00d-95b093ea6390",
            name = "Ron Weasley",
            alternateNames = listOf("Dragomir Despard", "Ronald", "Ickle Ronniekins", "Ronnie"),
            species = "human",
            gender = "male",
            house = "Gryffindor",
            dateOfBirth = "01-03-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "pure-blood",
            eyeColor = "blue",
            hairColor = "red",
            wand = Wand(wood = "willow", core = "unicorn tail hair", length = 14.0),
            patronus = "Jack Russell terrier",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Rupert Grint",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/ron.jpg",
        ),
        Character(
            id = "af95bd8a-dfae-45bb-bc69-533860d34129",
            name = "Draco Malfoy",
            alternateNames = listOf(),
            species = "human",
            gender = "male",
            house = "Slytherin",
            dateOfBirth = "05-06-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "pure-blood",
            eyeColor = "grey",
            hairColor = "blonde",
            wand = Wand(wood = "hawthorn", core = "unicorn tail hair", length = 10.0),
            patronus = "",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Tom Felton",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/draco.jpg",
        ),
    )
    val characterViewModel: MainViewModel = viewModel()
    val viewState by characterViewModel.charactersState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text("Error occurred. ${viewState.error}")
            } else -> {
                CharacterScreen(viewState.list)
            }
        }
    }

}

@Composable
fun CharacterScreen(characters: List<Character>) {
    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp, vertical = 24.dp)) {
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier) {
            items(characters){
                character ->
                CharacterItem(character)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Column(
            modifier = Modifier.fillMaxSize().padding(top = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = character.name, style = TextStyle(fontWeight = FontWeight.Bold))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterScreen() {
    CharacterScreen(listOf(
        Character(
            id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8",
            name = "Harry Potter",
            alternateNames = listOf("The Boy Who Lived", "The Chosen One", "Undesirable No. 1", "Potty"),
            species = "human",
            gender = "male",
            house = "Gryffindor",
            dateOfBirth = "31-07-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "half-blood",
            eyeColor = "green",
            hairColor = "black",
            Wand(wood= "holly", core = "phoenix tail feather", length = 11.0),
            patronus = "stag",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Daniel Radcliffe",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/harry.jpg",
        ),
        Character(
            id = "4c7e6819-a91a-45b2-a454-f931e4a7cce3",
            name = "Hermione Granger",
            alternateNames = listOf("Hermy", "Know-it-all", "Miss Grant", "Herm-own-ninny"),
            species = "human",
            gender = "female",
            house = "Gryffindor",
            dateOfBirth = "19-09-1979",
            yearOfBirth = 1979,
            wizard = true,
            ancestry = "muggleborn",
            eyeColor = "brown",
            hairColor = "brown",
            wand = Wand(wood = "vine", core = "dragon heartstring", length = 10.0),
            patronus = "otter",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Emma Watson",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/hermione.jpeg",
        ),
        Character(
            id = "c3b1f9a5-b87b-48bf-b00d-95b093ea6390",
            name = "Ron Weasley",
            alternateNames = listOf("Dragomir Despard", "Ronald", "Ickle Ronniekins", "Ronnie"),
            species = "human",
            gender = "male",
            house = "Gryffindor",
            dateOfBirth = "01-03-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "pure-blood",
            eyeColor = "blue",
            hairColor = "red",
            wand = Wand(wood = "willow", core = "unicorn tail hair", length = 14.0),
            patronus = "Jack Russell terrier",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Rupert Grint",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/ron.jpg",
        ),
        Character(
            id = "af95bd8a-dfae-45bb-bc69-533860d34129",
            name = "Draco Malfoy",
            alternateNames = listOf(),
            species = "human",
            gender = "male",
            house = "Slytherin",
            dateOfBirth = "05-06-1980",
            yearOfBirth = 1980,
            wizard = true,
            ancestry = "pure-blood",
            eyeColor = "grey",
            hairColor = "blonde",
            wand = Wand(wood = "hawthorn", core = "unicorn tail hair", length = 10.0),
            patronus = "",
            hogwartsStudent = true,
            hogwartsStaff = false,
            actor = "Tom Felton",
            alternateActors = listOf(),
            alive = true,
            image = "https://ik.imagekit.io/hpapi/draco.jpg",
        ),
    )
    )
}
