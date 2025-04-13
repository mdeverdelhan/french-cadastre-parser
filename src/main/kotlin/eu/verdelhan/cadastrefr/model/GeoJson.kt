package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
data class FeatureCollection<T>(
    val type: String = "FeatureCollection",
    val features: List<Feature<T>>
)

@Serializable
data class Feature<T>(
    val type: String = "Feature",
    val id: String? = null,
    val geometry: Geometry,
    val properties: T
)

@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type")
sealed interface Geometry

@Serializable
@SerialName("Point")
data class Point(val coordinates: List<Double>) : Geometry

@Serializable
@SerialName("MultiPoint")
data class MultiPoint(val coordinates: List<List<Double>>) : Geometry

@Serializable
@SerialName("LineString")
data class LineString(val coordinates: List<List<Double>>) : Geometry

@Serializable
@SerialName("MultiLineString")
data class MultiLineString(val coordinates: List<List<List<Double>>>) : Geometry

@Serializable
@SerialName("Polygon")
data class Polygon(val coordinates: List<List<List<Double>>>) : Geometry

@Serializable
@SerialName("MultiPolygon")
data class MultiPolygon(val coordinates: List<List<List<List<Double>>>>) : Geometry
