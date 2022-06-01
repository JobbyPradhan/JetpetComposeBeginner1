package com.mhs.jetpetcomposebeginner1.model

data class User(
    val description :String
)

fun dumpData(): List<User>{
    return listOf(
        User(
            "This is Data"
        ),
        User("This is Data1"),
        User("This is Data2")
    )
}