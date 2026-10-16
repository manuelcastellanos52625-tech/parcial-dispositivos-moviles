package com.ucaldas.aplicacion1.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ucaldas.aplicacion1.Nombres

// Paso 3: imagen reutilizable
@Composable
fun HeroImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        contentScale = ContentScale.Crop
    )
}

// Paso 4: informacion simple (para la lista)
@Composable
fun HeroInfo(
    hero: Nombres,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "ID: ${hero.id}",
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = hero.nombre,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = hero.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Superpoderes: ${hero.superPoderes.joinToString()}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// Paso 6: metrica derivada
private fun heroProfile(superPoderes: List<String>): String = when {
    superPoderes.any { it.contains("Inteligencia", ignoreCase = true) } &&
        superPoderes.any { it.contains("Combate", ignoreCase = true) } -> "Estratega"
    superPoderes.any { it.contains("Energia", ignoreCase = true) } -> "Cosmico"
    superPoderes.any { it.contains("velocidad", ignoreCase = true) } -> "Velocista"
    else -> "Titan"
}

// Paso 5: informacion enriquecida (para el detalle)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroInfoDetail(
    hero: Nombres,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Bloque principal destacado
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(56.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = hero.nombre.first().toString(),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                Column {
                    Text(
                        text = "ID: ${hero.id}",
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(text = hero.nombre, style = MaterialTheme.typography.headlineLarge)
                }
            }
        }

        // Descripcion amplia
        Text(text = hero.descripcion, style = MaterialTheme.typography.bodyLarge)

        // Estadisticas del heroe
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Metrica("Poderes", hero.superPoderes.size.toString())
                Metrica("Perfil", heroProfile(hero.superPoderes))
            }
        }

        // Chips de superpoderes
        Text(text = "Superpoderes", style = MaterialTheme.typography.titleMedium)
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            hero.superPoderes.forEach { poder ->
                AssistChip(onClick = {}, label = { Text(poder) })
            }
        }

        // Resumen tactico
        Text(
            text = "Resumen tactico: ${hero.nombre} es de perfil ${heroProfile(hero.superPoderes)} " +
                "con ${hero.superPoderes.size} habilidades destacadas.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun Metrica(titulo: String, valor: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = valor, style = MaterialTheme.typography.titleLarge)
        Text(text = titulo, style = MaterialTheme.typography.labelSmall)
    }
}

// Paso 7: card reutilizable (lista y detalle)
@Composable
fun HeroCard(
    hero: Nombres,
    onClick: (() -> Unit)? = null,
    option: Int = 0,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
    ) {
        HeroImage(
            imageUrl = hero.imagenUrl,
            contentDescription = hero.nombre
        )
        if (option == 0) {
            HeroInfo(hero = hero)
        } else {
            HeroInfoDetail(hero = hero)
        }
    }
}
