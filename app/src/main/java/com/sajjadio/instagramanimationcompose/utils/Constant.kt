package com.sajjadio.instagramanimationcompose.utils


const val HOME_ROUTE = "homeRoute"
const val STORY_ROUTE = "storyRoute"

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
        image = "https://th.bing.com/th/id/OIP.m-Yx687f--Vfv1Zioj2KuAHaHw?w=176&h=184&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "instagram"
    ),
    Story(
        image = "https://th.bing.com/th/id/R.71dfd3f36ed6d7bae45f86f75cc5f416?rik=oaRNOpaKAW3z8A&pid=ImgRaw&r=0",
        username = "tesla"
    ),
    Story(
        image = "https://cdn.icon-icons.com/icons2/2429/PNG/512/figma_logo_icon_147289.png",
        username = "figma"
    ),
    Story(
        image = "https://th.bing.com/th/id/OIP.k5mBS4TCgV1jk-4IvWjySAHaFj?w=265&h=199&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "elon_musk"
    ),
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
        image = "https://th.bing.com/th/id/R.71dfd3f36ed6d7bae45f86f75cc5f416?rik=oaRNOpaKAW3z8A&pid=ImgRaw&r=0",
        username = "tesla",
        post = "https://pbs.twimg.com/media/F2e_I2YaAAAO_ty?format=jpg&name=900x900",
        likes = 5304,
        comments = 305,
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        time = "2 hours ago"
    ),
    Post(
        image = "https://th.bing.com/th/id/OIP.m-Yx687f--Vfv1Zioj2KuAHaHw?w=176&h=184&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "instagram",
        post = "https://th.bing.com/th/id/OIP.w7GzWGNccU6j9Z2K0RMmqQHaHa?pid=ImgDet&rs=1",
        likes = 102035,
        comments = 504,
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        time = "17 minutes ago"
    ),
    Post(
        image = "figma",
        username = "tesla",
        post = "https://pbs.twimg.com/media/F2Dulo7WoAAhDfP?format=jpg&name=900x900",
        likes = 5304,
        comments = 305,
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        time = "5 hours ago"
    ),
)

data class Viewer(
    val image: String,
    val username: String
)

val viewers = listOf(

    Viewer(
        image = "https://th.bing.com/th/id/OIP.mKLX1KVGstNfbArqJQLh9gHaHa?w=182&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "dr.ali"
    ),
    Viewer(
        image = "https://th.bing.com/th/id/OIP.NI94miDnt29EtYfOyUGBUQHaLG?w=182&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "figma"
    ),
    Viewer(
        image = "https://th.bing.com/th/id/OIP.9xKLi4Z72mYf9cZWCcqI0gHaGI?w=197&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "luffy"
    ),

    Viewer(
        image = "https://th.bing.com/th/id/OIP.mKLX1KVGstNfbArqJQLh9gHaHa?w=182&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "dr.ali"
    ),
    Viewer(
        image = "https://th.bing.com/th/id/OIP.NI94miDnt29EtYfOyUGBUQHaLG?w=182&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "figma"
    ),
    Viewer(
        image = "https://th.bing.com/th/id/OIP.9xKLi4Z72mYf9cZWCcqI0gHaGI?w=197&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        username = "luffy"
    )
)