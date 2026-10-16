package com.ucaldas.aplicacion1

data class Nombres(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superPoderes: List<String>
)

val listaNombres = listOf(
    // ---------- HEROES ----------
    Nombres(
        1,
        "Superman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/644-superman.jpg",
        "Superman es un heroe de Superman Prime One-Million reconocido por ACTION COMICS #1.",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia")
    ),
    Nombres(
        2,
        "Batman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/70-batman.jpg",
        "Batman es un heroe de DC Comics reconocido por Detective Comics #27.",
        listOf("Inteligencia superior", "Combate experto")
    ),
    Nombres(
        3,
        "Spider-Man",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/620-spider-man.jpg",
        "Spider-Man es un heroe de Marvel Comics reconocido por Amazing Fantasy #15.",
        listOf("Inteligencia superior", "Alta resistencia", "Energia o poder especial", "Combate experto")
    ),

    // ---------- SUPERVILLANOS ----------
    Nombres(
        4,
        "Lex Luthor",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/405-lex-luthor.jpg",
        "Lex Luthor es un villano de DC Comics reconocido por Action Comics #23.",
        listOf("Inteligencia superior", "Super fuerza")
    ),
    Nombres(
        5,
        "Joker",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/370-joker.jpg",
        "Joker es un villano de DC Comics reconocido por Batman #1 (Spring 1940).",
        listOf("Inteligencia superior", "Combate experto")
    ),
    Nombres(
        6,
        "Green Goblin",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/299-green-goblin.jpg",
        "Green Goblin es un villano de Marvel Comics reconocido por Amazing Spider-Man #14 (July, 1964).",
        listOf("Inteligencia superior", "Super fuerza", "Combate experto")
    )
)
