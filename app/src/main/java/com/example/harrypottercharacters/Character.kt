package com.example.harrypottercharacters

import androidx.compose.ui.graphics.Color

data class Character(
    val id: String,
    val name: String,
    val alternateNames: List<String>,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String,
    val yearOfBirth: Int,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColor: String,
    val hairColor: String,
    val wand: Wand,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alternateActors: List<String>,
    val alive: Boolean,
    val image: String
)

data class Wand(
    val wood: String,
    val core: String,
    val length: Double
)
