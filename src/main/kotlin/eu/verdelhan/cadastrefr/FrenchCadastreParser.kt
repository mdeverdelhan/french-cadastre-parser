package eu.verdelhan.cadastrefr

import eu.verdelhan.cadastrefr.model.*
import kotlinx.serialization.json.Json

/**
 * Parser for French cadastre GeoJSON data.
 * This class provides methods to parse different cadastral GeoJSON feature collections.
 */
class FrenchCadastreParser {

    /** JSON configuration */
    val json = Json {
        ignoreUnknownKeys = true
    }

    /**
     * Parses a JSON string into the specified type.
     * @param T The type to parse into.
     * @param jsonString The JSON string to parse.
     * @return The parsed object of type T.
     */
    inline fun <reified T> parseJson(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }

    /**
     * Parses a JSON string containing parcel features into a [FeatureCollection] of [ParcelleProperties].
     * @param jsonString The JSON string representing parcel features.
     * @return A [FeatureCollection] of [ParcelleProperties].
     */
    fun parseParcellesJson(jsonString: String): FeatureCollection<ParcelleProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string containing building features into a [FeatureCollection] of [BatimentProperties].
     * @param jsonString The JSON string representing building features.
     * @return A [FeatureCollection] of [BatimentProperties].
     */
    fun parseBatimentsJson(jsonString: String): FeatureCollection<BatimentProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string containing topographic surface features into a [FeatureCollection] of [TsurfProperties].
     * @param jsonString The JSON string representing topographic surface features.
     * @return A [FeatureCollection] of [TsurfProperties].
     */
    fun parsePciTsurfJson(jsonString: String): FeatureCollection<TsurfProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string containing address features into a [FeatureCollection] of [AdresseProperties].
     * @param jsonString The JSON string representing address features.
     * @return A [FeatureCollection] of [AdresseProperties].
     */
    fun parseAdressesJson(jsonString: String): FeatureCollection<AdresseProperties> {
        return parseJson(jsonString)
    }

}
