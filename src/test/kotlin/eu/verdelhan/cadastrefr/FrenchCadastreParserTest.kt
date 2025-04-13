package eu.verdelhan.cadastrefr

import eu.verdelhan.cadastrefr.model.MultiPolygon
import eu.verdelhan.cadastrefr.model.Polygon
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.nio.file.Files
import java.nio.file.Paths

class FrenchCadastreParserTest {

    private lateinit var parser: FrenchCadastreParser

    @BeforeEach
    fun setUp() {
        parser = FrenchCadastreParser()
    }

    private fun readResourceFile(fileName: String): String {
        val uri = this::class.java.classLoader.getResource(fileName)?.toURI()
            ?: throw IllegalArgumentException("Resource not found: $fileName")
        return Files.readString(Paths.get(uri))
    }

    @Test
    fun `should parse parcelles JSON correctly`() {
        val json = readResourceFile("cadastre-34202-parcelles.json")
        val parcelles = parser.parseParcellesJson(json)

        assertNotNull(parcelles, "Parsed parcelles should not be null")
        assertEquals(14, parcelles.features.size, "Expected 14 parcelles")
        assertEquals("34202000BO0095", parcelles.features[13].id)
        assertEquals(618, parcelles.features[2].properties.contenance)

        val geometry = parcelles.features[3].geometry as? Polygon
        assertNotNull(geometry, "Geometry should be a Polygon")
        assertTrue(geometry!!.coordinates[0][1].contains(3.778057))
        assertTrue(parcelles.features[3].getGeometryAsJson().contains("pe\":\"Polygon\",\"coordinates\":[[[3.7781408,43.6005767],[3.778057,43.6006538],[3.777"))
    }

    @Test
    fun `should parse batiments JSON correctly`() {
        val json = readResourceFile("cadastre-34202-batiments.json")
        val batiments = parser.parseBatimentsJson(json)

        assertNotNull(batiments, "Parsed batiments should not be null")
        assertEquals(5, batiments.features.size, "Expected 5 batiments")
        assertEquals("34202", batiments.features[0].properties.commune)

        val geometry = batiments.features[1].geometry as? MultiPolygon
        assertNotNull(geometry, "Geometry should be a MultiPolygon")
        assertTrue(geometry!!.coordinates[0][0][0].contains(43.5815612), "Expected coordinate to contain 43.5815612")
    }

    @Test
    fun `should parse tsurf JSON correctly`() {
        val json = readResourceFile("pci-34202-tsurf.json")
        val tsurf = parser.parsePciTsurfJson(json)

        assertNotNull(tsurf, "Parsed tsurf should not be null")
        assertEquals(4, tsurf.features.size, "Expected 4 tsurf features")
        assertEquals("Objet_1162818", tsurf.features[3].id)
        assertEquals("65", tsurf.features[0].properties.sym)
    }

    @Test
    fun `should parse adresses JSON correctly`() {
        val json = readResourceFile("adresses_8_bd_du_port_lat_48_789&lon_2_789.json")
        val adresses = parser.parseAdressesJson(json)

        assertNotNull(adresses, "Parsed adresses should not be null")
        assertEquals(10, adresses.features.size, "Expected 10 addresses")
        assertEquals("8 Boulevard du port-mulon", adresses.features[9].properties.name)
        assertEquals("95127", adresses.features[0].properties.citycode)
    }
}
