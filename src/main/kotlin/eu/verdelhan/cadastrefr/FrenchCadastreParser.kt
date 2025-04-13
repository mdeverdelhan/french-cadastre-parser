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
     *
     * @param T The type to parse into.
     * @param jsonString The JSON string to parse.
     * @return The parsed object of type T.
     */
    inline fun <reified T> parseJson(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }

    /**
     * Parses a JSON string into a [ParcelleFeatureCollection].
     *
     * @param jsonString The JSON string containing parcel data.
     * @return A [ParcelleFeatureCollection] object.
     */
    fun parseParcellesJson(jsonString: String): FeatureCollection<ParcelleProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [BatimentFeatureCollection].
     *
     * @param jsonString The JSON string containing building data.
     * @return A [BatimentFeatureCollection] object.
     */
    fun parseBatimentsJson(jsonString: String): FeatureCollection<BatimentProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [TsurfFeatureCollection].
     *
     * @param jsonString The JSON string containing topographic surface data.
     * @return A [TsurfFeatureCollection] object.
     */
    fun parsePciTsurfJson(jsonString: String): FeatureCollection<TsurfProperties> {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [AdresseFeatureCollection].
     *
     * @param jsonString The JSON string containing address data.
     * @return A [AdresseFeatureCollection] object.
     */
    fun parseAdressesJson(jsonString: String): FeatureCollection<AdresseProperties> {
        return parseJson(jsonString)
    }
}
