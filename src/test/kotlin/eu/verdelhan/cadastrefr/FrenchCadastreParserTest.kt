package eu.verdelhan.cadastrefr


import FrenchCadastreParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

class FrenchCadastreParserTest {

    fun readResourceFile(fileName: String): String {
        val path = Paths.get(this::class.java.classLoader.getResource(fileName)!!.toURI())
        return String(Files.readAllBytes(path))
    }

    @Test
    fun `test parseParcellesJson`() {
        val parcellesJson = readResourceFile("cadastre-34202-parcelles.json")
        val parcelles = FrenchCadastreParser().parseParcellesJson(parcellesJson)
        assertNotNull(parcelles)
        assertEquals(14, parcelles.features.size)
        assertEquals("34202000BO0095", parcelles.features[13].id)
        assertEquals(618, parcelles.features[2].properties.contenance)
    }

    @Test
    fun `test parseBatimentsJson`() {
        val batimentsJson = readResourceFile("cadastre-34202-batiments.json")
        val batiments = FrenchCadastreParser().parseBatimentsJson(batimentsJson)
        assertNotNull(batiments)
        assertEquals(5, batiments.features.size)
        assertEquals("34202", batiments.features[0].properties.commune)
        assertTrue(batiments.features[1].geometry.coordinates.get(0).get(0).get(0).contains(43.5815612))
    }

    @Test
    fun `test parseTsurfJson`() {
        val tsurfJson = readResourceFile("pci-34202-tsurf.json")
        val tsurf = FrenchCadastreParser().parsePciTsurfJson(tsurfJson)
        assertNotNull(tsurf)
        assertEquals(4, tsurf.features.size)
        assertEquals("Objet_1162818", tsurf.features[3].id)
        assertEquals("65", tsurf.features[0].properties.sym)
    }

    @Test
    fun `test parseAdressesJson`() {
        val adressesJson = readResourceFile("adresses_8_bd_du_port_lat_48_789&lon_2_789.json")
        val addr = FrenchCadastreParser().parseAdressesJson(adressesJson)
        assertNotNull(addr)
        assertEquals(10, addr.features.size)
        assertEquals("8 Boulevard du port-mulon", addr.features[9].properties.name)
        assertEquals("95127", addr.features[0].properties.citycode)
    }
}
