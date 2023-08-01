package com.sajjadio.instagramanimationcompose.utils

data class Story(
    val image: String,
    val username: String
)

val stories = listOf(
    Story(
        image = "https://th.bing.com/th/id/OIP.SzixlF6Io24jCN67HHZulAHaLH?w=182&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "Your story"
    ),
    Story(
        image = "https://th.bing.com/th/id/OIP.mKLX1KVGstNfbArqJQLh9gHaHa?w=182&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "dr.ali"
    ),
    Story(
        image = "https://th.bing.com/th/id/OIP.NI94miDnt29EtYfOyUGBUQHaLG?w=182&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "figma"
    ),
    Story(
        image = "https://th.bing.com/th/id/OIP.9xKLi4Z72mYf9cZWCcqI0gHaGI?w=197&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "luffy"
    )
)

data class Post(
    val image: String,
    val username: String,
    val post: String,
    val likes: Int,
    val description: String,
    val comments: Int,
    val time: String,
)

val posts = listOf(
    Post(
        image = "https://th.bing.com/th/id/OIP.9xKLi4Z72mYf9cZWCcqI0gHaGI?w=197&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "luffy",
        post = "https://th.bing.com/th/id/OIP.9xKLi4Z72mYf9cZWCcqI0gHaGI?w=197&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        likes = 102035,
        comments = 504,
        description = "Hola, I updated my image profile don't loess me",
        time = "17 minutes ago"
    ),
    Post(
        image = "https://th.bing.com/th/id/OIP.XgT9d552B6R9C60Ul2yqkAHaHa?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "instagram",
        post = "https://th.bing.com/th/id/OIP.XgT9d552B6R9C60Ul2yqkAHaHa?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        likes = 5304,
        comments = 305,
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        time = "2 hours ago"
    ),
)